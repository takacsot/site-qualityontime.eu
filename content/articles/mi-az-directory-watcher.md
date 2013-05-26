---
title: "Mi az a Directory Watcher?"
kind: article
created_at: 2012-03-17 21:22:22 +0000
author: "Takács Ottó"
published: true
tags: articles
---
Mi is a directory watcher? Mire is használható? Egyáltalán miért is kellene nekem egy ilyen eszköz? Pár szót ejtek a már ismert implementációkról is.

Mi is az én problémám?
------------
Ahhoz, hogy lásd, hogy miként kerültem ebbe a problémakörbe látni kell, hogy miként is írok meg egy-egy bejegyzést. 

Rengeteg ötletem van és ezeket igen hamar le is írom. Vallom az elvet, hogy semmit sem szabad fejben tartani (lásd GTD). A gondolatok mindenhonnan jönnek. Saját blogom írásai akár munkahelyi dokumentum elkészítése során. Minden gondolat megéri az a maga kis helyét a GTD rendszeremben, hogy később kiforrja magát és a végén valami jelentős eredményt érjek el vele.

Ennek következményeképp sok-sok gondolatötlet gyűlik össze. Nem minden van ki is dolgozva és ráadásul nem is mindegyik van publikálva.

De ha elkezdem a kidolgozását, akkor már konkrétan Markdown állományokkal dolgozom (valójában már az ötleteket is ebben írom). Markdown egy szöveges állomány alapú authoring rendszer. Pontosabban egy önmagában is olvasható szöveges dokumentumot készítek, amit Markdown képes eszközökkel át tudom alakítani HTML, TeX, vagy akár PDF formátumba. Sok blog motor is támogatja a Markdown formátumban írt bejegyzéseket. Arról ne is beszéljünk, hogy egy palin és olvasható TXT formátum mennyivel könnyebben kezelhető verziókövető rendszerekben.

Általában Pandoc-ot használok (bár legutolsó verzióban a pdf generálás már csak LaTeX-en keresztül valósul meg :( ). Általában a következő batch file-t csinálom meg hozzá:

<pre  class="brush: plain;toolbar: false;tab-size:2" >
del result.html
pandoc *.txt -s -o result.html
</pre>

Azaz:

1. törlöm az előző build-ből maradt file-t
2. meghívom a fordítót,ami kigenerálja a HTML eredményt.

Az eredményt már csak betöltöm a böngészőbe, hogy lássam, hogyan is fog kinézni. Mikor újrafordítom, akkor már csak a böngészőt frissítem újra.

Mi is a gondom? A folyamatos compile-check ciklus. Milyen jó lenne, ha írom a szöveget és lementem, akkor már egyből mehetnék a böngészőbe és ellenőrizhetném az eredményt anélkül, hogy futtassam a fenti szkriptet.

Számomra az automatizálás nem csak az hogy gyakran ismétlődődolgot egy gombnyomásra megcsinál, hanem az is, hogy automatikus felismeri, hogy mit kell csinálni. szóval nekem nem is kelljen vele foglalkoznom.

Hol máshol merül még fel a fenti probléma?
------------

Persze az én problémám nem egyedülálló. Számos problémakör van (főleg szoftverfejlesztés területén) ahol a fenti probléma megoldása hasznos lehet:

- Változik a file akkor a megnyitott programba újra be kell tölteni a file-t, hogy a szövegszerkesztő tükrözze a változtatást
- file változásra compilert futtatni.
- Fejlesztés közben minden forráskód változtatásra lefut a unit test. Nem neked kell direktben meghívnod.
- És még kis értesítést is dob az eredményről.
- hasonló formában támogatva trigger-el egy CI szerver futtatást is
-  automatikus deployment távoli rendszerekre. Feltölteni egy ftp szerverre tud igen lassú is lenni. És mikor kész van jó lenne nem mellette ülni és kézzel elvégezni az unalomig ismert lépéseket. Majd a rendszer megcsinálja, ha feltöltődött minden rész teljesen magától.
- automatikus backupot készíteni a változtatásokról
- cleanuppolni application servert, ha új forrás került oda. Aka újraindítani a rendszert.
- Logfile változásokra reagálni automatikusan
- Programtelepítéskor figyelni, hogy a telepítő mi mindent változtatott meg a rendszerben (uninstallerhez, vagy hackelés kiderítéshez)
- Tételezzük fel, hogy integrációs tesztet egy dummy szerveren végezzük el aminek a válaszait konfigurálhatóvá tesszük a fájlrendszeren keresztül. Ezzel a mechanizmussal értesíteni tudjuk a rendszert arról, hogy most már másik választ kell adnia.
- dokumentum kezelő rendszer helyett egy közös, megosztott drivon tárolt projektdokumentációk változásáról értesülni
- stb...

Mit is kell keresni?
------------

De azért nem volt egyszerű megoldást találnom. Pontosabban nem tudtam mik azok a kulcsszavak, amikre a megfelelő választ kapok. rengeteget próbálkoztam. Kereséseim során a következő kulcsszavakat találtam, amik igazán eredményeket hoztak:

- directory watcher
- file watcher vagy poller

Persze nem vakon keresgéltem, hiszen tudtam, hogy vannak ilyen megoldások. Fejlesztések során mindennap tapasztaltam, hogy programok elvégzik a  fenti dolgokat. A gond az, hogy nem tudtam hogyan. 

A célom az volt, hogy egy kellemesen használható programot kapok, ami figyeli a könyvtárat és ha változást észlel, akkor végrehajt valami előre definiált dolgot. Nem kell nekem tudnom, hogy pontosan mi minden változott. Ami nekem kell az csak az, hogy lefusson. 

Elég sok programot találtam, de nem igazán voltam megelégedve:

-  sokat telepíteni kellett. Mármint installerrel. Sajnos egyik sem egy nagyon megbízható helyről jött. Alapvető elvem, hogy egy programról legyen annyi írásos tájékoztató vagy sceenshot, hogy döntést tudjak hozni mielőtt telepítem. Ha csak simán csak letöltöm és futtatom, akkor kipróbáltam volna, de telepítőben nem bízom.
- sharewere/commercial: ami telepítős volt és kielégítette a fenti kritériumokat azokért bizony fizetni kellett volna. Kizárt.
- ugyan ingyenes volt, ne adj isten,  open source, de gyenge minőségű. Elég sok ingyenes program van, ami figyeli a fájlrendszert és szépen kiírja a változásokat. De az engem nem érdekel. Valami konkrét dolgot kellene akkor megvalósítania. De gyakorlatilag konfigurálhatatlanok voltak.

De majd minden helyről kaptam tippeket, amik API/library szintű megoldásokat adnak Java, Ruby, Scala nyelvekhez. A fenti okok miatt megoldást nem találtam a problémámra, hát nekiálltam leprogramozni/scriptet írni, hogy meglegyen a saját kis utility programom a saját problémámra (jó programozónak lenni :) )


