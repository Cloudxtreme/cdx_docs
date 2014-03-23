class Admin::Field < ActiveRecord::Base

	belongs_to :collection

  attr_accessible :created_at, :created_by, :data_type, :label, :modified_at, :modified_by, :name, :collection_id
end
