class Admin::RtypesController < ApplicationController
  # GET /admin/rtypes
  # GET /admin/rtypes.json
  def index
    @objects = Admin::Rtype.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @objects }
    end
  end

  # GET /admin/rtypes/1
  # GET /admin/rtypes/1.json
  def show
    @object = Admin::Rtype.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @object }
    end
  end

  # GET /admin/rtypes/new
  # GET /admin/rtypes/new.json
  def new
    @object = Admin::Rtype.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @object }
    end
  end

  # GET /admin/rtypes/1/edit
  def edit
    @object = Admin::Rtype.find(params[:id])
  end

  # POST /admin/rtypes
  # POST /admin/rtypes.json
  def create
    @object = Admin::Rtype.new(params[:admin_rtype])

    respond_to do |format|
      if @object.save
        format.html { redirect_to @object, notice: 'Rtype was successfully created.' }
        format.json { render json: @object, status: :created, location: @object }
      else
        format.html { render action: "new" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /admin/rtypes/1
  # PUT /admin/rtypes/1.json
  def update
    @object = Admin::Rtype.find(params[:id])

    respond_to do |format|
      if @object.update_attributes(params[:admin_rtype])
        format.html { redirect_to @object, notice: 'Rtype was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /admin/rtypes/1
  # DELETE /admin/rtypes/1.json
  def destroy
    @object = Admin::Rtype.find(params[:id])
    @object.destroy

    respond_to do |format|
      format.html { redirect_to admin_rtypes_url }
      format.json { head :no_content }
    end
  end
end
