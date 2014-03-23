class Book < ActiveRecord::Base

	include ModelHelper
	attr_accessible :name, :title
end
