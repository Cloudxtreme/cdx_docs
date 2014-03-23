http://api.rubyonrails.org/classes/ActiveRecord/Migration.html
http://api.rubyonrails.org/classes/ActiveRecord/ConnectionAdapters/TableDefinition.html
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

ActiveRecord::Base.connection.tables.each do |table_name|
  puts "\n" + table_name
  ActiveRecord::Base.connection.columns(table_name).each do |c|
    puts "- " + c.name + ": " + c.type.to_s + " " + c.limit.to_s
    puts "\tdefault: " + c.default.to_s
    puts "\tcoder: " + c.coder.to_s
    puts "\tnull:" + c.null.to_s
  end
end

-- 
-- add_column(table_name, column_name, type, options): 
--   Adds a new column to the table called table_name named column_name specified to be one of the following types: 
--     :string, :text, :integer, :float, :decimal, :datetime, :timestamp, :time, :date, :binary, :boolean. 

ActiveRecord::Migration.add_column(:suppliers, :name, :string, {:limit => 60})
ActiveRecord::Migration.add_column(:suppliers, :granted, :boolean)
ActiveRecord::Migration.add_column(:suppliers, :sales_stage, :string, :limit => 20, :default => 'new', :null => false)

ActiveRecord::Migration.change_column(:suppliers, :granted, :boolean)
ActiveRecord::Migration.change_column(:suppliers, :sales_stage, :string, :limit => 20, :default => 'new', :null => false)

ActiveRecord::Migration.rename_column(:admin_fields, :data_type, :type_id)

--
-- see ActiveRecord::ConnectionAdapters::TableDefinition#column for details.
--
create_table "products", :force => true do |t|
  t.column "shop_id",    :integer
  t.column "creator_id", :integer
  t.column "name",       :string,   :default => "Untitled"
  t.column "value",      :string,   :default => "Untitled"
  t.column "created_at", :datetime
  t.column "updated_at", :datetime
end

# Assuming +td+ is an instance of TableDefinition
td.column(:granted, :boolean)
# granted BOOLEAN

td.column(:picture, :binary, :limit => 2.megabytes)
# => picture BLOB(2097152)

td.column(:sales_stage, :string, :limit => 20, :default => 'new', :null => false)
# => sales_stage VARCHAR(20) DEFAULT 'new' NOT NULL

td.column(:bill_gates_money, :decimal, :precision => 15, :scale => 2)
# => bill_gates_money DECIMAL(15,2)

td.column(:sensor_reading, :decimal, :precision => 30, :scale => 20)
# => sensor_reading DECIMAL(30,20)

# While <tt>:scale</tt> defaults to zero on most databases, it
# probably wouldn't hurt to include it.
td.column(:huge_integer, :decimal, :precision => 30)
# => huge_integer DECIMAL(30)

# Defines a column with a database-specific type.
td.column(:foo, 'polygon')
# => foo polygon


-- remove a column
ActiveRecord::Migration.remove_column(:users, :password)




