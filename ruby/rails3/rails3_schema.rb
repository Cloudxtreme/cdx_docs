
@models = ActiveRecord::Base.connection.tables.collect{|t| t.underscore.singularize.camelize}
@models.each do |model|
  begin
    klass = Object.const_get(model)
    puts klass.new.class
    #puts klass.column_names
    klass.columns.each do |c|
      puts "\t#{c.name}, #{c.type}, #{c.default}, #{c.sql_type}"
    end
  rescue NameError => e
    #
  end
end


