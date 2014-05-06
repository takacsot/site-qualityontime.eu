---
title: "Chapter 6: TO ERR IS HUMAN Dealing with the Inevitable - Error Conditions in Code"
kind: article
created_at: 2010-06-28 09:39:17 +0000
author: "Takács Ottó"
published: true

---
<ul>
    <li>Errors can and will occur.</li>
    <li>Take error handling seriously. The stability of your code rests on it.</li>
    <li>Never ignore an error condition. If you don&rsquo;t know how to handle the problem, signal a failure back up to the calling code. Don&rsquo;t sweep an error under the rug and hope for the best.</li>
    <li>Never ignore any errors that might be reported to you. If an error report channel exists, it&rsquo;s there for a reason.</li>
    <li>Handle each error in the most appropriate context, as soon as you know enough about it to deal with it correctly.</li>
    <li>Ignoring errors does not save time. You&rsquo;ll spend far longer working out the cause of bad program behavior than you ever would have spent writing the error handler.</li>
    <li>Write all error detection and handling now, as you write the code that may fail. Don&rsquo;t put it off until later. If you must be evil and defer handling, at least write the detection scaffolding now.</li>
</ul>


<div class='old-comments'></div>