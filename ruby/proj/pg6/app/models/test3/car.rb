class Test3::Car < ActiveRecord::Base
  include ModelHelper

	attr_protected

	

  validates :name, :presence => true

	before_create :before_create
  around_create :around_create
  after_create :after_create

	before_update :before_update
	around_update :around_update
	after_update :after_update

	before_destroy :before_destroy
	around_destroy :around_destroy
  after_destroy :after_destroy

	
	def before_create
	end

	def around_create
	end

  def after_create
  end

	def before_update
	end

	def around_update
	end

	def after_update
	end

	def before_destroy
	end

	def around_destroy
	end

  def after_destroy
  end

end
