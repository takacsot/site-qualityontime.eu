---
title: "Chapter 11: THE NEED FOR SPEED Optimizing Programs and Writing Efficient Code"
kind: article
created_at: 2010-06-30 13:42:19 +0000
author: "Takács Ottó"
published: true

---
<ul>
    <li>Think about the performance of your program from the very start&mdash;do not ignore it, hoping to make quick fixes at the end of development.</li>
    <li>Correct code is far more important than fast code. <em>There&rsquo;s no point in arriving quickly at the wrong answer</em>.</li>
    <li>Look for alternatives to optimizing code&mdash;can you increase your program&rsquo;s performance in any other way?</li>
    <li>Understand when you do need to optimize code, but prefer to write efficient high-quality code in the first place.</li>
    <li>Optimize your code separately from any other work, so the outcome of one task doesn&rsquo;t cloud the other.</li>
    <li>Optimize release builds of your program, not development builds.</li>
    <li>Tip: Test an individual function&rsquo;s impact on the total program execution time by making it slower. If you suspect that a particular function is causing a slowdown, try replacing its call with two calls in succession, and measure how it affects execution time.  If the program takes 10 percent longer to run, then the function consumes approximately 10 percent of execution time. Use this as a very basic timing test.</li>
    <li>Don&rsquo;t rely solely on a profiler to find the causes of program inefficiency; you might miss important problems.</li>
    <li>Never try to optimize code without performing some kind of before and after measurement.</li>
    <li>Prefer to replace a slow algorithm with a faster variant than to tinker with the algorithm&rsquo;s implementation.</li>
</ul>

<div class='old-comments'></div>