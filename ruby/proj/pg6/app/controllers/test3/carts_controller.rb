class Test3::CartsController < ApplicationController
  # GET /test3/carts
  # GET /test3/carts.json
  def index
    @objects = Test3::Cart.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @objects }
    end
  end

  # GET /test3/carts/1
  # GET /test3/carts/1.json
  def show
    @object = Test3::Cart.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @object }
    end
  end

  # GET /test3/carts/new
  # GET /test3/carts/new.json
  def new
    @object = Test3::Cart.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @object }
    end
  end

  # GET /test3/carts/1/edit
  def edit
    @object = Test3::Cart.find(params[:id])
  end

  # POST /test3/carts
  # POST /test3/carts.json
  def create
    @object = Test3::Cart.new(params[:test3_cart])

    respond_to do |format|
      if @object.save
        format.html { redirect_to @object, notice: 'Cart was successfully created.' }
        format.json { render json: @object, status: :created, location: @object }
      else
        format.html { render action: "new" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /test3/carts/1
  # PUT /test3/carts/1.json
  def update
    @object = Test3::Cart.find(params[:id])

    respond_to do |format|
      if @object.update_attributes(params[:test3_cart])
        format.html { redirect_to @object, notice: 'Cart was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /test3/carts/1
  # DELETE /test3/carts/1.json
  def destroy
    @object = Test3::Cart.find(params[:id])
    @object.destroy

    respond_to do |format|
      format.html { redirect_to test3_carts_url }
      format.json { head :no_content }
    end
  end
end
