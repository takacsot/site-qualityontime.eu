---
title: "JPathwatch"
kind: article
created_at: 2012-04-17 22:22:22 +0000
author: "Takács Ottó"
published: true
tags: articles
book: directory-watcher
book_page: 3
---
## [JPathwatch](http://jpathwatch.wordpress.com/)

Példaprogram a következő:

~~~java
public class JPathwatchSample {

  public static void main(String[] args) throws Exception {
    WatchService watchService = FileSystems.getDefault().newWatchService();
    Path watchedPath = Paths.get("c:/temp");
    WatchEvent.Kind[] eventsToWatch = new WatchEvent.Kind[] {
        StandardWatchEventKind.ENTRY_CREATE,
        StandardWatchEventKind.ENTRY_DELETE,
        StandardWatchEventKind.ENTRY_MODIFY,
        StandardWatchEventKind.OVERFLOW,
        ExtendedWatchEventKind.ENTRY_RENAME_FROM,
        ExtendedWatchEventKind.ENTRY_RENAME_TO,
    };
    WatchKey key = null;
    try {
      key = watchedPath.register(watchService, eventsToWatch, ExtendedWatchEventModifier.FILE_TREE);
    }
    catch (UnsupportedOperationException uox) {
      System.err.println("file watching not supported!");
    }
    catch (IOException iox) {
      System.err.println("I/O errors");
    }

    for (;;) {
      // take() will block until a file has been created/deleted
      WatchKey signalledKey;
      try {
        signalledKey = watchService.take();
      }
      catch (InterruptedException ix) {
        continue;
      }
      catch (ClosedWatchServiceException cwse) {
        System.out.println("watch service closed, terminating.");
        break;
      }

      // get list of events from key
      List<WatchEvent> list = signalledKey.pollEvents();

      // VERY IMPORTANT! call reset() AFTER pollEvents() to allow the
      // key to be reported again by the watch service
      signalledKey.reset();

      System.out.println("--------------------------------");
      // we'll simply print what has happened; real applications
      // will do something more sensible here
      for (WatchEvent e : list) {
        String message = "";
        if (e.kind() == StandardWatchEventKind.ENTRY_CREATE) {
          Path context = (Path) e.context();
          message = context.toString() + " created";
        }
        else if (e.kind() == StandardWatchEventKind.ENTRY_DELETE) {
          Path context = (Path) e.context();
          message = context.toString() + " deleted";
        }
        else if (e.kind() == StandardWatchEventKind.ENTRY_MODIFY) {
          Path context = (Path) e.context();
          message = context.toString() + " modified";
        }
        else if (e.kind() == ExtendedWatchEventKind.ENTRY_RENAME_FROM) {
          Path context = (Path) e.context();
          message = context.toString() + " renamed from";
        }
        else if (e.kind() == ExtendedWatchEventKind.ENTRY_RENAME_TO) {
          Path context = (Path) e.context();
          message = context.toString() + " renamed to";
        }
        else if (e.kind() == StandardWatchEventKind.OVERFLOW) {
          message = "OVERFLOW: more changes happened than we could retreive";
        }
        System.out.println(message);
      }
    }
  }
}
~~~

Jellemzői:

- java 5 
- java 7 api kompatibilis, ami jó. Könnyen át lehet állni java7-re
- java 7 api kompatibilis, ami rosz. Nem szép az API. pl: 
    - `StandardWatchEventKinds`: Milyen elbaszott egy név
	- `ENTRY_CREATE`: Minden esemény ENTRY-vel kezdődik. De mivel egy konstans család tagjai teljesen felesleges. Persze a CREATE, MODIFY, stb szavak könnyen ütközhetnek más API-val, de akkor miért pont az ENTRY-vel prefixelt. Prefix sem kell, ha nem az elbaszott `StandardWatchEventKinds` osztályba tartozik.
	- Kicsit kibővíti a java7-es API-t. Maguk a kibővítések jók (például a rekurzív figyelés). De emiatt lesz teljesen kompatibilis.
- rekurzívan is tud figyelni könyvtárszerkezetet
- szinkron API.
- szálat blokkolva (`take()`) és nem blokkolva (`poll()`) is használható.
- egy `take()` hívásra egyszerre több eventet is kapunk, amiből lehet következtetni a végrehajtandó műveletre.
- Könyvtár létrehozás:
    - `dir` created
- könyvtár törlése:
    - `dir` deleted
- file létrehozása
    - `file.txt` created
- file módosítása
    - `file.txt` modified
- file átnevezése
    - `file.txt` renamed from
    - `file2.txt` renamed to
- file törlés
    - `file2.txt` deleted
- kicsi file másolása a figyelt könvtárba
    - `stylesheet.css` created
    - `stylesheet.css` modified
    - `stylesheet.css` modified
- nagy file másolása
    - `alcatraz.101.hdtv-lol.avi` created
    - `alcatraz.101.hdtv-lol.avi` modified
    - újjabb event handling ciklus
    - `alcatraz.101.hdtv-lol.avi` modified
