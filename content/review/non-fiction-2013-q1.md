---
title: "Non Fiction 2013 Q1"
kind: article
created_at: 2013-03-29 10:39:52 +0000
author: "Takács Ottó"
published: true
tags: it,agile,management,olvasonaplo,articles
---
## [The mythical man-month](http://moly.hu/konyvek/frederick-p-brooks-the-mythical-man-month)

Újraolvasás.

Jó könyv, de megvenni nem javaslom. A könyv maga szolgáltatja a kivonatot. A 18. fejezet a korábbi fejezetek kivonatát tartalmazza. Abból lelehet vonni a tanulságot. Akkor mégis mért olyan jó, ha nem is kell az egész. Egyszerű. A példák és tapasztalatok régiek. A legtöbb esszé a 70-es években született. Akkoriban mások voltak a nagyságrendek és a legtöbb szoftver nem is volt olyan széles körben elterjedve, mint manapság a legtöbb. De a következtetések, alapigazságok nem sokat változtak.

Jó kivonatot lehet a WikipediÁn olvasni.

## [Peopleware productive projects and teams](http://moly.hu/konyvek/tom-demarco-timothy-lister-peopleware-productive-projects-and-teams)

Újraolvasás.

Étvágygerjesztő ajánlóban Ed Yordon azt írja, hogy ez egy olyan könyv, amit meg kell venned a főnöködnek. Ha pedig te vagy a főnök, akkor vedd meg minden beosztottadnak és a te főnöködnek is. Még az olvasás elején nagyon marketingszagú mondat volt, de így a végén már azt kell mondanom, hogy tökéletesen igaz. Olyan könyv, amit egyszer elolvasol és jó, de ettől függetlenül minden évben elő kell venned, hogy ne veszíts el a fókuszt, ne vigyenek át a sötét oldalra.

## [Óriás léptek](http://moly.hu/konyvek/anthony-robbins-orias-leptek)

Meglepően érdektelen. Nem bírtam átvergődni rajta.

## [Gradle Effective Implementation Guide](http://moly.hu/konyvek/hubert-klein-ikkink-gradle-effective-implementation-guide)

Szemétre a maven-vel.

Gradle build rendszer referenciakönyve. 

Sokkal jobb, mint a manapság olyan népszerű Maven. 

- használja a maven repositorikat dependency kezeléshez (ez momentán a legjobb dolog, amit a Maven hozott)
- zéró konfigurációval builder projektekt. A nem triviálisokat is a pluginek segitségével. 
- Groovy, mint programozási nyelv van mögötte, ha valami mégsem lenne elég.
- telepítés nélkül is működik 
- sima IDE integráció
- legnagyobbak is használják (Spring Source)

Szóval: flexibilis, zéró konfiguráció és még meglévő maven repot is kezel. Nem is kell több.

## [JavaScript testing](http://moly.hu/konyvek/liang-yuxian-eugene-javascript-testing)

Sok olyan JavaScript probléma,ami fel sem merül, ha nem plain javascriptet használsz, hanem valami frameworkot, mint pl. JQuery. 
Olyan technikákat ismertet debuggolásban, amik nevetségesek , ha már egyszer láttál firebug-ot vagy Chrome böngészőt.

Magyarán tényleg nagyon alapfokú és kezdőknek szól. 
És már a könyv felénél vagyunk.

Második felétől kezd hasznosabb és érdekesebb is lenni. Végül is egyre jobb tippeket és technikákat kapok. De még mindig nem éri meg a pénzét.

Majd van pár debugging tool bemutatása is, de max. azoknak infó, akik még nem láttam debuggert és hasonló eszközöket.

A Testing tool fejezettől vártam volna valamit, de csak 2 tool igencsak rövid bemutatására futotta.

Summa: le ne vedd a polcról, ha már csináltál webfejlesztést, és nem tök kezdő vagy informatikában.


## [Test-Driven JavaScript Development](http://moly.hu/konyvek/christian-johansen-test-driven-javascript-development)

Nagyon jó! Minden ami a _JavaScript testing_ könyvből hiányzik.

## [Java 7 Concurrency Cookbook ](http://moly.hu/konyvek/javier-fernandez-gonzalez-java-7-concurrency-cookbook)

Jó referenciakönyv. 
Receptkönyv, ami leírja hogyan használd az egyes elemeket. De sajnos ezek le vannak írva neten is. Szóval Könnyebb Google keresést csinálni, mint ezt lapozgatni.

