class Admin::TapesController < ApplicationController
  # GET /admin/tapes
  # GET /admin/tapes.json
  def index
    @objects = Admin::Tape.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @objects }
    end
  end

  # GET /admin/tapes/1
  # GET /admin/tapes/1.json
  def show
    @object = Admin::Tape.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @object }
    end
  end

  # GET /admin/tapes/new
  # GET /admin/tapes/new.json
  def new
    @object = Admin::Tape.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @object }
    end
  end

  # GET /admin/tapes/1/edit
  def edit
    @object = Admin::Tape.find(params[:id])
  end

  # POST /admin/tapes
  # POST /admin/tapes.json
  def create
    @object = Admin::Tape.new(params[:admin_tape])

    respond_to do |format|
      if @object.save
        format.html { redirect_to @object, notice: 'Tape was successfully created.' }
        format.json { render json: @object, status: :created, location: @object }
      else
        format.html { render action: "new" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /admin/tapes/1
  # PUT /admin/tapes/1.json
  def update
    @object = Admin::Tape.find(params[:id])

    respond_to do |format|
      if @object.update_attributes(params[:admin_tape])
        format.html { redirect_to @object, notice: 'Tape was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /admin/tapes/1
  # DELETE /admin/tapes/1.json
  def destroy
    @object = Admin::Tape.find(params[:id])
    @object.destroy

    respond_to do |format|
      format.html { redirect_to admin_tapes_url }
      format.json { head :no_content }
    end
  end
end
