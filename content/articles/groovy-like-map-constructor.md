---
title: "Groovy like map constructor"
kind: article
created_at: 2014-04-13 00:00
---

I miss so much the Groovy like [map constructor](http://mrhaki.blogspot.com/2009/09/groovy-goodness-using-lists-and-maps-as.html) in Java that I have created my own.

~~~java
public class MyBean{
  public MyBean(Map<String, ?> map){
    JakartaPropertyUtils.copyProperties(this, map);
  }
}
~~~

The `copyProperties` helper is a simple wrapper around Jakarta [commons-beanutils implementation](http://commons.apache.org/proper/commons-beanutils/javadocs/v1.8.3/apidocs/org/apache/commons/beanutils/PropertyUtils.html#copyProperties(java.lang.Object,%20java.lang.Object)) to [eliminate useless checked exception handling](http://www.qualityontime.eu/articles/checked-exception-code-generation/).

Why is it useful:

- when you fed up with enforced Java bean convention. Everyone knows how useless that convention but you have no other choice because frameworks are expecting. E.g.: It is not possible to replace getters/setter by public fields.
- Simplify test code
- the whole bean initialization is still centralized in constructor.

