class BooksController < ApplicationController

  def index
    @mdata = ''
    @columnkey2name = { 'name' => 'Name', 'title' => 'Title'}                 # used by html table
    @columnkey2name.keys.each { |key| @mdata += "{ 'mData': '#{key}' }," }    # used by ajax
  end

  def json
		
    @books = Book.paginate(
							:page => params[:iDisplayStart].to_i/params[:iDisplayLength].to_i + 1,
							:per_page => params[:iDisplayLength]
						)

    dtobj = {
      :sEcho => params[:sEcho],
      :iDisplayLength => params[:iDisplayLength],
      :iDisplayStart => params[:iDisplayStart],
      :iTotalRecords => Book.count,
			:iTotalDisplayRecords =>  Book.count,
      :aaData => Array.new(@books)
    }
    render :json => dtobj
  end

end

