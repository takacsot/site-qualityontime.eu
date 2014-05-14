---
title: "Interface Oriented Design - Ken Pugh"
kind: article
created_at: 2012-06-26 21:40:53 +0000
author: "Takács Ottó"
published: true
tags: 
  - review
  - olvasonaplo
  - it
  - cleancode
  - design
  - programming
---
<p><img src="http://moly.hu/system/covers/normal/covers_185772.jpg?1340739504" alt="Cover of Interface oriented design">&nbsp;</p>


three laws that all implementations should obey, regardless of what services they offer.<br />
<br />
1. An Interface’s Implementation Shall Do What Its Methods Says It Does<br />
If the purpose and meaning of a method are not unambiguously obvious from the method’s name and its place within an interface, then those aspects should be clearly documented.3 The documentation may refer to interface tests, such as those described later in this chapter, to demonstrate method meaning in a practical, usage context.<br />
2. An Interface Implementation Shall Do No Harm<br />
3. If An Implementation Is Unable to Perform Its Responsibilities, It Shall Notify Its Caller<br />
An implementation should always report problems that are encountered and that it cannot fix itself.<br />
<br />
Michael Hunter suggests, “They should be documented regardless. Conversely, if<br />
they need documentation, the name should be improved.”<br />
<br />
To successfully use an interface, both the caller and implementer need to understand the contract—what the implementation agrees to do for the caller. You can start with informal documentation of that agreement. Then, if necessary, you can create a standard contract.<br />
An interface implementation is not required to check the preconditions. You may assume that the user has met those preconditions. If the user has not, the implementation is free to fail. Any failures should be reported as in the Third Law of Interfaces.<br />
An implementation with weaker preconditions can meet the contract for the interface. One that has stronger preconditions cannot.<br />
An implementation with stronger postconditions meets the contract; one with weaker postconditions does not.<br />
You also need to know the protocol to the interface—the set of allowable sequences of method calls.<br />
As a general rule, no interface definition is complete until you have all the contractual tests successfully running for at least one implementation. <br />
Design to an interface, not an implementation.<br />
“Test to an interface, not an implementation”.<br />
Writing tests for an interface can also help you work out difficulties in the interface.<br />
If you find that your interface is hard to test, then it probably will be hard to use. If this happens, you can redesign your interface without even having coded an implementation.<br />
<br />
Levels of contracts.19 The levels are:<br />
• Basic type contracts as in typed programming languages<br />
• Semantic contracts that include the preconditions and postconditions<br />
• Performance contracts for real-time systems<br />
• Quality of service contracts that are hard to quantify<br />
<br />
Testing for quality of service contracts is usually more difficult than testing for performance contracts<br />
<br />
An implementation of an interface should obey the three laws:<br />
• Do what its methods say it does.<br />
• Do no harm.<br />
• Notify its caller with meaningful errors if unable to perform its responsibilities.<br />
Establish a contract for each interface (either formally or informally):<br />
• Indicate the preconditions and postconditions for each method.<br />
• Specify the protocol—the sequence of allowable method calls.<br />
• Optionally, spell out nonfunctional aspects such as performance or quality of implementation.<br />
• Create tests to check that an implementation performs according to its contract and that it obeys the three laws.<br />
<br />
Interfaces move data in one of two ways: push or pull. You ask a pullstyle interface—for example, a web browser—for data. Whenever you desire information, you type in a URL, and the information is returned. On the other hand, a push-style interface transfers data to you. An email subscription is a push-style interface.<br />
PUSH STYLE<br />
Advantage—can be simpler code, once paradigm is understood<br />
PULL STYLE<br />
Advantage—appears as a common control style (e.g., loop) in multiple languages<br />
<br />
MANY METHODS<br />
Advantage—implementer does not have to determine type of parameter<br />
Disadvantage—implementer has to implement all the methods<br />
SINGLE METHODS<br />
Advantage—can be more resilient to change, because new methods do not have to be implemented<br />
Disadvantage—must check parameter type to determine flow<br />
<br />
STATELESS<br />
Advantage—a small number of operators can service many requests. My mom would not be able to juggle more than a few requestors at a time.<br />
STATEFUL<br />
Advantage—there is less chatter to get the same amount of work done.<br />
<br />
STATELESS<br />
Advantage—order of the method calls does not matter<br />
Disadvantage—parameter lists are longer<br />
STATEFUL<br />
Advantage—parameter lists shorter<br />
Disadvantage—order of method calls important<br />
<br />
If you don’t like way that an interface works, transform it into one you like.<br />
<br />
One of the most difficult decisions in developing a program is determining what should be in an interface.<br />
You often face another question: how many methods should you have in an interface? Many methods can make an interface more difficult to understand but can also make it more powerful.<br />
Methods in an interface should be cohesive. They should provide services that revolve around a common concept.1 The problem is that the definition of commonness is relative.<br />
<br />
SINGLE PRINTER INTERFACE<br />
Advantage—can have single capability query method<br />
Disadvantage—related capabilities may not be logically grouped together<br />
MULTIPLE PRINTER INTERFACES<br />
Advantage—printer need only implement interfaces it supplies<br />
Disadvantage—lots of interfaces<br />
<br />
Coupling measures how one module depends on the implementation of another module.<br />
<br />
TIGHT COUPLING<br />
Disadvantage—callers have to be changed if implementation changes<br />
LOOSE COUPLING<br />
Advantage—callers do not need to be changed if implementation changes<br />
<br />
Interfaces<br />
MINIMAL<br />
Advantage—easier to implement and test with fewer methods<br />
Disadvantage—user must code their particular functionality and may wind up with duplicate code for same functionality<br />
COMPLETE<br />
Advantage—user has all needed methods<br />
Disadvantage—may be harder to understand an interface with numerous methods<br />
<br />
SIMPLE<br />
Advantage—easy for the user to perform common functions<br />
Disadvantage—variations must be coded as new methods<br />
COMPLEX<br />
Advantage—users have flexibility to “do it their way”<br />
Disadvantage—may be harder for users to understand<br />
<br />
USING INTERFACES<br />
Advantage—delay forming hierarchy until usage known<br />
USING INHERITANCE<br />
Advantage—less delegation of common operations<br />
<br />
USING INTERFACES<br />
Advantage—can cross hierarchies<br />
USING INHERITANCE<br />
Advantage—captures common attributes<br />
<br />
USING INTERFACES<br />
Advantage—can capture common set of usage<br />
USING INHERITANCE<br />
Advantage—captures set of common behavior<br />
<br />
USING INTERFACES<br />
Advantage—give more adaptability for roles that cross hierarchies<br />
Disadvantage—may have duplicated code without helper classes to provide common functionality<br />
USING INHERITANCE<br />
Advantage—base classes can provide common implementations<br />
Disadvantage—difficult to adapt to new situations.<br />
<br />
When you have multiple implementations of an interface such as InputStream, you may duplicate logic in each implementation. If there are common implementation methods and you do not use a helper class, you may find yourself copying and pasting a lot. If you can create a well-defined hierarchy with many inheritable implementations, you are far better off using inheritance, rather than interfaces. But you may find that starting with interfaces and then refactoring to inheritance allows you to discover what is the best hierarchy.<br />
<br />
INHERITANCE APPROACH<br />
Advantage—easy to inherit an implementation<br />
Disadvantage—may be difficult to adapt to changing roles<br />
INTERFACE APPROACH<br />
Advantages—can be clearer what methods must be implemented.<br />
A class in another inheritance hierarchy can provide the services of an interface.<br />
Disadvantage—may end up with lots of helper classes.<br />
<br />
• Interfaces show commonality of behavior.<br />
• Inheritance shows commonality of behavior along with commonality of implementation.<br />
• Interfaces are more fluid than inheritance, but you need to use delegation to share common code.<br />
• Inheritance couples the derived classes to the base class, but it allows them to easily share the common code of the base class.<br />
<br />
PROCEDURAL STYLE interface<br />
Advantage—remote and local interfaces can appear the same<br />
Disadvantage—can require more communication (especially if fine-grained)<br />
DOCUMENT STYLE interface<br />
Advantage—can require less communication<br />
Disadvantages—style is less familiar to programmers<br />
<br />
SYNCHRONOUS<br />
Advantage—practically immediate response<br />
Disadvantage—cannot scale up as well<br />
ASYNCHRONOUS<br />
Advantage—can scale well, especially with document queues<br />
Disadvantage—documents should be validated on client before transmitting<br />
<br />
REMOTE STATELESS<br />
Advantages—servers can be easily scaled. If you have multiple servers processing client requests, any server can handle any client.<br />
The service has redundancy. Any server could go down and the client could continue with any other server.<br />
Disadvantage—amount of state information passed between client and server can grow, especially for a full shopping cart. In most cases, this amount will be less than the size of the web pages for which the state information is transferred.<br />
REMOTE STATEFUL<br />
Advantage—less information to communicate between client and server<br />
Disadvantage—if using central database where the state information is stored, the amount of simultaneous connections to that database could be a limiting factor to scalability<br />
<br />
Stability is a needed trait for external interfaces.<br />
Both procedural and document interfaces can be flexible.<br />
You should follow a few guidelines in being flexible in interfaces. First, never alter the semantics of existing methods or data. Second, you can add methods or data; just don’t expect that users will add calls to the new methods or provide the new data.<br />
But although adding functionality is easy, deleting methods or data is hard.<br />
Whenever you have an remote interface that is available to the outside world, you need to worry about security.<br />
<br />
No guaranteed way exists to determine what responsibilities should go with which interfaces; designing interfaces takes the same effort as designing classes. Bertrand Meyer says, “Finding classes is the central decision in building an object-oriented software system; as in any creative discipline, making such decisions right takes talent and experience, not to mention luck.” He goes on to say, “No book advice can replace your know-how and ingenuity.” The same can be said for finding the right set of cohesive interfaces.<br />
<br />
In interface-oriented design, the emphasis is on designing a solution<br />
with interfaces. When using IOD, here are some tips:<br />
• Use IRI cards to assign responsibilities to interfaces.<br />
• Keep service interface definitions in code separate from the code<br />
for classes that implement it.<br />
• Write tests first to determine the usability of an interface.<br />
• Write tests against the contract for the interface.<br />
<br />
Application confguration<br />
USING CONFIGURATION<br />
Advantage—hides implementation requirements<br />
Disadvantage—services have dependency on a configuration interface<br />
USING INVERSION OF CONTROL<br />
Advantage—common feature (used in frameworks)<br />
Disadvantage—can be harder to understand<br />
<br />
You should review your interfaces before you implement them. Otherwise, you may implement methods that turn out to be useless.<br />
<br />
Using interface-oriented design, just as with other techniques, does not guarantee that you’ll never have to restructure your interfaces or refactor your code. As you develop a system, you usually discover additional information that suggests a restructuring of the design.<br />
</p>
<p>
&nbsp;
</p>

		


<div class='old-comments'></div>