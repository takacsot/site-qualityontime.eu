---
title: "Effective Java - Joshua Bloch"
kind: article
created_at: 2012-07-09 22:22:22 +0000
author: "Takács Ottó"
published: true
tags: 
  - review
  - olvasonaplo
  - it
  - java
  - cleancode
---
![](http://moly.hu/system/covers/normal/covers_50545.jpg?1261413580)

(2007)

Hogyan is áll össze a könyv? Vegyél egy kis Design Pattern-t, adj hozzá egy kis Refactoringot, majd fűszerezd meg egy kis általános programozási jó tanácsokkal, mint amilyeneket a [Code Craft](http://www.qualityontime.eu/review/code-craft-pete-goodliffe-0). Ez egészet Java környezetbe kell helyezni, hogy a kockafejű (pardon, kávéscsészealj fejű) javas fejlesztők is megértség. Végül adj hozzá pár igazán Java specifikus dolgot és kész is. Ami egyébként meglepően nem nagy (úgy értem meglepő egy amerikai könyvtől), de nagyon érthető és színtiszta hasznos tanácsokat ad.

Ha a fent említett témákat és könyveket olvastad, akkor kevés új dolog kerül a szemed elé, de a java specifikus oldalát érdemes megnézni. Ha nem ismered ezen könyveket, akkor viszont olyan könyv, amit mindenképpen el kell olvasni. Ki tudja talán felkelti az olyan témák iránt az érdeklődést, mint a Refacotring, meg a DesignPatternsek.

(újraolvasás update 2012)

Igazából nem emlékeztem, hogy elolvastam-e valaha:

Ugyan ebből senki sem fog programozni tanulni. De ha mar tud Java-zni, akkor tele van jó tanácsokkal.

Ha esetleg mar olvastad az első kiadást akkor nem sokat fog adni. Persze feltételezve hogy azért naprakész vagy az addig történtekkel.


[Tartalomjegyzék, ami talán felkelti az érdeklődést:](http://www.java-tips.org/java-book-reviews/books/effective-java-programming-language-guide.html)

<pre>
Chapter 2: Creating and Destroying Objects
Item 1: Consider providing static factory methods instead of constructors 
Item 2: Enforce the singleton property with a private constructor 
Item 3: Enforce non-instantiability with a private constructor 
Item 4: Avoid creating duplicate objects 
Item 5: Eliminate obsolete object references 
Item 6: Avoid finalizers 

Chapter 3: Methods Common to All Objects 
Item 7: Obey the general contract when overriding equals 
Item 8: Always override hashCode when you override equals. 
Item 9: Always override toString 
Item 10: Override clone judiciously 
Item 11: Consider implementing Comparable 

Chapter 4: Classes and Interfaces
Item 12: Minimize the accessibility of classes and members 
Item 13: Favor immutability 
Item 14: Favor composition over inheritance 
Item 15: Design and document for inheritance or else prohibit it. 
Item 16: Prefer interfaces to abstract classes 
Item 17: Use interfaces only to define types 
Item 18: Favor static member classes over nonstatic 

Chapter 5: Substitutes for C Constructs
Item 19: Replace structures with classes 
Item 20: Replace unions with class hierarchies 
Item 21: Replace enum constructs with classes 
Item 22: Replace function pointers with classes and interfaces 

Chapter 6: Methods
Item 23: Check parameters for validity 
Item 24: Make defensive copies when needed 
Item 25: Design method signatures carefully 
Item 26: Use overloading judiciously 
Item 27: Return zero-length arrays, not nulls 
Item 28: Write doc comments for all exposed API elements 

Chapter 7: General Programming
Item 29: Minimize the scope of local variables 
Item 30: Know and use the libraries 
Item 31: Avoid float and double if exact answers are required 
Item 32: Avoid strings where other types are more appropriate 
Item 33: Beware the performance of string concatenation 
Item 34: Refer to objects by their interfaces 
Item 35: Prefer interfaces to reflection 
Item 36: Use native methods judiciously 
Item 37: Optimize judiciously 
Item 38: Adhere to generally accepted naming conventions 

Chapter 8: Exceptions
Item 39: Use exceptions only for exceptional conditions 
Item 40: Use checked exceptions for recoverable conditions and run-time exceptions for programming errors 
Item 41: Avoid unnecessary use of checked exceptions 
Item 42: Favor the use of standard exceptions 
Item 43: Throw exceptions appropriate to the abstraction 
Item 44: Document all exceptions thrown by each method 
Item 45: Include failure-capture information in detail messages 
Item 46: Strive for failure atomicity 
Item 47: Don't ignore exceptions 

Chapter 9: Threads 
Item 48: Synchronize access to shared mutable data 
Item 49: Avoid excessive synchronization 
Item 50: Never invoke wait outside a loop 
Item 51: Don't depend on the thread scheduler 
Item 52: Document thread safety 
Item 53: Avoid thread groups 

Chapter 10: Serialization 
Item 54: Implement Serializable judiciously 
Item 55: Consider using a custom serialized form 
Item 56: Write readObject methods defensively 
Item 57: Provide a readResolve method when necessar 
</pre>

[Original reading 2007](http://takacsot.freeblog.hu/archives/2007/12/28/Joshua_Bloch_Effective_Java_Programming_Language_Guide/)

[Moly](http://moly.hu/konyvek/joshua-bloch-effective-java)
