class Admin::User < ActiveRecord::Base
  include ModelHelper
  attr_accessible :created_at, :created_by, :modified_at, :modified_by, :name, :email, :profile_id

	belongs_to :profile
end
