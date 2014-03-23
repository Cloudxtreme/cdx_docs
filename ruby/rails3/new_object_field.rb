
ActiveRecord::Migration.add_column(:admin_dtypes, :label, :string)
ActiveRecord::Migration.add_column(:admin_dtypes, :status, :boolean)
ActiveRecord::Migration.add_column(:admin_dtypes, :status, :boolean)

ActiveRecord::Migration.add_column(:admin_dtypes, :htype_id, :integer)
ActiveRecord::Migration.add_column(:admin_dtypes, :widget_id, :integer)
ActiveRecord::Migration.add_column(:admin_dtypes, :default_pattern, :integer)
ActiveRecord::Migration.add_column(:admin_dtypes, :default_class, :integer)

ActiveRecord::Migration.add_column(:admin_widgets, :label, :string)
ActiveRecord::Migration.add_column(:admin_htypes, :label, :string)

ActiveRecord::Migration.add_column(:admin_fields, :html_class, :string)
ActiveRecord::Migration.add_column(:admin_fields, :html_placeholder, :string)
ActiveRecord::Migration.add_column(:admin_fields, :html_required, :boolean)
ActiveRecord::Migration.add_column(:admin_fields, :html_validation_msg, :string)
ActiveRecord::Migration.add_column(:admin_fields, :html_min, :string)
ActiveRecord::Migration.add_column(:admin_fields, :html_max, :string)
ActiveRecord::Migration.add_column(:admin_fields, :html_step, :string)
ActiveRecord::Migration.add_column(:admin_fields, :html_width, :integer)
ActiveRecord::Migration.add_column(:admin_fields, :html_height, :integer)
ActiveRecord::Migration.add_column(:admin_fields, :html_pattern, :string)
#ActiveRecord::Migration.add_column(:admin_fields, :html_data_xxx_msg, :integer)
ActiveRecord::Migration.add_column(:admin_fields, :display_order, :integer)


ActiveRecord::Migration.add_column(:admin_collections, :html_table_width, :integer)


vi models/admin/field.rb

  attr_accessible :created_at, :created_by, :dtype_id, :label, :modified_at, :modified_by, :name, :collection_id, 

	attr_protected




