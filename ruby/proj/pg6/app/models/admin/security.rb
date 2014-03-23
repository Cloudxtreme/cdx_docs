class Admin::Security < ActiveRecord::Base
  include ModelHelper
  attr_accessible :created_at, :created_by, :modified_at, :modified_by, :name, :field_id, :profile_id

  belongs_to :field
  belongs_to :profile
end
