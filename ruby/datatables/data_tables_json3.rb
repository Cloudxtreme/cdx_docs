--
-- Dynamic columns
--

vi routes.rb
  get "hello/world"
  get "hello/datatable"

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
vi hello_controller.rb

class HelloController < ApplicationController
  def world
    @columns = [ 'Rendering engine', 'Browser', 'Platform(s)', 'Engine version', 'CSS grade' ]
  end

  def datatable
    json = {
      "sEcho" => 1,
      "iTotalRecords" => "57",
      "iTotalDisplayRecords" => "57",
      "aaData" => [
        [ "Gecko", "Firefox 1.0", "Win 98+ / OSX.2+", "1.7", "<a href='http://www.google.com'>A</a>" ],
        [ "Gecko", "Firefox 1.0", "Win 98+ / OSX.2+", "1.7", "A" ],
        [ "Gecko", "Netscape Browser 8", "Win 98SE+", "1.7", "A" ],
        [ "Gecko", "Firefox 1.5", "Win 98+ / OSX.2+", "1.8", "A" ],
        [ "Gecko", "Firefox 2.0", "Win 98+ / OSX.2+", "1.8", "A" ],
        [ "Gecko", "Firefox 3.0", "Win 2k+ / OSX.3+", "1.9", "A" ],
        [ "Gecko", "Camino 1.0", "OSX.2+", "1.8", "A" ],
        [ "Gecko", "Camino 1.5", "OSX.3+", "1.8", "A" ],
        [ "Gecko", "Netscape 7.2", "Win 95+ / Mac OS 8.6-9.2", "1.7", "A" ],
        [ "Gecko", "Netscape Browser 8", "Win 98SE+", "1.7", "A" ],
        [ "Gecko", "Netscape Navigator 9", "Win 98+ / OSX.2+", "1.8", "A" ],
        [ "Gecko", "Mozilla 1.0", "Win 95+ / OSX.1+", "1", "A" ]
      ]
    }
    render :json=>json
  end

end

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
vi world.html.erb

<script type="text/javascript">
$(document).ready(function() {
  $('#example').dataTable( {
    bProcessing: true,
    sAjaxSource: 'http://cchoudesktop:3000/hello/datatable/'
  } );

});
</script>


<h1>Live example</h1>
<table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
  <thead>
    <tr>
      <% @columns.each do |column| %>
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

