class HelloController < ApplicationController

	# http://cchoudesktop:3000/hello/world/
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
        [ "Gecko", "Firefox 1.0", "Win 98+ / OSX.2+", "1.7", "A" ],
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

	#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	# http://cchoudesktop:3000/hello/foo/
	# w/ column names

	def foo
    @columns = [ 'Rendering engine', 'Browser']
	end

	def bar
    json = {
      "sEcho" => 1,
      "iTotalRecords" => "57",
      "iTotalDisplayRecords" => "57",
      "aaData" => [
        { "engine" => "Gecko", "browser" => "Firefox 1.0"},
        { "engine" => "Trident", "browser" => "Internet Explorer 4.0"},
        { "engine" => "Gecko", "browser" => "Firefox 2.0", "os" => "Win 98+ / OSX.2+", "version" => "1.8", "grade" => "A" },
      ]
    }
    render :json=>json

	end


	#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	# http://cchoudesktop:3000/hello/foo/
  # /w pagination

  def foo1
    @columns = [ 'Rendering engine', 'Browser', 'Platform(s)', 'Engine version', 'CSS grade' ]
  end

  def bar1
		secho = params['sEcho']
		idlength = params['iDisplayLength']
		idstart = params['iDisplayStart']

    json = {
      "sEcho" => secho,
			"iDisplayLength" => idlength,
			"iDisplayStart" => idstart,
      "iTotalRecords" => "18",
      "iTotalDisplayRecords" => "18",
      "aaData" => [
        [ "Gecko", "Firefox 1.0", "Win 98+ / OSX.2+", "1.7", "<a href='http://www.google.com'>A</a>" ],
        [ "Gecko", "Firefox 1.0", "Win 98+ / OSX.2+", "1.7", "A" ],
        [ "Gecko", "Firefox 1.0", "Win 98+ / OSX.2+", "1.7", "A" ],
        [ "Gecko", "Firefox 1.0", "Win 98+ / OSX.2+", "1.7", "A" ],
        [ "Gecko", "Netscape Browser 8", "Win 98SE+", "1.7", "A" ],
        [ "Gecko", "Firefox 1.5", "Win 98+ / OSX.2+", "1.8", "A" ],
        [ "Gecko", "Firefox 2.0", "Win 98+ / OSX.2+", "1.8", "A" ],
        [ "Gecko", "Firefox 3.0", "Win 2k+ / OSX.3+", "1.9", "A" ],
        [ "Gecko", "Camino 1.0", "OSX.2+", "1.8", "A" ],
        [ "Gecko", "Camino 1.5", "OSX.3+", "1.8", "A" ]
      ]
    }


    json1 = {
      "sEcho" => secho,
			"iDisplayLength" => idlength,
			"iDisplayStart" => idstart,
      "iTotalRecords" => "18",
      "iTotalDisplayRecords" => "18",
      "aaData" => [
        [ "Gecko", "Firefox 1.0", "Win 98+ / OSX.2+", "1.7", "<a href='http://www.google.com'>A</a>" ],
        [ "Gecko", "Firefox 1.0", "Win 98+ / OSX.2+", "1.7", "A" ],
        [ "Gecko", "Firefox 1.0", "Win 98+ / OSX.2+", "1.7", "A" ],
        [ "Gecko", "Firefox 1.0", "Win 98+ / OSX.2+", "1.7", "A" ],
        [ "Gecko", "Netscape Browser 8", "Win 98SE+", "1.7", "A" ],
        [ "Gecko", "Netscape Browser 8", "Win 98SE+", "1.7", "A" ],
        [ "Gecko", "Netscape Browser 8", "Win 98SE+", "1.7", "A" ],
        [ "Gecko", "Mozilla 1.0", "Win 95+ / OSX.1+", "1", "A" ]
      ]
    }

puts '========================================================'
puts idlength
if params['iDisplayStart'] == '0'
		puts json.to_json
    render :json=>json 
		puts '----------------------------'
else
		puts json1.to_json
		render :json => json1
		puts '++++++++++++++++++++++++++++'
end
  end

end
