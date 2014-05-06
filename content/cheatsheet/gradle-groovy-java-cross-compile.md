---
title: "Gradle Groovy Java cross compile"
created_at: 2014-05-15 00:00
kind: article
tags:
  - java
  - groovy
  - gradle
  - toolbox
---

Mostanság [Gradle](http://www.gradle.org/) kedvenc build tool-om. Sajnos még nem álltam rá teljesen, hiszen a teljes projectet le kell kezelnem vele és még nem volt rá kapacitásom, hogy minden lépést bekonfiguráljak (kicsit parázok a korrekt EAR file készítésétől, mert azzal maven alatt is szokott gond lenni).
De oldalági projekteknél már csak ez jöhet szóba. 

De van egy gond, ha keverem a nyelveket. Mondjuk [Groovy](http://groovy.codehaus.org/) és Java. 

A [Groovy](http://groovy.codehaus.org/)-t könnyű bevezetni, mikor rámutatsz, hogy pár dolog végtelenűl leegyszerüsödik, hogy pl GroovyBean-eket használunk.

~~~java
 @Canonical 
 class Customer {
     String first, last
     int age
     Date since
     Collection favItems = ['Food']
     def object 
 }
~~~

A fenti példa egy teljes értékű Java beant hoz létre mindenféle getterrel, setterrel, toStringgel, hashCoddal, equalsval és hasznos konstruktorokkal.

Majd ezt használni akarod Java-ban. És nem fog menni!

A [Gradle](http://www.gradle.org/) [Groovy](http://groovy.codehaus.org/) pluginja a Java buildtől függ. Maygarán előbb a Java-t fogja buildeni és csak aztán a [Groovy](http://groovy.codehaus.org/) forrásokat. És persze a Java bebukik, mert még nem fordult le a GroovyBean, amit használna. (Hasonló probléma [Scala](http://www.scala-lang.org/) esetben is)

Szerencsére van megoldás:

~~~java
sourceSets {
  main {
      groovy {
          srcDirs = ['src/main/groovy', 'src/main/java'] 
      }
      java {
          srcDirs = []  
      }
  }
  test {
    groovy {
        srcDirs = ['src/test/groovy', 'src/test/java'] 
    }
    java {
        srcDirs = []  
    }
 }
}
~~~
