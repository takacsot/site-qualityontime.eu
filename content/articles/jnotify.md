---
title: "JNotify"
kind: article
created_at: 2012-04-15 22:22:22 +0000
author: "Takács Ottó"
published: true
tags: articles
---
##[JNotify](http://jnotify.sourceforge.net/)

<pre class="brush: java"> <code>
public class JNotifySample {
  public static void main(String args[]) throws Exception {</code></pre>

Nativ megoldás. Az operációs rendszer értesít a változásokról.

A websiton található sample minimális átirat.

<pre class="brush: java"> 
public class JNotifySample {
  public static void main(String args[]) throws Exception {
    // path to watch
    String path ="c:/TEMP";
    // watch mask, specify events you care about,
    // or JNotify.FILE_ANY for all events.
    int mask = JNotify.FILE_CREATED |
        JNotify.FILE_DELETED |
        JNotify.FILE_MODIFIED |
        JNotify.FILE_RENAMED;

    // watch subtree?
    boolean watchSubtree = true;

    // add actual watch
    int watchID = JNotify.addWatch(path, mask, watchSubtree, new Listener());

    // sleep a little, the application will exit if you
    // don't (watching is asynchronous), depending on your
    // application, this may not be required
    Thread.sleep(1000000);

    // to remove watch the watch
    boolean res = JNotify.removeWatch(watchID);
    if (!res) {
      // invalid watch ID specified.
    }
  }

  static class Listener implements JNotifyListener {
    public void fileRenamed(int wd, String rootPath, String oldName,
        String newName) {
      print("renamed " + rootPath + " : " + oldName + " -> " + newName);
    }

    public void fileModified(int wd, String rootPath, String name) {
      print("modified " + rootPath + " : " + name);
    }

    public void fileDeleted(int wd, String rootPath, String name) {
      print("deleted " + rootPath + " : " + name);
    }

    public void fileCreated(int wd, String rootPath, String name) {
      print("created " + rootPath + " : " + name);
    }

    void print(String msg) {
      System.err.println(msg);
    }
  }
}
</pre>

Működésének jellemzői:

- Aszinkron értesítés folyik. Semmi ráhatásunk nincs, hogy mikor kapjuk az értesítést.
- Könyvtár létrehozás:
    - `created c:/TEMP : notify\dir` az új könyvtár létrehozása
    - `modified c:/TEMP : notify` szülő könyvtár módosulása(!)
- könyvtár törlése:
    - `deleted c:/TEMP : notify\dir`
    - `modified c:/TEMP : notify`
- file létrehozása
    - `created c:/TEMP : notify\file.txt`
    - `modified c:/TEMP : notify`
- file módosítása
    - `modified c:/TEMP : notify\file.txt`
- file átnevezése
    - `renamed c:/TEMP : notify\file.txt -> notify\file2.txt`
    - `modified c:/TEMP : notify`
    - `modified c:/TEMP : notify\file2.txt`
    - `modified c:/TEMP : notify\file2.txt`
- file törlés
    - `deleted c:/TEMP : notify\file2.txt`
    - `modified c:/TEMP : notify`
- file másolása a figyelt könvtárba
    - `created c:/TEMP : notify\alcatraz.101.hdtv-lol.avi`
    - `modified c:/TEMP : notify`
    - `modified c:/TEMP : notify\alcatraz.101.hdtv-lol.avi`
    - `modified c:/TEMP : notify\alcatraz.101.hdtv-lol.avi`
- külső librarikat kell futtató környezetnek adni a `-Djava.library.path=` jvm argumentummal
- alap file műveletekre komplex értesítés érkezik, ami jó
- alap file műveletekre komplex értesítés érkezik, ami rossz
- java 5
- rekurzívan tud könyvtárakat figyelni

Elég körülményes egy buildelő rendszert ráépíteni, mert a file módosításon kívül igen komplex értesítéseket kapunk. Amire lehet egy kicsit építeni az az, hogy bármi is történik vagy a file vagy egy könyvtár módosul. A gond az, hogy többször is. Ha több fájlról van szó, akkor meg állományonként, ami igen nagy.

Igen részletesen lehet az fájlrendszer értesítéseit elkapni, de pont emiatt nagyon nehéz egy olyan egyszerű funkcionalitást is ráépíteni mint az én kis dokumentum fordításom.

A probléma megoldása lehet az, hogy ha értesülünk az eseményről:

1. lekapcsolódunk az eseményekről egy kicsit, elvégre már az első esemény is elegendő.
2. Várunk egy kicsit, hogy a folyamatban lévő műveletek be tudjanak fejeződni.
3. Visszaállunk figyelésre. A végrehajtandó tevékenység lehet, hogy annyi ideig tart, hogy közben teljesen valid másik file esemény megtörténte is.
4. Végrehajtjuk amit akarunk.

A triggerelt esemény végrehajtásának hosszától függően a 3. és 4. esemény fel is cserélhető.

Konkrétan:

Csupaszítsuk le egy kicsit az alapprogramot:

<pre class="brush: java;toolbar: false;tab-size:2"  >public class JNotifySample2 {
  public static void main(String args[]) throws Exception {
    String path = "c:/TEMP/notify";
    int mask = JNotify.FILE_CREATED |
        JNotify.FILE_DELETED |
        JNotify.FILE_MODIFIED |
        JNotify.FILE_RENAMED;
    boolean watchSubtree = false;
    JNotify.addWatch(path, mask, watchSubtree, new JNotifyExecutorListener());
    System.out.println("Press CTR+C to stop...");
    for (; true;) {
      Thread.sleep(10000);
    }
  }
}</pre>

És a listenert is készítsük el:

<pre class="brush: java;toolbar: false;tab-size:2"  >package public class JNotifyExecutorListener extends JNotifyAdapter {
  volatile boolean executing = false;
  static void  p(String s){
    System.out.println(s);
  }
  @Override
  public void fileModified(int wd, String rootPath, String name) {
    p("modification is notified");
    if(!name.endsWith(".txt")){
      return;
    }
    p("executing something? "+executing);
    if (!executing) {
      p("start the BatchExecutor thread");
      Thread t = new Thread(new BatchExecutor());
      t.start();
    }
    p("modification handler method end");
  }

  class BatchExecutor implements Runnable {
    @Override
    public void run() {
      p("setting to execution...");
      // Indicating that it make no sense to
      executing = true;
      p("executing something (BatchExecutor)? "+executing);
      try {
        p("sleep a bit...");
        Thread.sleep(1 * 1000); // 1 sec
      }
      catch (InterruptedException e) {
        p(e.toString());
        return;
      }
      finally {
        p("setting back flag");
        // ready to catch the next event
        executing = false;
      }
      p("executing something (BatchExecutor 2)? "+executing);

      try {
        p("Start command line...");
        Runtime.getRuntime().exec("cmd /c Path_to/build.bat ");
      }
      catch (IOException e) {
        e.printStackTrace();
      }
      p("command is ready");
    }
  }
}</pre>

<div class='old-comments'></div>