class Test3::BikesController < ApplicationController
  # GET /test3/bikes
  # GET /test3/bikes.json
  def index
    @objects = Test3::Bike.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @objects }
    end
  end

  # GET /test3/bikes/1
  # GET /test3/bikes/1.json
  def show
    @object = Test3::Bike.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @object }
    end
  end

  # GET /test3/bikes/new
  # GET /test3/bikes/new.json
  def new
    @object = Test3::Bike.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @object }
    end
  end

  # GET /test3/bikes/1/edit
  def edit
    @object = Test3::Bike.find(params[:id])
  end

  # POST /test3/bikes
  # POST /test3/bikes.json
  def create
    @object = Test3::Bike.new(params[:test3_bike])

    respond_to do |format|
      if @object.save
        format.html { redirect_to @object, notice: 'Bike was successfully created.' }
        format.json { render json: @object, status: :created, location: @object }
      else
        format.html { render action: "new" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /test3/bikes/1
  # PUT /test3/bikes/1.json
  def update
    @object = Test3::Bike.find(params[:id])

    respond_to do |format|
      if @object.update_attributes(params[:test3_bike])
        format.html { redirect_to @object, notice: 'Bike was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /test3/bikes/1
  # DELETE /test3/bikes/1.json
  def destroy
    @object = Test3::Bike.find(params[:id])
    @object.destroy

    respond_to do |format|
      format.html { redirect_to test3_bikes_url }
      format.json { head :no_content }
    end
  end
end
