---
title: "YAGNI - Productive programmer"
kind: article
created_at: 2012-03-01 10:11:11 +0000
author: "Takács Ottó"
published: true
tags: 
  - extracts
---
- YAGNI STANDS FOR“YOUAIN’TGONNANEEDIT.” It is the battle cry of agile project development to help prevent speculative development.
- Whatever form it takes, though, the health of your software suffers if you indulge in too much speculative development. In its worst form, it leads to frameworks!
- Java has this disease worse than any other language.
- Don’t pay complexity tax unless you absolutely must.
- Always be willing to offer suggestions that meet the spirit of the request if not the actual details. Most of the time, users and business analysts have a particular vision in mind for how a feature should work. Try to get to the core of what the feature does, and see if a simpler solution exists.
- Communication is paramount: without good communication channels, you have constant frustration between the perceived pushy users and the overly reticent developers.
- Software development is first and foremost a communication game.
- Does adding complexity reduce complexity? Hardly. Be leery of vendor-driven solutions to every possible problem. Their first priority is to sell their product, and their second priority is (maybe) to make your life better.
- ezert fontos h elobb sajat magad legyel teljesen definialtan tisztaban a problemaddal.
- Maximize work on essential complexity; kill accidental complexity.
- Occam’s Razor, which says that given multiple explanations for something, the simplest is the most likely.
- colleague Terry Dietzler called the “80-10-10 Rule” for Access (which I’ve renamed Dietzler’s Law): you can do 80 percent of what the customer wants in a remarkably short time. The next 10 percent is possible, but takes a lot of effort. The last 10 percent is flat out impossible because you can’t get “underneath” all the tooling and frameworks. And users want 100 percent of what they want, so 4GLs gave way to general-purpose languages
- Powerful languages + domain-specific meta-layers offer the best approach currently available.
- Dietzler’s Law: even general-purpose programming languages suffer from the “80-10-10” rule.
- Pay attention to the lore of “ancient” technologies.
- Fortunately, a giant catalog of nonintuitive software lore exists in the [Anti Patterns catalog](http://c2.com/cgi/wiki? AntiPatternsCatalog).
- Take some time and read those decades-old software books that are still widely read, like [The Mythical Man-Month](http://en.wikipedia.org/wiki/The_Mythical_Man-Month), Hunt and Thomas’s [The Pragmatic Programmer(Addison-Wesley)](http://pragprog.com/the-pragmatic-programmer), and Beck’s [Smalltalk Best Practice Patterns](http://www.amazon.com/Smalltalk-Best-Practice-Patterns-Kent/dp/013476904X) (Prentice Hall).
- But blind adherence to standards is just as bad as having no standards at all.
- In software, lots of the practices on projects exist because “that’s the way we’ve always done it.”
- In other words, because of angry monkeys.
- “Because we’ve always done it this way” is not a sufficient reason for any development habit. If you understandwhy you have always done it that way, and it makes sense, then by all means continue. But you should always question assumptions and verify their validity.
{}

- Fluent Interfaces To write a fluent interface like Car requires that you kill one of the sacred cows of Java: the Car class is no longer a JavaBean. While that doesn’t seem like a big deal, much of the infrastructure of Java insists on this specification.
- no one in the Java world questions whether they should make their objects beans. The default is to follow the other angry monkeys and make everything a bean.
{}

- META-PROGRAMMING IS FORMALLY DEFINED AS WRITING PROGRAMS THAT WRITE PROGRAMS, but the practical definition is much broader.
- Testing Java with Groovy. Groovy is the dynamic language syntax for Java.
- In fact, I’m a big advocate of not calling “Groovy” by its name when nondevelopers are around. I prefer calling it the Enterprise Business Execution Language (using the acronym ebXl—managers think that acronyms with capital Xs in them are sexy).
- Meta-programming changes your syntactic vocabulary, giving you more ways to express yourself.
- building restrictions into the language didn’t make the poor developers any better, and it placed a governor on the best developers, making them jump through ridiculous hoops to get things done.
{}

- SLAP STANDS FOR THESINGLELEVEL OF ABSTRACTION PRINCIPLE
- Composed Method in Action
- Refactoring to composed method reveals hidden reusable code.
- if you are rigorous about test-driven development TDD (see Chapter 6), you pretty much automatically get composed method code. TDD encourages, actually forces, you to write really cohesive methods (the smallest thing for which you can write a test), which lends itself to composed method.
- TDD predisposes composed method.
- SLAP insists that all your code within a method live at the same level of abstraction.
- In other words, you shouldn’t have a method in which part of it deals with low-level database connectivity, another part with high-level business code, and another with web service plumbing.
- Encapsulate all implementation details away from public methods.
- Polyglot programming refers to building applications using one or more special-purpose languages in addition to a general-purpose language. We already do this, but it is so natural that we don’t even think about it. For example, SQL has so ingrained itself into application development that it is taken for granted that virtually every application will use it.
- Groovy is an obvious candidate to help modernize the crusty bits of the Java language.


<div class='old-comments'></div>