---
title: "Miért nincs jó static site generaló és jó web alapú help rendszer."
kind: article
created_at: 2013-03-24 19:00:44 +0000
author: "Takács Ottó"
published: true
tags: 
  - java
---
Mi az a két dolog, ami nagyon hiányzik a Java ecosystemből? Egy jó __static site generator__ és a egy jó __web help rendszer__. (Végig free vagy open source megoldásokról beszélek)

## Mire nem jó a Word és barátai?

Mire nem jó a Word és barátai (Excel, PDF, stb.). Lehet vele szép leveleket és nagyszerű táblázatokat készíteni. Élvezem is. De amire egyáltalán nem alkalmas az a **bármilyen szoftverrel kapcsolatos dokumentáció**. 

Minden ami szoftverrel kapcsolatos, így a dokumentáció is olyan, mint annak alapja, hogy __verziózott__ legyen. Tipikusan __többen dolgoznak__ rajta és __követni kell a változásokat__. Aki már dolgozott olyan dokumentummal, aminek mindenféle verziója létezett párhuzamosa (tipikusan a file nevében jelölve, hogy mennyire friss) és némelyik módosítás során az új verziót kell a régebbivel összehasonlítani, más esetben meg változáskövetéssel bekacsolt Word dokumentummal kell égetni a szemed, akkor tudod, hogy miért fontos. 

Másik a __kereshetőség__. Még a legnagyobb és legfejlettebb IT céges környezetben is dominál az egyszerű megosztott könyvtár, amit minden érintett elér. Egyszerűnek tűnik, hisz ha kell valami, akkor ott meg fogod találni. 

De mégis mennyi dokumentum után válik hasznavehetetlenné? 10? 100? 1000? 

És egy bináris Word vagy Excel file-ban nem olyan triviális keresni, ha nem a "kedvenc" szövegszerkesztődet használod. Vegyél kb. 1000 Word dokumentumot (legyünk optimisták és mindegyiknek csak a legfrissebb verziója van jelen) és próbáld benne keresni a téged érdeklő dolgokat. Filerendszer alapú keresés (pl. totalcmd) használhatatlan, hiszen bináris állományokról van szó. Egyenként megnyitni több száz Word dokumentumot az meg kész rémálom. (régen volt google desktop, ami nagyon jó volt erre a problémára)

Mindkettőre megoldás lenne egy rendesen használható __document management renszer__. De mint említettem még a legnagyobb IT cégek sem használják.

## Mi legyen Word helyett?

Mi legyen Word helyett? Semmi különleges. Csak sima txt file és semmi több. Könnyen verziózható, könnyen követhető a változása, könnyen kereshető. 

Jöhetne a kérdés: "_és mi van sablonjaimmal és formanyomtatványaimmal, meg a _módszertan_ szerinti dokumentumokkal?_" 

Ha csak egy kicsit is strukturált szöveggel dolgozol (Markdown vagy valami wiki dialektus), akkor könnyedén tudsz generálni akármilyen dokumentumot.  

A kedvenc módszered sablonjaira meg az a válaszom: __Egyetlen egy módszertan sem követeli meg pontosan azt a Word sablont. Amit azok megkövetelnek, az a TARTALOM!__

## De miért nincs egy jó static site generáló?

És el is értünk egyik problémámhoz: generáljuk ki azokat a szükséges dokumentumokat a megfelelő formátumba. Szerintem egy sima HTML kimenet az esetek jelentős többségében több, mint elegendő.

_De akkor miért nem inkább egyből Wiki-be_? Hiszen arra is igaz minden, amit fentebb leírtam.

A szoftver dokumentáció a szoftver része. Pontosabban egy adott dokumentáció halmaz egy adott verziójú szoftverrendszerhez tartozik. Magyarán életciklusok nem szétválasztható. És egy wiki-vel nem tudod megvalósítani ezt az életciklus kötést, hiszen egy teljesen különálló rendszerben (adatbázis) dolgozik. Vannak persze filerendszer alapú wiki implementációk is, de Java-ban nagyon kevés létezik és az is gyatra (alapigény lenne, hogy ne egy könyvtárba hordja össze struktúra nélkül, hanem valami könyvtárszerkezet alapú hierarchiával is tudjon boldogulni). (Egyébként a [VQWiki](http://www.vqwiki.org/) áll legközelebb az én személyes igényeimhez)

Rengeteg static site generáló van. Sajnos a legjobbak, legfejlettebbek mind vagy Ruby vagy Python nyelven íródtak és szükséges a saját futtató környezetük. Én meg olyan környezetben dolgozom (EP), ahol ez nem megoldható. Java alapú megoldások közül szinte egyik sem érdemli meg a "használható" jelzőt. Bővebb értelemben vett Java megoldások közül a [Monkeyman](https://github.com/wspringer/monkeyman)  (Scala) a legjobb. Mivel a bővítéséhez (pl saját formátumú PDF) már kell a  Scala, itt is korlátokba ütköztem.

Marad az a megoldás, hogy saját magam készítek valami használhatót. Nagyon prototípus kezdemény szinten már működik is a [QSiteGen](https://github.com/takacsot/QSiteGen). Használható, de még messze van a boldogság.

## És miért nincs rendes help rendszer?

A __help__ egy speciális szoftver dokumentáció.

Mit értek az alatt, hogy help rendszer? Pontosan azt, amit. Csak nyisd meg bármelyik help-et és látod.

Kell bele:

- tartalom
- beépített kereshetőség (ebben tér el a korábban leírt dokumentációtól)

Semmi más. Például a hierarchikus rendszer tulajdonképpen tudna jönni a tartalomból. Más kérdés, hogy tipikusan egy extra konfigurációs lépést igényel. Magyarán igen nehézkes. 

Nekem egyébként is egy webes alapú help rendszer kell (hiszen webalkalmazásokat fejlesztek). Döbbenetes, hogy a Java mennyire szegényes az alternatívákban. És ami van, az is az igen nehézkesen használható.  (A könnyen használható rendszer az, aminek ha elolvasom egy tutorialját, akkor max. 30 percen belül egy használható végeredményt kapok, anélkül hogy mindenféle manuális varázslatot hajtanék végre.)

A legtöbb help rendszer valami miatt igényli, hogy tartalmon kívül még mindenféle extra konfigurációs állományokat is készítsél. Persze lehet automatizálni, de akkor miért nincs már alapból megoldani?

Egyébként is amire igazán szükség van az nem  konfigurációból kinyert hierarchikus oldalszerkezet, hanem a kereshetőség. Hiszen alapszabály: keresés gyorsabb, mint a navigálás.

## Mit is tud egy ideális help rendszer

1. Filerendszerből dolgozik
2. Automatikusan konvertál a megfelelő formátumba
3. Beépített kereső

Az 1. és 2. pont egy __static site generáló__ is tudja. A 3. pontot pedig egy __indexelő szolgáltatás__. Ha a help oldal publikus lenne, akkor A Google is elég volna. De egy intranet megoldásnál már nehézkesebbek. Ha teljes szabadságod van a környezet konfigurációjában, akkor [Solr](http://lucene.apache.org/solr/) vagy még inkább [nutch](http://lucene.apache.org/nutch/) 

A legszörnyűbb, hogy PHP és más számomra elérhetetlen (mert EP) implementációk tudják ezt. De Java-hoz nem találtam.

Mese nincs: ez is rám vár.

És az egészben az a legszörnyűbb, hogy alapvetően nagyon egyszerű dolgokról van szó. Emiatt meglepő, hogy miért hiányzik.


<div class='old-comments'></div>