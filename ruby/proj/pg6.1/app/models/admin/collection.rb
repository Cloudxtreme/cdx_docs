class Admin::Collection < ActiveRecord::Base

	include ModelHelper

  attr_accessible :created_at, :created_by, :data_type, :label, :modified_at, :modified_by, :name

	has_many :fields 
	has_many :types

end
