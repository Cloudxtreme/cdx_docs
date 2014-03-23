class Admin::DtypesController < ApplicationController
  # GET /admin/dtypes
  # GET /admin/dtypes.json
  def index
    @objects = Admin::Dtype.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @objects }
    end
  end

  # GET /admin/dtypes/1
  # GET /admin/dtypes/1.json
  def show
    @object = Admin::Dtype.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @object }
    end
  end

  # GET /admin/dtypes/new
  # GET /admin/dtypes/new.json
  def new
    @object = Admin::Dtype.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @object }
    end
  end

  # GET /admin/dtypes/1/edit
  def edit
    @object = Admin::Dtype.find(params[:id])
  end

  # POST /admin/dtypes
  # POST /admin/dtypes.json
  def create
    @object = Admin::Dtype.new(params[:admin_dtype])

    respond_to do |format|
      if @object.save
        format.html { redirect_to @object, notice: 'Dtype was successfully created.' }
        format.json { render json: @object, status: :created, location: @object }
      else
        format.html { render action: "new" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /admin/dtypes/1
  # PUT /admin/dtypes/1.json
  def update
    @object = Admin::Dtype.find(params[:id])

    respond_to do |format|
      if @object.update_attributes(params[:admin_dtype])
        format.html { redirect_to @object, notice: 'Dtype was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /admin/dtypes/1
  # DELETE /admin/dtypes/1.json
  def destroy
    @object = Admin::Dtype.find(params[:id])
    @object.destroy

    respond_to do |format|
      format.html { redirect_to admin_dtypes_url }
      format.json { head :no_content }
    end
  end
end
