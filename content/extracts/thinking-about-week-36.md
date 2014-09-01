---
title: "Thinking about - week 36"
created_at: 2014-09-04 00:01
kind: article
tags:
  - en
  - programming
  - development
  - software
  - testing
  - database
  - extracts
  - spring
  - quality
  - code craft
  - hibernate
  - jpa
  - persistence
  - scrum
  - management
  - velocity
  - metrics
  - agile
---

####[What Makes a Good Programmer?](http://henrikwarne.com/2014/06/30/what-makes-a-good-programmer/)

> 1 - Problem Decomposition

>But before you write any code, you need to be clear on how to solve the problem. One skill good programmers have is the ability to break the problem down in smaller and smaller parts, until each part can be easily solved. ... A good programmer finds a way to model the problem in such a way that the resulting program is easy to reason about, easy to implement and easy to test.

> 2 - Scenario Analysis

>the ability to consider many different scenarios for the program. This applies both to the logic in the program, and to the internal and external events that can occur. ...

>The good programmers ask themselves: _How can this break?_ In other words, they have the ability to think like testers. In contrast, inexperienced programmers mostly only consider the “happy path” 

> 3 - Naming

>Programming consists to a large degree of naming things: classes, methods and variables. When done well, the program becomes largely _self-documenting_, 

>(from Phil Karlton): _“There are only two hard things in Computer Science: cache invalidation and naming things.”_ 

>  naming is hard because it needs to be clear in your mind what each name represents. 

>4 - Consistency

>the biggest challenge in programming is managing complexity. Consistency is one way to combat complexity.

>5 -  Learning

>As a software developer, you are constantly learning. Before adding a new feature, you have to understand what it is supposed to do. Before adding code to an existing program, you usually have to learn what the existing code does, in order fit the new functionality in properly


#### [Spring pitfalls: transactional tests considered harmful ](http://www.nurkiewicz.com/2011/11/spring-pitfalls-transactional-tests.html)

It is highlighting some important aspect. Examples are mostly about Hibernate and other JPA implementations. Some of the examples are not relevant it you are not using JPA.

I am using transactional test for SQL syntax check only. As you might know SQL cannot be unit tested (semantic of SQL) You could not test declarative tool with declarative toolset.

The proposed solution is to load a fresh database which might be working for h2 database but for a  big monster like Oracle is a questionable solution.

####[Stand-ups are Broken, but Should They be Fixed?](http://blog.8thlight.com/eric-smith/2014/07/18/standups-are-broken-but-should-they-be-fixed.html)

> on every team I’ve ever been on, if there’s a customer (or scrum-master or project manager) present, the meeting always turns into a status report.

If you have a good visible taskboard you do not need to report anything because it is visible on the wall.

> The stand-up meeting was created to solve a particular problem—developers don’t always talk to each other. ... if your team is working in the same war-room or communicates frequently through other means, it’s probably not necessary to have everybody discuss explicitly what they are doing.

> Despite the desire for an On-Site Customer, most teams do not have their customer available all the time,

Oh, yes. At the end of the iteration/sprint is just fine for most of the customers.


####[Scrum, velocity, and driving down the motorway the wrong way](http://gojko.net/2013/09/12/scrum-velocity-and-driving-down-the-motorway-the-wrong-way/)

> Velocity is in essence a negative metric – it can tell you that something is wrong, but not that something is good.

>Velocity is a nice metric for internal process monitoring, so you can spot problems early. But beware of using a negative metric such as velocity as your primary measure of success, it leads down the path of false hyperproductivity and a warm feeling that you’re doing something good when in fact you might be driving the wrong way down a motorway, with a truck heading straight at you.


####[Nightmare on Agile Street](http://allankelly.blogspot.com/2014/07/nightmare-on-agile-street.html)

A very humorous story about an Agile project which is not so agile. Or more precisely about a project in which stakeholders are remembering those aspects of agile what they prefer and ignoring the rest. And the result is a total disaster.

A few weeks ago I had a similar (not so extreme) feeling and I wanted to cancel the project too. But... :)

####[Does Speaking Another Language Change How You Think?](http://www.scotthyoung.com/blog/2014/07/27/language-and-thought/)

>Language is a tool that fills the needs of its speakers.

>Languages also have expressions and words for concepts that don’t match one-to-one
>  But, again, it’s a nuance in expression, the same fundamental thoughts can be conveyed fairly equally in most languages, plus or minus a bit of brevity.

>The big way that learning a new language changes your thinking is that language is a gateway to culture

>language is a preferential route for cultural understanding (albeit a difficult one)

>The Language Learning Experience Changes How You Think

