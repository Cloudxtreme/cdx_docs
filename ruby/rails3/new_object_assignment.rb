#
# use this as the template
#
ActiveRecord::Migration.create_table :assignments do |t|
  t.string :name
  t.timestamps
end

ActiveRecord::Migration.add_column(:assignments, :project_id, :integer)
ActiveRecord::Migration.add_column(:assignments, :resource_id, :integer)


rails generate scaffold Assignment name:string


invoke  resource_route
				resources :assignment 


#	Rails.application.reload_routes!

vi users_controller.rb
		@admin_users --->  @objects
		@admin_user  --->  @object

vi user.rb
  include ModelHelper
  attr_accessible :created_at, :created_by, :modified_at, :modified_by, :name, :email

#ActionDispatch::Reloader.cleanup!
#ActionDispatch::Reloader.prepare!

views:
	copy edit.html.erb from ../field 
	copy index.html.erb from ../field 
	copy _form.html.erb from ../field
	copy  show.html.erb from ../field


