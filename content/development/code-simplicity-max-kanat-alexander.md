---
title: "Code Simplicity - Max Kanat-Alexander"
kind: article
created_at: 2012-10-07 11:33:33 +0000
author: "Takács Ottó"
published: true
tags: review,quality,olvasonaplo,it,development
---
![Code Simplicity cover](http://akamaicovers.oreilly.com/images/0636920022251/cat.gif)

Rövid kis könyvecske. Nem igazán számítottam sok mindenre. És részben igazam is lett. __Kevés a tartalom, de az esszenciális.__

Nem igazán konkrét design tanácsokat ad, hanem azokat az alapelveket vázolja, amik segiteni fognak a jó design megalkotásában.

Kivonat:

- Why do computers break so much? For software, there’s one reason, and one reason only: bad programming.
- differentiate breaking program from incorrect user satisfaction.
- a “good programmer” should do everything in his power to make what he writes as simple as possible to other programmers. A good programmer creates things that are easy to understand, so that it’s really easy to shake out all the bugs
- sometimes this idea of simplicity is misunderstood to mean that programs should not have a lot of code, or shouldn’t use advanced technologies. But that’s not true. Sometimes a lot of code actually leads to simplicity; it just means more writing and more reading, which is fine. You have to make sure that you have some short document explaining the big mass of code, but that’s all part of reducing complexity
- When we spend so much time talking about code, though, it is very easy to forget that we are doing so purely because we desire a better result. Nothing in this book forgives a poor result—the entire reason that we focus on improving code is because improving the code is the most important problem we must solve in order to improve the result
- in fact a single purpose for all software: To help people.
- You can even prioritize feature requests this way. Which feature will help people the most?
- science of software design should be: To allow us to write software that is as helpful as possible.
- To allow our software to continue to be as helpful as possible.
- In fact, the major barrier today to writing and maintaining helpful software is the actual difficulty of design and programming
- When software is hard to create or modify, programmers spend most of their time focusing on making things “just work,” and less time focusing on helping the user.
- To design systems that can be created and maintained as easily as possible by their programmers, so that they can be—and continue to be—as helpful as possible.
- The desirability of any change is directly proportional to the value of the change and inversely proportional to the effort involved in making the change.
- Value is actually composed of two factors: the probability of value (how likely it is that this change will help a user), and the potential value (how much this change will help a user during those times when it does help that person)
- Features that have no users have no immediate value. These could include features that users can’t find, features that are too difficult to use, or features that simply don’t help anybody
- The equation as we have it so far is very simple, but it is missing an important element —time. Not only do you have to implement a change, but you also have to maintain it over time
- So, looking at this realistically, we see that effort actually involves both the effort of implementation and the effort of maintenance, and value involves both the value now and the value in the future. 
- in fact, nearly all decisions in software design reduce entirely to measuring the future value of a change versus its effort of maintenance
- we want to avoid situations where, for a given change, the effort of maintenance will eventually outweigh the future value
- The ideal solution—and the only way to guarantee success—is to design your systems such that the effort of maintenance decreases over time, and eventually becomes zero(or as close to it as possible)
- As long as you can do that, it doesn’t matter how large or small the future value becomes; you don’t have to worry about it
- Theoretically, as long as the future value is always larger than the maintenance effort, the change is still desirable
- Often, designing a system that will have decreasing maintenance effort requires a significantly larger effort of implementation—quite a bit more design work and planning are required. However, remember that the effort of implementation is nearly always an insignificant factor in making design decisions, and should mostly be ignored
- It is more important to reduce the effort of maintenance than it is to reduce the effort of implementation.
- The quality level of your design should be proportional to the length of future time in which your system will continue to help people
- The most common and disastrous error that programmers make is predicting something about the future when in fact they cannot know.
- You are safest if you don’t attempt to predict the future at all, and instead make all your design decisions based on immediately known present time information
- there is a difference between designing in a way that allows for future change and attempting to predict the future
- Law of Change: The longer your program exists, the more probable it is that any piece of it will have to change.
- Write your software so that it’s as flexible as reasonably possible, and you’ll be able to adapt to whatever future changes do come along
- There are three broad mistakes that software designers make when attempting to cope with the Law of Change, listed here in order of how common they are: 
   1. Writing code that isn’t needed 
   2. Not making the code easy to change 
   3. Being too generic
- Don’t write code until you actually need it, and remove any code that isn’t being used.
- Not Making the Code Easy to Change: we call “rigid design.” This when a programmer designs code in a way that is difficult to change.
- There are two ways to get a rigid design: 
   1. Make too many assumptions about the future. 
   2. Write code without enough design
- Code should be designed based on what you know now, not on what you think will happen in the future.
- Being Too Generic - We call this “overengineering"
- There are several other problems with overengineering:
   1. You can’t predict the future, so no matter how generic your solution is, it will not be generic enough to satisfy the actual future requirements you will have
   2. When your code is too generic, it often doesn’t handle specifics very well from the user’s perspective
   3. Being too generic involves writing a lot of code that isn’t needed, which brings us back to our first flaw
- In general, when your design makes things more complex instead of simplifying things, you’re overengineering.
- Be only as generic as you know you need to be right now.
- There is a method of software development that avoids the three flaws by its very nature, called “incremental development and design.
- ”Good programmers will introduce roughly one defect into a program for every 100 lines of code they write. The best programmers, under the best possible circumstances, will introduce one defect per 1,000 lines of code they write"
- Law of Defect Probability: The chance of introducing a defect into your program is proportional to the size of the changes you make to it.
- The best design is the one that allows for the most change in the environment with the least change in the software.
- Never “fix” anything unless it’s a problem, and you have evidence showing that the problem really exists.
- In any particular system, any piece of information should, ideally, exist only once.
- Law of Simplicity: The ease of maintenance of any piece of software is proportional to the simplicity of its individual pieces.
- there is a “redesign” step before each new feature is added, you can use that time to simplify the system
- Simplicity Is Relative - when you create something, it may seem relatively “simple” to you, because you understand it inside and out. But to somebody who’s never seen it before, it might appear very complicated
- If you want to understand the viewpoint of somebody who doesn’t know anything about your code, find some code you’ve never read, and read it. Try to understand not just the individual lines, but what the whole program is doing and how you would modify it if you had to. That’s the same experience other people are having when reading your code. You might notice that the level of complexity doesn’t have to get very high before it becomes frustrating to read other people’s code
- Consistency is a big part of simplicity
- it’s better to be consistent and simple, but if you can’t be totally simple, at least be consistent
- Readability of code depends primarily on how space is occupied by letters and symbols.Making code easy to read also helps make it easy to fix.
- Names should be long enough to fully communicate what something is or does without being so long that they become hard to read.
- Having good comments in code is a big part of making it readable
- should not add comments that say what a piece of code is doing
- The real purpose of comments is to explain why you did something, when the reason isn’t obvious
- being a designer a difficult job. Handling a big failure gets you a lot of thanks, but preventing one from ever happening...well, nobody’s likely to notice
- more features there are, the higher the cost of adding a feature gets. You can minimize this problem by having an excellent software design, but there will still always be some slight extra cost for every new feature
- There are other ways to add complexity than just adding features,
   - Expanding the purpose of the software
   - Adding programmers:  You are more likely to be successful with a small group of expert programmers than a large group of inexpert programmers
   - Changing things that don’t need to be changed: Any time you change something, you’re adding complexity.
   - Being locked into bad technologies: A technology in this sense is “bad” if it locks you in (doesn’t allow you to switch easily to some other technology in the future), isn’t going to be flexible enough for your future needs, or just doesn’t have the level of quality you need in order to design simple software with it
   - Misunderstanding: Programmers who don’t fully understand their work tend to develop complex systems
   - Poor design or no design
   - Reinventing the wheel
- Want to see your user get angry really fast? Make it difficult for her to accomplish her purpose. Pop up windows in her face when she’s trying to do something. Add so many features to your program that she can’t find the right one. Use lots of strange icons that she doesn’t understand. There are lots of ways to do it, but they all boil down to interfering with the user’s purpose or violating the basic purpose of the program itself.
- Bad Technologies Another common source of complexity is picking the wrong technology to use in your system—particularly one that ends up not holding up well to future requirements
- Thankfully, there are three factors you can look at to determine if a technology is “bad” before you even start using it: 
   - survival potential, 
   - interoperability, and 
   - attention to quality
- A technology’s survival potential is the likelihood that it will continue to be maintained, by looking at its recent release history.
- Interoperability is a measure of how easy it is to switch away from a technology if you have to
- Attention to Quality This one is more of a subjective measurement, but the idea is to see if the product has been getting better in its recent releases
- What Problem Are You Trying to Solve? you need to ask is, “What problem are you trying to solve?”
- Ask them what problem they’re trying to solve, though, and a simple solution will start to present itself. For example, in this case, once we understand the problem fully, the solution becomes simple and obvious
- So, when things get complex, back up and take a look at the problem you’re trying to solve. Take a really big step back. You are allowed to question everything.
- Any method of solving that problem is acceptable, so what you need to do is figure out what the best method would be for the situation that you’re in
- Discard your assumptions. Really look at the problem you’re trying to solve. Make sure that you fully understand every aspect of it, and then figure out the simplest way to solve it
- No—just ask yourself, “How, in general, in a perfect world, should this sort of problem be solved?” From there, you might see how your code needs to be reworked. Then you can rework your code. Then you can solve the problem
- If you’re having trouble with a complex problem, write it down on paper in plain language, or draw it out as a diagram. Some of the best programming is done on paper, really.
- Most difficult design problems can be solved by simply drawing or writing them out on paper.If some part of your system is too complex, there is a specific way to fix it—redesign the individual pieces, in small steps. Each fix should be as small as you can safely make it without introducing further complexity.
- Each step could be as small as giving a single variable a better name, or just adding a few comments to confusing code. But more often, the steps involve splitting one complex piece into multiple simple pieces
- Never robotically apply a tool purely because some authority has deemed it best—always do what is right for the code you’re looking at and the situation you’re in
- Some designers, when faced with a very complex system, throw it out and start over again. However, rewriting a system from the ground up is essentially an admission of failure as a designer.
- You should only rewrite if all of the following are true:
   1. You have developed an accurate estimate that shows that rewriting the system will be a more efficient use of time than redesigning the existing system
   2. You have a tremendous amount of time to spend on creating a new system
   3. You are somehow a better designer than the original designer of the system or, if you are the original designer, your design skills have improved drastically since you designed the original system
   4. You fully intend to design this new system in a series of simple steps and have users who can give you feedback for each step along the way. 
   4. You fully intend to design this new system in a series of simple steps and have users who can give you feedback for each step along the way. 
   5. You have the resources available to both maintain the existing system and design a new system at the same time
- The degree to which you know how your software behaves is the degree to which you have accurately tested it.Unless you’ve tried it, you don’t know that it works.

<div class='old-comments'></div>