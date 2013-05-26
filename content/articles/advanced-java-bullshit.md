---
title: "Advanced Java? Bullshit!"
kind: article
created_at: 2012-04-09 22:00:00 +0000
author: "Takács Ottó"
published: true
tags: articles
---
Mások forráskódjával dolgozni mindig tanulságos volt. A legjobban azt szeretem, mikor tanulhatok belőle. Most is vár pár open source project, hogy alaposabban megismerkedjek a forráskódjával, hogy ellessek megoldásokat és fejlesszem magam. 

Sajnos azért ennek az ellenkezőjét is megtapasztalom.

<!--break-->

néha úgy érzem, hogy naiv vagyok. Azt gondolom hogy vannak olyan programozástechnikai megoldások, amik csak a kezdők számára nem mennek rutinból. ezek egyike, mikor java-ban konstans objektummal szemben végzel kommutatív (felcserélhető) műveleteket (például `equals`). 

Mire is gondolok:

<pre class="brush: java;toolbar: false;tab-size:2"  >
if (moreformats != null && moreformats.length() > 0 && !moreformats.equalsIgnoreCase("All"));
</pre>

Mi ezzel a gond? Semmi. Működik és jól végzi a dolgát. A gond akkor merül fel, mikor olvasnod kell. Kicsit nehézkes.  Van ennél egy olvashatóbb megoldás is:

<pre class="brush: java;toolbar: false;tab-size:2"  >
if(! "All".equalsIngosrcase(moreformats));
</pre>

A kulcs az, hogy konstans objektumnak küldve üzenetet nem kell foglalkoznunk a NULL ellenőrzéssel. 

Nem tűnik nagy nyerésnke, de ha egy kicsit komplexebb példát veszünk jobban látszik a különbség.

<pre class="brush: java;toolbar: false;tab-size:2"  >
        if ((filterName != null && filterName.length() > 0 && !filterName.equalsIgnoreCase("All")) || 
            (moreformats != null && moreformats.length() > 0 && !moreformats.equalsIgnoreCase("All")) ||
            (moredate != null && moredate.length() > 0 && !moredate.equalsIgnoreCase("All")) ||
            (secondLang != null && secondLang.length() > 0 && !secondLang.equalsIgnoreCase("All"))) {
            out.println(" | " + labels.getString("from"));
        }
</pre>

<pre class="brush: java;toolbar: false;tab-size:2"  >
        if ((!"All".equalsIgnoreCase(filterName)) || 
            (!"All".equalsIgnoreCase(moreformats)) ||
            (!"All".equalsIgnoreCase(moredate)) ||
            (!"All".equalsIgnoreCase(secondLang))) {
            out.println(" | " + labels.getString("from"));
        }
</pre>

<!-- event to the end of the fiel -->
<link href="http://www.qualityontime.eu/syntax/styles/shThemeDefault.css" rel="stylesheet" type="text/css" />
<script src="http://www.qualityontime.eu/syntax/scripts/shCore.js" type="text/javascript"></script>
<script type="text/javascript" src="http://www.qualityontime.eu/syntax/scripts/shBrushJScript.js"></script>
<script type="text/javascript" src="http://www.qualityontime.eu/syntax/scripts/shBrushJava.js"></script>
<script src="http://www.qualityontime.eu/syntax/scripts/shAutoloader.js" type="text/javascript"></script>
<!-- http://alexgorbatchev.com/SyntaxHighlighter -->
<script type="text/javascript">
SyntaxHighlighter.all()
</script>

<div class='old-comments'></div>