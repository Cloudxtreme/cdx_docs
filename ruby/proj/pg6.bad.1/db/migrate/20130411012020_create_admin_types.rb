class CreateAdminTypes < ActiveRecord::Migration
  def change
    create_table :admin_types do |t|
      t.string :name
      t.integer :created_by
      t.integer :modified_by
      t.datetime :created_at
      t.datetime :modified_at

      t.timestamps
    end
  end
end
