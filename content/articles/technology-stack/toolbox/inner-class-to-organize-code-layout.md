---
title: "Inner class for stepdown rule"
kind: article
publish: true
created_at: 2014-07-07 02:32
tags:
  - java
  - cleancode
  - uncle bob
  - programming
  - development
  - en
---

Inner and nested classes (static or not) are not only for passing as anonymous classes for other component or not to expose special derivatives to the public. It is also useful to organize your code layout to improve readability.

I present two usage of class to improve readability:

- group methods together to see clearly which functions are belonging to each other and which is belonging to an other method.
- simplifying parameter passing hell for service methods (common in Spring - e.g.)

## Group methods together

One the [Clean Coders ](http://cleancoders.com/) videos and also in the [Clean Code ](http://www.amazon.com/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882) book there is a specific section about functions and the way to organize the layout of them (look for _The Stepdown Rule_ in section _Functions_).

The summary of this concept is to organize code the following way:

- Main function
  - f1 used in main
  - f2 used in main
    - f21 used in f2
  - f3 used in main
    - f31 used in f3
    - f32 used in f3
    - f33 used in f3
      - f331 used in f33

Applying all other rules in [Clean Code ](http://www.amazon.com/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882)  it is a meaningful advice. For example when considering the rule of a function is doing one thing and a function has one abstraction level only we must have sever (private) method in the class. It is clear that the file can be difficult to review. Such a layout makes easy to identify which lower level function is belonging to which higher level function. So you could skip them if you are not interested in the lower level stuffs.

But modern IDE-s are not supporting this kind of formatting. When let IDE formatting the code all unction will be indented to the same level. Except....

Except we are introducing some kind of extra block which will be indented. And here we can use a nested class.

Before code

~~~java
  void main(){
    f1();
    f2();
  }
  void f1(){...}
  void f11(){...}
  void f12(){...}
  void f2(){...}
~~~

After (introducing only one layer of grouping):

~~~java
  void main(){
    new F1().f1();
    new F2().f2();
  }

  private class F1{
    void f1(){...}
    void f11(){...}
    void f12(){...}
  }
  private class F2{
    void f2(){...}
  }
~~~

## Simplifying parameter passing

In service centric code base (like the one easy to make when using [Spring ](http://spring.io/), or simply a legacy code to take care ) you might start calling a service method with a small number input parameter which is increasing as we are going deeper and deeper in the call stack.

Example:

~~~java
  void main(String in){
    ...
    f1(in, new List());
    ...
  }

  void f1(String in, List collector){
    ...
    f2(some_other, collector, Option.WHATEVER);
    ...
  }
  ...
~~~

And here it is an other case of using inner classes. Their only purpose is to make parameters class variable and simplify method calls.

~~~java
  void main(String in){
    ...
    new F1(in, new List()).f1();
    ...
  }

  private class F1{
    String in;
    List collector;
    Object some_other;
    Option whatever = Option.WHATEVER
    // constructor are not included in the sample. 
    
    void f1(){
      ...
      f2();
      ...
    }

  }
  ...
~~~

