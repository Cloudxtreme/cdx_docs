JqueryLivesearchDemo::Application.routes.draw do
  
  resources :products, :only => :index
  
  root :to => 'products#index'
  
  # match ':controller(/:action(/:id))(.:format)'
end
