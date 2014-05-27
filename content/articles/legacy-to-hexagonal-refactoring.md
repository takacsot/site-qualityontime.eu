---
title: "Refactoring legacy system to hexagonal architecture"
kind: article
created_at: 2014-05-27 19:00
tags:
  - en
  - it
  - architecture
  - design pattern
  - uncle bob
  - testing
  - hexagonal
  - test
  - SOLID
  - software
---

In this article I am describing transformation step how to change a legacy system to more flexible hexagonal architecture by following the [Single Responsibility Principle ](http://en.wikipedia.org/wiki/Single_responsibility_principle).

To avoid any difficult to understand abstraction I am using specific example from the domain I working on currently.

## Domain action description

We are creating meetings. The meeting is a very complicated entity. Here it is a simplified version of it:

- meeting has basic data like subject, comment, etc.
- meeting has several participant
- meeting can have several interpretation service required (EP is using the most interpreter in the word). Complex entity and have many many child entity attached.
- meeting can have several technical service required (e.g projector or any other technical service). Many child entity attached.
- meeting can have multiple location which is also complicated in itself.

I think it is clear that even such a simple action as creating a meeting is not a trivial "few-liner" code to implement.



Worst possible architecture
----------------------------

One of the so called "service" methods is `createUpdateDelete` function which is taking care of... (well) the creation, update and delete operation in one big chunk. 

As this is only one of method of the service object this is under continuous change and some of the changes has side effect so even if no creation operation is changed it becoming behaving incorrectly.

For short it is violating the [Single Responsibility Principle ](http://en.wikipedia.org/wiki/Single_responsibility_principle).

Step 1: Operation object
--------------------------

Very first step is to extract method into separate object. Now that object is encapsulation all the statement required to perform the job.

NB: I am not describing any of the primitive [Refactoring ](http://en.wikipedia.org/wiki/Refactoring) steps to implement this change: move method to separate object, move all the dependencies too, delegate original method to the new object method.

Then split the object into three different object per operation: `CreateMeeting`, `UpdateMeeting`, `DeleteMeeting`.

No let's focus on one of the operation only: `CreateMeeting`

I am sure that it is already better 

What kind of responsibilities CreateMeeting has?

- validate input data structure
- map input to db entities
  - map meeting
  - map participant
  - map technical need and all its child too
  - map interpretation and all its child to
  - map location and all its child too
- insert into db
  - insert meeting
  - insert participant
  - insert technical need and all its child
  - insert interpretation need and all its child
  - insert location and all its child

So we still have too many responsibility.  Can you estimate how many test case it need to test? (trick: is has the "fact" in the formula :) - Oh yes it is exponential to the number of component working together)

Step 2: split responsibilities
-----------------------------

Let's regroup responsibilities:

- input validation
- Meeting
  - mapping
  - insert
- participant
  - mapping
  - insert
- technical need
  - mapping
  - insert
- interpretation need
  - mapping
  - insert
- location
  - mapping
  - insert

Hmm... It has slightly different shape. I think we could identify a few of the additional object which could be used to decompose `CreateMeeting`.

At the end I could come up the following list of object: `ValidateMeeting`, `MeetingSave`, `ParticipantSave`, `TechnicalNeedSave`, `InterpretationNeedSave`, `LocationSave`

Each of the these objects are responsible for mapping to db entities and inserting into db (through `repositories`/`dao`s).
The `CreateMeeting` object now have a single responsibility: orchestrating the create meeting operation. All other (lower level) responsibility is delegated to the appropriate object identified above.

And as a side effect `CreateMeeting` is a [hexagonal ](http://alistair.cockburn.us/Hexagonal+architecture) cell. And hexagonal architecture is well separated from each other and make unit testing amazingly easy.

You could say "But `LocationSave` has more than one responsibility: mapping to db entities and calling repository for inserting into db".  

My answer:

- First of all inserting it just a delegation to repository object. 
- Second, mapping to db entities sometimes so simple that there is no need to separate.
- in [Single Responsibility Principle ](http://en.wikipedia.org/wiki/Single_responsibility_principle) Uncle Bob defines "a responsibility as a reason to change". Using other words: ["Gather together the things that change for the same reasons. Separate those things that change for different reasons."](http://blog.8thlight.com/uncle-bob/2014/05/08/SingleReponsibilityPrinciple.html). And mapping to db entities are highly related to repository.

