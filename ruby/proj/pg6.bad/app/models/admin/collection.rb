class Admin::Collection < ActiveRecord::Base
	has_many :fields

  attr_accessible :name
	
end
