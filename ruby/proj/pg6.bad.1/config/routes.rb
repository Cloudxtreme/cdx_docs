Pg6::Application.routes.draw do


  resources :posts

	namespace :service do
		resources :projects
		resources :resources
		resources :assignments
		resources :accounts
		resources :skills
		resources :timecards
	end

  namespace :admin do 
		resources :namespaces
		resources :collections 
		get "fields/json" 
		resources :fields 
		resources :types 
		resources :users
		resources :profiles
		resources :securities
	end

  #get "sessions/new"
  #get "users/new"
#	resources :sessions, :only => [:new, :create, :destroy]
#	match '/signup', 	:to => 'users#new'
#	match '/signin', 	:to => 'sessions#new'
#	match '/signout', :to => 'sessions#destroy'

  get "hello/world"
  get "hello/datatable"
#  get "hello/foo"
#  get "hello/bar"
#  get "hello/foo1"
#  get "hello/bar1"

  get "users/datatable"
	resources :users

	get "books/json"
	resources :books

	get "admins/getr"
	get "admins/setr"
	resources :admins

#	resources :tables
	resources :bags
	resources :products

  # The priority is based upon order of creation:
  # first created -> highest priority.

  # Sample of regular route:
  #   match 'products/:id' => 'catalog#view'
  # Keep in mind you can assign values other than :controller and :action

  # Sample of named route:
  #   match 'products/:id/purchase' => 'catalog#purchase', :as => :purchase
  # This route can be invoked with purchase_url(:id => product.id)

  # Sample resource route (maps HTTP verbs to controller actions automatically):
  #   resources :products

  # Sample resource route with options:
  #   resources :products do
  #     member do
  #       get 'short'
  #       post 'toggle'
  #     end
  #
  #     collection do
  #       get 'sold'
  #     end
  #   end

  # Sample resource route with sub-resources:
  #   resources :products do
  #     resources :comments, :sales
  #     resource :seller
  #   end

  # Sample resource route with more complex sub-resources
  #   resources :products do
  #     resources :comments
  #     resources :sales do
  #       get 'recent', :on => :collection
  #     end
  #   end

  # Sample resource route within a namespace:
  #   namespace :admin do
  #     # Directs /admin/products/* to Admin::ProductsController
  #     # (app/controllers/admin/products_controller.rb)
  #     resources :products
  #   end

  # You can have the root of your site routed with "root"
  # just remember to delete public/index.html.
  # root :to => 'welcome#index'

  # See how all your routes lay out with "rake routes"

  # This is a legacy wild controller route that's not recommended for RESTful applications.
  # Note: This route will make all actions in every controller accessible via GET requests.
  # match ':controller(/:action(/:id))(.:format)'
end
