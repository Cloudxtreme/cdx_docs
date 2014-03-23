class Admin::VtypesController < ApplicationController
  # GET /admin/vtypes
  # GET /admin/vtypes.json
  def index
    @objects = Admin::Vtype.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @objects }
    end
  end

  # GET /admin/vtypes/1
  # GET /admin/vtypes/1.json
  def show
    @object = Admin::Vtype.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @object }
    end
  end

  # GET /admin/vtypes/new
  # GET /admin/vtypes/new.json
  def new
    @object = Admin::Vtype.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @object }
    end
  end

  # GET /admin/vtypes/1/edit
  def edit
    @object = Admin::Vtype.find(params[:id])
  end

  # POST /admin/vtypes
  # POST /admin/vtypes.json
  def create
    @object = Admin::Vtype.new(params[:admin_vtype])

    respond_to do |format|
      if @object.save
        format.html { redirect_to @object, notice: 'Vtype was successfully created.' }
        format.json { render json: @object, status: :created, location: @object }
      else
        format.html { render action: "new" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /admin/vtypes/1
  # PUT /admin/vtypes/1.json
  def update
    @object = Admin::Vtype.find(params[:id])

    respond_to do |format|
      if @object.update_attributes(params[:admin_vtype])
        format.html { redirect_to @object, notice: 'Vtype was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /admin/vtypes/1
  # DELETE /admin/vtypes/1.json
  def destroy
    @object = Admin::Vtype.find(params[:id])
    @object.destroy

    respond_to do |format|
      format.html { redirect_to admin_vtypes_url }
      format.json { head :no_content }
    end
  end
end
