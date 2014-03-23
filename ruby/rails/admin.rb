--
-- to remove wrong scaffold
--
rm db/migrate/20130410201734_create_admin_fields.rb
rm app/models/admin/field.rb
rm test/unit/admin/field_test.rb
rm test/fixtures/admin/fields.yml
rm app/controllers/admin/fields_controller.rb
rm app/views/admin/fields
rm app/views/admin/fields/index.html.erb
rm app/views/admin/fields/edit.html.erb
rm app/views/admin/fields/show.html.erb
rm app/views/admin/fields/new.html.erb
rm app/views/admin/fields/_form.html.erb
rm test/functional/admin/fields_controller_test.rb
rm app/helpers/admin/fields_helper.rb
rm test/unit/helpers/admin/fields_helper_test.rb
rm app/assets/javascripts/admin/fields.js.coffee
rm app/assets/stylesheets/admin/fields.css.scss

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
ActiveRecord::Migration.create_table(:admin_collections)
ActiveRecord::Migration.add_column(:admin_collections, :name, :string)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

rails generate scaffold Admin::Collection name:string label:string data_type:string created_by:integer modified_by:integer created_at:datetime modified_at:datetime

ActiveRecord::Migration.create_table :admin_collections do |table|
  table.timestamps
  table.integer :created_by
  table.integer :modified_by
  table.datetime :created_at
  table.datetime :modified_at
  table.string :name
  table.string :label
  table.string :data_type
  table.integer :collection_id
end

vi route.conf
  namespace :admin do
    resources :collections
    resources :fields
    resources :types
  end

http://cchoudesktop:3000/admins/setr/


rails generate scaffold Admin::Field name:string label:string data_type:string created_by:integer modified_by:integer created_at:datetime modified_at:datetime collection_id:integer

ActiveRecord::Migration.create_table :admin_fields do |table|
  table.timestamps
  table.integer :created_by
  table.integer :modified_by
  table.datetime :created_at
  table.datetime :modified_at
  table.string :name
  table.string :label
  table.string :data_type
	table.integer :collection_id
end


rails generate scaffold Admin::Type name:string created_by:integer modified_by:integer created_at:datetime modified_at:datetime

ActiveRecord::Migration.create_table :admin_types do |table|
  table.timestamps
  table.integer :created_by
  table.integer :modified_by
  table.datetime :created_at
  table.datetime :modified_at
  table.string :name
end