Hogyan is kell egy egy directory watcher-t megvalósítani?
--------

Két stratégia van egy ilyen alkalmazás elkészítésére:

1. Egy háttérfolyamat bizonyos időközönként olvassa (pollozza) a fájlrendszert és az aktuális állapotot összehasonlítja az előző futással és az alapján dönti el mi minden történt.
   - Előnye, hogy minden rendszerben viszonylag könnyen megvalósítható.
   - Hátránya, hogy a poll-ozási gyakoriságtól függő mértékben terheli a rendszert. Valamit a vizsgálandó fájlmennyiség függvényében elég lomha is lehet.
2. Rábízzuk az operációs rendszerre, hogy értesítse a programunkat a változtatásokról.
   - Előnye, hogy sokkal jobb a teljesítménymutatója.
   - Kell az operációs rendszer támogatás. Egyszerűen nem mindegyik operációs rendszer támogat mindenféle monitorozást.
   - Natív operációs rendszer támogatás miatt elengedhetetlen valami natív lib használata, ami az interpreteres nyelveknél (ebből a szempontból a Java is az) gondot jelenthet.

De lássuk a medvét, hogy mire is jutottam.
  
<!-- event to the end of the fiel -->
<link href="http://www.qualityontime.eu/syntax/styles/shThemeDefault.css" rel="stylesheet" type="text/css" />
<script src="http://www.qualityontime.eu/syntax/scripts/shCore.js" type="text/javascript"></script>
<script type="text/javascript" src="http://www.qualityontime.eu/syntax/scripts/shBrushJScript.js"></script>
<script type="text/javascript" src="http://www.qualityontime.eu/syntax/scripts/shBrushJava.js"></script>
<script type="text/javascript" src="http://www.qualityontime.eu/syntax/scripts/shBrushRuby.js"></script>
<script type="text/javascript" src="http://www.qualityontime.eu/syntax/scripts/shBrushScala.js"></script>
<script type="text/javascript" src="http://www.qualityontime.eu/syntax/scripts/shBrushSql.js"></script>
<script type="text/javascript" src="http://www.qualityontime.eu/syntax/scripts/shBrushPlain.js"></script>
<script src="http://www.qualityontime.eu/syntax/scripts/shAutoloader.js" type="text/javascript"></script>
<!-- http://alexgorbatchev.com/SyntaxHighlighter -->
<script type="text/javascript">
SyntaxHighlighter.all()
</script>

<div class='old-comments'></div>