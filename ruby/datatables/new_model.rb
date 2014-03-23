#
# Step 1: basic page
#

$ more book.rb 
class Book < ActiveRecord::Base
	attr_accessible :title
end

Book.create(:title => 'title1')

	# >>>>> Error: Can't mass-assign protected attributes: name
  	Sol. Restart 'rails console'


$ vi routes.rb 
  get "books/json"
  resources :books

$ vi books_controller.rb
class BooksController < ApplicationController
	def index
	end
end

$ mkdir views/books
touch index.html.erb

http://cchoudesktop:3000/books/

#
# Step 2: datatables
#

$ vi books_controller.rb
class BooksController < ApplicationController

  def index
    @mdata = ''
    @columnkey2name = { 'name' => 'Name', 'title' => 'Title'}                 # used by html table
    @columnkey2name.keys.each { |key| @mdata += "{ 'mData': '#{key}' }," }    # used by ajax
  end

  def json
    @books = Book.all

    json = {
      :sEcho => 1,
      :iTotalRecords => @books.size,
      :aaData => Array.new(@books)
    }
    render :json=>json
  end

end

vi index.html.erb
<script type="text/javascript">
$(document).ready(function() {
  $('#example').dataTable( {
    bProcessing: true,
    sAjaxSource: 'http://cchoudesktop:3000/books/json/',
    aoColumns: [ <%=@mdata.to_s%> ]
  } );
});
</script>


<h1>Live example</h1>
<table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
  <thead>
    <tr>
      <% @columnkey2name.each_pair do |key, column| %>
        <th width="20%"><%=column%></th>
      <% end %>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td colspan="5" class="dataTables_empty">Loading data from server</td>
    </tr>
  </tbody>
</table>

http://cchoudesktop:3000/books/




