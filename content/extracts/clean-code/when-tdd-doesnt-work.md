---
title: "When TDD doesn't work - Uncle Bob"
kind: article
created_at: 2014-05-02 00:00
---

>  software controls machines that physically interact with the world.

> How can I test that my software rings the bell?

> test that the software rings the bell by listening. In other words, I can test that manually.

> __I can write unit tests that prove that the software _should_ ring the bell.__ But if I want to be sure that the bell rings when the proper signals are sent to the driver, I either have to set up that microphone or just listen to the bell.

>  It's the stuff out at the boundaries of the system. It's the IO devices that require manual testing. At the moment the software controls something that physically interacts with the world, automated tests become so impractical that manual tests are the best option.

> But what about the layer just before the physical world? Can you write automated tests for that layer?

> Are there any other areas where tests aren't appropriate? Yes. The test code itself. ... You don't have to write tests for those because the actual unit tests and the production code are the tests for those pieces of code.

[Original](http://blog.8thlight.com/uncle-bob/2014/04/30/When-tdd-does-not-work.html)