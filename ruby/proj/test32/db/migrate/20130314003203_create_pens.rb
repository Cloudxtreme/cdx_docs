class CreatePens < ActiveRecord::Migration
  def change
    create_table :pens do |t|
      t.string :name

      t.timestamps
    end
  end
end
