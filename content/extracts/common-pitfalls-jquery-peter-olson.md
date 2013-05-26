---
title: "Common Pitfalls of jQuery - Peter Olson"
kind: article
created_at: 2012-05-13 22:22:22 +0000
author: "Takács Ottó"
published: true
tags: extracts
---
1. Excessive jQuery Calls

Instead of 

<pre>
$("#example").text("Hello, world!");
$("#example").css("color", "red");
</pre>

user 

<pre>
var $example = $("#example");
$example.text("Hello, world!");
$example.css("color", "red");
</pre>

2. Missing parts of selectors

3. Repetitive Selectors

4. Unused Shortcuts

[Common Pitfalls of jQuery](http://www.codeproject.com/Articles/346904/Common-Pitfalls-of-jQuery)

<div class='old-comments'></div>