
New method:
~~~~~~~~~~~
class Admin::Type < ActiveRecord::Base
  def self.all_types
    Admin::Type.all
  end
end

class Admin::TypesController < ApplicationController
  def index
    Admin::Type.all_types
	end
end
