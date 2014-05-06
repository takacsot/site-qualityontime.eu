---
title: "Chapter 8: TESTING TIMES The Black Art of Testing Code"
kind: article
created_at: 2010-06-29 13:08:40 +0000
author: "Takács Ottó"
published: true

---
<ul>
    <li>Test everything. Keep what is good.</li>
    <li>The single most important rule of testing is to do it.</li>
    <li>Testing is not debugging. Don&rsquo;t get the two confused. They require different skills. Make sure you know when you&rsquo;re testing and when you&rsquo;re debugging.</li>
    <li>Testing can only discover the presence of faults. It can&rsquo;t prove the absence of faults. Don&rsquo;t be led into a false sense of security by code that passes a suite of inadequate tests.</li>
    <li>It is a programmer&rsquo;s responsibility to test the source code he or she writes.</li>
    <li>You must test every piece of code you write. Don&rsquo;t expect anyone else to do it for you.</li>
    <li>Effective code testing starts early, so you catch bugs when they&rsquo;re least harmful. You can write tests before writing code!</li>
    <li>For each piece of code you write, immediately write a test. Or write the test first.</li>
    <li>Write a test for every fault you find.</li>
    <li>Run your tests as often as you can.</li>
    <li>It&rsquo;s very easy to trust the code you read and to believe that it&rsquo;s correct. When you&rsquo;ve just written some code, you&rsquo;ll read what you intended to write, not what you actually wrote. Learn to look twice&mdash;read all code cynically.</li>
    <li>Write a comprehensive suite of tests, each one exercising a different aspect of the code. Fifteen tests that demonstrate the same fault over and over are less useful than fifteen tests that show fifteen different faults.</li>
    <li>Test randomly generated sets of input data to avoid guesswork. This is a surprisingly effective test strategy.</li>
    <li>Design your code for easy testing. When you structure code for testability, you will be structuring it in a sensible, understandable, and main-tainable way. You&rsquo;ll reduce component coupling and increase cohesion. You&rsquo;ll make it more flexible, easy to use, and easier to wire up in different configurations. Your code will be better. (<em>Testable code is a well designed code - Ottó</em>)
    <ul>
        <li>Make each section of code self-contained, without undocumented and tenuous dependencies on the outside world.</li>
        <li>Don&rsquo;t rely on global variables</li>
        <li>Limit the complexity of your code; break it into small, comprehensible, bite-sized chunks that can be individually tested.</li>
        <li>Make the code observable, so you can see what it&rsquo;s doing, query internal state, and ensure that it&rsquo;s operating as expected.</li>
    </ul>
    </li>
</ul>
<ul>
    <li>Automate your code testing as much as possible. It&rsquo;s quicker and easier than running tests by hand, and it&rsquo;s far safer: The tests are more likely to be run regularly.</li>
    <li>Run unit tests automatically as a part of your build process.</li>
</ul>


<div class='old-comments'></div>