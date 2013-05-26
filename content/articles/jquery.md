---
title: "JQuery"
kind: article
created_at: 2012-03-18 16:09:09 +0000
author: "Takács Ottó"
published: true
tags: articles
---
When using jQuery (or any other JavaScript library for that matter), have you ever wondered how to test whether an element exists using a selector?

<pre>
if ($("#mydiv").length > 0){
  // do something here
}
</pre>

Do not use:
<pre>
$jq('#customsort_EC').ready(function(e) 
</pre>

but in documentation mantioned the selector has not effect for ready(). ....

<div class='old-comments'></div>