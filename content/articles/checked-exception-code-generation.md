---
title: "From checked Exception to code generation"
kind: article
created_at: 2013-03-07 20:27:25 +0000
author: "Takács Ottó"
published: true
tags: java,development,productivity,articles
---
<h1 id="from-checked-exception-to-code-generation">From checked Exception to code generation</h1>
<p>Mi is ez? Nyavajgás és picsogás mennyire fárasztó a Java, ha már ismersz más koncepciókat is</p>
<p>Többféle vélemény van arról, hogy miként kell kivételeket (polgári néven Exception) kezelni. Java-ban két fő kivétel van:</p>
<ul>
<li>amit kezelni kell</li>
<li>amit nem kell kezelni</li>
</ul>
<p>Mikor azt írom nem kell kezelni nem azt jelenti, hogy hagyjuk figyelmen kívül. Csupán arról van szó, hogy Java-ban nem jól van kezelve. Pontosabban alap Java API nem kezeli jól.</p>
<p>Bárhová tévedsz checked exceptionökbe futsz bele. Nem tudod kikerülni. Még azokban az esetekben is, amikor API szinten lehetőséged van arra, hogy kivételkezelés nélkül is teljesen szabályos kódot tudj írni.</p>
<p>Iskolapélda a filekezelés. Alap, hogy file művelet előtt ellenőrzöd létezik-e, írható, olvasható-e (stb) a file. Ha mindent le tudsz ellenőrizni, akkor felteszem nem akarsz minden áron <code>FileNotFoundException</code>-t kezelni. Teljesen elégedett lennék azzal, ha ez csak simán RuntimeException lenne. Jöjjön csak a nagy Exception, de kelljen minden áron lekezelnem. Főleg, ha nem is tudok vele mit kezdeni.</p>
<p>És itt a másik indok. A dobálódzó kivételek jelentős részét nem lehet értelmesen lekezelni. Azon kívül, hogy a felhasználót/programozót értesítem a lehetőségről, semmi mást nem tudok tenni. Semmit (az esetek 90%-ban)!</p>
<p>Nagyos sok és jó érvet lehet találni a neten. De nekem leginkább a Spring adja a referenciát. Mivel a Spring az egyik legjobban kitalált szoftvercsomag és nem kényszerít minden áron a kivételkezelésre, hanem hagyja, hogy az intelligenciád döntsön felőle, elegendő bizonyítékot kell szolgáltatnia bárkinek.</p>
<p>De azért vannak még vélemények:</p>
<ul>
<li><a href="http://c2.com/cgi/wiki?TheProblemWithCheckedExceptions">The Problem With Checked Exceptions</a></li>
<li><a href="http://java.dzone.com/articles/checked-exceptions-i-love-you">&quot; I would go as far as 98% of catch blocks are meaningless&quot;</a></li>
<li><a href="http://www.artima.com/intv/solidP.html">Failure and Exceptions</a></li>
<li><a href="http://www.mindview.net/Etc/Discussions/CheckedExceptions">Does Java need Checked Exceptions?</a></li>
<li><a href="http://radio-weblogs.com/0122027/stories/2003/04/01/JavasCheckedExceptionsWereAMistake.html">Java's checked exceptions were a mistake</a></li>
</ul>
<p>Nem Springet használ az ember. Mindenkinek megvan a maga kedvenc utility library-je. De abban biztos vagyok, hogy Jakarta Commons család sokak kedvence. De általános betegsége, hogy nem foglalkozik a kivételekkel. Hanem simán továbbdelegálja a hívó programegységnek, azaz nekünk. És már kezdhetjük is írni a try-catch blokkokat és throws deklarációkat.</p>
<p>Az évek során rendszeres rutinommá vált, hogy használt commons utilokhoz wrapper osztályokat írok, amik csak delegálják a hívást és bármilyen exception is jön szépen becsomagolják egy RuntimeException-be. Végül is csak egyszer kell csinálni.</p>
<p>Egyszer? Sajnos nem. Céget és országot is váltottam. Több párhuzamos egymástól független projektben is részt vettem. És minden esetben újra kellett implementálnom ugyan azt. Nem nehéz, de már meguntam. Nosza generáljuk ki.</p>
<p>De nem olyan egyszerű. Van amiben az Eclipse elég sok segítséget tudott nyújtani, de még mindig macera volt.</p>
<p>Nosza írjunk egy scriptet, ami szépen elvégzi a generálást. Maga a generálás nem is nehéz. Ami gond az Java forrás feldolgozása. Kis kutakodással találtam pár parsert és a <a href="https://code.google.com/p/javaparser/">javaparser</a> elég egyszerű volt ahhoz, hogy fel is használjam.</p>
<p>(Groovy)</p>
<pre class="sourceCode java"><code class="sourceCode java">Map convertables = [<span class="st">&quot;eu.qualityontime.commons.io&quot;</span>: [
    /r:\environment\docs\commons-io<span class="fl">-2.1</span>\src\main\java\org\apache\commons\io\CopyUtils.<span class="fu">java</span>/,
    <span class="co">//... additional files</span>
  ], 
  <span class="st">&quot;eu.qualityontime.commons.io.filefilter&quot;</span>:[
    /r:\environment\docs\commons-io<span class="fl">-2.1</span>\src\main\java\org\apache\commons\io\filefilter\FileFilterUtils.<span class="fu">java</span>/
    ]]

File targetDir = <span class="kw">new</span> File(/r:\TEMP\target/)
targetDir.<span class="fu">mkdirs</span>()

