#
# use this as the template
#
ActiveRecord::Migration.create_table :admin_users do |t|
  t.string :name
	t.string :email
	t.boolean :active
  t.timestamps
end

rails generate scaffold Admin::User name:string

      create    app/models/admin/user.rb

      invoke  resource_route
						namespace :admin do 
							resources :users 
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

##########

# create foreign key


ActiveRecord::Migration.add_column(:admin_users, :profile_id, :integer)
update admin_users set profile_id = 1;
  and change profile_id to not null?????

model:
vi user.rb
	attr_accessible ===> add :profile_id
  belongs_to :profile


