---
title: "Mit tegyünk, ha a Scrum nem jó?"
kind: article
created_at: 2010-05-30 12:07:23 +0000
author: "Takács Ottó"
published: true
tags: 
  - it
  - management
  - productivity

---
Mikor __Agile__ szoftverfejlesztés szóba kerül, akkor önkéntelenül mindenki a __Scrum__-ra gondol, pedig nem így van. [Korábbi írásomhoz](/extracts/megertik-es-atelik-munkajukat-scrum-modszerrol-1-resz) érdekes és tanulságos hozzászólások születtek. Több ötletet és elgondolást találtam, amit hasznosítani tudok.

Egy dolog biztosan kiderült: az __agile módszereknek van feltétele__. Ezt a feltételt leginkább cég szinten kell biztosítani erre nagyon jó megoldás lehet, ha a cégvezetés elsajátítja a Franklincovey cégvezetési elveket. Az elvek azonosak és megvalósításban is nagy hasonlóság van. Pár hete voltam és az egyik legzseniálisabb képzésen, amin valaha részt vettem.

A nagycéges környezetben való agile használat majdnem lehetetlen abban a formában ahogy a manifesztóban szerepel. De szerencsére nem kell ragaszkodunk hozzá. __Agile csak alapelvek.__ A konkrét fejlesztési módszerek és technikákból össze lehet rakni egy olyan "saját" fejlesztési folyamatot, ami a adott keretek között a __leghatékonyabb__ tud lenne. (Egyébként szeretem a Scrum-ot, sőt SCM papírom is van)

Pár olyan technika és módszer, ami saját tapasztalatom szerint __bevált és javítja a fejlesztési folyamatot__:

* __Iteratív fejlesztés__: A nagyot tervezünk és onnantól kezdve kidolgozzuk és fejlesztünk és a végén majd meglátjuk mennyire sikerült elkészülnünk nem olyan hatékony. Sokkal praktikusabb, ha __rendszeres ellenőrző visszacsatolásokat__ iktatunk be. Ügyfélnek lehetősége van megvizsgálni az eredményeket és mi az alapján módosíthatjuk a munkafolyamatunkat.
* __Inkrementális delivery__: tapasztalatom szerint __minden fejlesztés felbontható__ önállóan is __kerek egész__, __tesztelhető__ falatokra. Ezeket a falatokat elkészítjük és __átadjuk__. Az átvevő nem is minden esetben a végső ügyfél hanem egy belső tesztelő csapat. Az tesztelés eredményeként megkapjuk azt a __visszajelzést__, amivel korrigálni tudjuk a szoftvert. A legjobb az, ha az iteratív fejlesztést összekombináljuk az inkrementális szállítással.
* __"big visible charts"__: burndown, sprint dashboard stb. Alapszabály, hogy minden résztvevőnek minden pillanatban tisztában kell lennie, hogyan is áll a projekt. Alapszabály, hogy __3 másodperc__ alatt képet kell kapnunk. Ez egy eszköz arra, hogy a célok világosak legyenek és mindenki tudja, mi a legfontosabba projekt egészére vonatkoztatva. Sokan lebecsülik ezt az eszközt, mert olyan "gyermeteg", bagatel. De ugyan ezek az emberek küzdenek azzal, hogy nem tiszta ki mit csinál és kérdezgeti a fejlesztőt, hogyan is áll mosta  fejlesztés. Pedig ha lenne egy egyszerű burndown a kérdései java részére választ kapna.
* __Daily standup__: folyamatos __kommunikáció__. Ritmust ad a napnak. Minden információ naprakészen előkerül. Csak azok nem profitálnak belőle, akik nem akarnak.
* __Retrospektív__: Nincs fejlődés, ha nem, vizsgáljuk meg önmagunkat. Panaszkodásban jók vagyunk. Még ötleteink is akadnak arra nézve, hogy miként lehetne jobbá tenni a saját életünket. De __cselekvés rutinja__ nélkül mindez semmit sem ér.






