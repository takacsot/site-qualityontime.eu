---
title: "Advanced Java? Bullshit!"
kind: article
created_at: 2012-04-09 22:00:00 +0000
author: "Takács Ottó"
published: true
---
Mások forráskódjával dolgozni mindig tanulságos volt. A legjobban azt szeretem, mikor tanulhatok belőle. Most is vár pár open source project, hogy alaposabban megismerkedjek a forráskódjával, hogy ellessek megoldásokat és fejlesszem magam. 

Sajnos azért ennek az ellenkezőjét is megtapasztalom.

néha úgy érzem, hogy naiv vagyok. Azt gondolom hogy vannak olyan programozástechnikai megoldások, amik csak a kezdők számára nem mennek rutinból. ezek egyike, mikor java-ban konstans objektummal szemben végzel kommutatív (felcserélhető) műveleteket (például `equals`). 

Mire is gondolok:

~~~java
if (moreformats != null && moreformats.length() > 0 && !moreformats.equalsIgnoreCase("All"));
~~~

Mi ezzel a gond? Semmi. Működik és jól végzi a dolgát. A gond akkor merül fel, mikor olvasnod kell. Kicsit nehézkes.  Van ennél egy olvashatóbb megoldás is:

~~~java
if(! "All".equalsIngosrcase(moreformats));
~~~

A kulcs az, hogy konstans objektumnak küldve üzenetet nem kell foglalkoznunk a NULL ellenőrzéssel. 

Nem tűnik nagy nyerésnke, de ha egy kicsit komplexebb példát veszünk jobban látszik a különbség.

~~~java
if ((filterName != null && filterName.length() > 0 && !filterName.equalsIgnoreCase("All")) || 
	(moreformats != null && moreformats.length() > 0 && !moreformats.equalsIgnoreCase("All")) ||
    (moredate != null && moredate.length() > 0 && !moredate.equalsIgnoreCase("All")) ||
    (secondLang != null && secondLang.length() > 0 && !secondLang.equalsIgnoreCase("All"))) {
		out.println(" | " + labels.getString("from"));
}
~~~

~~~java
        if ((!"All".equalsIgnoreCase(filterName)) || 
            (!"All".equalsIgnoreCase(moreformats)) ||
            (!"All".equalsIgnoreCase(moredate)) ||
            (!"All".equalsIgnoreCase(secondLang))) {
            out.println(" | " + labels.getString("from"));
        }
~~~
