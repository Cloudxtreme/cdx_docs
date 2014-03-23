
-- http://guides.rubyonrails.org/migrations.html#using-models-in-your-migrations
-- http://apidock.com/rails/ActiveRecord/ConnectionAdapters/SchemaStatements/create_table

vi CreateTable1.rb

ActiveRecord::Migration.create_table(:suppliers)
	ActiveRecord::Migration.add_column(:suppliers, :name, :string, {:limit => 60})
	ActiveRecord::Migration.execute("comment on column suppliers.name is 'Supplier Name'");
