class Product < ActiveRecord::Base

	include ModelHelper
	attr_accessible :name
end
