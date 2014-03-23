class CreateApples < ActiveRecord::Migration
  def change
    create_table :apples do |t|
      t.string :dstr
      t.text :dtxt
      t.integer :dint
      t.float :dflt
      t.decimal :ddec
      t.datetime :ddt
      t.time :dtime
      t.date :ddate
      t.binary :dbin
      t.boolean :bbl

      t.timestamps
    end
  end
end
