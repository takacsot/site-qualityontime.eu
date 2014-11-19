---
title: "I give a shit on story points"
publish: false
book: management-stack
book_page: 41
tags:
  - agile
  - en
---

Léptnen nyomon szembejön velem a storypontok dolga. Elvileg leegyszerüsítné az életünk, de a gyakorlatban csak nehezebbé teszi pont abból a szempontból, amiek segítenie kellene.

Mi a story point?
----------------

TODO: Hivalatolsabb referenciát is összerakni

Az, hogy mis tulajdnonképpne hatalas iradalma van. Talán Mike Cohn: Agile estimation and planning c. könyve a legismertebb. Igaz, hogy az nem csak a storypontokról szól, de egyértelműen azokat preferálja. 

amindennapjainkban valamiképpne [Scrum](http://en.wikipedia.org/wiki/Scrum_%28software_development%29) környezetben jön elő. Szűmos [Scrum ](http://en.wikipedia.org/wiki/Scrum_%28software_development%29) bevezetésen vettem részt és még többről van másodkező ismeretem. Kivétel nélkül mindegyik bevezette a story pontokat is.

DE: a [Scrum ](http://en.wikipedia.org/wiki/Scrum_%28software_development%29) nem beszél storypontokról. Sőt egyéltalán nincs is szó munkaerő becslésről sem. egyéltalán. Semmi!!!!

Az interjúztató kérdezte, hogy miként tudnám elmagyarázni a strpontokatazüzleti emberkenk (jelenleg az egyik legnagyobb problémájuk). És itt a bukta, mivel ez nem takar semmilen használható üzleti informcációt.

Dan North az egyik előadásában (http://www.infoq.com/presentations/agile-does-not-scale) bezsél arról, hogy a storypointok miért vicc: "-Mikorra lesz meg? - Nem tudom - De mégi - hát van 200 storypont és X [velocity ](http://en.wikipedia.org/wiki/Velocity_%28software_development%29), de még nem tudjuk, mert kell egy pár hét..... -De mégis mikor?"



And thatis highlighting manz problem with story points.

As I see (and it cause me many problem when dealing with story points). It tries to mix up __many unrelated__ estimation characteristics into one single number:

- complexity: more complex job, challenge of new technologies are higher in story points. But later the same level of story become less because of gained experience. Although the same kind of taks should have the same story point.
- work volume: more work should be bigger, obvious.
- team experience: less experinced team in certain area is giving more story point then experienced team. (as story point is sensitive to team composition it becomes clear by time: In the beginning the same task has higher story point then later)
- individual developer experience: better developer can be more than  10X more productive and faster then a dump. And as all team is composed by different qualities of developer.... A single number is hiding capabilities and risk of different developer qualities.

Plus it has so many other weakness:

- any kind of story point estimate (and its brother [velocity ](http://en.wikipedia.org/wiki/Velocity_%28software_development%29)) is unique to the team. Uncomparable. How to deal with multiple team project protfolio? It has to be transformed to a common measurement and measurement unit (most probably calendar days)
- extramely sensitive to team composition change. SOmone got sick? a developer has an urgent support work in other project? Or just got new team member? Or somone quit?  (statistically it is quite probable in any project takes more than half a year)
- not giving any information without [velocity ](http://en.wikipedia.org/wiki/Velocity_%28software_development%29). Obvious. After havin [velocity ](http://en.wikipedia.org/wiki/Velocity_%28software_development%29) you could estimate due dates (which is a calendar unit!!!!!) and costs (which is calendar unit and money!!!!). 
- there is no real correllation amongst story point and real effor spent. the only thing can be shure that higher story point is more then lower. But a 4sp is not 2 times more then 2sp! (disclaimer: correlation exists on small stories and small story points - but it leads to #noestimate subject)


TODO: the follwing section might be subject of standlone article

Estimation is never commitment: ref: Scheduling-EN.

Under promiss and over deliver.


Instead of story points
-------------------------

Instead of story points you should use calendar based estimates with proper risk management and (semi-)automatic estimation adjustment.


Here are techniques which are working to me.

### Technique: periodic re-estimation

Just go for it. Once you have more knowledge just review and adapt you estimation. It was always much faster then the forst time when you ahd to spend most of your time on understanidng the problem. On re-estimation you already know the problem. 

Several months of work can be reviewed/re-estimated in 1 hour with team. It measn it can be really frequent. My experience is that after the first or second re/estimation no more re-estimation is needed because the domin become clear the estimations are becoming less risky.

### Technique: automatic estimation adjustment.

1. Do estimate in single number
2. during development collect effort spent
3. after task completed adjust compute average deviation from estimate
4. apply deviation to remaining task

Adapting to experience change
No re-estimation
Simple
Automatic
Working very well in practice


Variation:
- adjust by task size categories. Adjust 1d of work based on completed 1d tasks only. works estomated to 5d is adjusted by completed work estimated to 5d. etc.
- adjust by developer: compute developer to developer.


MMRE: http://en.wikipedia.org/wiki/Software_development_effort_estimation (Assessing the accuracy of estimates)

### Technique: automatic estimation adjustment with Monte Carlo simulation

See "How to measure anything"
Plus beats cognitive biasses (http://en.wikipedia.org/wiki/Cognitive_bias)

### Technique: Expert estimation

The "black art" estimation is describing as very effective technique of estimation. 

What it is: take expert of domain with team knowledge and let him estimate. It is against the commonaly agreed approach to estimate by developers who will really do the job. But it can be really cost effective (less time consuming) to do good enough estimates. 

Restrictions:

- expert of the domain (to know the what)
- expert of technology (to know the how)
- experience in team who will developer (to know how to adjust to reality)

### Technique: M-L-M Estimation

(min + 4 x likely + max)/ 6

Very powerful with Monte carlo simulation.

http://www.brighthubpm.com/project-planning/22852-risk-adjusted-minimum-likely-maximum-estimation-for-software-projects/
http://eyefodder.com/2011/06/software-estimation-a-good-simple-way-courtesy-of-the-navy-and-the-cold-war.html
Some article how Fogbugs is using estimation and

-------------

Links:

- http://www.qualityontime.eu/review/code-craft-pete-goodliffe/chapter-21-how-long-piece-string-black-art-software-timescale-estimation/





