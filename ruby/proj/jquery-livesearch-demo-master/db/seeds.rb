# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rake db:seed (or created alongside the db with db:setup).
#
# Examples:
#
#   cities = City.create([{ name: 'Chicago' }, { name: 'Copenhagen' }])
#   Mayor.create(name: 'Emanuel', city: cities.first)

products = [
  { :name => "Headphones",        :price => rand(49) + 0.9, :description => "Praesent commodo cursus magna, vel scelerisque nisl consectetur et" },
  { :name => "DVD game",          :price => rand(49) + 0.9, :description => "Integer posuere erat a ante venenatis dapibus posuere velit aliquet" },
  { :name => "17\" screen",       :price => rand(49) + 0.9, :description => "Nullam quis risus eget urna mollis ornare vel eu leo" },
  { :name => "External HDD",      :price => rand(49) + 0.9, :description => "Etiam porta sem malesuada magna mollis euismod" },
  { :name => "eBook",             :price => rand(49) + 0.9, :description => "Maecenas sed diam eget risus varius blandit sit amet non magna" },
  { :name => "USB Memory stick",  :price => rand(49) + 0.9, :description => "Cras justo odio, dapibus ac facilisis in, egestas eget quam" },
  { :name => "Digital camera",    :price => rand(49) + 0.9, :description => "Aenean lacinia bibendum nulla sed consectetur" },
  { :name => "Keyboard",          :price => rand(49) + 0.9, :description => "Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus" },
  { :name => "Wireless mouse",    :price => rand(49) + 0.9, :description => "Donec id elit non mi porta gravida at eget metus" },
  { :name => "USB hub",           :price => rand(49) + 0.9, :description => "Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus" }
]

products.each { |product| Product.create(product) unless Product.exists?(:name => product[:name]) }