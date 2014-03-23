class Admin::ProfilesController < ApplicationController
  # GET /admin/profiles
  # GET /admin/profiles.json
  def index
    @objects = Admin::Profile.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @objects }
    end
  end

  # GET /admin/profiles/1
  # GET /admin/profiles/1.json
  def show
    @object = Admin::Profile.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @object }
    end
  end

  # GET /admin/profiles/new
  # GET /admin/profiles/new.json
  def new
    @object = Admin::Profile.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @object }
    end
  end

  # GET /admin/profiles/1/edit
  def edit
    @object = Admin::Profile.find(params[:id])
  end

  # POST /admin/profiles
  # POST /admin/profiles.json
  def create
    @object = Admin::Profile.new(params[:admin_profile])

    respond_to do |format|
      if @object.save
        format.html { redirect_to @object, notice: 'Profile was successfully created.' }
        format.json { render json: @object, status: :created, location: @object }
      else
        format.html { render action: "new" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /admin/profiles/1
  # PUT /admin/profiles/1.json
  def update
    @object = Admin::Profile.find(params[:id])

    respond_to do |format|
      if @object.update_attributes(params[:admin_profile])
        format.html { redirect_to @object, notice: 'Profile was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /admin/profiles/1
  # DELETE /admin/profiles/1.json
  def destroy
    @object = Admin::Profile.find(params[:id])
    @object.destroy

    respond_to do |format|
      format.html { redirect_to admin_profiles_url }
      format.json { head :no_content }
    end
  end
end
