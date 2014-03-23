
See new_model.rb

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
vi books_controller.rb
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



vi index.html.erb
<script type="text/javascript">
$(document).ready(function() {
  $('#example').dataTable( {
    bProcessing: true,
    "bServerSide": true,
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


