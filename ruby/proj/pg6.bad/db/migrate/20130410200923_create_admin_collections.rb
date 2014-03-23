class CreateAdminCollections < ActiveRecord::Migration
  def change
    create_table :admin_collections do |t|
      t.string :name

      t.timestamps
    end
  end
end
