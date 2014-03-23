class ProductsController < ApplicationController

  def index
    @products = Product.all(:conditions => ["name LIKE ?", "%#{params[:query]}%"], :order => 'name', :limit => 5)

    respond_to do |format|
      format.html # index.html.erb
      format.json do
          render :json => @products.map(&:name)
      end
    end
  end

	def index1  
     @products = Product.order(:name).where("name like ?", "#{params[:term]}")  
     render json: @products.map(&:name)  
 	end  

end
