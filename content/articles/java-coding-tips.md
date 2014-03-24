---
title: "Java coding tips - Minimum JNDI mock for unit tests"
kind: article
created_at: 2012-03-18 17:31:25 +0000
author: "Takács Ottó"
published: true
tags: articles
---
<p><a href="http://en.newinstance.it/2009/03/27/mocking-jndi/">Minimum JNDI mock for unit tests:</a></p>
<pre class="sourceCode java"><code class="sourceCode java"><span class="kw">import javax.naming.Context;</span>
<span class="kw">import javax.naming.InitialContext;</span>
<span class="kw">import javax.naming.NamingException;</span>
<span class="kw">import javax.naming.spi.InitialContextFactory;</span>

<span class="kw">public</span> <span class="kw">class</span> InitialContextFactoryForTest <span class="kw">
implements</span> InitialContextFactory {

    <span class="kw">private</span> <span class="dt">static</span> Context context;

    <span class="dt">static</span> {
        <span class="kw">try</span> {
            context = <span class="kw">new</span> InitialContext(<span class="kw">true</span>) {
                Map&lt;String, Object&gt; bindings = <span class="kw">new</span> HashMap&lt;String, Object&gt;();

                @Override
                <span class="kw">public</span> <span class="dt">void</span> <span class="fu">bind</span>(String 
name, Object obj)
                        <span class="kw">throws</span> NamingException {
                    bindings.<span class="fu">put</span>(name, obj);
                }

                @Override
                <span class="kw">public</span> Object <span class="fu">lookup</span>(String name) <span class="kw">
throws</span> NamingException {
                    <span class="kw">return</span> bindings.<span class="fu">get</span>(name);
                }
            };
        } <span class="kw">catch</span> (NamingException e) { <span class="co">// can&#39;t happen.</span>
            <span class="kw">throw</span> <span class="kw">new</span> RuntimeException(e);
        }
    }

    <span class="kw">public</span> Context <span class="fu">getInitialContext</span>(Hashtable&lt;?, ?&gt; 
environment)
            <span class="kw">throws</span> NamingException {
        <span class="kw">return</span> context;
    }

    <span class="kw">public</span> <span class="dt">static</span> <span class="dt">void</span> <span class="fu">
bind</span>(String name, Object obj) {
        <span class="kw">try</span> {
            context.<span class="fu">bind</span>(name, obj);
        } <span class="kw">catch</span> (NamingException e) { <span class="co">// can&#39;t happen.</span>
            <span class="kw">throw</span> <span class="kw">new</span> RuntimeException(e);
        }
    }
}</code></pre>
<p>Using in test:</p>
<pre class="sourceCode java"><code class="sourceCode java">@Override
    <span class="kw">protected</span> <span class="dt">void</span> <span class="fu">setUp</span>() <span 
class="kw">throws</span> Exception {
        <span class="co">// sets up the InitialContextFactoryForTest as default factory.</span>
        System.<span class="fu">setProperty</span>(Context.<span class="fu">INITIAL_CONTEXT_FACTORY</span>,
                InitialContextFactoryForTest.<span class="fu">class</span>.<span class="fu">getName</span>());

        <span class="co">// binds the object</span>
        dataSource = <span class="fu">getDataSource</span>();
        InitialContextFactoryForTest.<span class="fu">bind</span>(<span class="st">&quot;jdbc/mysql&quot;</span>, 
dataSource);
    }</code></pre>

öüó