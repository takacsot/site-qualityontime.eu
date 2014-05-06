---
title: "Automation - Productive Programmer"
kind: article
created_at: 2012-02-27 10:11:11 +0000
author: "Takács Ottó"
published: true
tags:
  -  extracts
---
Automation

- Computers are designed to perform simple, repetitive tasks over and over really fast.
- General infrastructure setup is something you have to do for every project: setting up version control, continuous integration, user IDs, etc. Buildix*is an open source project (developed by ThoughtWorks) that greatly simplifies this process for Java-based projects.
- Cache Stuff Locally
- For oft-referenced material (like programming APIs), you should cache the content locally (which also lets you access it on airplanes).
- wget is a *-nix utility designed to cache parts of the web locally.
- wget --mirror â~@~Sw 2 --html-extension â~@~S-convert-links â~@~SP c:\wget_files\example1
- There may be web sites from which you would like to distill information that require logon or other steps to get to content. cURL allows you to automate that interaction.
{}

- Subvert Ant for Non-Build Tasks 
- Use tools out of their original context when appropriate.
- The worst thing about [Ant](http://ant.apache.org/) is its reliance on XML, which is hard to write, hard to read, hard to refactor, and hard to diff. A nice alternative is [Gant](http://gant.codehaus.org/). It provides the ability to interact with existing Ant tasks, but you write your build files in Groovy, meaning that you are now in a real programming language.
- Other similar build tools: [Gradle](http://gradle.org/), [Rake](http://rake.rubyforge.org/), [Buildrl](http://buildr.apache.org/), [Sbt](https://github.com/harrah/xsbt/wiki) 
- Subvert Rake for Common Tasks
	- Rake makes a great shell script substitute because it gives you the full expressive power of Ruby but allows you to easily interact with the operating system.
	- Using Ruby to drive the underlying operating system is much easier than writing bash scripts or batch files.
- Subvert Selenium to Walk Web Pages
	- While this is useful when creating tests, it is invaluable if you need to automate your interaction with a web application.
	- The first time you need to walk through the application to get to the fourth page, record it using Selenium IDE,
- QA department finds a bug. Have them record their bug discovery missions with Selenium IDE and report back to you. Then, you can automatically walk through the exact scenario they did, over and over, until you fix the bug. This saves both time and frustration.
- Don’t spend time doing by hand what you can automate.
- the real power of Subversion lies at the command line.
- Performing simple, repetitive tasks squanders your concentration. Figuring out a clever way to automate the task makes you smarter because you learn something along the way.
- Finding innovative solutions to problems makes it easier to solve similar problems in the future.

Justifying Automation

- Perhaps you can compromise: don’t save every single thing you do, but the second time you find yourself doing something, automate it. Chances are excellent that if you do it twice, you’ll end up doing it 100 times.
- Justifying automation is about return on investment and risk mitigation.
- The best way to mitigate this risk is to timebox your efforts: allocate an exact amount of time for exploration and fact gathering. At the end of the timebox, re-evaluate objectively whether completely pursuing this task is feasible. Timeboxed development is about learning enough to make realistic judgments.
- Timebox speculative development.
- Yak shaving is dangerous because it eats up a lot of time. It also explains why estimating tasks is so often wrong: just how long doesit take to fully shave a yak? Always keep in mind what you are trying to achieve, and pull the plug if it starts to spiral out of control.
{}
- A canonical representation refers to the simplest form without loss of information. Canonicality refers to the practice of eliminating duplication.
- version control, which qualifies as canonicality because the “real” files live in version control. 
- Everything required to build your project should reside in version control. That includes binary files (libraries, frameworks, JAR files, build scripts, etc.). The only things that shouldn’t be in version control are the configuration files particular to a developer’s machine
- Always keep the entire universe required to build your software in version control
- Keep a single copyof everything you don’t build in version control.
- Use a Canonical Build Machine
- The other process required in every development shop is continuous integration.
- Having a canonical build server makes it the only “official” build for the project. Changes to development tools don’t affect it.
- make sure that everyone on the project has the exact same set (down to the minor version number) of all plug-ins.
- The creators of Eclipse anticipated this problem and allow you to configure multiple plug-in and feature locations. Inexplicably, this option resides on the Help menu, under Software Updates and Manage Configurations.
- a canned solution called Pulse was created to manage Eclipse plug-ins.
{}

- Use indirection to keep your life in sync.
- Windows in the form of the E Text Editor.†
- No matter what you are copying and pasting, resuse by copy and paste is evil. Even though the bundles look like single files in OS
- Use virtualization to canonicalize dependencies for your projects.
- The problem is one of isolation: you can’t encapsulate the development environment (or the developed application) at any level lower than the operating system.
- We built our applications using virtual instances of the operating system. The premier tool for doing this at the time was VMWare, and it had just gotten Really Good.
- Don’t let object-relational mapping tools (O/R mappers) violate canonicality.
- Using an O/R mapper introduces repetition in projects where we have essentially the same information in three places: in the database schema, in an XML mapping document, and in a class file. This represents two violations of the DRY principle.
- The solution to this problem is to create a single representation and generate the other two.
- Add behavior to generated code via extension, open classes, or partial classes.
- Lots of projects treat source code and SQL as completely separate artifacts, sometimes created by entirely separate groups of developers.
- Always keep code and schemas in sync.
- Rake migrations
- dbDeploy is an open source framework that provides some of the benefits of migrations in a platform-agnostic way.
- Use migrations to create repeatable snapshots of schema changes.
{}

- Out-of-date documentation is worse than none because it is actively misleading.
- For managers, documentation is about risk mitigation.
- When you think about it, that’s the goal of documenting your work in the first place: to create a reliable source of what you did and why.
- Always keep “living” documentation.
- Anything that takes real effort to create makes its creator irrationally attached to it.
- Whiteboard + digital camera trumps a CASE tool.
- (vegre egy csomo olyan otlet emit mar en is bevexettem es felfedeztem. most mar szepen meg is tudom fogalmazni es ervelni. korabban a csak szocska vagy a szerintem kifejezest hasznaltam. ezeel a konyvvel tudatos szintre emelkedett. Otto)
- Generate all the technical documents you can.
- such tool is yDoc,
- Never keep two copies of the same thing (like code and a diagram describing it).
- SchemaSpy§ is an open source tool that does for database entity/relationship diagrams what yDoc does for code.
- Repetition is the single most diminishing force in software development.


<div class='old-comments'></div>