<div class='old-comments'>
		<div class='one-old-comment'>
			<span class='comment-date'>2010-05-31 10:43:26</span>
			<span class='commenter-name'>akocsis</span>
			<div class='comment-body'>
				<span class='comment-title'>Grat</comment>
				Gratulálok, ez egy jó írás a témáról.

Két megjegyzés:

"az agile módszereknek van feltétele. Ezt a feltételt leginkább cég szinten kell biztosítani erre nagyon jó megoldás lehet, ha a cégvezetés elsajátítja a Franklincovey cégvezetési elveket. "
Igaz, csakhogy általában a cég vezetősége nem biztos, hogy úgy táncol, ahogy a szoftverfejlesztőik akarják. Akkor pedig végképp nem, ha ügyfél-beszállító viszony van közöttük.

"Agile csak alapelvek. "
Ez az, amit még agilis fejlesztés előadótól nem hallottam.
A sok informatikus meg elhiszi, hogy betű szerint kell venni a manifesztót: nem dokumentál, nem tart be folyamatokat, és hülyének tartja az ügyfelét, ha annak ez nem tetszik.
Emiatt tartom az agilis fejlesztést az információs társadalamra káros dolognak.
			</div>
		</div>
		
		<div class='one-old-comment'>
			<span class='comment-date'>2010-05-31 13:25:49</span>
			<span class='commenter-name'>Takács.Ottó</span>
			<div class='comment-body'>
				<span class='comment-title'>Nem kell, hogy a cégvezetők</comment>
				Nem kell, hogy a cégvezetők úgy ugráljanak, ahogy a szoftverfejlesztők akarják. Franklincovey felmérést készített, hogy mi teszi igazán naggyá a legkiválóbb cégeket. És a tapasztalatokat egy kerek egész rendszerbe szervezte, amik elemei önállóan is alkalmazhatóak. ha a cégvezetés igazán kiváló céget szeretne felépíteni, akkor a szoftverfejelsztési részlegben szinte magától ki fog alakulni az agilis fejlesztési módszer.

Pár alapelv by Franklincovey:

- Tiszta cél meghatározás
- Bizalom a cégen belül és kívül is kívül is
- Célok részekre bontás
- big visible charts :) minden célt tisztán és nyilvánosan követhető módon láttatni kell.
- mindenki egyénileg és csoportosan mérve van
- az fejleszthető, ami mérhető is
- heti létfontosságú cél megbeszélések
- Rendszer folyamatos fejlesztése
- akadályok folyamatos eltakarítása
- állandó folyamatfejlesztés
- aktív tehetséggondozás 

és mindezek teljes részleg vagy akár egész cég szintjén.

Eszményien hangzik :)

			</div>
		</div>
		
		<div class='one-old-comment'>
			<span class='comment-date'>2010-06-02 13:55:06</span>
			<span class='commenter-name'>akocsis</span>
			<div class='comment-body'>
				<span class='comment-title'>Van linked a Franklincovey</comment>
				Van linked a Franklincovey cégvezetési elvek leírásához?

Igazából továbbra is úgy látom, hogy mindegy milyen a cégvezetés, a fejlesztés nem lesz agilis.
Mert a vállalatokat felülről lefelé vezetik, körülbelül úgy, hogy a felsővezetők meghatározzák a stratégiát, azaz feladatokat és céldátumokat az alattuk lévő középvezetőknek. A középvezetők ezek alapján feladatokat és határidőkat szabnak meg az alsóvezetőknek, akik ugyanígy tesznek a beosztottakkal.
A teljesítendő cél, a határidő, sőt még a költségvetés is előre meghatározott. Ez a gondolatmenet, ez a mechanizmus hatja át a vállalat egészét, mert különben darabokra esne.
Ezen nem változtat sem a bizalom, sem a mérhetőség, sem a folyamatfejlesztés, sem a tehetséggondozás.
			</div>
		</div>
		</div>