convertables.<span class="fu">each</span>{String packageName, List&lt;String&gt; files -&gt;
  File packageDir = <span class="kw">new</span> File(targetDir,packageName.<span class="fu">replaceAll</span>(&#39;\\.&#39;, <span class="st">&quot;/&quot;</span>))
  packageDir.<span class="fu">mkdirs</span>()
  files.<span class="fu">each</span>{ filename -&gt;
    println filename
    FileInputStream inp = <span class="fu">openInputStream</span>(<span class="kw">new</span> File(<span class="fu">separatorsToSystem</span>(filename)))
    CompilationUnit cu = JavaParser.<span class="fu">parse</span>(inp)
    StringBuilderWriter sbw = <span class="kw">new</span> <span class="fu">StringBuilderWriter</span>()
    PrintWriter w = <span class="kw">new</span> PrintWriter(sbw)
    StaticDelegateGeneratorVisitor v = <span class="kw">new</span> <span class="fu">StaticDelegateGeneratorVisitor</span>(packageName:packageName, print:w)
    v.<span class="fu">visit</span>(cu, <span class="kw">null</span>)
    println v.<span class="fu">typeName</span>
    File outFile= <span class="kw">new</span> File(packageDir, v.<span class="fu">typeName</span>+<span class="st">&quot;.java&quot;</span>)
    outFile.<span class="fu">createNewFile</span>()
    FileUtils.<span class="fu">write</span>(outFile, sbw.<span class="fu">toString</span>())
  }
}</code></pre>
<p>Maga a generátor sem túl bonyolult:</p>
<pre class="sourceCode java"><code class="sourceCode java"><span class="kw">class</span> StaticDelegateGeneratorVisitor  <span class="kw">extends</span> VoidVisitorAdapter{
  String packageName
  PrintWriter print
  String delegeName
  PackageDeclaration importablePackage

  String <span class="fu">getTypeName</span>(){
    <span class="st">&quot;QoT${delegeName}&quot;</span>
  }

  @Override
  <span class="kw">public</span> <span class="dt">void</span> <span class="fu">visit</span>(CompilationUnit n, Object arg) {
    print.<span class="fu">println</span> <span class="st">&quot;package ${packageName};&quot;</span>
    <span class="kw">super</span>.<span class="fu">visit</span>(n, arg);
  }

  @Override
  <span class="kw">public</span> <span class="dt">void</span> <span class="fu">visit</span>(PackageDeclaration n, Object arg) {
    importablePackage = n
    <span class="kw">super</span>.<span class="fu">visit</span>(n, arg);
  }

  @Override
  <span class="kw">public</span> <span class="dt">void</span> <span class="fu">visit</span>(ClassOrInterfaceDeclaration n, Object arg) {
    delegeName = n.<span class="fu">getName</span>()
    print.<span class="fu">println</span> <span class="st">&quot;import ${importablePackage.getName()}.*;&quot;</span>
    print.<span class="fu">println</span> <span class="st">&quot;</span><span class="ch">\n</span><span class="st">public class ${getTypeName()}{&quot;</span>
    <span class="kw">super</span>.<span class="fu">visit</span>(n, arg)
    print.<span class="fu">println</span> <span class="st">&quot;}&quot;</span>
  }

  @Override
  <span class="kw">public</span> <span class="dt">void</span> <span class="fu">visit</span>(ImportDeclaration n, Object arg) {
    print.<span class="fu">print</span> n
    <span class="kw">super</span>.<span class="fu">visit</span>(n, arg)
  }

  @Override
  <span class="kw">public</span> <span class="dt">void</span> <span class="fu">visit</span>(MethodDeclaration m, Object arg) {
    <span class="kw">if</span>(!ModifierSet.<span class="fu">isStatic</span>(m.<span class="fu">getModifiers</span>())||!ModifierSet.<span class="fu">isPublic</span>(m.<span class="fu">getModifiers</span>())){
      <span class="kw">return</span>
    }

    japa.<span class="fu">parser</span>.<span class="fu">ast</span>.<span class="fu">type</span>.<span class="fu">Type</span> type=m.<span class="fu">getType</span>()
    List&lt;Parameter&gt; parameters = m.<span class="fu">getParameters</span>()==<span class="kw">null</span>?[]:m.<span class="fu">getParameters</span>()
    List paramname = parameters.<span class="fu">collect</span>{it.<span class="fu">id</span>}
    <span class="dt">boolean</span>  voidReturn = type <span class="kw">instanceof</span> VoidType
    print.<span class="fu">println</span> <span class="st">&quot;  public static ${type} ${m.getName()} (${parameters.join(&#39;, &#39;)}){&quot;</span>
    print.<span class="fu">println</span> <span class="st">&quot;    try{&quot;</span>
    print.<span class="fu">println</span> <span class="st">&quot;      ${voidReturn?&#39;&#39;:&#39;return&#39;} ${delegeName}.${m.getName()}(${paramname.join(&#39;, &#39;)});&quot;</span>
    print.<span class="fu">println</span> <span class="st">&quot;    }catch(Exception e){throw new RuntimeException(e);}&quot;</span>
    print.<span class="fu">println</span><span class="st">&quot;  }</span><span class="ch">\n</span><span class="st">&quot;</span>
    <span class="kw">super</span>.<span class="fu">visit</span>(m, arg)
  }

}</code></pre>
<p>Használd egészséggel!</p>


<div class='old-comments'></div>