class CreateExample1Timecards < ActiveRecord::Migration
  def change
    create_table :example1_timecards do |t|
      t.string :name

      t.timestamps
    end
  end
end
