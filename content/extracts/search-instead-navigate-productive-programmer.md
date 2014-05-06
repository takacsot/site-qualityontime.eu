---
title: "Search instead of navigate - Productive programmer"
kind: article
created_at: 2012-02-25 10:11:11 +0000
author: "Takács Ottó"
published: true
tags: 
  - extracts
---
Search instead of navigate

- The bigger the haystack, the harder it is to find the needle.
- Filesystems have become massive haystacks, and we constantly do hard target searches for needles.
tools indexes the interesting parts of your entire hard drive, making searches blazingly fast. They don’t just look at filenames: they index the contents of files.
- Google Desktop Search is its plug-in API, which allows developers to add search plug-ins. For example, Larry’s Any Text File Indexer§ allows you to configure Google Desktop Search for source files.
- Replace file hierarchies with search.
- Eventually, we’ll get filesystems that “understand” the idea that you can tag files with arbitrary attributes.
- Windows Vista also offers a similar feature. If your operating system offers this feature, use it! It is a much better way to organize your groups of files.
- Try simple searching before resorting to “hard target” searching.
- Cygwin in Windows include a utility called find. Find is responsible for finding files from the given directory downward, recursing through directory structures. Find takes tons of parameters that allow you to refine your searches, including regular expressions for filenames.
- findis pretty darn useful by itself, but when you combine it with grep, you have a really powerful team. One of the options on findis -exec, which executes the command(s) that follow with the option of passing the found filename as a parameter.
- find . -name "*.java" -exec grep -n -H "new .*Db.*" {} \; example, say you want to temporarily go to the directory where the executable command javalives. You can do so with a combination of the pushdand whichcommands: pushd `which java`/..
{}
- Rooted views allow you to eliminate the distraction of out-of-context files and focus just on the set of files upon which you need to work right now.
- normal Explorer window, opened with the following parameters: explorer /e,/root,c:\work\cit The rooted view affects only this instance of Explorer.
- Rooted views are particularly good for project work and especially good if you use a file- or folder-based version control system (like Subversion or CVS).
- Take advantage of built-in focus facilities (like colors).
- The default is a measly 300 lines, which will easily scroll off when doing something interesting. Set it to 9999 lines (and ignore
- The widest width that your screen will support without horizontal scrolling.
- Set the position. If this is a command window with a single purpose (like a servlet engine or Ant/Nant/Rake window), have it always appear in a known location. You will learn that location quickly, allowing you to know what this command prompt does without even looking at it.
- Set unique foreground and background colors.
When you cycle through open command prompts, the color (and position) tell you the purpose of this window faster than you can read. - And, of course, turn off Quick Edit Mode.
- Use links to create virtual project management folders.
{}

- Multiple monitors allow you to write code on one and debug on the other. Or keep documentation alongside your coding.
- Virtual desktops unclutter your stacks of windows.
- A massive pile of windows on your desktop distracts you from your focus because you constantly have to sort through the windows.
- set up “communication,” “documentation,” and “development” desktops, which cut down on clutter and aided my sanity.


<div class='old-comments'></div>