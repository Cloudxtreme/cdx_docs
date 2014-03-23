
rails console

ActiveRecord::Base.connection.tables
ActiveRecord::Base.connection.current_database
MyModel.connection.execute("UPDATE `my_models` SET `beer`='free' WHERE 1")

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-- http://guides.rubyonrails.org/migrations.html#using-models-in-your-migrations
-- http://apidock.com/rails/ActiveRecord/ConnectionAdapters/SchemaStatements/create_table

# bundle exec rails runner CreateTable1.rb
vi CreateTable1.rb

ActiveRecord::Migration.create_table(:suppliers)
ActiveRecord::Migration.add_column(:suppliers, :name, :string, {:limit => 60})

> ActiveRecord::Migration.drop_table(:suppliers)
> ActiveRecord::Migration.rename_table(:suppliers, :computers)

ActiveRecord::Migration.create_table :books do |table|
	table.string :name
	table.string :title
	table.timestamps
end

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-- http://www.funonrails.com/2012/01/get-models-list-inside-rails-app.html

vi Tables.rb
@models = ActiveRecord::Base.connection.tables.collect{|t| t.underscore.singularize.camelize}
puts @models

#
# http://rubydoc.info/github/rails/rails/master/ActiveRecord/ConnectionAdapters/PostgreSQLColumn
# #coder, #default, #limit, #name, #null, #precision, #primary, #scale, #sql_type, #type
#
ActiveRecord::Base.connection.tables.each do |table_name|
  puts "\n" + table_name
  ActiveRecord::Base.connection.columns(table_name).each do |c| 
		puts "- " + c.name + ": " + c.type.to_s + " " + c.limit.to_s 
		puts "\tdefault: " + c.default.to_s
		puts "\tcoder: " + c.coder.to_s  
		puts "\tnull:" + c.null.to_s 
	end
end

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-- show all tables
ActiveRecord::Base.connection.tables.each do |table|
    puts ActiveRecord::Base.connection.indexes(table).inspect
end


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-- indexes
ActiveRecord::Migration.add_index(:users, :email, :unique => true)
ActiveRecord::Migration.remove_index(:users, :email)

