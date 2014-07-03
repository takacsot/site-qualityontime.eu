---
publish: false
---

There are many kind of colleges. how to deal with them. It is  not always easy.

TODO: get people from Code Craft and other books similar

Here are some special behavior I could not handle:

College 1 (Igor): What he intend to develop he is doing. The problem lies before the actual start of development. He misses the the capability to discover all aspect of task if it is not explicitly defined.  Example: having a story to implement some input validation. It is about around 3-5 field and their dependencies. He has identified 6 test case (I have identified 7, but that is not important now) and implemented to pass all these test. But when I have reviewed the code I have identified that 4 of the 6 test case is testing something not relevant or testing something wrong instead of the correct. So in total "my test" and not only bigger in number but was testing the behavior. 
Another example when we have sit down and discussed what to develop and how to do it too. The next day when we review the progress he is talking about some kind cool (technical)  component found in the net and made some demo because it is so cool to use in the feature (only for small part of it). He has wasted 2-3 days to discover the component (even if we have told it is time to focus on the feature to develop - but as I was not his boss I was not able to push him)

College 2 (Mohamed): He is developing what is needed somehow. But how? First of he is extraordinary slow. Let him implement (even if it is working at the end) takes forever. And the code what he is creating has the lack of structural thinking. I always have the feeling that he is investing lots of energy to make the code unreadable. He is the developer who is implementing something in double the line of code then it should (plain Java) or even implement in one line if he would learn some (internal or external) API. (Example: identify whether having duplicate in list of numbers implemented in 10 lines instead of `return new HashSet(in).size() != in` where in is a `List` of numbers. I have the feeling that the code he is creating is just created using some random generator. He is working and try to put some code somewhere if it is not working move the line somehwere else or put some if somewhere. At the end it must be working (you know the theory of million monkeys writung any novel...). Make it short the code he is creating is not just simply slow to have (development time) but it is also extraordinary difficult to maintain. He is very bad in organizing code and giving names to objects.