---
title: "Chapter 21: HOW LONG IS A PIECE OF STRING? The Black Art of Software Timescale Estimation"
kind: article
created_at: 2010-05-26 12:20:25 +0000
author: "Takács Ottó"
published: true
tags: extracts
---
<ul>
    <li><em>Horribly important &nbsp;section - Otto</em>.</li>
    <li><em>The only peopl</em>e able to provide timescale information are the programmers <em>who</em> have to <em>do the work</em>. This is part of the commercial reality of life in the software factory.</li>
    <li>software timescale estimates are nothing more than <em>educated guesses</em></li>
    <li>The <em>quality of an estimate</em> is primarily determined by <em>how well you understand the task being estimated</em>. That is, how well you <em>really</em> understand it, not how well you <em>think</em> you do.</li>
    <li><em>Without enough time to do this, you need to concoct a worst-case figure </em>that development should not exceed.</li>
    <li>Software timescale estimation requires <em>educated guesswork</em>. Each estimate should come with a gauge of your confidence in it.</li>
    <li>There are lots of variables to consider. They come with the inherent complexity of the problem, the implications of your code  design, and the existing software ecosystem it must fit into. Some of those variables may change from day to day.</li>
    <li>Requirements will change under your feet, leading to software scope increases. As the feasibility of a project is investigated, new problems and user-level requirements are unearthed at a phenomenal rate. This makes the estimation job tricky&mdash;you&rsquo;ve got to  work hard to keep up with it all (see &ldquo;Requirements Specification&rdquo; on page 371 for strategies to manage this).</li>
    <li>You can&rsquo;t give an accurate estimate without knowing all the work involved. Perhaps you&rsquo;ll need to rework existing libraries that don&rsquo;t provide enough functionality or refactor to enable safe extension of existing code. If you haven&rsquo;t discovered this, then your estimate will be too low.</li>
    <li>Few projects start on a blank canvas. You must <em>learn the existing system before you can estimate how long work will take</em>. You seldom have time to do this properly before the estimate is delivered.</li>
    <li>If the task is something that has not been attempted before, then it is harder to figure how long it will take. You have no prior experience to base the estimate on.</li>
    <li>Many projects rely on third parties, and these dependencies can prove to be nightmarish. The source of the dependency could be an operating system vendor, a small but significant code library, an external specification, even the customer. You can&rsquo;t control the third-party delivery; your estimates depend on it shipping on time. This increases the risk of delay and must be monitored carefully.</li>
    <li>Creating timescale estimates is a genuinely hard task. Don&rsquo;t underestimate how much work is involved. Appreciate the repercussions of making a bad estimate.</li>
    <li>But there&rsquo;s a very real difference between a quick code hack or prototype effort and a full, production-ready piece of work.</li>
    <li>Everyone (including you) wants shorter development timescales. Don&rsquo;t kid yourself about what is technically possible in the given development time. Don&rsquo;t promise a hack timescale when you must deliver production code.</li>
    <li>Rulez:
    <ul>
        <li><em>Break the task down into the smallest blocks possible, </em>effectively performing a first pass of system design.</li>
        <li>When you reach a fine resolution with suitably comprehensible parts, provide a timescale estimate for each block in <em>man-hours </em>or man-days.</li>
        <li>Once you&rsquo;ve estimated all of the individual timescales, place them back-to-back, add up their durations, and voila: an instant timescale estimate.</li>
    </ul>
    </li>
    <li>Time estimates should be made for small tasks whose individual scope is easy to understand. The measurement should be in units of man-hours or man-days.</li>
    <li>It is vital to <em>consider every activity </em>that will be required to deliver the software.</li>
    <li><em>If there is no specification, write one and get it approved by the task stakeholders.</em></li>
    <li>At the very least, <em>document all assumptions</em> that you have made about the work.</li>
    <li>Different people will work on the same task at different rates.</li>
    <li>Understand whether you&rsquo;re creating an estimate for work that <em>you</em> will do (on a system you understand well) or that <em>someone else</em> will do (who might have to learn it first).</li>
    <li>never plan up front on working overtime.</li>
    <li>Don&rsquo;t make estimates in isolation. Solicit other people&rsquo;s opinions to help improve your estimates.</li>
    <li>important part is risk management&mdash;creating a safe and sensible plan in the face of uncertainty and hidden traps.</li>
    <li>The standard planning misconception when trying to compress a large project is that throwing more developers at a problem will speed it up. This rarely works.</li>
    <li>Create development schedules that will leave your codebase in a clean state. Plan to repay your technical debt.</li>
    <li>When starting a new task, check whether or not the allotted timescale really is practical&mdash;especially if you didn&rsquo;t have the luxury of making the estimate yourself.</li>
    <li><em>Keep a constant eye on how long you&rsquo;re taking against scheduled time. Write down your timescales and keep them close at hand</em>. <em>Add personal estimates for any intermediate tasks that don&rsquo;t figure on the main software plan, and run yourself as a mini-project.</em> If you hit your internal milestones, you&rsquo;ll have more chance of keeping on track with your externally visible timescales. Repeatedly review your list&mdash;at least once a day.</li>
    <li><em>If you discover that you won&rsquo;t hit the deadline, make this known as soon as possible </em>so the plan can be adjusted. This happens far too rarely in practice.</li>
    <li><em>Do as much work as necessary, and no more. </em>It might be fun to add that cute extra feature. But don&rsquo;t.</li>
    <li>Careful design exploiting modularity tends to reduce component dependency, and so reduces the ill effects of slippage and the bunching up of tasks on the schedule. Agree on component interfaces early on, and provide stub components so development can continue while others parts of the system are being built.</li>
    <li>Watch out for changing requirements and specifications and track how this will affect your timescales.</li>
</ul>


<div class='old-comments'></div>