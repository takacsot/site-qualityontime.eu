---
title: "Thinking about - week 31"
created_at: 2014-07-28 01:14
kind: article
tags:
  - en
  - hu
  - programming
  - development
  - software
  - testing
  - database
  - extracts
  - jooq
---

#### [Stop Unit Testing Database Code](http://blog.jooq.org/2014/06/26/stop-unit-testing-database-code/)

> Writing tests that use an actual database is hard.

>   - that results from tests against your test system have (almost) no meaning
>   - that your tests will not cover some of the most complex aspects of your productive system
>   - that you will start spending way too much time on tweaking tests rather than implementing useful business logic

> Databases couldn’t be any less stateless. The whole idea of a database is to manage state. And that’s very complicated and completely opposite to what any unit test can ever model


My database unit testing is about testing SQL syntax only.



#### [Flyway and jOOQ for Unbeatable SQL Development Productivity ](http://blog.jooq.org/2014/06/25/flyway-and-jooq-for-unbeatable-sql-development-productivity/)

>    1. Database increment
>    2. Database migration
>    3. Code re-generation
>    4. Development

Good combination of tools. I would like to use. But those Oracle DBA guys do not like using tools which are  not used to (even if it is more advanced)

#### [TDD != Unit Tests (and vise versa)](http://blog.drorhelper.com/2014/06/tdd-unit-tests-and-vise-versa.html)

The post itself is not about this topic but the reaction on depate made around [Test-induced design damage](http://martinfowler.com/articles/is-tdd-dead/) started by [DHH](http://david.heinemeierhansson.com/).


#### [The "Just In Time" Theory of User Behavior](http://blog.codinghorror.com/the-just-in-time-theory/)

>I've long believed that the design of your software has a profound impact on how users _behave_ within your software. But there are two sides to this story:
> 
>    - Encouraging the "right" things by making those things intentionally easy to do.
>    - Discouraging the "wrong" things by making those things intentionally difficult, complex, and awkward to do.

>The purpose of locks, the locksmith said, is to protect you from the 98% of mostly honest people who might be tempted to try your door if it had no lock.

>10% of people will never steal, 10% of people will always steal, and for everyone else … it depends.

> most people will consistently and reliably cheat "just a little", to the extent that they can still consider themselves honest people.

Once upon a time I have made a test whether I am a good man. For example a good man does not steal. And first question: Have you ever taken a pen from your workplace for private use? Of course I did....

> __a simple reminder at the time of the temptation__ is usually all it takes for people to suddenly "remember" their honesty.

>You do it by showing them …

>    - the minimum helpful reminder
>    - at exactly the right time


