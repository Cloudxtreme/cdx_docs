puts User.column_names

User.columns.each do |c|
  puts "#{c.name}, #{c.type}, #{c.default}, #{c.sql_type}"
end


foo = Object.const_get('User')
puts foo.new.class