- alkönyvtár létrehozás
    - `dir\subdiir` created
    - `dir` modified
- alkönyvtárban file ltrehozás
    - `dir\subdiir\subfile.txt` created
    - `dir\subdiir` modified
- alkönyvtárban file módosulás
    - `dir\subdiir\subfile.txt` modified
	
File másolás kezelésére itt készítő tanácsa (FAQ):

>__Can I use jpathwatch to find out when a program finished writing to a file?__

>This is a bit tricky, but doable. First of all the problem is that most operating systems do not provide events for that, all they report is if a file has been created, modified or deleted in a directory, which is what jpathwatch passes back to your application code.

>So effectively, you can find out when a program writes to a file, but you can’t find out when it’s done with it.

>What I recommend in this case is to use heuristics: Assume that a process is done writing to a file when the file isn’t modified for a while (say, ten seconds or so).

>Assume you watch a directory on an FTP server, and you want to pick up files after they have finished uploading to that directory.

>In a loop, you `poll()` on the WatchService for events on that directory. For each file that is created or modified (`ENTRY_CREATE/ENTRY_MODIFY`), you store the time of the last event on that file. Maintain a sorted list of these times; the oldest file in the list is the one that is going to expire first. Remove files that have expired from your sorted list (calculate if their last event time plus the timeout is less than the current time) and flag them as ‘done’.

>For the now oldest file in your list that hasn’t expired yet, calculate the time until it will expire, and call `poll()` with that duration. If you have no more files in your list, call `take()` instead of `poll()` to wait for new files to appear.

Az én kis problémámra a következő implementációt hoztam össze.

Másodjára implementálva a megoldást kiderül, hogy a JNotify esetén mely kódrészleteket tudom újra felhasználni. A JNotify-ban megismert BatchExecutor nagyon jól ki lehet emelni. A szemafor váltogatást interfész mögé teszem és már egy csomó mindent nem kell újra megírnom. 

~~~java
public interface IWorkerSemafor {
  public void working();
  public void notWorking();
}

class BatchExecutor implements Runnable {
  private final IWorkerSemafor semafor;

  BatchExecutor(IWorkerSemafor semafor) {
    this.semafor = semafor;
  }

  @Override
  public void run() {
    this.semafor.working();
    try {
      Thread.sleep(1 * 1000); // 1 sec
    }
    catch (InterruptedException e) {
      return;
    }
    finally {
      this.semafor.notWorking();
    }
    try {
      System.out.println("executing command... "+new Date());
      Runtime.getRuntime().exec("cmd /c build.bat ");
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}
~~~

És a következő egyszerű kódot írtam, hogy meghajthassam a funkcionalitást:

~~~java
public class JPathwatchSample2 {

  public static void main(String[] args) throws Exception {
    Thread watcherT = new Thread(watcher);
    watcherT.start();
    System.out.println("JPathwatch: Press CTR+C to stop");
    for (;;) {
      Thread.sleep(1000);
    }
  }

  static volatile boolean workerRunning = false;

  static Runnable watcher = new BackgroundWatcher();

  static class BackgroundWatcher implements Runnable, IWorkerSemafor {
    public void run() {
      WatchService watchService = FileSystems.getDefault().newWatchService();
      Path watchedPath = Paths.get("c:/temp");
      setup(watchService, watchedPath);
      for (;;) {
        WatchKey signalledKey;
        try {
          signalledKey = watchService.take();
        }
        catch (InterruptedException ix) {
          continue;
        }
        catch (ClosedWatchServiceException cwse) {
          System.out.println("watch service closed, pls exit");
          break;
        }
        List&lt;WatchEvent&lt;?>> list = signalledKey.pollEvents();
        signalledKey.reset();
        if (workerRunning) {
          continue;
        }
        if (null == list || 0 == list.size()) {
          continue;
        }
        Thread worker = new Thread(new BatchExecutor(this));
        worker.start();
      }
    }
    private void setup(WatchService watchService, Path watchedPath) {
      WatchEvent.Kind<?>[] eventsToWatch = new WatchEvent.Kind[] {
          StandardWatchEventKind.ENTRY_CREATE,
          StandardWatchEventKind.ENTRY_DELETE,
          StandardWatchEventKind.ENTRY_MODIFY,
          StandardWatchEventKind.OVERFLOW,
          ExtendedWatchEventKind.ENTRY_RENAME_FROM,
          ExtendedWatchEventKind.ENTRY_RENAME_TO,
      };
      WatchKey key = null;
      try {
        key = watchedPath.register(watchService, eventsToWatch, ExtendedWatchEventModifier.FILE_TREE);
      }
      catch (UnsupportedOperationException uox) {
        uox.printStackTrace();
      }
      catch (IOException iox) {
        iox.printStackTrace();
      }
    }
    @Override
    public void working() {
      workerRunning = true;
    }
    @Override
    public void notWorking() {
      workerRunning = false;
    }
  };
}
~~~

