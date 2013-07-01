module Paginate
  def paginate_articles
	articles_to_paginate = past_sorted_articles
	article_groups = []
	until articles_to_paginate.empty?
		article_groups << articles_to_paginate.slice!(0..@config[:page_size]-1)
	end
	article_groups.each_with_index do |subarticles, i|
	  first = i*config[:page_size] + 1
	  last  = (i+1)*config[:page_size]

	  @items << Nanoc::Item.new(
		"<%= render 'pagination_page', :item_id => #{i}, :nr_pages=> #{article_groups.size} %>",
		{ :title => "Archive (articles #{first} to #{last})" },
		"/archive/page/#{i+1}/"
	  )
	end
  end
end

include Paginate

