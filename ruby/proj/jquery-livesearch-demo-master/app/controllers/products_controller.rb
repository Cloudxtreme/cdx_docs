class ProductsController < ApplicationController
  
  def index
    if params[:query]
      @products = Product.all(:conditions => ["name LIKE ?", "%#{params[:query]}%"], :order => 'name', :limit => 5)
    else
      # @products = Product.all
    end
    
    respond_to do |format|
      format.html # index.html.erb
      format.json do
        if params[:type] == "full"
          render :json => @products.map(&:_as_json)
        else
          render :json => @products.map(&:name)
        end
      end
    end
  end
  
end
