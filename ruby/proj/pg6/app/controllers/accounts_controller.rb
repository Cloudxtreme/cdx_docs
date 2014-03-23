class AccountsController < ApplicationController
  # GET /admin/collections
  # GET /admin/collections.json
  def index
    @objects = Account.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @objects }
    end
  end

  # GET /admin/collections/1
  # GET /admin/collections/1.json
  def show
    @object = Account.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @object }
    end
  end

  # GET /admin/collections/new
  # GET /admin/collections/new.json
  def new
    @object = Account.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @object }
    end
  end

  # GET /admin/collections/1/edit
  def edit
    @object = Account.find(params[:id])
  end

  # POST /admin/collections
  # POST /admin/collections.json
  def create
    @object = Account.new(params[:account])

    respond_to do |format|
      if @object.save
        format.html { redirect_to @object, notice: 'Collection was successfully created.' }
        format.json { render json: @object, status: :created, location: @object }
      else
        format.html { render action: "new" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /admin/collections/1
  # PUT /admin/collections/1.json
  def update
    @object = Account.find(params[:id])

    respond_to do |format|
      if @object.update_attributes(params[:account])
        format.html { redirect_to @object, notice: 'Collection was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /admin/collections/1
  # DELETE /admin/collections/1.json
  def destroy
    @object = Account.find(params[:id])
    @object.destroy

    respond_to do |format|
      format.html { redirect_to accounts_url }
      format.json { head :no_content }
    end
  end
end
