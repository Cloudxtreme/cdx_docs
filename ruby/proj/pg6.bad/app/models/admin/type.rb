class Admin::Type < ActiveRecord::Base
  attr_accessible :created_at, :created_by, :modified_at, :modified_by, :name
end
