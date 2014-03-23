class Admin::ValidatesController < ApplicationController
  # GET /admin/validates
  # GET /admin/validates.json
  def index
    @objects = Admin::Validate.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @objects }
    end
  end

  # GET /admin/validates/1
  # GET /admin/validates/1.json
  def show
    @object = Admin::Validate.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @object }
    end
  end

  # GET /admin/validates/new
  # GET /admin/validates/new.json
  def new
    @object = Admin::Validate.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @object }
    end
  end

  # GET /admin/validates/1/edit
  def edit
    @object = Admin::Validate.find(params[:id])
  end

  # POST /admin/validates
  # POST /admin/validates.json
  def create
    @object = Admin::Validate.new(params[:admin_validate])

    respond_to do |format|
      if @object.save
        format.html { redirect_to @object, notice: 'Validate was successfully created.' }
        format.json { render json: @object, status: :created, location: @object }
      else
        format.html { render action: "new" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /admin/validates/1
  # PUT /admin/validates/1.json
  def update
    @object = Admin::Validate.find(params[:id])

    respond_to do |format|
      if @object.update_attributes(params[:admin_validate])
        format.html { redirect_to @object, notice: 'Validate was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /admin/validates/1
  # DELETE /admin/validates/1.json
  def destroy
    @object = Admin::Validate.find(params[:id])
    @object.destroy

    respond_to do |format|
      format.html { redirect_to admin_validates_url }
      format.json { head :no_content }
    end
  end
end
