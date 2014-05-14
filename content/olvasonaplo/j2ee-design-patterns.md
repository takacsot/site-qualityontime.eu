---
title: "J2EE Design Patterns"
kind: article
created_at: 2012-07-21 22:22:22 +0000
author: "Takács Ottó"
published: true
tags: 
  - review
  - olvasonaplo
  - java
  - design

---
![](http://ec3.images-amazon.com/images/P/0596004273.01._AA240_SCLZZZZZZZ_.jpg)

olvasás: 2006

Eleje bevezető, ami persze semmi különleges.

Második rész prezentáció réteg béli design patternek. Outdated. Struts után szinte semmi sincs. Pár workflows dolog példaképpen belekerült, de semmi különleges nincs benne. Mintha ez az elektronikus kiadás már régi lenne és nem tudja mi történt azóta. Újabb kiadásokban lehet, hogy több minden van. Pl az advanced megoldások között a custom JSP tag-ekre van példa. Kicsit röhej, hogy ezt, mint advanced megoldást hozzák fel.

Harmadik rész az üzleti réteg felőli patternek.

Data Transfer Object, Data Access Patterns, DAO, ORM. Interface patterns, amiből az Service Locator Pattern az érdekes, de nem különleges, csak még én nem találkoztam vele és mellesleg kb. a JNDI-t írja le.

Konkurencia. Mondjuk ez a rész tetszett. Ugyan database concurencyről volt szó, de adott jó pár példát, hogyan is kellene ezt megoldani. Pl Filter, ami dedikálja a connectiont a adott végrehajtó szálnak, majd a transaction proxy, amit minden fölé fel lehet húzni. De egyébként csak akkor érdekes, ha magadnak akarod leprogramozni, hiszen ezeket az mind iBATIS, mind a Hibernate lekezeli. Szóval, csak "saját használatra". Minden mása Fowler könyv után nem új. Persze az implementáció az más kérdés, de is programozási gyakorlat után nem kérdés a megvalósítások kitalálása.

Locking-ra van egy érdekes implementációs példa,mait esetleg alkalmazni is tudnám a céges környezetben. Sokkal flexibilisebb, mint a jelenleg használt.

Messaging, amit még indig nem ismerek,hogy értelmesen tudjam használni és itt is lazán átugrottam. Ezt a részt érdemes lenne feldolgoznom alaposabban. Hasonlóra nem emlékszem a Fowler könyvből.

A végén pár anti-patternt is felsorol. Legtöbbje a hagyományos EJB(EJB2) fejlesztéssel kapcsolatos. Szimpatikus, hogy nem EJB támogatott könyv. 

Asszondja csak ésszel kell élni, tisztára Fowler könyv.

A függelékben minden tárgyalt téma referencia, vagy inkább emlékeztető szinten szerepel.
Összefoglalva ha nem ismered a Fowler könyvet és "csak" Javas vagy, akkor esszenciális. Ha nem csak Javas vagy,akkor is érdemes elolvasni, mert a témák nem csak Java-sak, csak a terminológia (JSP->ASP stb.). A Fowler könyv után viszont nem merem jó szívvel javasolni mint tudásbefektetést. Az alap témák ugyan azok. Szinte csak nyelv és eszközrendszer specifikus dolgokban ad többet, meg pár példa jobban kidolgozott, míg más példák sokkal kevésbé. Ha ingyen hozzá tudsz férni az fenomenális szerencse :).


<div class='old-comments'></div>