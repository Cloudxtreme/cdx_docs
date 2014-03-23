class CreateServiceTimecards < ActiveRecord::Migration
  def change
    create_table :service_timecards do |t|
      t.string :name

      t.timestamps
    end
  end
end
