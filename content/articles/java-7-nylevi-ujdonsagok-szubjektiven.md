---
title: "Java 7 nylevi újdonságok szubjektíven"
kind: article
created_at: 2012-03-15 21:22:22 +0000
author: "Takács Ottó"
published: true
tags: java,articles
---
Ok, hogy már 2011 nyara óta kint van, de hozzám csak most jutott el a [File  Watcher](http://docs.oracle.com/javase/tutorial/essential/io/notification.html) api kapcsán.

Az API változás nem igazán szokott meghatni. Java-val szállított API és library annyira nagy, hogy az már szinte káros. Persze értem, hogy ha nagy akkor standardként lehet sok-sok eszközre számítani. De a másik oldalról ez megkötés is, mert sok API nem a legoptimálisabban lett megtervezve és az implementációk sem mindig jók. Manapság egy thirparty lib-et beilleszteni nem egy nagy gond. Hosszabb távon szerintem jobb lenne gy olyan megoldás, hogy választhassam, hogy melyik csomagot akarom telepíteni. Valahogy úgy, mint más rendszerekben a csomagok (lásd ruby gem)


Az újítások nem minden aspektusát emelem ki, de annyit igen, hogy érteni lehessen az izét.



[The try-with-resources Statement](http://docs.oracle.com/javase/7/docs/technotes/guides/language/try-with-resources.html)
=======

<pre  class="brush: java;toolbar: false;tab-size:2" >
static String readFirstLineFromFile(String path) throws IOException {
  try (BufferedReader br = new BufferedReader(new FileReader(path))) {
    return br.readLine();
  }
}
</pre>

equivalent with

<pre  class="brush: java;toolbar: false;tab-size:2" >
static String readFirstLineFromFileWithFinallyBlock(String path) throws IOException {
  BufferedReader br = new BufferedReader(new FileReader(path));
  try {
    return br.readLine();
  } finally {
    if (br != null) br.close();
  }
}
</pre>

Ezt a szart. 

Tudni kell, hogy a közösség nagyon régóta várta Java-ba bevezetni a closur-okat. De az nem történt meg. 

És a fenti példa closur-okkal API szintre hozható lett volna

<pre class="brush: scala;toolbar: false;tab-size:2" >
    withFileIterator(myfilename) {
      line => {
        println(line)
      }
</pre>

A fenti példában nincs [Scala](http://www.scala-lang.org/) foglalt szó. Ebben csak sima függvényhívások vannak. De van closur!

De ehelyett java-ban a nyelv szintaxisát buherálták meg és ezzel növelték a nyelv komplexitását. 

Nagy különbség van API és nyelvi komplexitás növelésben. Mert míg az API esetén választási lehetőséged van, hogy melyiket használod, addig a nyelv esetén már nincs.


Handling More Than One Type of Exception
-----------------

<pre  class="brush: java;toolbar: false;tab-size:2" >
catch (IOException|SQLException ex) {
    logger.log(ex);
    throw ex;
}
</pre>

Nagyon jó, nagyon hasznos. Rájöttek, hogy a java kivételkezelési stratégiája nem a legrugalmasabb. Pontosabban az a gond, hogy checked excpetion-ök vannak garmadával, még akkor is, ha érdemben alig van olyan eset, amikor le lehet kezelni.

- [Bruce Eckel](http://www.artima.com/intv/handcuffs.html), vagy [ez](http://www.mindview.net/Etc/Discussions/CheckedExceptions)
- Sokak által kedvelt Spring Framework sem nagyon dolgozik checked exception-ökkel.

Ezzel egy lépést tettek előre, hogy ahol nem kell ott ne kelljen mindent felsorolni. Főleg ott, ahol az excpetion-ök együtt járnak. 
Például a Jakarta Beanutils majd minden metódusa ugyan azt a 3 kivétel dobálja majd minden eljáráshívásnál. 

Nagyszerű újítás.

[Binary Literals](http://docs.oracle.com/javase/7/docs/technotes/guides/language/binary-literals.html)
-----------

<pre  class="brush: java;toolbar: false;tab-size:2" >
// A 16-bit 'short' value:
short aShort = (short)0b1010000101000101;
</pre>

Semleges. A teljes szakmai múltamban nem vettem volna hasznát.

[Underscores in Numeric Literals](http://docs.oracle.com/javase/7/docs/technotes/guides/language/underscores-literals.html)
-------------------
<pre  class="brush: java;toolbar: false;tab-size:2" >
long creditCardNumber = 1234_5678_9012_3456L;
</pre>

Nagyon jó. Hiányozni nem hiányzott, de azért hasznos kis trükk a kód olvashatósága érdekében. 


[Strings in switch Statements](http://docs.oracle.com/javase/7/docs/technotes/guides/language/strings-switch.html)
------------

<pre  class="brush: java;toolbar: false;tab-size:2" >
public String getTypeOfDayWithSwitchStatement(String dayOfWeekArg) {
     String typeOfDay;
     switch (dayOfWeekArg) {
         case "Monday":
             typeOfDay = "Start of work week";
             break;
         case "Tuesday":
         case "Wednesday":
         case "Thursday":
             typeOfDay = "Midweek";
             break;
         case "Friday":
             typeOfDay = "End of work week";
             break;
         case "Saturday":
         case "Sunday":
             typeOfDay = "Weekend";
             break;
         default:
             throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeekArg);
     }
     return typeOfDay;
}
</pre>

Ideje volt!

[Type Inference for Generic Instance Creation](http://docs.oracle.com/javase/7/docs/technotes/guides/language/type-inference-generic-instance-creation.html)
--------------

<pre  class="brush: java;toolbar: false;tab-size:2" >
Map&lt;String, List&lt;String>> myMap = new HashMap&lt;String, List&lt;String>>();
Map&lt;String, List&lt;String>> myMap = new HashMap&lt;>();
</pre>

Nem vagyok nagy híve a generikusoknak.

Elképesztően verbose(bőbeszédű, feleslegesen bőbeszédű) a szintaktikája. Sokszor azért sem használom, mert olvashatatlanná teszi a programot. És el is  vezet a következő gondomhoz.

Gyakorlatilag kötelező. Pontosabban alapból nem generikus használat esetén tele vagyok compile warninggal, ami ellent mond azon elvemnek, hogy a [compiler warning-ok legyenek bekapcsolva](http://www.qualityontime.eu/extracts/chapter-9-finding-fault-debugging-what-do-when-things-go-wrong) és úgy programozz, hogy egy warning se legyen.

Magának a generikusnak a szintaxisa (mármint ha te csinálsz generikus osztályt) valami rémálom (trivialitásoktól eltekintve)
[Ezen  youtube vidon](http://www.youtube.com/watch?feature=player_embedded&v=V1vQf4qyMXg) van pár példa, amit [Scala](http://www.scala-lang.org/) tíz körrel lepipál. És ami lényeg, hogy ennek semmi köze nincs a [Scala](http://www.scala-lang.org/) egyéb funkcionalitásához. Ez csak az, hogyan lehet a generikusokat egyszerűbb szintaxissal megvalósítani.

Ezt megoldást már a generikusok legelső megvalósításával meg kellett volna lépni. 

[Improved Compiler Warnings and Errors When Using Non-Reifiable Formal Parameters with Varargs Methods](http://docs.oracle.com/javase/7/docs/technotes/guides/language/non-reifiable-varargs.html)
------

Igazság szerint érteni alig értem, szóval valószínűleg eddig sem zavart.

<!-- event to the end of the fiel -->
<link href="http://www.qualityontime.eu/syntax/styles/shThemeDefault.css" rel="stylesheet" type="text/css" />
<script src="http://www.qualityontime.eu/syntax/scripts/shCore.js" type="text/javascript"></script>
<script type="text/javascript" src="http://www.qualityontime.eu/syntax/scripts/shBrushJScript.js"></script>
<script type="text/javascript" src="http://www.qualityontime.eu/syntax/scripts/shBrushJava.js"></script>
<script type="text/javascript" src="http://www.qualityontime.eu/syntax/scripts/shBrushRuby.js"></script>
<script type="text/javascript" src="http://www.qualityontime.eu/syntax/scripts/shBrushScala.js"></script>
<script type="text/javascript" src="http://www.qualityontime.eu/syntax/scripts/shBrushSql.js"></script>
<script type="text/javascript" src="http://www.qualityontime.eu/syntax/scripts/shBrushXml.js"></script>
<script type="text/javascript" src="http://www.qualityontime.eu/syntax/scripts/shBrushPlain.js"></script>
<script src="http://www.qualityontime.eu/syntax/scripts/shAutoloader.js" type="text/javascript"></script>
<!-- http://alexgorbatchev.com/SyntaxHighlighter -->
<script type="text/javascript">
SyntaxHighlighter.all()
</script>

<div class='old-comments'></div>