Ami nekem hiányzott: 
1. receptek feltételezték, hogy tudod pontosan mit akarsz csinálni. nekem az is kellene, hogy melyik (üzleti) esetben melyik megoldás lenne a legcélravezetőbb. 
2. A hogyan teszteljünk konkurens programokat rész egy szem assert-et sem tartalmaz. Nem is nagyon értem miért van a fejezet nevében a Test.

A [Java Concurrency in Practice](http://moly.hu/konyvek/brian-goetz-tim-peierls-joshua-bloch-joseph-bowbeer-david-holmes-doug-lea-java-concurrency-in-practice) jobb.

## [The ThoughtWorks Anthology 2](http://moly.hu/konyvek/the-thoughtworks-anthology-2)

Kellemesen jó volt. Minden esszé jó témákat boncolgatott. Bár sokszor volt olyan érzésem, hogy csak azért szaporítja a szót, hogy több oldal legyen.

És annyira nem lehet hasznos, hiszen konkrétan semmire sem emlékszem belőle.

## [CoffeeScript Programming with jQuery, Rails, and Node.js](http://moly.hu/konyvek/michael-erasmus-coffeescript-programming-with-jquery-rails-and-node-js)

JavaScript ereje a problémái nélkül.

Egyetlen hátránya, hogy kell egy compiler, JavaScript-re fordítja. Az eredmény script meglepően olvasható. Gond nélkül kezeli bármelyik JS library-t, mivel ez csak a JavasScript-re tesz egy másik szintaxis réteget. 

Ha találok Java alá egy jó kis on-the-fly fordítót, akkor élesben is használni fogom.

## [Domain Specific Languages](http://moly.hu/konyvek/martin-fowler-domain-specific-languages)

Meglepően unalmas volt.

Nem az írás stílusával vagy tartalom minőségével volt a gond, hanem magával az alaptémával.

Egyszerűen nem érdekelt annyira, hogy lekössön. 
Igazából csak pár External DSL parsing technikát emésztettem sokáig és az internal DSL szekciókban találtam pár érdekes gondolatot (a trivialitásokon túl). 

Jó lesz arra, hogy ha kell, akkor újra elővegyem. Már tudom, hogy milyen jellegű DSL problémákra, milyen jellegű megoldások vannak.

## [Specification by Example](http://moly.hu/konyvek/gojko-adzic-specification-by-example)

Röviden: Specifikáció és test automatizálás.

Nagyon jó koncepciót vázol fel a példákon keresztüli specifikálásról. Csupa-csupa megszívlelendő tanács. Második fele inkább foglalkozott a teszt automatizálással. előnyök, buktatók, best practice-ek.

Minden tanács megszívlelendő.

DE…

A tesztelési rész akármilyen jó. Teljesen mindegy milyen jó specifikációs tanácsokat ad. Nem elég. Felkelti a vágyat, de szinte semmi konkrét eszközt nem ad, amivel a koncepciót megvalósíthasd. Folyamatosan beszél a „Specification by example”-ről de jó ha 2-3 példát (triviálisokat) hoz fel, hogyan is néz ez ki a valóságban. Amit én szeretnék látni az egy valós életbeli példa egy nagyobbacska üzleti alkalmazásból. Egy olyan, ahol jól működik.

Magyarán nem alapmű, vagy alapvetés, hanem egy jó kis kiegészítő mű….csak még nem tudom, hogy mihez.

## [Akka Essentials](http://moly.hu/konyvek/munish-k-gupta-akka-essentials)

Igazából még nem fejeztem be. 

Referencia jellegű könyv. Az Akka tényleg leveszi az ember válláról a legnehezebb és legnyűgösebb részét az elosztott rendszereknek, job-oknak. 

[Kicsit bővebben nem csak Akka-ról](http://gadget.greenformatics.hu/typesafe-stack-20).

## [Seven Databases in Seven Weeks](http://moly.hu/konyvek/eric-redmond-jim-r-wilson-seven-databases-in-seven-weeks)

Igazából azért olvastam el, hogy képbe kerüljek a NoSQL adatbázisokkal. Mik az előnyeik, hátrányaik, legpraktikusabb felhasználási feltételeik. 
És meglepő módon mindenre választ kaptam. 

Summa: SQL nem halott, csak nem jó mindenre. NoSQL nem az új [Silver Bullet](http://en.wikipedia.org/wiki/No_Silver_Bullet), de a megfelelő problémára ez a megfelelő eszköz. 


<div class='old-comments'></div>