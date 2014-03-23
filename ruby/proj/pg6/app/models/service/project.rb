class Service::Project < ActiveRecord::Base
  include ModelHelper

  attr_accessible :created_at, :created_by, :label, :modified_at, :modified_by, :name, :namespace_id
  validates :name, :presence => true

  after_create :after_create
  after_destroy :after_destroy

  def after_create
  end

  def after_destroy
  end


end
