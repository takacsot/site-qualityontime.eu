---
title: "Jawr, webjars, bootstrap, Spring setup trick"
created_at: 2014-05-16 00:51
book: technology_stack
book_page: 101
tags:
  - java
  - web
  - spring
  - javascript
  - css
  - bootstrap
---

It is well known that you could not escape from some kind web optimizer library when developing web applications.

In case of Java, one of the best tool is called [Jawr](https://jawr.java.net/). Extremely flexible and easy to use.

The other set of tools which helps to keep you project clean from third party JavaScript libraries is the [webjars](http://www.webjars.org/). Luckily Jawr is providing support for using [resources from classpath](https://jawr.java.net/docs/generators.html).

I have run into one serious problem only: when using some non js, css or image resources I could not access throug Jawr. More precisely I could not access glyphicons from bootstrap webjar. Jawr is rewriting css url reference to something like this:

~~~css
url('../jar:/META-INF/resources/webjars/bootstrap/3.1.1/fonts/glyphicons-halflings-regular.ttf')
~~~

Here it is the trick to resolve this non existing path (as Jawr is not  serving font files...).

In the `web.xml` you must tell Spring to watch for `jar:` prefixed paths:

~~~xml
  <servlet>
    <servlet-name>SpringDispatcherServlet</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>classpath:spring-mvc.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>SpringDispatcherServlet</servlet-name>
    <url-pattern>/app/*</url-pattern>
    <!-- for webjar resources see spring-mvc.xml -->
    <url-pattern>/jar:/*</url-pattern>
  </servlet-mapping>
~~~

In spring mvc config we should map the resource to the proper classpath:

~~~xml
  <mvc:resources mapping="/META-INF/resources/webjars/**" location="classpath:/META-INF/resources/webjars/"/>
~~~

And enjoy the result.