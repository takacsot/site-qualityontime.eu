---
title: "Lessons Learned while Introducing a New Programming Language - Jay Fields"
kind: article
created_at: 2012-01-27 10:11:11 +0000
author: "Takács Ottó"
published: true
tags: extracts
---
I hate all programming languages - Matt Foemmel

...

A language that doesn't affect the way you think about programming, is not worth knowing - Alan Perlis

...

Introducing a language is a delicate act. 

__Integration tests are a good place to introduce a new language, but any non-production code will probably be an equally good choice.__ For example, you could also choose database migration scripts, log file parsers, 3rd party software simulators, or deployment software. As long as you pick something that can fail without too much immediate pain you should be able to easily recover from any adoption issues.

I eased my teammates adoption fears by making the following commitments.

- If you want to work on the code I'll work with you (if you want me to work with you).
- If you don't want to work on the code I'll fix anything that's broken.
- If the initial pain of working with a new language becomes unbearable to you, I'll rewrite everything in Java on my own time.

Chances are your team already has a tool-chain that they are happy with. Whatever that tool-chain is, your new language is going to need to play well within it.

 During the early/fragile adoption time, you're the one who's going to need to do the majority of the compromising.

Find allies. work closely with them on improving both of your skills. 

Know Everything
Obviously you can't actually know everything, but you're going to need to have an answer or be able to quickly get an answer to anything that comes up. 

 You're going to need to know the dark corners of the language and the associated corner cases that exist.
You'll also need to be an expert on issues such as memory allocation, performance, deployment, tool integration, library support, upgrade schedules, and everything else that is outside of the language's syntax.

Introducing a new language is likely a multi-year affair for any moderately sized organization

[Lessons Learned while Introducing a New Programming Language](http://blog.jayfields.com/2012/01/lessons-learned-while-introducing-new.html)


<div class='old-comments'></div>