class Service::TimecardsController < ApplicationController
  # GET /service/timecards
  # GET /service/timecards.json
  def index
    @objects = Service::Timecard.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @objects }
    end
  end

  # GET /service/timecards/1
  # GET /service/timecards/1.json
  def show
    @object = Service::Timecard.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @object }
    end
  end

  # GET /service/timecards/new
  # GET /service/timecards/new.json
  def new
    @object = Service::Timecard.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @object }
    end
  end

  # GET /service/timecards/1/edit
  def edit
    @object = Service::Timecard.find(params[:id])
  end

  # POST /service/timecards
  # POST /service/timecards.json
  def create
    @object = Service::Timecard.new(params[:service_timecard])

    respond_to do |format|
      if @object.save
        format.html { redirect_to @object, notice: 'Timecard was successfully created.' }
        format.json { render json: @object, status: :created, location: @object }
      else
        format.html { render action: "new" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /service/timecards/1
  # PUT /service/timecards/1.json
  def update
    @object = Service::Timecard.find(params[:id])

    respond_to do |format|
      if @object.update_attributes(params[:service_timecard])
        format.html { redirect_to @object, notice: 'Timecard was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /service/timecards/1
  # DELETE /service/timecards/1.json
  def destroy
    @object = Service::Timecard.find(params[:id])
    @object.destroy

    respond_to do |format|
      format.html { redirect_to service_timecards_url }
      format.json { head :no_content }
    end
  end
end
