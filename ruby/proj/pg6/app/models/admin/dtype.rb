class Admin::Dtype < ActiveRecord::Base
  include ModelHelper

  #attr_accessible :created_at, :created_by, :label, :modified_at, :modified_by, :name, :namespace_id
	attr_protected
  validates :name, :presence => true

	belongs_to :htype
	belongs_to :widget
	belongs_to :rtype

  after_create :after_create
  after_destroy :after_destroy

  def after_create
  end

  def after_destroy
  end


end
