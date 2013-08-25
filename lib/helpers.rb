#require 'builder'
require 'fileutils'
require 'time' 
require 'date' 

def tags(items=nil)
  count_tags(items).sort_by{|k,v| k}.map{ |x| x[0] }
end


def partial(identifier_or_item)
  item = identifier_or_item.is_a?(Nanoc3::Item) ? identifier_or_item : item_by_identifier(identifier_or_item)
  item.compiled_content(:snapshot => :pre)
end

#Assuming: some part (e.g. filename itself) unique enough
def item_by_id(identifier)
  items ||= @items
  items.find { |item| item.identifier.include? identifier }
end

def path_by_id(identifier)
	item_by_id(identifier).path
end

def item_by_identifier(identifier)
  items ||= @items
  items.find { |item| item.identifier == identifier }
end

def is_front_page?
    @item.identifier == '/'
end

def site_name
  @config[:site_name]
end

def pretty_time(time)
  #puts time.inspect
  time = Time.parse(time) if not time.is_a?(Time) and not time.nil?
  time.strftime("%b %d, %Y") unless time.nil?
end

def featured_count
  @config[:featured_count].to_i
end

def excerpt_count
  @config[:excerpt_count].to_i
end

def to_month_s(month)
  Date.new(2010, month).strftime("%B")
end

# Creates in-memory tag pages from partial: layouts/_tag_page.haml
def create_tag_pages
  tag_set(items).each do |tag|
    items << Nanoc3::Item.new(
      "= render('_tag_page', :tag => '#{tag}')",           # use locals to pass data
      { :title => "Category: #{tag}", :is_hidden => true}, # do not include in sitemap.xml
      "/tags/#{tag}/",                                     # identifier
      :binary => false
    )
  end
end

def parse_time(t)
	if(t.is_a? Time)
	t
	else
		Time.parse(t)
	end
end

#=> { 2010 => { 12 => [item0, item1], 3 => [item0, item2]}, 2009 => {12 => [...]}}
def articles_by_year_month(l_articles=sorted_articles)
  result = {}
  current_year = current_month = year_h = month_a = nil
  l_articles.each do |item|
	d = parse_time(item[:created_at])
	if current_year != d.year
      current_month = nil
      current_year = d.year
      year_h = result[current_year] = {}
    end
    if current_month != d.month
      current_month = d.month
      month_a = year_h[current_month] = [] 
    end
    month_a << item
  end
  result
end

def past_sorted_articles
	sorted_articles.select{|a| parse_time(a[:created_at]) < Time.new}
end

def list_non_published
	puts "Not yet published items"
	just_now = Time.new
	non_published_items = items.select { |item| item[:created_at] && attribute_to_time(item[:created_at]) > just_now }
	non_published_items.each do |it|
		puts "#{it[:created_at]}: #{it.identifier}"
	end
end