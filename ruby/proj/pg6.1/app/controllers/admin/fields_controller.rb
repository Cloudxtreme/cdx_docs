class Admin::FieldsController < ApplicationController

  def json

		criteria = {:collection_id => 1 }
		#sort_order = %w[ id name ].join(',') + ' ' + 'DESC'
		# "id desc, name asc"

    @books = Admin::Field.where(criteria).paginate(
              :page => params[:iDisplayLength].nil? ? 1 : params[:iDisplayStart].to_i/params[:iDisplayLength].to_i + 1,
              :per_page => params[:iDisplayLength]
            ) #.order("id desc, name asc")

    dtobj = {
			:json => {
	      :sEcho => params[:sEcho],
  	    :iDisplayLength => params[:iDisplayLength],
    	  :iDisplayStart => params[:iDisplayStart],
      	:iTotalRecords => Admin::Field.count,
      	:iTotalDisplayRecords =>  Admin::Field.count,
      	:aaData => Array.new(@books)
			}
    }
    render dtobj
  end


  # GET /admin/fields
  # GET /admin/fields.json
  def index
    @objects = Admin::Field.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @objects }
    end
  end

  # GET /admin/fields/1
  # GET /admin/fields/1.json
  def show
    @object = Admin::Field.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @object }
    end
  end

  # GET /admin/fields/new
  # GET /admin/fields/new.json
  def new
    @object = Admin::Field.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @object }
    end
  end

  # GET /admin/fields/1/edit
  def edit
    @object = Admin::Field.find(params[:id])
  end

  # POST /admin/fields
  # POST /admin/fields.json
  def create
    @object = Admin::Field.new(params[:admin_field])

    respond_to do |format|
      if @object.save
        format.html { redirect_to @object, notice: 'Field was successfully created.' }
        format.json { render json: @object, status: :created, location: @object }
      else
        format.html { render action: "new" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /admin/fields/1
  # PUT /admin/fields/1.json
  def update
    @object = Admin::Field.find(params[:id])

    respond_to do |format|
      if @object.update_attributes(params[:admin_field])
        format.html { redirect_to @object, notice: 'Field was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @object.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /admin/fields/1
  # DELETE /admin/fields/1.json
  def destroy
    @object = Admin::Field.find(params[:id])
    @object.destroy

    respond_to do |format|
      format.html { redirect_to admin_fields_url }
      format.json { head :no_content }
    end
  end
end
