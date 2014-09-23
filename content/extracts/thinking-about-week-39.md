---
title: "Thinking about - week 39"
created_at: 2014-09-23 21:01
kind: article
tags:
  - en
  - architecture
  - design
  - evo
  - javascript
  - code craft
  - clean code
---

[Craft Conf](http://craft-conf.com/2014/)  presentations


## [Dan North - Jackstones: the journey to mastery](http://www.ustream.tv/recorded/46968772)

More like a motivational speech but very good. You want to be a master of development.

Until you are novice pretend to be master

But being a master you should be able to use any practice: TDD, SOLID with critique...

Practice until you realize when it is useful.

As a journeyman

- try different approaches
- try different domains

Learn how to learn

Listen like you do not know the answer - you may not know.


## [Gojko Adzic - How I Learned to Stop Worrying…](http://www.ustream.tv/recorded/46772902)

Amazingly good presentation. 

It is focusing how to make agile really working and that is not really about developers but they are wrong too....  I have to re-watch to extract.

We have to change how we are thinking about user stories.

User story is about behavior changes.

## [Theo Schlossnagle - Responsibly maximizing craftsmanship in software engineering](http://www.ustream.tv/recorded/46744760)

How software sucks

Specification are extremely difficult to get right.

-  human language is not the best for that
-  humans are sux
-  stakeholders are not the real stakeholders

laziness is promoted as something good. 

- brainless way. People use tool which is  not planned for that purpose because they are lazy to find/develop the proper tool.

Learning curve of huge projects is amazingly huge. It become difficult to add features quickly. (!of course not decoupled!)

Learn to hit the fucking deadline: 

-  Learn estimating

Learn papers: there are many researches about how to develop big system and resolve problems effectively (heheh történt ilyen mikor valaki bemutat egy design patternt mint valami újdonság és jó design cuccost)

Engineer are function better autonomously

- decide on what and how to work and on what

You are judged based on your API

So: choose the proper size of component to be able to work autonomously using well defined API to communicate each other. So build component maintainable. 

DO not refactor but rewrite component. Rewrite better, based on knowledge you know about. It is part of maintenance.

SQL is not API!!!

##[Stefan Tilkov - Architecture War Stories ](http://www.ustream.tv/recorded/46744759)

War stories with humour and fun. Very interesting.

- 20 architect ->  It is sure it will not work :)
- Don't cache the cache.
- In distributed systems, application state is your enemy
- If it is "sophisticated", you probably shouldn't  be doing it
- Development != production
- Data should be free from code dependency. Data is just data. Especially not for specific version of applications. 
- The longer you store the simpler data should be.
- Beware of smelly BLOBs
- Your system WILL be dynamic
- Centralized responsibility hurts. Single person bottleneck
- Face too much rigidity, a way around the rules will be found
- If it makes you want to scratch your eyes out, you might not want to do it.
- Sometimes constraints need to be fought
- Beware all things "meta"
- Fight the madness
- Tunneling is the root of all evil
- Don't be too smart
- Do not try to build  system which fits to everyone
- Don't be all things to all people
- Sometimes specific code is preferable
- Saying no might help sometimes

Advice:

1. Give feedback
2. Reflect

## [Jutta Eckstein - Complex Projects aren't planable but controllable ](http://www.ustream.tv/recorded/46744756)

Individual goal are against company goals because most of th goal need teamwork which is killed by individual goal setups.

and many other mut it was not so structured to extract the "single message".

Use values instead of estimates (business values....) for deciding to initiate the project. There are many way to define value (ROI, Risks, Cost of delay, Importance, Willingness for investment)

Plan in different levels: roadmap, long term, mid term, short term


