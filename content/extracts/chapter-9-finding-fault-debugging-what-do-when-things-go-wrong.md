---
title: "Chapter 9: FINDING FAULT Debugging: What to Do When Things Go Wrong"
kind: article
created_at: 2010-06-07 20:25:37 +0000
author: "Takács Ottó"
published: true
tags: extracts
---
<ul>
    <li>Build your code with all compiler warnings switched on. It will highlight potential problems before they can bite.</li>
    <li>Always follow the golden rule of debugging: <em>Use your brain.</em></li>
    <li>Set a reasonable time limit for &ldquo;unstructured&rdquo; debugging, and then resort to more methodical approaches if you don&rsquo;t find success.</li>
    <li>Learn the code you&rsquo;re debugging&mdash;you can&rsquo;t expect to find errors in code you don&rsquo;t understand.</li>
    <li>When you look for a fault, suspect everything. Eliminate even the unlikeliest of causes first, rather than presume they have nothing to do with it. Assume nothing.</li>
    <li>When your build fails, look at the first compiler error. Trust this far more than the subsequent messages.</li>
    <li>Debugging is a methodical activity, slowly closing in on the location of a fault. Don&rsquo;t treat it like a simple guessing game.</li>
    <li>The first step to locating a fault is finding out how to reproduce it reliably.</li>
    <li>Start from what you know&mdash;the point of a program crash, for example. Then work back from there to the cause of the failure.</li>
    <li>Once you think you&rsquo;ve found the cause of a bug, investigate it thoroughly to prove that you are right. Don&rsquo;t blindly accept your first hypothesis.</li>
    <li>Fix bugs with the utmost care. Don&rsquo;t risk breaking anything else with your modification.</li>
    <li>When you fix a bug, check to see if the same mistake is lurking in related sections of code. Exterminate the bug once and for all: Fix all occurences of the fault now.</li>
    <li>With each fault you fix, learn the lessons. How could you have prevented it? How could you have discovered it more quickly?</li>
    <li>Use debuggers sparingly, when you encounter behavior you can&rsquo;t explain. Don&rsquo;t reach for them routinely to use as an alternative to understanding how your code works.</li>
</ul>


<div class='old-comments'></div>