---
title: "Delete your Tests"
kind: article
created_at: 2014-06-23 00:00
---

> Tests, like any code, should be deleted when their cost exceeds their value.

TO be deleted:

> Unneeded Tests

>Documentation and Duplicating Implementation: very declarative code which has little behaviour to test, and with excessively mocked-out code where the tests become a specification of the implementation. 

Highly declarative tests are SQL verification tests too.

> Tests can also be made redundant by the type system. Simple tests on preconditions or valid inputs to methods can often be replaced by preconditions the type system can enforce.
> e.g. if you have 3 methods that all expect an argument that is an integer between 1 and 11 why not make them accept an object of a type that can only be between 1 and 11? While you’re at it you can give it a more meaningful name than integer. onChange(VolumeLevel input) is more meaningful than onChange(int volumeLevel) and removes need for tests at the same time.

> Is the test testing desired behaviour, or behaviour that’s really just a side effect of the chosen implementation approach? Does the tested behaviour still match what customers and or users want now? Usage patterns change over time as users change, their knowledge of the software changes, and new features are added and removed. 

> Speed is one of the most important attributes of tests to consider when evaluating their value. Fast tests are valuable because they give us rapid feedback on unanticipated side effects of changes we make

> any change you made broke hundreds of tests, regardless of whether it changed any behaviour? These brittle tests impose a significant cost on the development of any new features, performance improvements, or refactoring work. 

> Non-deterministic tests have a particularly high cost. 

[Original](http://benjiweber.co.uk/blog/2014/04/27/delete-your-tests/)

