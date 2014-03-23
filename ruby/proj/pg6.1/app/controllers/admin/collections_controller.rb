class Admin::CollectionsController < ApplicationController
  # GET /admin/collections
  # GET /admin/collections.json
  def index
    @admin_collections = Admin::Collection.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @admin_collections }
    end
  end

  # GET /admin/collections/1
  # GET /admin/collections/1.json
  def show
    @admin_collection = Admin::Collection.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @admin_collection }
    end
  end

  # GET /admin/collections/new
  # GET /admin/collections/new.json
  def new
    @admin_collection = Admin::Collection.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @admin_collection }
    end
  end

  # GET /admin/collections/1/edit
  def edit
    @admin_collection = Admin::Collection.find(params[:id])
  end

  # POST /admin/collections
  # POST /admin/collections.json
  def create
    @admin_collection = Admin::Collection.new(params[:admin_collection])

    respond_to do |format|
      if @admin_collection.save
        format.html { redirect_to @admin_collection, notice: 'Collection was successfully created.' }
        format.json { render json: @admin_collection, status: :created, location: @admin_collection }
      else
        format.html { render action: "new" }
        format.json { render json: @admin_collection.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /admin/collections/1
  # PUT /admin/collections/1.json
  def update
    @admin_collection = Admin::Collection.find(params[:id])

    respond_to do |format|
      if @admin_collection.update_attributes(params[:admin_collection])
        format.html { redirect_to @admin_collection, notice: 'Collection was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @admin_collection.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /admin/collections/1
  # DELETE /admin/collections/1.json
  def destroy
    @admin_collection = Admin::Collection.find(params[:id])
    @admin_collection.destroy

    respond_to do |format|
      format.html { redirect_to admin_collections_url }
      format.json { head :no_content }
    end
  end
end
