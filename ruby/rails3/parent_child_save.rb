
Collection (has_many :field) 
     |
     +-----> Field (belongs_to :collection)

on parent:
  show.html.erb, add:

	<%= link_to 'New Field', new_admin_field_path(:collection_id => @admin_collection.id)%>


on child:

	_form.html.erb
  <%= f.hidden_field :collection_id , :value => params[:collection_id]%>

vi field.rb (should be here already!)
	attr_accessible :collection_id


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
http://cchoudesktop:3000/admin/collections/1
  Click 'New Field'
	Enter 'Address' in the name field
	Click 'Create Field'

pg6=# select * from admin_fields;
 id |     created_at      |         updated_at         |  name   | label | data_type | created_by | modified_by |     modified_at     | collection_id 
----+---------------------+----------------------------+---------+-------+-----------+------------+-------------+---------------------+---------------
  2 | 2013-04-11 00:10:00 | 2013-04-11 00:10:24.983317 | Address |       |           |            |             | 2013-04-11 00:10:00 |             1
(2 rows)


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

ActionDispatch::Reloader.cleanup!
ActionDispatch::Reloader.prepare!

has_many models of Site Model 
	Admin::Collection.reflect_on_all_associations.map{|m| m.class_name if m.macro==:has_many}

belongs_to model
	Admin::Field.reflect_on_all_associations.map{|m| m.class_name if m.macro==:belongs_to}

				Admin::Collection.reflections
				Admin::Collection.reflections.keys
					[:fields]

				Admin::Collection.reflections[:fields]
					@macro=:has_many, 
					@name=:fields, 
					@class_name="Field", 
					@table_name="admin_fields"

					Admin::Collection.reflections[:fields].table_name


--
-- find data from all children
--
obj = Admin::Collection.new
nsbase = obj.class.to_s.split('::').first
children = obj.class.reflect_on_all_associations.map{|m| m.class_name if m.macro==:has_many}
children.each do |child|
	klass = "#{nsbase}::#{child.to_s}"
	puts "===== #{klass} ====="
	records = klass.constantize.all
	records.each do |record|
		puts record.name
	end
end

--
-- find parent 
--
obj = Admin::Field.new
nsbase = obj.class.to_s.split('::').first
parent = obj.class.reflect_on_all_associations.map{|m| m.class_name if m.macro==:belongs_to}.first
klass = "#{nsbase}::#{parent.to_s}"
puts "===== #{klass} ====="
records = klass.constantize.all
records.each do |record|
	puts record.name
end








