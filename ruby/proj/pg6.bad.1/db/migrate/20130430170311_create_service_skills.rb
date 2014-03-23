class CreateServiceSkills < ActiveRecord::Migration
  def change
    create_table :service_skills do |t|
      t.string :name

      t.timestamps
    end
  end
end
