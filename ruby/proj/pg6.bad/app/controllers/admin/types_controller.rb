class Admin::TypesController < ApplicationController
  # GET /admin/types
  # GET /admin/types.json
  def index
    @admin_types = Admin::Type.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @admin_types }
    end
  end

  # GET /admin/types/1
  # GET /admin/types/1.json
  def show
    @admin_type = Admin::Type.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @admin_type }
    end
  end

  # GET /admin/types/new
  # GET /admin/types/new.json
  def new
    @admin_type = Admin::Type.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @admin_type }
    end
  end

  # GET /admin/types/1/edit
  def edit
    @admin_type = Admin::Type.find(params[:id])
  end

  # POST /admin/types
  # POST /admin/types.json
  def create
    @admin_type = Admin::Type.new(params[:admin_type])

    respond_to do |format|
      if @admin_type.save
        format.html { redirect_to @admin_type, notice: 'Type was successfully created.' }
        format.json { render json: @admin_type, status: :created, location: @admin_type }
      else
        format.html { render action: "new" }
        format.json { render json: @admin_type.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /admin/types/1
  # PUT /admin/types/1.json
  def update
    @admin_type = Admin::Type.find(params[:id])

    respond_to do |format|
      if @admin_type.update_attributes(params[:admin_type])
        format.html { redirect_to @admin_type, notice: 'Type was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @admin_type.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /admin/types/1
  # DELETE /admin/types/1.json
  def destroy
    @admin_type = Admin::Type.find(params[:id])
    @admin_type.destroy

    respond_to do |format|
      format.html { redirect_to admin_types_url }
      format.json { head :no_content }
    end
  end
end
