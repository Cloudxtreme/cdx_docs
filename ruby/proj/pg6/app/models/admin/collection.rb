class Admin::Collection < ActiveRecord::Base
	include ModelHelper

	attr_protected
	validates :name, :presence => true

	belongs_to :namespace
	has_many :fields, :dependent => :destroy

  after_create :after_create
  after_destroy :after_destroy

  def after_create

		@collection_name = self.name
		@namespace = self.namespace.name

		# controller
    fd = File.open('templates/controllers/objects_controller.rb.erb')
    template = fd.read
		fd.close

    renderer = ERB.new(template, nil, '-')
    fd = File.open("app/controllers/#{@namespace.downcase}/#{@collection_name.downcase.pluralize}_controller.rb", 'w')
    fd.puts renderer.result(binding)
    fd.close

		# model
		fd = File.open('templates/models/object.rb.erb')
    template = fd.read
    fd.close

	  renderer = ERB.new(template, nil, '-')
    fd = File.open("app/models/#{@namespace.downcase}/#{@collection_name.downcase}.rb", 'w')
    fd.puts renderer.result(binding)
    fd.close

		# views
		dir = "app/views/#{@namespace.downcase}/#{@collection_name.downcase.pluralize}"
    unless File.directory?(dir)
      FileUtils.mkdir_p(dir)
    end

		%w[ edit _form index new show ].each do |file|
	    fd = File.open("templates/views/#{file}.html.erb")
  	  template = fd.read
   		fd.close

    	renderer = ERB.new(template, nil, '-')
    	fd = File.open("#{dir}/#{file}.html.erb", 'w')
    	fd.puts renderer.result(binding)
    	fd.close
		end

		# db object
		ActiveRecord::Migration.create_table "#{@namespace.downcase}_#{@collection_name.downcase.pluralize}" do |t|
  		t.string :name
  		t.timestamps
		end

		# route
		@namespaces = Admin::Namespace.all

    fd = File.open('templates/config/routes.rb.erb')
    template = fd.read
    fd.close

    renderer = ERB.new(template, nil, '-')
    fd = File.open("config/routes.rb", 'w')
    fd.puts renderer.result(binding)
    fd.close

	end

	def after_destroy
    @collection_name = self.name
    @namespace = self.namespace.name

    return if @namespace == 'Admin' # skip admin 

		# db object
		table_name = "#{@namespace.downcase}_#{@collection_name.downcase.pluralize}"
		if ActiveRecord::Base.connection.table_exists? table_name
	    ActiveRecord::Migration.drop_table table_name
		end

		# files
		controller = "app/controllers/#{@namespace.downcase}/#{@collection_name.downcase.pluralize}_controller.rb"
  	FileUtils.rm_rf(controller) if File.exist?(controller)

		model = "app/models/#{@namespace.downcase}/#{@collection_name.downcase}.rb"
		FileUtils.rm_rf(model) if File.exist?(model)

		views = "app/views/#{@namespace.downcase}/#{@collection_name.downcase.pluralize}"
		FileUtils.rm_rf(views) if File.directory?(views)
	end

end
