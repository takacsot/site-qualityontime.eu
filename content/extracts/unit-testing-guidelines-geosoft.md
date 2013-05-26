---
title: "Unit Testing Guidelines - geosoft"
kind: article
created_at: 2012-04-03 22:22:22 +0000
author: "Takács Ottó"
published: true
tags: extracts
---
1. Keep unit tests small and fast
2. Unit tests should be fully automated and non-interactive
3. Make unit tests simple to run
4. Measure the tests
5. Fix failing tests immediately
    - Each developer should be responsible for making sure a new test runs successfully upon check in, and that all existing tests runs successfully upon code check in.
6. Keep testing at unit level
7. Start off simple
8. Keep tests independent
9. Keep tests close to the class being tested
10. Name tests properly
11. Test public API
12. Think black-box
13. Think white-box
14. Test the trivial cases too
    - Trivial is hard to define. It may mean different things to different people.
    - From a black-box perspective there is no way to know which part of the code is trivial.
    - The trivial cases can contain errors too, often as a result of copy-paste operations:
15. Focus on execution coverage first
16. Cover boundary cases
17. Provide a random generator
    - When the boundary cases are covered, a simple way to improve test coverage further is to generate random parameters so that the tests can be executed with different input every time.
    - To achieve this, provide a simple utility class that generates random values of the base types like doubles, integers, strings, dates etc. The generator should produce values from the entire domain of each type.
18. Test each feature once
19. Use explicit asserts
    - Always prefer assertEquals(a, b) to assertTrue(a == b)
20. Provide negative tests
21. Design code with testing in mind
22. Don't connect to predefined external resources
23. Know the cost of testing
    - Not writing unit tests is costly, but writing unit tests is costly too
24. Prioritize testing
    - Unit testing is a typical bottom-up process, and if there is not enough resources to test all parts of a system priority should be put on the lower levels first.
25. Prepare test code for failures
26. Write tests to reproduce bugs
27. Know the limitations
    - Unit tests can never prove the correctness of code!!

[Unit Testing Guidelines](http://geosoft.no/development/unittesting.html)

<div class='old-comments'></div>