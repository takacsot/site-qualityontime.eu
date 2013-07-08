require 'time' 
require 'date' 

def items_in_the_same_book(current_item)
	@items.select{|item| item[:book] == current_item[:book]}
end

def sorted_items_in_the_same_book(current_item)
	items_in_the_same_book(current_item).sort_by{|i| pn(i)}
end

def sorted_pages_same_book_but_main(current_item)
	sorted_items_in_the_same_book(current_item)[1..-1]
end
def main_book_page(current_item)
	sorted_items_in_the_same_book(current_item)[0]
end

def book_page(current_item, page_num)
	items_in_the_same_book(current_item).select{|item| page_num == pn(item)}
end

def pn(item)
	ret = 99
	ret = item[:book_page] if item[:book_page]
	ret
end