class UsersController < ApplicationController

	def index
		@mdata = ''
		@columnkey2name = { 'name' => 'Name', 'email' => 'Email'}									# used by html table
		@columnkey2name.keys.each { |key| @mdata += "{ 'mData': '#{key}' }," }		# used by ajax
	end

	def datatable
		@users = User.all

		json = {
      :sEcho => 1,
      :iTotalRecords => @users.size,
      :aaData => Array.new(@users)
    }
    render :json=>json
	end


  def new
  end
end
