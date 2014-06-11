---
title: "Functionals - Toolbox"
kind: article
created_at: 2014-06-11 21:29
book: toolbox
book_page: 2
tags:
  - en
  - it
  - java
---


Functionals? Well. Almost.

Current topic is the `AppCollections` (and its friends) and package `eu.qualityontime.functionals`.

## AppCollections


It is a utility function collection of some collection related fuctions. It can be called helper class.

1. simple wrapper around existing helper methods (mostly related to functional helpers)
2. factory methods of certain collection implementations: `Map()`, `IMap()` etc.
3. functional helpers: `sort`, `find`, etc.
4. non existing helpers or null-save helpers: e.g.: `isEmpty`

### Factory methods

Example: `Map()`, `IMap()`, `List()`, `IList()`

One of the most boring programming task is to write and read something like `new ArrayList<Some>()`. It is full of noise:

- Implementation details even if I am using the same implementation everywhere (e.g.: in 90% of case `ArrayList` is the best implementation - there are statistics that array list is performing the best in mixed, average usage)
- generics noise (remember Java 6 has no empty diamond)
- `new` keyword as noise.
- standard collections do not have initializer constructor (e.g when you want to fill a `Map` with some predefined values) and still want to make them mutable (so no `Arrays.asList`).

Alternatives: [Guava ](http://code.google.com/p/guava-libraries/) have similar factory methods in `Maps`, `Lists`, etc classes. But I do prefer `List` over `newArrayList()` and `IList(...)` over `ImmutableList.of(...)`.

The advantages of using simple factory method is trivial once you are composing them:

~~~java
  Map<String, Foo>  t1= new HashMap<>();
  t1.put("some", ....);
  List<Some> temp = new ArrayList<Some>();
  temp.add(...)
  ...
  Other o = new Other();
  o.setSomes(temp);
  return o;
~~~

vs.

~~~java
  Other o = new Other();
  o.setSomes(List(Map("some", ...),...));
  return o;
~~~

## Non-existing helpers

Simplest example: `isEmpty`

Implementation:

~~~java
  public static boolean isEmpty(Collection<?> coll) {
    return (coll == null || coll.isEmpty());
  }
~~~

There is no trick. There is no any special code behind. It is simply as it is: null save helpers which does not exists in standard JDK.

Alternatives: [Commons Collections ](http://commons.apache.org/proper/commons-collections/) has similar functionality. But it is possible that you do not want to have certain dependencies when you plan to use a few helper method only.

On the other hand dependencies like [Commons Collections ](http://commons.apache.org/proper/commons-collections/), [Commons Lang ](http://commons.apache.org/proper/commons-lang/), [Guava ](http://code.google.com/p/guava-libraries/) are never "real" dependencies. They are just extensions on the weak JDK `java.util` package.

## Functional helpers

Once you get used to Functional Programming paradigm you will change your style of code. For more info you must read [Guava Explained ](https://code.google.com/p/guava-libraries/wiki/FunctionalExplained). Similar implementation is available in [Commons Collections ](http://commons.apache.org/proper/commons-collections/) too.

### But why do I need wrapper?

First of all you do not need it. You should develop a small wrapper around collections and using it. See later in description of package `eu.qualityontime.functionals`.

If you are not developing any wrapper you still have some advantages over using "plain" libraries. (even if I have reasoned against in the previous section).

- [Façade](http://en.wikipedia.org/wiki/Facade_pattern) to simplify accessing 3rd party libraries. I do not want to remember which specific class to call when transforming values: `Iterables`? `Lists`?, `Maps`? (from [Guava ](http://code.google.com/p/guava-libraries/)).
- It is always a good idea to hide 3rd party libaries behind a [Bridge](http://en.wikipedia.org/wiki/Bridge_pattern). Originally I was using [Commons Collections ](http://commons.apache.org/proper/commons-collections/) for (eg) transforming lists. At that time [Commons Collections ](http://commons.apache.org/proper/commons-collections/) was not supporting generics. So a second version of the library was using generics as much as possible. Then I have moved to some other derivative of [Commons Collections ](http://commons.apache.org/proper/commons-collections/) which supports generics ([example](https://github.com/megamattron/collections-generic)). And finally I have changed to [Guava ](http://code.google.com/p/guava-libraries/). The change was always transparent to old code because I was supporting both kind of functional API through the `AppCollections`. Lickily libraries are interface compatibles so writing some wrapper around a `Tranformer` of [Commons Collections ](http://commons.apache.org/proper/commons-collections/) to imitate `Function` of [Guava ](http://code.google.com/p/guava-libraries/).

## Functional package

Package `eu.qualityontime.functionals`:

- `FIterable`
- `FMap`
- `FMultimap`

`F` prefix means functional. All these classes are wrapper around the appropriate type and delgate all method call. And as an addition it is extending them by few useful functional stuff.

What does the following code do?

~~~java
  List<Todo> todos = ...
  Predicate<Todo> completed = ...
  Function<Todo, List<User>> assignedUsers = ...
  Function<User, Long> nationality_id = ...
  Function<User, Map<String, Object>> to_map = ... 
  Function<Long, String> to_string = ...
  ...
  //and the magic
  Map<String, Collection<Map<String,Object>> = FIterable(todos) //FIterable<Todo>
    .filter(completed) //FIterable<Todo>
    .flatMap(assignedUsers) //FIterable<User>
    .groupBy(nationality_id) //FMultimap<Long, User>
    .transformValues(to_map) //FMultimal<Long, Map<String, Object>>
    .asMap() //FMap<Long, Collection<Map<String,Object>>
    .mapKeys(to_string);//FMap<String, Collection<Map<String,Object>>
~~~

Do you really have any difficulties to understand (even without comments)? Simply beautifull!

