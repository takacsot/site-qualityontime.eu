---
title: "foldLeft implementation"
kind: article
created_at: 2014-07-14 12:00
tags:
  - java
  - toolbox
  - functional
  - programming
---

`foldeLeft` (folding in general) is one of the most powerful functional construct. Clean, elegant and generic.

Almost all functional operations can be [build on top of the `fold` functions](https://twitter.github.io/scala_school/collections.html#generalized). So you need to have one. Once you have `foldLeft` you got a bunch "operation" id addition (see later).

A [few example ](http://oldfashionedsoftware.com/2009/07/30/lots-and-lots-of-foldleft-examples/) how `foldLeft` an be used:

- sum
- product
- count
- average
- last
- contains
- map/collect/transform
- filter/select/reject
- unique
- etc...

I had a continuous need of implementing some `min` and `max` on collection and I wanted to add my functional [FIterable ](https://github.com/takacsot/toolbox/blob/master/src/main/java/eu/qualityontime/functionals/FIterable.java).

~~~java
  public interface F2<X, Y, Z> {
    public Z f(X p1, Y p2);

    public static interface Simple<T> extends F2<T, T, T> {
    }

    public static interface Collector<V, S> extends F2<V, S, V> {
    }
  }

//....


  public <C> C foldLeft(C init, F2<C, T, C> reducer) {
    for (T i : this.iterable) {
      init = reducer.f(init, i);
    }
    return init;
  }

//...

  @Test
  public void foldLeft() throws Exception {
    Integer res = FIterable(IList(1, 2, 3, 4)).foldLeft(0, new F2.Collector<Integer, Integer>() {
      @Override
      public Integer f(Integer p1, Integer p2) {
        return p1 + p2;
      }
    });
    assertEquals(10, res.intValue());

    String longestString = FIterable(IList("aaaaa", "a", "qqqqqqqqqqq", "bb")).foldLeft("", new F2.Simple<String>() {
      @Override
      public String f(String p1, String p2) {
        return p1.length() > p2.length() ? p1 : p2;
      }
    });
    assertEquals("qqqqqqqqqqq", longestString);
  }

~~~
