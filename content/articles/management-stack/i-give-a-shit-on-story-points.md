---
title: "I give a shit on story points"
publish: true
kind: article
created_at: 2014-11-25 19:14
book: management-stack
book_page: 41
tags:
  - agile
  - en
  - estimation
  - scheduling
  - story point
---

You can see story point more and more famous as a kind of estimation  (and scheduling technique). It intends to simplify estimation and scheduling but in practice it makes life more and more difficult.

What is the story point?
----------------

Let's see some definitions:

> "Story point is a arbitrary measure used by Scrum teams. This is used to measure the effort required to implement a story.
> In simple terms its a number that tells the team __how hard__ the story is. Hard could be related to complexity, Unknowns and effort." --  _[agilefaq](https://agilefaq.wordpress.com/2007/11/13/what-is-a-story-point/)_


>"A story point is to program code what a kilogram is to sand or a kilometer is to distance: An arbitrary unit of measure which describes __how heavy, far, big or complex__ something is." -- _[Explaining Story Points to Management](http://www.scrum-breakfast.com/2008/02/explaining-story-points-to-management.html)_ (Otto: Soooo bad...., see later, mixing up SP and [velocity ](http://en.wikipedia.org/wiki/Velocity_%28software_development%29) and their relationship...)

>" The number of use case points in a project is a function of the following:
>
> -     the number and complexity of the use cases in the system
> -    the number and complexity of the actors on the system
> -    various non-functional requirements (such as portability, performance, maintainability) that are not written as use cases
> -    the environment in which the project will be developed (such as the language, the team’s motivation, and so on) " -- _[Estimating With Use Case Points](http://www.mountaingoatsoftware.com/articles/estimating-with-use-case-points)_ (Otto: Quite a lot of not so related aspect of development...)

And many many more....

It has a huge literature. One of the always quoted reference is [Mike Cohn's Agile estimating and planning](<%=item_by_id('agile-estimating-and-planning').path%>). It is not only about story point but it is clear that Cohn preferes story point more. (On the other hand the book itself is great, a must read.)
([De facto "main reference point" about story points.](http://www.mountaingoatsoftware.com/blog/tag/story-points))

In out "everyday" it come up in the context of  [Scrum ](http://en.wikipedia.org/wiki/Scrum_%28software_development%29) I have participated in several  [Scrum ](http://en.wikipedia.org/wiki/Scrum_%28software_development%29)  introduction and I have indirect (but close enough to be reliable) information from other. Without any exception it introduced the usage of story points.

BUT: __[Scrum ](http://en.wikipedia.org/wiki/Scrum_%28software_development%29) is not about story points.__ Not at all. What is more! Not even talking about estimation. Nothing. When I am saying [Scrum ](http://en.wikipedia.org/wiki/Scrum_%28software_development%29) I am talking about the Scrum as it is. Of course when you are talking about Scrum it is always the original Scrum PLUS many-many additional tools and techniques (including story points).

Once I had a talk with some manager using Scrum in his organization. He told me that one of their current challenge (using Scrum for many years and still having this problem. hmmm.... -  on the other hand they have introduced a very agile process which is great) is to make business people understanding the concept of story points. I think it is a mistake to explain it to a businessman who is interest in time and schedule...


In one of his [presentation Dan North]((http://www.infoq.com/presentations/agile-does-not-scale)) highlighted why story point is insane (around 24:40 - not exact transcript):

>- (businessman) How much will it cost and when can I have it?
- (agile guy) We don't know. We are agile.
- What?... How much will it cost and when can I have it? These are not hard questions.
- OK. We have done some work and we think that it gonna be 295 stories..
- What?...
- And about 1000 story points.
- What is the story point?
- We don't know yet.
- You are absolutely kidding me.
- We gonna run for few weeks and we gonna burn up and burn down and the velocity and hablalal...
- Stop! Stop right now and get out of my building.

(Humorous with lots of truth!)

As I see (and it cause me many problem when dealing with story points). It tries to mix up __many unrelated__ estimation characteristics into one single number:

- __complexity__: more complex job, challenge of new technologies are higher in story points. But later the same level of story become less because of gained experience. Although the same kind of taks should have the same story point.
- __work volume__: more work should be bigger, obvious.
- __team experience__: less experienced team in certain area is giving more story point then experienced team. (as story point is sensitive to team composition it becomes clear by time: In the beginning the same task has higher story point then later)
- __individual developer experience__: better developer can be more than  10X more productive and faster then a dump. And as all team is composed by different qualities of developer.... A single number is hiding capabilities and risk of different developer qualities.

Plus it has so many other weakness:

- any kind of story point estimate (and its brother [velocity ](http://en.wikipedia.org/wiki/Velocity_%28software_development%29)) is __unique to the team__. __Uncomparable__. How to deal with multiple team project protfolio? It has to be transformed to a common measurement and measurement unit (most probably calendar days)
- extremely __sensitive to team composition change__. Someone got sick? A developer has an urgent support work in other project? Or just got a new team member? Or someone quits?  (statistically it is quite probable in any project takes more than half a year)
- __not giving any information without [velocity ](http://en.wikipedia.org/wiki/Velocity_%28software_development%29)__. Obvious. After having [velocity ](http://en.wikipedia.org/wiki/Velocity_%28software_development%29) you could estimate due dates (which is a calendar unit!!!!!) and costs (which is calendar unit and money!!!!). 
- there is __no strong correlation amongst story point and real effort spent__. The only thing can be sure that higher story point is more then lower. But a 4 sp is not 2 times more then 2 sp! (disclaimer: correlation exists but not strong except on small stories and [small story points](http://www.mountaingoatsoftware.com/blog/seeing-how-well-a-teams-story-points-align-from-one-to-eight) - but it leads to #noestimate subject)

So if story points has so many issues why are we using it?


Instead of story points
-------------------------

Instead of story points you should use calendar based estimates with proper risk management and (semi-)automatic estimation adjustment.

But how? It is a subject of another article (later).