---
title: "DOC Command prompt"
kind: article
created_at: 2012-02-28 13:22:23 +0000
author: "Takács Ottó"
published: true
tags: reference,articles
---
__fc - Free BeyondCompare in XP__
:    FC is an advanced DOS Command that compares two files and displays the differences between them. Though the file comparison results are not as interactive as BeyondCompare or Altova DiffDog, fc is still very useful. You can even set fc to resynchronize the files after finding a mismatch. 

__tree - visual directory structure__
:    You often need to take prints of your physical directory structure but XP has no simple "visual" commands for printing directory contents. Here, try the Tree DOS command and redirect the output to a text file.

__find - advanced file search with filter__
:   Find is the most powerful DOS command and even more useful than the Windows Desktop Search tool or the Windows Find Wizard. The find command searches for a specific string of text in a file or files. After searching the specified file or files, find displays any lines of text that contain the specified string.
To search your hard disk to find and display the file names on drive C: that contain the string "Google" use the pipe (|) to direct the results of a dir command to find as follows:
`dir c:\ /s /b | find "Google" `

command > file 	
:    Write standard output of command to file

command 1> file 	
:   Write standard output of command to file (same as previous)

command 2> file 	
: Write standard error of command to file (OS/2 and NT)

command > file 2>&1 	
: Write both standard output and standard error of command to file (OS/2 and NT)

commandA 2>&1 | commandB 	
: Redirect standard output and standard error of commandA to standard input of commandB (OS/2 and NT)

ECHO "%~dp0" 	
:    Shows the batch file's directory with trailing backslash (credits: Sean Brannery)

Call another program in the background
:   START

<div class='old-comments'></div>