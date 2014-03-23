class Service::AssignmentsController < ApplicationController
  # GET /service/assignments
  # GET /service/assignments.json
  def index
    @objects = Service::Assignment.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @objects }
    end
  end

  # GET /service/assignments/1
  # GET /service/assignments/1.json
  def show
    @object = Service::Assignment.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @object }
    end
  end

  # GET /service/assignments/new
  # GET /service/assignments/new.json
  def new
    @object = Service::Assignment.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @object }
    end
  end

  # GET /service/assignments/1/edit
  def edit
    @object = Service::Assignment.find(params[:id])
  end

  # POST /service/assignments
  # POST /service/assignments.json
  def create
    @object = Service::Assignment.new(params[:service_assignment])

    respond_to do |format|
      if @object.save
        format.html { redirect_to @object, notice: 'Assignment was successfully created.' }
        format.json { render json: @object, status: :created, location: @object }
      else
        format.html { render action: "new" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /service/assignments/1
  # PUT /service/assignments/1.json
  def update
    @object = Service::Assignment.find(params[:id])

    respond_to do |format|
      if @object.update_attributes(params[:service_assignment])
        format.html { redirect_to @object, notice: 'Assignment was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /service/assignments/1
  # DELETE /service/assignments/1.json
  def destroy
    @object = Service::Assignment.find(params[:id])
    @object.destroy

    respond_to do |format|
      format.html { redirect_to service_assignments_url }
      format.json { head :no_content }
    end
  end
end
