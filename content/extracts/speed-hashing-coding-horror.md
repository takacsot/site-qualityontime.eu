---
title: "Speed Hashing - Coding horror"
kind: article
created_at: 2012-04-23 22:22:22 +0000
author: "Takács Ottó"
published: true
tags: 
  - extracts
---
Az abszolút minimum amit tudni kell a hash függvényekről, digitális aláírásról és jelszavakról.

>If you are a user:

>Make sure all your passwords are 12 characters or more, ideally a lot more. I recommend adopting pass phrases, which are not only a lot easier to remember than passwords (if not type) but also ridiculously secure against brute forcing purely due to their length.

>If you are a developer:

>Use bcrypt or PBKDF2 exclusively to hash anything you need to be secure. These new hashes were specifically designed to be difficult to implement on GPUs. Do not use any other form of hash. Almost every other popular hashing scheme is vulnerable to brute forcing by arrays of commodity GPUs, which only get faster and more parallel and easier to program for every year.

[Speed Hashing](http://www.codinghorror.com/blog/2012/04/speed-hashing.html)

<div class='old-comments'></div>