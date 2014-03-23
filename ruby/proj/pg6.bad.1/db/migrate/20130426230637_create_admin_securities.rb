class CreateAdminSecurities < ActiveRecord::Migration
  def change
    create_table :admin_securities do |t|
      t.string :name

      t.timestamps
    end
  end
end
