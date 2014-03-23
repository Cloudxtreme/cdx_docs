class CreateAdminFields < ActiveRecord::Migration
  def change
    create_table :admin_fields do |t|
      t.string :name
      t.string :label
      t.string :data_type
      t.integer :created_by
      t.integer :modified_by
      t.datetime :created_at
      t.datetime :modified_at

      t.timestamps
    end
  end
end
