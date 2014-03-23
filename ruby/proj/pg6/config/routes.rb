Pg6::Application.routes.draw do

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

	
		namespace :sfdc do
			 
		end
	
		namespace :test3 do
			 
				resources :carts 
			 
				resources :hellos 
			 
				resources :children 
			 
				resources :worlds 
			 
				resources :bikes 
			 
				resources :cars 
			 
		end
	
		namespace :service do
			 
				resources :projects 
			 
				resources :resources 
			 
				resources :assignments 
			 
				resources :timecards 
			 
		end
	
		namespace :admin do
			 
				resources :kendos 
			 
				resources :fields 
			 
				resources :collections 
			 
				resources :validates 
			 
				resources :vtypes 
			 
				resources :dtypes 
			 
				resources :widgets 
			 
				resources :htypes 
			 
				resources :rtypes 
			 
		end
	

  resources :posts

  get "users/datatable"
  resources :users

  get "books/json"
  resources :books

  get "admins/getr"
  get "admins/setr"
  resources :admins


end
