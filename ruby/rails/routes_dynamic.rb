#
# NOTE: can't test this from console!!  It will not work!!!!
#
1) rails generate controller Admins index

2) vi routes.rb
  get "admins/getr"
  get "admins/setr"
  resources :admins

3)
   18  touch setr.html.erb
   19  touch getr.html.erb

4) rails server -e production
	http://cchoudesktop:3000/admins/

5) vi admins_controller.rb
class AdminsController < ApplicationController
  def index
  end

  def getr
    Rails.application.routes.routes.map do |j|
      puts "#{j.name} - #{j.defaults} #{j.verb}"
    end
  end

  def setr
    #Pg6::Application.reload_routes!
    Rails.application.reload_routes!
  end
end


# add route
http://cchoudesktop:3000/admins/getr/
vi routes.rb
	resources :bags
http://cchoudesktop:3000/admins/setr/
http://cchoudesktop:3000/bags/             ------------> Loaded!!

# remove route
vi routes.rb
  # resources :bags
http://cchoudesktop:3000/admins/setr/
http://cchoudesktop:3000/bags/             ------------> No route error!!


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Can add the followings to 'setr' so we'll have 'true' dynamic routes

	Pg6::Application.routes.draw do
	  get "admins/getr"
 		get "admins/setr"
  	resources :admins

		resources :bags
	end

