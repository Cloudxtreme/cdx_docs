class Admin::UsersController < ApplicationController
  # GET /admin/users
  # GET /admin/users.json
  def index
    @objects = Admin::User.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @objects }
    end
  end

  # GET /admin/users/1
  # GET /admin/users/1.json
  def show
    @object = Admin::User.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @object }
    end
  end

  # GET /admin/users/new
  # GET /admin/users/new.json
  def new
    @object = Admin::User.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @object }
    end
  end

  # GET /admin/users/1/edit
  def edit
    @object = Admin::User.find(params[:id])
  end

  # POST /admin/users
  # POST /admin/users.json
  def create
    @object = Admin::User.new(params[:admin_user])

    respond_to do |format|
      if @object.save
        format.html { redirect_to @object, notice: 'User was successfully created.' }
        format.json { render json: @object, status: :created, location: @object }
      else
        format.html { render action: "new" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /admin/users/1
  # PUT /admin/users/1.json
  def update
    @object = Admin::User.find(params[:id])

    respond_to do |format|
      if @object.update_attributes(params[:admin_user])
        format.html { redirect_to @object, notice: 'User was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /admin/users/1
  # DELETE /admin/users/1.json
  def destroy
    @object = Admin::User.find(params[:id])
    @object.destroy

    respond_to do |format|
      format.html { redirect_to admin_users_url }
      format.json { head :no_content }
    end
  end
end
