#
# use this as the template
#
ActiveRecord::Migration.create_table :admin_securities do |t|
  t.string :name
  t.timestamps
end

rails generate scaffold Admin::Security name:string

      create    app/models/admin/securities.rb

      invoke  resource_route
						namespace :admin do 
							resources :securities 
						end

      invoke  scaffold_controller
      create    app/controllers/admin/users_controller.rb

      invoke    erb
      create      app/views/admin/users
      create      app/views/admin/users/index.html.erb
      create      app/views/admin/users/edit.html.erb
      create      app/views/admin/users/show.html.erb
      create      app/views/admin/users/new.html.erb
      create      app/views/admin/users/_form.html.erb

	Rails.application.reload_routes!

vi users_controller.rb
		@admin_users --->  @objects
		@admin_user  --->  @object

vi user.rb
  include ModelHelper
  attr_accessible :created_at, :created_by, :modified_at, :modified_by, :name, :email

ActionDispatch::Reloader.cleanup!
ActionDispatch::Reloader.prepare!

views:
	copy index.html.erb from ../field ----> Admin::Field to Admin::User 
	copy _form.html.erb from ../field
	copy  show.html.erb from ../field


ActiveRecord::Migration.add_column(:admin_securities, :field_id, :integer)
ActiveRecord::Migration.add_column(:admin_securities, :profile_id, :integer)

# model:

vi security.rb
	attr_accessible :field_id, :profile_id
	belongs_to :field
	belongs_to :profile

vi field.rb
	has_many :profile

vi profile.rb
	has_many :profile

  


