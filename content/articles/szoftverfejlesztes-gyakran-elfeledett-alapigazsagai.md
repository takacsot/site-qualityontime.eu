---
title: "A szoftverfejlesztés gyakran elfeledett alapigazságai "
kind: article
created_at: 2010-10-06 19:50:56 +0000
author: "Takács Ottó"
published: true
tags: 
  - development
  - agile
  - productivity
  - quality
---
Csak ezen a héten találkoztam ezzel a cikkel. A blog szerzőjének (Marhefka István) engedélyével publikálom újra.

Az eredeti fordítást az [http://infokukac.com](http://infokukac.com/2010/01/a-szoftverfejlesztes-gyakran-elfeledett-alapigazsagai-forditas/) oldalon található.

<!--break-->

Véletlenül találtam rá Robert L. Glass cikkére, amely a “Frequently Forgotten Fundamental Facts about Software Engineering” címet viseli.  Nagyon tetszett, véleményem szerint sok igazságot tartalmaz. Úgy gondoltam, érdemes lefordítani magyarra. A cikk 2001-ben írodott, nyomokban tartalmaz olyan gondolatot, ami 9 év elteltével már nem annyira aktuális, de ennek ellenére még mindig megállja a helyét.

##Robert L. Glass: A szoftverfejlesztés gyakran elfeledett alapigazságai

Ez a cikk egyszerű gyűjteménye azon szoftverfejlesztéssel kapcsolatos tényeknek, alapigazságoknak, amelyekben hiszek. Ezt a listát azért teregetem itt ki, mert túl sok ember, aki magát szoftverfejlesztőnek, -tervezőnek, informatikusnak, programozó matematikusnak stb. tartja, egyáltalán nincs tisztában vele, vagy lehet, hogy egyszerűen már elfeledte.

Nem várom el, hogy egyetérts mindenben, talán az igazságok némelyike fel is fog idegesítni. Én örülök ennek, legalább elkezdődhet egy párbeszéd közöttünk, hogy mely tények valóban tények, és mi csupán az én élénk, kritikus képzeletem szüleménye. Most már elég a bevezetőből: lássuk, mik a leggyakrabban elfeledett alapigazságok a szoftverfejlesztésben!

###Komplexitás

[C1] A probléma komplexitásának 10% növekedése, a szoftvermegoldás komplexitásában 100%-os növekedést eredményez. Ne is próbáljuk ezt a körülményt elkerülni (habár a komplexitás csökkentése minden esetben kívánatos), ez egyszerűen így van. (Hogy miért igaz ez, ld. az RD2-es pontot a “Követelmények és tervezés részben”.)

###Az emberek

[P1] A legfontosabb tényező, amelynek a segítségével szembenézhetünk a komplexitással nem az a számos eszköz és technológia, amelyet a fejlesztők alkalmaznak, hanem sokkal inkább a minőségi fejlesztők maguk.

[P2] A jó fejlesztők akár 30x jobbak is lehetnek a középszerű programozóknál, az “egyéni különbségek” (“individual differences”) kutatás szerint. A fizetésük nem lehet alkukérdés, a szoftveriparban ők jelentik a legnagyobb üzletet.

###Eszközök és technológiák

[T1] A legtöbb szoftvereszköz és -technológia kb. 5-30% produktivitás- és minőségnövekedést eredményez. Egyszer valaki kitalálta, hogy ezek egy nagyságrendbeli előnnyel kecsegtetnek (10-es szorzó). A hype-olás a szoftverfejlesztés pestise.

[T2] Egy új eszköznek, technológiának a megtanulása kezdetben a fejlesztő produktivitásának hanyatlását és a termék minőségének csökkenését eredményezi. Csak akkor várhatjuk a tényleges előnyöket, ha a tanulási időszakon túl vagyunk.

###A minőség

[Q1] A minőség bizonyos tulajdonságok halmaza. Mindenki különbözőképpen definiálja ezen tulajdonságokat, a leggyakrabban elfogadottak azonban a hordozhatóság, megbízhatóság, teljesítmény, ergonómia, tesztelhetőség, érthetőség és módosíthatóság.

[Q2] A minőség nem egyenlő a felhasználói elégedettséggel, a követelményeknek való megfelelőséggel és a költség, ill. határidő korlátok betartásával, azonban ezek között egy érdekes kapcsolat áll fenn: Felhasználói elégedettség = a termék minősége + követelményeknek való megfelelőség + szállítás a szükséges időben + megfelelő költségek.

[Q3] Mivel a minőség nem csupán a megbízhatóságot jelenti, ezért sokkal többről szól, mint a szoftverhibákról.

[Q4] Ha az egyik minőséggel kapcsolatos tulajdonságon javítunk, az gyakran a másik rovására megy. Pl. ha a teljesítményen növelünk, az gyakran a módosíthatóság rovására megy.

###Megbízhatóság

[RE1] A hibák keresése és javítása durván 40%-a a kifejlesztés költségének. Ezért ez a legfontosabb fázis a (ki)fejlesztés életciklusában.

[RE2] Vannak bizonyos hibák, amelyket a programozók viszonylag gyakran elkövetnek. Ezek közé tartozik az off-by-one hiba (másnéven: +/- 1-es hiba), a definition vagy reference inconsistency (ha vki tudja, mire gondol a szerző, szóljon! – ford.), ill. a mélyebb tervezési döntések mellőzése. Ezért az olyan technikák, mint pl. az N-verziós (vagy többverziós) programozás, amely több, különböző fejlesztőktől származó megoldás alapján kísérel meg egy helyes végeredményt megállapítani, kudarcra vannak ítélve.

[RE3] Amikor egy tipikus programozó azt hiszi, hogy a program alaposan le van tesztelve, valójában kb. 55-60%-a van megfuttatva a kód logikai útvonalainak. Az automatizált eszközök, mint pl. a kódlefedettség-elemzők megemelhetik ezt a szintet 85-90%-ra. A 100%-os szint elérése szinte lehetetlen.

[RE4] Még ha a 100%-os kódlefedettségi szint elérhető is lenne (ld. RE3), akkoris a 100%-os lefedettség elégtelen kritérium lenne a teszteléshez. A szoftverhibák durván 35%-a köszönhető a hiányzó logikai útvonalaknak, a hibák további 40%-a az logikai útvonalak egyedi kombinációinak futtatásából ered. Ezeket nem lehet 100%-os kódlefedettséggel észrevenni. (Ez azt jelenti, hogy a 100%-os kódlefedettség a lehetséges hibák kb. 25%-át képes detektálni!)

[RE5] Nincs legjobb módszer a hibák megszüntetésére. A különféle technikák vegyítése elkerülhetetlen.

[RE6] (RE5 folyománya) A szoftverben mindig maradnak hibák, még a legkeményebb ellenőrzések után is. A cél egyrészt, hogy csökkentsük a számukat, de inkább az, hogy csökkentsük a hatásukat.

###Teljesítmény

[EF1] A teljesítmény sokkal inkább a jó tervezés, jó architektúra kérdése, mint inkább a jó kódolásé. Úgyhogy ha a projekt követelményei között a teljesítmény kitüntetett, akkor azt az életciklus elején figyelembe kell venni.

[EF2] A magasszintű programozási nyelvekben írt kódok futási ideje – a megfelelő fordítói optimalizálások után – akár 90%-át is elérheti a vele egyenértékű, assembly-ben írt kódhoz képest. Ez azonban eléggé feladatfüggő: bizonyos feladatokat sokkal nehezebb hatékonyan magasszintű nyelvekben lekódolni.

[EF3] A méretre vagy futási időre történő optimalizálás egymással ellentétes. Az egyikben történő javítás rontja a másikat.

###Karbantartás

[M1] A minőség és karbantartás között érdekes kapcsolat áll fenn (ld. Q3, Q4).

[M2] A karbantartás tipikusan a teljes szoftverköltség 40-80%-át (átlagosan 60%-át) viszi el. Ezért általában ez a legfontosabb fázis.

[M3] A továbbfejlesztések durván a szoftverkarbantartási költségek 60%-áért felelősek. A hibajavítás csak 17% körül van. Ígyhát a szoftverkarbantartás leginkább a régi programban történő új funkciók hozzáadásáról szól, nem pedig a hibajavításról.

[M4] Az előző két szabályt hívhatjuk a szoftverek “60-60-as szabály”-ának.

[M5] A legtöbb szoftverfejlesztéssel és -karbantartással kapcsolatos feladat azonos – kivéve azt a plusz karbantartással kapcsolatos feladatot, amikor meg kell érteni, hogy mit is csinál a létező termék. Ez a domináns karbantartási tevékenység, kb. 30%-át viszi el a karbantartási időnek. Így aztán nem teljesen alaptalan az az állítás, hogy a karbantartás nehezebb, mint a fejlesztés.

###Követelmények és tervezés

[RD1] A határidőből kifutó projektek egyik leggyakoribb oka az instabil követelmények (a másikat ld. ES1).

[RD2] Amikor a projekt a követelményfelmérési szakaszból a tervezési szakaszba jut, az a “származtatott követelmények” robbanását eredményezi. A tervezési fázisban elkészülő követelménylista gyakran 50x nagyobb az eredeti követelménylistánál.

[RD3] Részben ez a robbanás okolható azért, hogy olyan nehéz nyomonkövetni a követelményeket (az eredeti követelmények megvalósulását az egymást követő projektfázisok egyes projekttermékeiben), annak ellenére, hogy mindenki egyetért, hogy a nyomonkövetésnek meg kellene valósulnia.

[RD4] Egy szoftveres problémára ritkán adódik csupán egy legjobb megoldás. (Bill Curtis egyszer azt mondta, hogy ha egy szoba tele van szoftvertervező szakértőkkel, és bármelyik kettő véletlenül egyetért, akkor az már biztosan többség.) Ennek következménye például az is, hogy az újrafelhasználható tervezési megoldásokra irányuló kísérletek olyan sokáig ellenálltak a jelentős fejlődésnek.

###Review-k és vizsgálatok

[RI1] A szigorú (code) review-k gyakran szüntetik meg a szoftvertermék hibáinak 90%-át még mielőtt az az első teszteléseken átesne. (Sok kutatási eredmény szól erről. Hát, persze! Honnan is tudjuk, hogy mikor találtuk meg az összes hiba 100-át?!)

[RI2] A szigorú (code) review-k sokkal hatékonyabbak, költségkímélőbbek, mint bármely más hibamegszüntető stratégia, beleértve magát a tesztelést is, de nem szabad, hogy magát a tesztelést helyettesítse. (Ld. RE5)

[RI3] A szigorú review-zást jól csinálni extrém kihívás, és a legtöbb szervezet nem is csinálja, legalábbis nem az összes szoftverrel kapcsolatos termékükre (beleértve a dokumentációkat is).

[RI4] A szállítás utáni eredmények áttekintését általában fontosnak tartják, mert mérhető válik az ügyfél elégedettsége, és terepet biztosít a folyamatok fejlesztésére. Mégis a legtöbb szervezet nem csinálja. Amikor ezeket a review-kat meg kellene tartani (3-12 hónappal a szállítás után) a review potenciális résztvevői már szét is szóródtak más projektekre.

###Újrafelhasználhatóság

[REU1] Az újrafelhasználhatóság kicsiben (szubrutinok könyvtárai) kb. 50 évvel ezelőtt kezdődött, és viszonylag megoldott probléma.

[REU2] Az újrafelhasználhatóság nagyban (komponensek szintjén) jórészt még mindig megoldatlan, annak ellenére, hogy mindenki egyetért abban, hogy fontos és kívánatos dolog.

[REU3] Véleménykülönbségek találhatóak abban, hogy _miért_ nem megoldott még mindig a komponens szintű újrafelhasználhatóság. A legtöbben úgy gondolják, hogy nem technológiai, hanem menedzsment probléma (szándék, nem szakértelem kérdése). (Mások szerint az a nehéz, hogy a különféle programozási feladatok között megtaláljuk a közös részproblémát. Ha ez igaz, akkor ez azt jelenti, hogy a “nagybani” újrafelhasználhatóság relatív megoldatlansága a szoftver természetének és a szoftverek által megoldott problémák velejárója.)

[REU4] A nagybani újrafelhasználhatóság kapcsolódó rendszercsaládok között működik a legjobban, ezért szakterületfüggő. Ez leszűkíti a lehetséges alkalmazási lehetőségét.

[REU5] A minta-újrahasznosítás az egyetlen megoldás a kód újrafelhasználhatóságának problémájára.

###Becslés

[ES1] A határidőből kifutó projektek egyik leggyakoribb oka az optimista becslés (a másikat ld. RD1).

[ES2] A legtöbb becslést még az életciklus elején végzik. Ez teljesen érthető, amíg rá nem jön valaki arra, hogy ez az egész még a követelményfelmérés előtt történik, akkor, amikor még nem is értjük a problémát. Ígyhát a becslések legtöbbször rossz időben történnek.

[ES3] A legtöbb becslést – legalábbis néhány kutató szerint – a felső menedzsment vagy a marketing készíti, nem pedig azok az emberek és főnökeik, akik magát a szoftvert készítik. Ígyhát nem is a megfelelő emberek végzik a becslést.

[ES4] Ahogy a projekt halad, a becsléseket ritkán vizsgálják felül. Ígyhát a rossz időben és a nem megfelelő emberek által készített becslés soha nem kerül javításra.

[ES5] Mivel a becslések hibásak, nincs okunk arra, hogy azt feltételezzük, hogy a szoftverprojektek költségen és határidőn belül fognak elkészülni. Pedig mindenki azt hiszi!

[ES6] Egy projekttanulmányban, amely képtelen volt a becslések szerinti elvárásokat teljesíteni, a menedzsment úgy látta, hogy a projekt egy bukás volt, a technikai résztvevők viszont életük legsikeresebb projektjének tartották! Ez jól illusztrálja a menedzsment és a technikai szereplők szemszögéből a becslés szerepének és a projekt sikerének széttartását. A korábbi tények figyelembevételével ez aligha meglepő.

[ES7] A becslések által kitűzött célok elérése gyakran okoz nyomást, amely azt eredményezi, hogy a fejlesztők mellőzik a jó szoftverfejlesztési technikákat. Ez abszurd ok miatti abszurd eredmény.

###Kutatás

[RES1] Sok kutató hirdeti az igét ahelyett, hogy vizsgálódna. Ennek eredményeképpen (a) néhány fennhéjázott fogalom kevésbe értékes, mint amennyire a pártfogója gondolja, és (b) kevés az a kiértékelő kutatás, amely segítene megállapítani az új eszközök és technológiák tényleges értékét.

Ezek hát az én szoftverfejlesztéssel kapcsolatos igazságaim. Mik a Tieid? Azt várom, hogy ha párbeszédet kezdeményezünk egymással, akkor újabb tényekre derülhet fény, amiket vagy kifelejtettem, vagy amiknek nem voltam tudatában. Különösképpen az új tények érdekelnek, de természetesen arra is kíváncsi vagyok, ha valamivel nem értesz egyet.

A szerző címe: rglass@indiana.edu (és angolul várja a hozzászólásokat :) )

[Eredeti cikk](http://www.computer.org/portal/web/buildyourcareer/fa035)

<div class='old-comments'>
		<div class='one-old-comment'>
			<span class='comment-date'>2010-10-07 10:07:32</span>
			<span class='commenter-name'>akocsis</span>
			<div class='comment-body'>
				<span class='comment-title'>Nagyon jó!</comment>
				Valóban nagyon értékés, érdemes volt újra leközölni.
Szinte végig bólogattam :)
			</div>
		</div>
		</div>