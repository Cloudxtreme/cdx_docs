class Admin::NamespacesController < ApplicationController
  # GET /admin/namespaces
  # GET /admin/namespaces.json
  def index
    @objects = Admin::Namespace.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @objects }
    end
  end

  # GET /admin/namespaces/1
  # GET /admin/namespaces/1.json
  def show
    @object = Admin::Namespace.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @object }
    end
  end

  # GET /admin/namespaces/new
  # GET /admin/namespaces/new.json
  def new
    @object = Admin::Namespace.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @object }
    end
  end

  # GET /admin/namespaces/1/edit
  def edit
    @object = Admin::Namespace.find(params[:id])
  end

  # POST /admin/namespaces
  # POST /admin/namespaces.json
  def create
    @object = Admin::Namespace.new(params[:admin_namespace])

    respond_to do |format|
      if @object.save
        format.html { redirect_to @object, notice: 'Namespace was successfully created.' }
        format.json { render json: @object, status: :created, location: @object }
      else
        format.html { render action: "new" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /admin/namespaces/1
  # PUT /admin/namespaces/1.json
  def update
    @object = Admin::Namespace.find(params[:id])

    respond_to do |format|
      if @object.update_attributes(params[:admin_namespace])
        format.html { redirect_to @object, notice: 'Namespace was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /admin/namespaces/1
  # DELETE /admin/namespaces/1.json
  def destroy
    @object = Admin::Namespace.find(params[:id])
    @object.destroy

    respond_to do |format|
      format.html { redirect_to admin_namespaces_url }
      format.json { head :no_content }
    end
  end
end
