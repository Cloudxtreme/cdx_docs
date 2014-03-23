class Account < ActiveRecord::Base
	include ModelHelper
  attr_accessible :name
end
