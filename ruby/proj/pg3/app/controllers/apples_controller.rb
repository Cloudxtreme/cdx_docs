class ApplesController < ApplicationController
  # GET /apples
  # GET /apples.json
  def index
    @apples = Apple.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @apples }
    end
  end

  # GET /apples/1
  # GET /apples/1.json
  def show
    @apple = Apple.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @apple }
    end
  end

  # GET /apples/new
  # GET /apples/new.json
  def new
    @apple = Apple.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @apple }
    end
  end

  # GET /apples/1/edit
  def edit
    @apple = Apple.find(params[:id])
  end

  # POST /apples
  # POST /apples.json
  def create
    @apple = Apple.new(params[:apple])

    respond_to do |format|
      if @apple.save
        format.html { redirect_to @apple, notice: 'Apple was successfully created.' }
        format.json { render json: @apple, status: :created, location: @apple }
      else
        format.html { render action: "new" }
        format.json { render json: @apple.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /apples/1
  # PUT /apples/1.json
  def update
    @apple = Apple.find(params[:id])

    respond_to do |format|
      if @apple.update_attributes(params[:apple])
        format.html { redirect_to @apple, notice: 'Apple was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @apple.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /apples/1
  # DELETE /apples/1.json
  def destroy
    @apple = Apple.find(params[:id])
    @apple.destroy

    respond_to do |format|
      format.html { redirect_to apples_url }
      format.json { head :no_content }
    end
  end
end
