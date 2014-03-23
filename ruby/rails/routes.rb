-- http://guides.rubyonrails.org/routing.html

vi routes.rb
	resources :photos
	
creates seven different routes.......

	HTTP Verb		Path							action		used for
  ~~~~~~~~~   ~~~~~~~~~~~~~~~~~ ~~~~~~~~  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	GET					/photos						index			display a list of all photos
	GET					/photos/new				new				return an HTML form for creating a new photo
	POST				/photos						create		create a new photo
	GET					/photos/:id				show			display a specific photo
	GET					/photos/:id/edit	edit			return an HTML form for editing a photo
	PUT					/photos/:id				update		update a specific photo
	DELETE			/photos/:id				destroy		delete a specific photo

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-- http://api.rubyonrails.org/classes/Ac/tionDispatch/Routing.html

Rails.application.routes.routes
Rails.application.routes.routes.first
Rails.application.routes.routes.first.name
Rails.application.routes.routes.first.path
Rails.application.routes.routes.first.verb
Rails.application.routes.routes.first.ip
Rails.application.routes.routes.first.defaults


#<Journey::Route:0x0000000280c490 
	@name="users", 
	@app=#<ActionDispatch::Routing::RouteSet::Dispatcher:0x00000003c89800 
		@defaults={:action=>"index", :controller=>"users"}, 
		@glob_param=nil, 
		@controllers={}>, 
		@path=#<Journey::Path::Pattern:0x00000003d131b8 
						@anchored=true, 
						@spec=/users(.:format), 
						@requirements={}, 
						@separators="/.?", 
						@names=["format"], 
						@optional_names=nil, 
						@required_names=nil, 
						@re=/\A\/users(?:\.([^\/.?]+))?\Z/, 
						@offsets=nil>, 
						@verb=/^GET$/, 
						@ip=//, 
						@constraints={:request_method=>/^GET$/}, 
						@defaults={:action=>"index", :controller=>"users"}, 
						@required_defaults=nil, 
						@required_parts=nil, 
						@parts=[:format], 
						@decorated_ast=nil, 
						@precedence=16>, 

Rails.application.routes.routes.map do |j|
 puts "#{j.name} - #{j.defaults} #{j.verb}"
end




