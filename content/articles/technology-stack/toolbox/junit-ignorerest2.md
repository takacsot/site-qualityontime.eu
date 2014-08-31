---
title: "JUnit IgnoreRest - turn 2"
kind: article
created_at: 2014-08-31 00:01
publish: true
tags:
  - java
  - testing
  - en
  - toolbox
---

In the previous [IgnoreRest](<%=item_by_id('/junit-ignorerest/').path %>) article I was complaining about that it is not notifying IDE properly without a custom test runner.

So I have implemented the runner I need.

~~~java
  public class IgnoreRestSupportRunner extends BlockJUnit4ClassRunner {
    public IgnoreRestSupportRunner(Class<?> klass) throws InitializationError {
      super(klass);
    }

    @Override
    protected void runChild(final FrameworkMethod method, RunNotifier notifier) {
      IgnoreRest ignoreRestAnnotation = method.getAnnotation(IgnoreRest.class);
      Description description = describeChild(method);
      if (IgnoreRestHelper.hasIgnoreRestAnnotation(description) && null == ignoreRestAnnotation) {
        notifier.fireTestIgnored(description);
      }
      else {
        super.runChild(method, notifier);
      }
    }
  }
~~~

And that is all. Nothing else. All the remining code needed is extracted from the previous implementation. For supporting Spring I have to make use exactly the same code but the base class has to be `SpringJUnit4ClassRunner`.

So the only runner I have to deal with is the [junit-hierarchicalcontextrunner ](https://github.com/bechte/junit-hierarchicalcontextrunner/wiki).

Source is available on [GitHub ](https://github.com/takacsot/toolbox/tree/master/src/main/java/eu/qualityontime/test)