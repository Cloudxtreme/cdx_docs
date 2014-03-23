class Test3::Bike < ActiveRecord::Base
  include ModelHelper

	
  attr_accessible :created_at,:created_by,:modified_at,:modified_by,:name,:label,:namespace_id,:year,:make
	

	

  validates :name, :presence => true

  after_create :after_create
  after_destroy :after_destroy

  def after_create
  end

  def after_destroy
  end


end
