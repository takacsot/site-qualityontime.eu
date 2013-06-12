---
title: "Chapter 13: GRAND DESIGNS How to Produce Good Software Designs"
kind: article
created_at: 2010-07-15 22:32:07 +0000
author: "Takács Ottó"
published: true
tags: extracts
---
<ul>
    <li>There are two ways of constructing a software design: One way is to make it so simple that there are obviously no deficiencies, and the other way is to make it so complicated that there are no obvious deficiencies. The first method is far more difficult.</li>
    <li>Think before you type; establish a coherent design. Otherwise you&rsquo;ll end up with chaotic code.</li>
    <li>Less is more. Strive for simple code that does a lot with a little.</li>
    <li>It&rsquo;s a complicated job to make something simple. If a code structure looks obvious, don&rsquo;t assume that it was easy to design.</li>
    <li>Design modules that are internally cohesive with minimal coupling. The decomposition must represent a valid partition of the problem space.</li>
    <li>Draw lines in the sand that people don&rsquo;t need to cross: Identify clear APIs and interfaces.</li>
    <li>Design for extensibility, but don&rsquo;t be hopelessly general&mdash;you&rsquo;ll end up writing an OS, not a program.</li>
    <li>Do it once. Do it well. Avoid duplication.</li>
    <li>Manage the portability of your code in its design, rather than hacking it in as an afterthought.</li>
    <li>No one is born able to design code: We learn.</li>
    <li>Take a pragmatic approach to design tools and methodologies&mdash;use them when they are genuinely helpful&mdash;but don&rsquo;t become a slave to them.</li>
</ul>
<ul>
    <li>The architecture is the single largest influence on the design and future growth of a software system. It is therefore essential to get it right in the early stages of development.</li>
    <li>Capture system architecture in a known place; a document accessible to everyone involved&mdash;programmers, maintainers, installers, managers (perhaps even customers).</li>
    <li>The architecture is the initial system design. It is therefore the first developmental step after the requirements have been agreed upon.</li>
    <li>An architecture specification is an essential device to communicate the shape of your system. Ensure that you keep it in sync with the software.</li>
    <li>Architecture identifies the key components of the system and how they interact. It doesn&rsquo;t define how they work.</li>
    <li>A good architecture leaves space for maneuverability, extension, and modification. But it isn&rsquo;t hopelessly general.</li>
    <li>Recognize the key architectural styles and appreciate their pros and cons. This will help you to sympathetically work with existing software and perform appropriate system design.</li>
</ul>

<div class='old-comments'></div>