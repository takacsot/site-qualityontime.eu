#Thinking about...


#### [Spring pitfalls: transactional tests considered harmful ](http://www.nurkiewicz.com/2011/11/spring-pitfalls-transactional-tests.html)

Fontos dologra mutat rá, bár a legtöbb  példája konkrétan Jibernate, ming JPA implementációra is vonatkozi. Pár példa nem is releváns, ha nem JPA-t használ az ember.

Én SQL syntax checkre használom a TRansactional teszteket. Mivel SQL-t nem lehet unit testelni. (Deklerative eszközzel nem tudsz deklerative eszközt tesztelni.)

A megoldás amit javasol, hogy nem transactionál, hanem mindig betölt egy friss adatbázis dumpot, ami h2 esetén müködhet, de oracle esetén már igazán nagy overhead.


####[Stand-ups are Broken, but Should They be Fixed?](http://blog.8thlight.com/eric-smith/2014/07/18/standups-are-broken-but-should-they-be-fixed.html)

> on every team I’ve ever been on, if there’s a customer (or scrum-master or project manager) present, the meeting always turns into a status report.

If you have a good visible taskboard you do not need to report anything because it is visible on the wall.

> The stand-up meeting was created to solve a particular problem—developers don’t always talk to each other. ... if your team is working in the same war-room or communicates frequently through other means, it’s probably not necessary to have everybody discuss explicitly what they are doing.

> Despite the desire for an On-Site Customer, most teams do not have their customer available all the time,

Oh, yes. At the end of the iteration/sprint is just fine for most of the customers.

####[What Makes a Good Programmer?](http://henrikwarne.com/2014/06/30/what-makes-a-good-programmer/)

> 1. Problem Decomposition

>But before you write any code, you need to be clear on how to solve the problem. One skill good programmers have is the ability to break the problem down in smaller and smaller parts, until each part can be easily solved. ... A good programmer finds a way to model the problem in such a way that the resulting program is easy to reason about, easy to implement and easy to test.

> 2. Scenario Analysis

>the ability to consider many different scenarios for the program. This applies both to the logic in the program, and to the internal and external events that can occur. ...

>The good programmers ask themselves: _How can this break?_ In other words, they have the ability to think like testers. In contrast, inexperienced programmers mostly only consider the “happy path” 

>3. Naming

>Programming consists to a large degree of naming things: classes, methods and variables. When done well, the program becomes largely _self-documenting_, 

>(from Phil Karlton): _“There are only two hard things in Computer Science: cache invalidation and naming things.”_ 

>  naming is hard because it needs to be clear in your mind what each name represents. 

>4. Consistency

>the biggest challenge in programming is managing complexity. Consistency is one way to combat complexity.

>5. Learning

>As a software developer, you are constantly learning. Before adding a new feature, you have to understand what it is supposed to do. Before adding code to an existing program, you usually have to learn what the existing code does, in order fit the new functionality in properly