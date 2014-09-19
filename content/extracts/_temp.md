---
publish: false
---
#Thinking about...


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

###http://www.ustream.tv/recorded/46744747
Differnetece  external and internal quality. Internal quality a kind of subjective. Extrernal quality whihc is noticable only.
Extrenal qualit like: goal achieved. tipically business goal.
REffere to E.Myth revisited (A vállallkozás mitosza). And apply that concept to software development.
Offshore: use concept from 4 hours workweek book. Offshore whihc is freeing up you ding important things.
Automate or find someone who is thinking and will aitomate. 

###http://www.ustream.tv/recorded/46744746
Bruce Eckel - What Makes a Good Development Process? 
Infoq már megvolt. 

###http://www.ustream.tv/recorded/46744741
Amber Case - Getting Things Done at Scale 
1/50 has a good experience in acquisition of an company.
Why:
- Crippling managment/overhaad to get simple things done
- Founder flight: charismatic, visionary leader is living fast.
- Lack of detailed transition plan
- Loss of   passion for original product
- Left of respect and cross-compromise.
- Culture clash 
- Jealousy/blocking from parent company employees
- Sprinters vs  Marathon runners
How to handle
1. Pre-ngotiate
  - Do not leave details for later and hope they work
  - Be as detailed as possible and get corporate bayoff 
  - do not be vague. Vaguness  breeds confusion nad paranoia.
2. Predetermine your desired outcome
  - Creatre and lead a transiton plan
  - retain pasion for original product
  - help parent company to sprint
  - adopt traits of a marthon runner
  - maintain and  improve team quality
4. Over communication - Lack of communication with new or remote team leads to suspection and insecurity.
5. Win friends and influence team
...
Several social (read a book about it)
and orginazational stuff which is a little bit common sense...
Growing:
- Hire slowly
- Litmus test

###http://www.ustream.tv/recorded/46743935
Agile team don't necesserily create agile software architectures.
Agile architecture is reacting to changes easily. (e.g microservices - giving flexibility)
How do we inspect software architecture
  - read code - so much to read
  - pucture 
    - how? 
    - TEam arent able to visualize softwasre architecture effectively
      - difficult to write a single diagram: multiple diagramm need to be created
Think how to align your code to the architecture.
Even if BUD is forgotten it is replaced by nothing.
So 
- create highl level BUD in the bggining. Significant decision (here you have to design about messageing , micorservice, async or sync etc.) - helps sharing understaning of system.
- Plus you have to identify and mmitigate your highest priority risks
- up front design including technology. Technology choise is effecting your architecture
-

De csak ennyi semmi több.... uff
A többi csak szarakodás




---------

MB: not even checking changes when updating project so he could not learning from others development effort.

