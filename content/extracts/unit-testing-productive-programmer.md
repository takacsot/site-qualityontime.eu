---
title: "Unit Testing - Productive programmer"
kind: article
created_at: 2012-02-29 10:11:11 +0000
author: "Takács Ottó"
published: true
tags: 
  - extracts
---
UNIT TESTING IS WELL ESTABLISHED AS A BENEFICIAL CODE-HYGIENE PRACTICE.

- Testing is the engineering rigor of software development.
- Rigorously applied TDD has other design benefits as well, so many that I usually refer to TDD as test-driven design.
- TDD forces you to think through the testing process before you write the code.
- When a code is unit tastable it has a better design.
- Refactor comments to methods.
- Always keep all your tests as part of your build process. The most insidious things in software are the side-effect faults that you accidentally introduce when making changes to a completely unrelated chunk of code. Running your unit tests as regression tests allows you to find those side effects immediately. Having this safety net of unit tests always saves you time and effort.
- Having a strong set of unit tests allows you to play “what if” refactoring games (that is, you can make a broad change and run your tests to determine the impact). When I first started working with developers who were accustomed to having strong unit tests, they would start making changes to the code, which made me nervous because wholesale changes can break lots of stuff.
- I’ve come to the conclusion that anything less than 100 percent code coverage is a dangerous compromise.
- But what if you already have a large code base that has no tests?
- All new code gets unit tests with 100 percent coverage (hopefully developed by TDD).
- Every time you fix a bug, you write a test.
{}

- Static analysisis a programmatic validation mechanism where tools look for known bug patterns in your code.
- FindBugs
- PMD, an open source tool for Java.
- [Panopticode](http://sourceforge.net/projects/panopticode/) is an open source project with lots of common metrics tools preconfigured.
- rcov is a commonly used code coverage tool.
- For cyclomatic complexity, you can use the open source Saikuro.
- Flog measures ABC: assignments, branches, and calls,


<div class='old-comments'></div>