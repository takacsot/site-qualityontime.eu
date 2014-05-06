---
title: "open cursors"
kind: article
created_at: 2011-02-11 11:32:50 +0000
author: "Takács Ottó"
published: true
---
> select count(1), user_name
from v$open_cursor
group by user_name
order by 1 desc


>SELECT   o.SID,
         o.sql_text,
         o.address,
         o.hash_value,
         o.user_name,
         s.schemaname
    FROM v$open_cursor o, v$session s
   WHERE o.saddr = s.saddr AND o.SID = s.SID




>   
select *
from v$open_cursor    
where 
(saddr,sid) in 
(select  saddr,SID
from v$open_cursor
MINUS
select  saddr,SID
from v$session
)
and user_name ='TEST_USER'

<div class='old-comments'></div>