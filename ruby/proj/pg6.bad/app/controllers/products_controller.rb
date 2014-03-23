class ProductsController < ApplicationController

  def index
		logger.info '222'
		m = Product.first
  end

	def exp
		expire_action :action => :index
	end
end
