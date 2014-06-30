---
title: "JUnit IgnoreRest"
kind: article
created_at: 2014-07-03 00:01
publish: true
tags:
  - java
  - testing
  - en
  - toolbox
---

Given a scenario that you do not want to run all you test in a test case. For whatever reason you want to run only some of them.

For example: when developing and you find a failing test and when investigation you want to avoid the noise what other test runs are generating (e.g. logging output).

Simple, built in solution is to `@Ignore` all other but the relevant test case

~~~java
  @Test
  @Ignore
  public void test1(){...  }
  @Test
  @Ignore
  public void test2(){...  }
  @Test
  public void test3(){...  }
~~~

Of course it is extremely uncomfortable to do especially when having sever dozens of test methods.

A few days ago I have run into a special annotation called `@IgnoreRest` in [Spock ](http://www.intelligrape.com/blog/2012/08/31/cool-spock-ignoreignorerest-annotations/). It simply takes the marked test and executes only that one. All other is ignored.

Of course there is no similar in "standard" [JUnit ](http://junit.org/).

How it should look like (identical to the previous sample):

~~~java
  @Test
  public void test1(){...  }
  @Test
  public void test2(){...  }
  @Test
  @IgnoreRest
  public void test3(){...  }
~~~

Without implementation I had to develop myself. There were many options to implement:

- Write custom runner: In this case I should take care of other custom runners I am using heavily (like Spring runner or [junit-hierarchicalcontextrunner ](https://github.com/bechte/junit-hierarchicalcontextrunner/wiki))
- using `@Rule`:  In this case I have to use `Rule` to take care of my annotations. But it is nothing extraordinary. This is the way I have implemented.

There is one single issue which makes this implementation incomplete: ignored test are not marked as ignored.

At the moment in [JUnit ](http://junit.org/) version 4.11 there is  not way to use `RunNotifier` (that is the way IDEA is able to display ignored test properly). At the moment the official answer is to use `Assume`. Once an assume exception is raised [JUnit ](http://junit.org/) is ignoring the result but not calling `RunNotifier` as in case of `@Ignore`. So even if the solution is working properly IDEs are not displaying it properly so it is much difficult to notice if you forget to clean up `@IgnoreRest`.

NB: All source is available on [Github](https://github.com/takacsot/toolbox) in package `eu.qualityontime.test`

A specific test case

~~~java
  @Rule
  public IgnoreRestRule rule = new IgnoreRestRule();

  @Test
  public void test1() throws Exception {
    assertTrue(false);
  }

  @Test
  public void test2() throws Exception {
    assertTrue(false);
  }

  @Test
  public void test3() throws Exception {
    assertTrue(false);
  }

  @Test
  @IgnoreRest
  public void test4() throws Exception {
    assertTrue(true);
  }
~~~



The marker [IgnoreRest](https://github.com/takacsot/toolbox/blob/master/src/main/java/eu/qualityontime/test/IgnoreRest.java)

~~~java
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ ElementType.METHOD })
  public @interface IgnoreRest {}
~~~

[IgnoreRestRule](https://github.com/takacsot/toolbox/blob/master/src/main/java/eu/qualityontime/test/IgnoreRestRule.java)

~~~java
  
  import java.lang.reflect.Method;
  import org.junit.Assume;
  import org.junit.rules.TestWatcher;
  import org.junit.runner.Description;
  import org.junit.runners.model.Statement;

  public class IgnoreRestRule extends TestWatcher {

    @Override
    public Statement apply(Statement base, Description description) {
      if (isIgnorable(description)) {
        return new Statement() {
          @Override
          public void evaluate() throws Throwable {
            Assume.assumeFalse("IgnoreRest", true);
          }
        };
      }
      return super.apply(base, description);
    }

    private boolean isIgnorable(Description description) {
      return hasIgnoreRestAnnotation(description) && null == description.getAnnotation(IgnoreRest.class);
    }

    private boolean hasIgnoreRestAnnotation(Description description) {
      Class<?> c = description.getTestClass();
      for (Method m : c.getDeclaredMethods()) {
        if (null != m.getAnnotation(IgnoreRest.class)) {
          return true;
        }
      }
      return false;
    }
  }

~~~