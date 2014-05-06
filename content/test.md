---
created_at: 2014-05-05 00:00
tags:
  - t1
---
Test page to compile
sd

<%= item[:tags]%>


Tags for <%=tags_for(@item)%>

tags: <%=tags%>

count_tags: <%=count_tags%>

<% tags.each do |tag| %>
- <%= tag%>
<% end %>

