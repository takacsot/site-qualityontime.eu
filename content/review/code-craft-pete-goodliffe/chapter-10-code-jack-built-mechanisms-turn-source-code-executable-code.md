---
title: "Chapter 10: THE CODE THAT JACK BUILT Mechanisms to Turn Source Code into Executable Code"
kind: article
created_at: 2010-07-11 22:29:24 +0000
author: "Takács Ottó"
published: true

---
<ul>
    <li>Consider the build system a part of the source tree, and maintain the two together. They are intimately entwined.</li>
    <li>Every programmer on a project must use the same build environment. Otherwise you&rsquo;re not all building the same software.</li>
    <li>A good build system allows you to repeatedly create physically identical binary files.</li>
    <li>You must be able to pull out a source tree from three years ago and rebuild it correctly.</li>
    <li>A good build is presented as a single step. You need only push a button or issue one command.</li>
    <li>Establish an automatic build of your software. Use it to ensure that your codebase is in a consistent state.</li>
    <li>If the build breaks, it&rsquo;s everyone&rsquo;s problem.</li>
    <li>Release builds are always made from virgin source. Ensure that these pristine sources can always be retrieved from source control or a backup archive in the future.</li>
</ul>


<div class='old-comments'></div>