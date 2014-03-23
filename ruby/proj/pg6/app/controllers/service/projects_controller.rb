class Service::ProjectsController < ApplicationController
  # GET /service/projects
  # GET /service/projects.json
  def index
    @objects = Service::Project.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @objects }
    end
  end

  # GET /service/projects/1
  # GET /service/projects/1.json
  def show
    @object = Service::Project.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @object }
    end
  end

  # GET /service/projects/new
  # GET /service/projects/new.json
  def new
    @object = Service::Project.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @object }
    end
  end

  # GET /service/projects/1/edit
  def edit
    @object = Service::Project.find(params[:id])
  end

  # POST /service/projects
  # POST /service/projects.json
  def create
    @object = Service::Project.new(params[:service_project])

    respond_to do |format|
      if @object.save
        format.html { redirect_to @object, notice: 'Project was successfully created.' }
        format.json { render json: @object, status: :created, location: @object }
      else
        format.html { render action: "new" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /service/projects/1
  # PUT /service/projects/1.json
  def update
    @object = Service::Project.find(params[:id])

    respond_to do |format|
      if @object.update_attributes(params[:service_project])
        format.html { redirect_to @object, notice: 'Project was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /service/projects/1
  # DELETE /service/projects/1.json
  def destroy
    @object = Service::Project.find(params[:id])
    @object.destroy

    respond_to do |format|
      format.html { redirect_to service_projects_url }
      format.json { head :no_content }
    end
  end
end
