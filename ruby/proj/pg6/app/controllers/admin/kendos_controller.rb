class Admin::KendosController < ApplicationController
  # GET /admin/kendos
  # GET /admin/kendos.json
  def index
    @objects = Admin::Kendo.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @objects }
    end
  end

  # GET /admin/kendos/1
  # GET /admin/kendos/1.json
  def show
    @object = Admin::Kendo.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @object }
    end
  end

  # GET /admin/kendos/new
  # GET /admin/kendos/new.json
  def new
    @object = Admin::Kendo.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @object }
    end
  end

  # GET /admin/kendos/1/edit
  def edit
    @object = Admin::Kendo.find(params[:id])
  end

  # POST /admin/kendos
  # POST /admin/kendos.json
  def create
    @object = Admin::Kendo.new(params[:admin_kendo])

    respond_to do |format|
      if @object.save
        format.html { redirect_to @object, notice: 'Kendo was successfully created.' }
        format.json { render json: @object, status: :created, location: @object }
      else
        format.html { render action: "new" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /admin/kendos/1
  # PUT /admin/kendos/1.json
  def update
    @object = Admin::Kendo.find(params[:id])

    respond_to do |format|
      if @object.update_attributes(params[:admin_kendo])
        format.html { redirect_to @object, notice: 'Kendo was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /admin/kendos/1
  # DELETE /admin/kendos/1.json
  def destroy
    @object = Admin::Kendo.find(params[:id])
    @object.destroy

    respond_to do |format|
      format.html { redirect_to admin_kendos_url }
      format.json { head :no_content }
    end
  end
end
