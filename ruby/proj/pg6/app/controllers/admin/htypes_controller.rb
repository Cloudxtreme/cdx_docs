class Admin::HtypesController < ApplicationController
  # GET /admin/htypes
  # GET /admin/htypes.json
  def index
    @objects = Admin::Htype.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @objects }
    end
  end

  # GET /admin/htypes/1
  # GET /admin/htypes/1.json
  def show
    @object = Admin::Htype.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @object }
    end
  end

  # GET /admin/htypes/new
  # GET /admin/htypes/new.json
  def new
    @object = Admin::Htype.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @object }
    end
  end

  # GET /admin/htypes/1/edit
  def edit
    @object = Admin::Htype.find(params[:id])
  end

  # POST /admin/htypes
  # POST /admin/htypes.json
  def create
    @object = Admin::Htype.new(params[:admin_htype])

    respond_to do |format|
      if @object.save
        format.html { redirect_to @object, notice: 'Htype was successfully created.' }
        format.json { render json: @object, status: :created, location: @object }
      else
        format.html { render action: "new" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /admin/htypes/1
  # PUT /admin/htypes/1.json
  def update
    @object = Admin::Htype.find(params[:id])

    respond_to do |format|
      if @object.update_attributes(params[:admin_htype])
        format.html { redirect_to @object, notice: 'Htype was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /admin/htypes/1
  # DELETE /admin/htypes/1.json
  def destroy
    @object = Admin::Htype.find(params[:id])
    @object.destroy

    respond_to do |format|
      format.html { redirect_to admin_htypes_url }
      format.json { head :no_content }
    end
  end
end
