---
publish: false
---
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

###http://gojko.net/2013/09/12/scrum-velocity-and-driving-down-the-motorway-the-wrong-way/

> Velocity is in essence a negative metric – it can tell you that something is wrong, but not that something is good.

>Velocity is a nice metric for internal process monitoring, so you can spot problems early. But beware of using a negative metric such as velocity as your primary measure of success, it leads down the path of false hyperproductivity and a warm feeling that you’re doing something good when in fact you might be driving the wrong way down a motorway, with a truck heading straight at you.


####[Nightmare on Agile Street](http://allankelly.blogspot.com/2014/07/nightmare-on-agile-street.html)

A very humorous story about an Agile project which is not soo agile. Or more precisely about a project in which stakeholders are remembering of those aspect of agile what then prefer. And the result is a total disaster.

A few weeks ago I had a similar (not so extreme) feeling and I wanted to cancel the project too. But... :)

####[Does Speaking Another Language Change How You Think?](http://www.scotthyoung.com/blog/2014/07/27/language-and-thought/)

>Language is a tool that fills the needs of its speakers.

>Languages also have expressions and words for concepts that don’t match one-to-one
>  But, again, it’s a nuance in expression, the same fundamental thoughts can be conveyed fairly equally in most languages, plus or minus a bit of brevity.

>The big way that learning a new language changes your thinking is that language is a gateway to culture

>language is a preferential route for cultural understanding (albeit a difficult one)

>The Language Learning Experience Changes How You Think

Craft Conf  előadások
----------------------

#### Dan North - Jackstones: the journey to mastery
http://www.ustream.tv/recorded/46968772
More motivational speech but very good. You want to be a master of development.
Unill you are novece pretend to be master
But be a master you should be able to use any practice: TDD, SOLID with critique...
Practice unitll you realize when it is useful.
As a journimand
- try different approachhed
- try different domins
Learn how to learn
Listen like you do not know the answer - you may not know.

###$Gojko Adzic - How I Learned to Stop Worrying…
http://www.ustream.tv/recorded/46772902

Amazingly good presentation. It is focusing how to make agile really working and that is not really about developers but thay are wrong too....  I have to re-watch to extract.
We have to change how we are thinking about user stories.
USer story is about behaviour changes.

####http://www.ustream.tv/recorded/46744760
Theo Schlossnagle - Responsibly maximizing craftsmanship in software engineering
How software sucks
Specification are extramely difficult to get right.
  human language is not the best for that
  humans are sux
  stakeholders are not the real stakeholders
  latziness is prometed as something good. - brainless way. People use tool which is  not planned for that purpose beacause they are lazy to find/develop the proper tool.
Learning curve of huge projects is amayingly huge. It become difficult to add features quickly. (!of course not decoupled!)
Larn to hit the fucking deadline: 
  Learn estimating
Laern papers: tehre are many reserches about how to developo big system and resolve problems effectively (heheh történt ilyen mikor valai bemutat egy design patternt mint valami újdonság és jó design cuccost)
Engineer are function better autonomously
  decide on what and how to work and on what
You are judged based on yoy API
So: choose the proer size of component to be able to work autonomously using well defined API to communicate each other. So build component maintanable. 
DO not refactor but reqrite component. Reqriter better based on knowledge you know about. It is part of maintanace.
SQL is not API!!!

####http://www.ustream.tv/recorded/46744759
Stefan Tilkov - Architecture War Stories 
War stories with humour and fun. Very interesting.
20 architect ->  It is sure it will not work :)
Don't cache the cache.
In distributed systems, application state is your enemy
If it is "sophisticated", you probabley shouldn't  be doing it
Development != production
DAta should be free from code dependency. Data is just data. Especially not for specuifuc version of applications. 
The longer you store the simpler data should be.
Beware of smelly BLOBs
Your sysyem WILL be dymamic
CEntralize responsibility hurts. Single person botthlenech
Face too much rigidity, a weay around the rules will be found
If it makes you want to scratch your eyes out, you might not want to do it.
Sometimes constraints need to be fought
Beware all things "meta"
Fight the madness
Tunneling is the root of all evil
Don't be too smart
Do not try to build  systam which fits to everyone
Don't be all thingsto all people
Sometimes pecific code is prefereble
Saying no myght help sometimes

Advice:
1. Give feeback
2. Reflect

####http://www.ustream.tv/recorded/46744756
Jutta Eckstein - Complex Projects aren't planable but controllable 
Individual goeal are against company goals because most of th goeal need teamwork which is killed by individual goal setups.
and many othe mut it was not so structured to extract the "single message".
Use values instead of estimates (business values....) for decising to initiate the project. There are many way to define value (ROI, Risks, Cost of delay, Importance, Willingness for investment)
Plan in differente leveles: roadmap, long term, mid term, short term


####http://www.ustream.tv/recorded/46744753
Jevgeni Kabanov - Data-Driven Software Engineering 
Deliver Quality software on time :)
Reality: Onley 60% deliver on time  and half of releases crashes in production
Solution: Measure and experiment (sound Agileish)
Wha tis metter: predictibility productivity and quality for softweare eng, team. And well measurable metrics (except productivity)
From large statistical data.
Having standup has 4% more predictibility and similarly small numbers on other aspects.
Meeting several times a week has negative effect on quality. -  Disctraction.
Who estimates? If management is resented -6% in predictibility. -3% on quality. the opposite when the whole team is presented - all engineer.
Who tests? Developer tests +5% in quality. Automtated test 8% predictibility, +3% quality. Testers doing testing does not really makes difference.
Code reviews: Enormous boost (17-22%) on predictibility, not a big boost on quiality, code reviews is improving your architecture, not neccerely decrease number of bugs, 
Good data to sell to mamagment.
Automated test: "Fuctionality covered by automate test = not code coverage". Significant 15-25% gain in predictibility and quality. Nothing  else is increasing quality as much as automated tests.
Pair up: 7% predictibility, 13% in quality. - But code review are much better in predictibility but worst in quality. In general Code review is more valuable.
Code quality: "Fix all code quality metrics - e.g. Sonar", 17% predictibility, 13% in quality. So set it up for all your project. And very cheap to monitor.
Tools: how tools effect. version control 9% predictibility, ide 8%, issue tracker 5%, etc But the specific tool itself  is not effecting too much. Except JRebel +8%.

Measure: Desdline misses, Scope changes, Blocker issues after release, User satisfaction. 

#### http://www.ustream.tv/recorded/46744750
Gerard Meszaros - Find the Right Abstraction Level for Your Tests 
Goog good, but difficult to extract essence.

