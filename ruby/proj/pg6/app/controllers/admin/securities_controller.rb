class Admin::SecuritiesController < ApplicationController
  # GET /admin/securities
  # GET /admin/securities.json
  def index
    @objects = Admin::Security.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @objects }
    end
  end

  # GET /admin/securities/1
  # GET /admin/securities/1.json
  def show
    @object = Admin::Security.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @object }
    end
  end

  # GET /admin/securities/new
  # GET /admin/securities/new.json
  def new
    @object = Admin::Security.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @object }
    end
  end

  # GET /admin/securities/1/edit
  def edit
    @object = Admin::Security.find(params[:id])
  end

  # POST /admin/securities
  # POST /admin/securities.json
  def create
    @object = Admin::Security.new(params[:admin_security])

    respond_to do |format|
      if @object.save
        format.html { redirect_to @object, notice: 'Security was successfully created.' }
        format.json { render json: @object, status: :created, location: @object }
      else
        format.html { render action: "new" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /admin/securities/1
  # PUT /admin/securities/1.json
  def update
    @object = Admin::Security.find(params[:id])

    respond_to do |format|
      if @object.update_attributes(params[:admin_security])
        format.html { redirect_to @object, notice: 'Security was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /admin/securities/1
  # DELETE /admin/securities/1.json
  def destroy
    @object = Admin::Security.find(params[:id])
    @object.destroy

    respond_to do |format|
      format.html { redirect_to admin_securities_url }
      format.json { head :no_content }
    end
  end
end
