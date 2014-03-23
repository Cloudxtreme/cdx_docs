class Service::ResourcesController < ApplicationController
  # GET /service/resources
  # GET /service/resources.json
  def index
    @objects = Service::Resource.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @objects }
    end
  end

  # GET /service/resources/1
  # GET /service/resources/1.json
  def show
    @object = Service::Resource.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @object }
    end
  end

  # GET /service/resources/new
  # GET /service/resources/new.json
  def new
    @object = Service::Resource.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @object }
    end
  end

  # GET /service/resources/1/edit
  def edit
    @object = Service::Resource.find(params[:id])
  end

  # POST /service/resources
  # POST /service/resources.json
  def create
    @object = Service::Resource.new(params[:service_resource])

    respond_to do |format|
      if @object.save
        format.html { redirect_to @object, notice: 'Resource was successfully created.' }
        format.json { render json: @object, status: :created, location: @object }
      else
        format.html { render action: "new" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /service/resources/1
  # PUT /service/resources/1.json
  def update
    @object = Service::Resource.find(params[:id])

    respond_to do |format|
      if @object.update_attributes(params[:service_resource])
        format.html { redirect_to @object, notice: 'Resource was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /service/resources/1
  # DELETE /service/resources/1.json
  def destroy
    @object = Service::Resource.find(params[:id])
    @object.destroy

    respond_to do |format|
      format.html { redirect_to service_resources_url }
      format.json { head :no_content }
    end
  end
end
