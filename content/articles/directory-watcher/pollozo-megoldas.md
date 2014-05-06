---
title: "Pollozó megoldás"
kind: article
created_at: 2012-04-21 22:22:22 +0000
author: "Takács Ottó"
published: true
book: directory-watcher
book_page: 5
---
##Pollozó megoldás

Igazából pollozó megoldást nem kell nagyon programkóddal igazolni, mert alapvetően újgyakorlatnak kell lennie:

1. Könyvtár rekurzív bejárása és megjegyzése
2. várakozni egy kicsit
3. Könyvtár rekurzív bejárása és megjegyzése.
4. Összehasonlítani a 1. és 3. pont eredményeit
5. Különbség kiértékelése alapján lehet továbblépni

Előnye, hogy 

- nem kell operációs rendszer támogatás
- kis adaptációval akár egy távoli FTP rendszer monitorozását is meg lehet oldani
- Oprendszer támogatott megoldásokkal ellentétben távoli könyvtárakon is megbízhatóan működik
- Komplex fájlrendszerbeni változásokat könnyebb lekövetni

Hátránya:

- a már korábban említett folyamatos könyvtárbejárás
- sok idő, ha a fájlrendszer lassú
- nagy könyvtárszerkezetnél a bejárás nagyon rendszerterhelő

Ami viszont érdekesnek találtam az a [jpoller](http://jpoller.sourceforge.net/). Főleg azért érdekes, mert olyan rémületes ábrája van, hogy még átnézni sem volt kedvem, nem hogy megérteni :)

![JPoller class diagram](http://jpoller.sourceforge.net/images/Architecture.jpg)



<div class='old-comments'></div>