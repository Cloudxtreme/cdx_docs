class PensController < ApplicationController
  # GET /pens
  # GET /pens.json
  def index
    @pens = Pen.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @pens }
    end
  end

  # GET /pens/1
  # GET /pens/1.json
  def show
    @pen = Pen.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @pen }
    end
  end

  # GET /pens/new
  # GET /pens/new.json
  def new
    @pen = Pen.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @pen }
    end
  end

  # GET /pens/1/edit
  def edit
    @pen = Pen.find(params[:id])
  end

  # POST /pens
  # POST /pens.json
  def create
    @pen = Pen.new(params[:pen])

    respond_to do |format|
      if @pen.save
        format.html { redirect_to @pen, notice: 'Pen was successfully created.' }
        format.json { render json: @pen, status: :created, location: @pen }
      else
        format.html { render action: "new" }
        format.json { render json: @pen.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /pens/1
  # PUT /pens/1.json
  def update
    @pen = Pen.find(params[:id])

    respond_to do |format|
      if @pen.update_attributes(params[:pen])
        format.html { redirect_to @pen, notice: 'Pen was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @pen.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /pens/1
  # DELETE /pens/1.json
  def destroy
    @pen = Pen.find(params[:id])
    @pen.destroy

    respond_to do |format|
      format.html { redirect_to pens_url }
      format.json { head :no_content }
    end
  end
end
