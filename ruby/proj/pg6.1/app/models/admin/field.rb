class Admin::Field < ActiveRecord::Base

	include ModelHelper

  attr_accessible :created_at, :created_by, :type_id, :label, :modified_at, :modified_by, :name, :collection_id

	belongs_to :collection
	belongs_to :type

end
