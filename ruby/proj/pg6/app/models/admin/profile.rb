class Admin::Profile < ActiveRecord::Base
  include ModelHelper
  attr_accessible :created_at, :created_by, :modified_at, :modified_by, :name

	has_many :profile
end
