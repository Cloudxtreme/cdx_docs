
module HasCellphone
  def self.included(base)
    base.validates_presence_of :cellphone
    base.before_save :parse_cellphone
  end

  def parse_cellphone
    # do something
  end
end

class User < ActiveRecord::Base
  include HasCellphone
end
