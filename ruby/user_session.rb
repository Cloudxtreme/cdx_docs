rails generate controller Sessions new

Pg6::Application.routes.draw do
  resources :users
  resources :sessions, :only => [:new, :create, :destroy]
  match '/signup',  :to => 'users#new'
  match '/signin',  :to => 'sessions#new'
  match '/signout', :to => 'sessions#destroy'

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
vi sessions_controller.rb 

class SessionsController < ApplicationController
  def new
    @title = 'Sign in'
  end

  def create
		render 'new' # simplify the process
  end

  def destroy
  end
end

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<h1>Sign In</h1>

<%= form_for(:session, :url => sessions_path) do |f| %>
  <div class='field'>
    <%= f.label :email %> <br />
    <%= f.text_field :email %>
  </div>

  <div class='field'>
    <%= f.label :password %> <br />
    <%= f.password_field :password %>
  </div>

  <div class='action'>
    <%= f.submit 'Sign In' %>
  </div>
<% end %>


<%= debug(params) %>

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
http://cchoudesktop:3000/signin





