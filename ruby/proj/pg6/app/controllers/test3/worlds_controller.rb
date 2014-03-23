class Test3::WorldsController < ApplicationController
  # GET /test3/worlds
  # GET /test3/worlds.json
  def index
    @objects = Test3::World.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @objects }
    end
  end

  # GET /test3/worlds/1
  # GET /test3/worlds/1.json
  def show
    @object = Test3::World.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @object }
    end
  end

  # GET /test3/worlds/new
  # GET /test3/worlds/new.json
  def new
    @object = Test3::World.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @object }
    end
  end

  # GET /test3/worlds/1/edit
  def edit
    @object = Test3::World.find(params[:id])
  end

  # POST /test3/worlds
  # POST /test3/worlds.json
  def create
    @object = Test3::World.new(params[:test3_world])

    respond_to do |format|
      if @object.save
        format.html { redirect_to @object, notice: 'World was successfully created.' }
        format.json { render json: @object, status: :created, location: @object }
      else
        format.html { render action: "new" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /test3/worlds/1
  # PUT /test3/worlds/1.json
  def update
    @object = Test3::World.find(params[:id])

    respond_to do |format|
      if @object.update_attributes(params[:test3_world])
        format.html { redirect_to @object, notice: 'World was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /test3/worlds/1
  # DELETE /test3/worlds/1.json
  def destroy
    @object = Test3::World.find(params[:id])
    @object.destroy

    respond_to do |format|
      format.html { redirect_to test3_worlds_url }
      format.json { head :no_content }
    end
  end
end
