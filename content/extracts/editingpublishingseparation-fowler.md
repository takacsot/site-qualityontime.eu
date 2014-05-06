---
title: "EditingPublishingSeparation - Fowler"
kind: article
created_at: 2012-08-21 19:15:59 +0000
author: "Takács Ottó"
published: true
tags: 
  - extracts
---
Igazán azért érdekes, mivel az ebben leírt koncepciót tökéletesen kielégíti egy __static site generator és egy verziókövető rendszer párosa__.


>Yet for a CMS there's a clear downside - the data access patterns for editing and publication are very different. Editing involves small number of people frequently accessing the article, doing both reads and updates. Publishing involves many more people (we hope) accessing the article, but all doing reads. There are some edits done to fix problems in published articles, but these are far fewer than the reads and are from a well-controlled group of people.

>....

>The editing module is geared around the frequent updates, it provides support for editing, tracking changes and monitoring the workflow of the editing process. When an article is published it's copied over the publishing module.

>....

>The publishing module treats the article as largely read-only, updated rarely and only by the editing module.

>...

>The articles can also be stored in different formats.  ... such as editing in markdown and publishing in html. In this case the editing module should store the markdown form while the publishing module stores html.

>...

>Separating these modules can also help with the editing workflow.
