---
title: "Thinking about - week 38"
created_at: 2014-09-19 04:01
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


All videos can be found on [http://vimeo.com/ndcoslo/videos](http://vimeo.com/ndcoslo/videos)



##Doc Norton - The Technical Debt Trap 

The danger occurs when the dept is not paid back. Every minute spent on not so good  code counts as interest in that dept.
Technical dept is good.

- rapid delivery, time to market
- heps learning, indication of learning

People are confused the dept metaphor with the idea that you could write code poorly.

__Code must be clean enough to be able to refactor!__ (always) - Otto: so Tests are there...., well tested :)

Ask yourself:

- is the code clean?
- is the code tested
- is there a learning objective or event
- is there a plan for payback
- is the business truly informed

I any of these are missing it is not technical dept. It is a __mess__!!!

Remember quality is your responsibility.

NEVER ask permission to do job correctly.

When monitoring complexity track trends not points. (exact values are meaningless but tends are meaningful).

##Brendan Forster - 10 Things Ive Learned From Doing OSS

- Read other people code
- there are lots of ways to collaborate. e.g donations, Documentation
- Scratch your own itch  
  if you have considerable code you should share it, consider your contract.
-  ...
- you are not your code 
- words are hard
- be familiar with software licenses
- friction sucks, Make it easy for me to hack on your code.
- "done" vs "dead"

##Enrico Campidoglio - Why no code reviews

Problem 1 is about Ego.  EGO=1/Knowledge. The less the knowledge the greater the EGO.

Problem 2: you == your code

Problem 3: Fear of making mistakes. Fear of let colleges see my mistakes

Problem 4: Culture o(lack of it) "you are wrong".... See Ego!

Do not review the person. REview the code. Do not speak in absolute. Fools are speaking absolute.

Time: it need time.

NB: Good diagram about productivity of a geek

What do you get from code review?

- code quality goes up
- bugs go down, especially fund during code review,.
- sharing knowledge

When you know that someone is watching you will take care of you code more. "The Big Brother EEffect"

It can eager ambition because yo want to impress your programmer fellow.

Give constructive feedback. 

In a project everyone is in the same boat. (Sometimes I do not have the feeling - Otto -  But we have to trust  people that they are doing their bests)

Kind of review

1. Formal code review. Most bugs found
2. Over the shoulder code review. Less former. Less bug to be found
3. Async code review. Happen async to the code written. "distributed". IT happens offline. Good compromise in nr of bugs found and time.

Tools:
- Gerrit, Diffy

rules:

1. review small portions of code at a time. One commit one logical change.
1. keep and follow a checklist
1. keep under 1 hour

##Aral Balkan - Free is a Lie

Interesting and shocking conspiracy theory how Google/Facebook is ruling our life and data...

