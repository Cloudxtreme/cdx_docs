class Admin::WidgetsController < ApplicationController
  # GET /admin/widgets
  # GET /admin/widgets.json
  def index
    @objects = Admin::Widget.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @objects }
    end
  end

  # GET /admin/widgets/1
  # GET /admin/widgets/1.json
  def show
    @object = Admin::Widget.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @object }
    end
  end

  # GET /admin/widgets/new
  # GET /admin/widgets/new.json
  def new
    @object = Admin::Widget.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @object }
    end
  end

  # GET /admin/widgets/1/edit
  def edit
    @object = Admin::Widget.find(params[:id])
  end

  # POST /admin/widgets
  # POST /admin/widgets.json
  def create
    @object = Admin::Widget.new(params[:admin_widget])

    respond_to do |format|
      if @object.save
        format.html { redirect_to @object, notice: 'Widget was successfully created.' }
        format.json { render json: @object, status: :created, location: @object }
      else
        format.html { render action: "new" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /admin/widgets/1
  # PUT /admin/widgets/1.json
  def update
    @object = Admin::Widget.find(params[:id])

    respond_to do |format|
      if @object.update_attributes(params[:admin_widget])
        format.html { redirect_to @object, notice: 'Widget was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /admin/widgets/1
  # DELETE /admin/widgets/1.json
  def destroy
    @object = Admin::Widget.find(params[:id])
    @object.destroy

    respond_to do |format|
      format.html { redirect_to admin_widgets_url }
      format.json { head :no_content }
    end
  end
end
