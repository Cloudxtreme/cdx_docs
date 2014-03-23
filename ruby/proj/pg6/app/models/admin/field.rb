class Admin::Field < ActiveRecord::Base
	include ModelHelper
	attr_protected
  validates :name, :presence => true

	belongs_to :collection
	belongs_to :dtype
	has_many :security, :dependent => :destroy
	has_many :validate, :dependent => :destroy

  after_create :after_create
  after_destroy :after_destroy

	def html_input_string(namespace, collection, value)

		if self.dtype.name == 'multiselect'

			html_str = "<select multiple='multiple' " +
								"data-placeholder='Please select...' " +
								"id='#{namespace}_#{collection}_#{self.name}' " +
								"name='#{namespace}_#{collection}[#{self.name}][]'>\n"

			soptions2soptions = {} 
			if value 
				# saved as array-->yaml format
				saved_options = value.split("\n")
				saved_options.each { |a| soptions2soptions[$1] = $1 if a =~ /- (.*)/ }
			end

      options = self.html_options.gsub(/ /,'').split(',')
			defaults = self.html_default.gsub(/ /,'').split(',')
     	# html_str += "<option value=''>Please select...</option>\n" 

      options.each do |option|
				if defaults.include?(option) and not value
          html_str += "<option value='#{option}' selected>#{option}</option>\n"
        elsif soptions2soptions[option]
          html_str += "<option value='#{option}' selected>#{option}</option>\n"
        else
          html_str += "<option value='#{option}'>#{option}</option>\n"
        end
      end

			html_str += "</select>\n"

		elsif self.dtype.htype.name == 'select'

			html_str = "<select " + 
									"id='#{namespace}_#{collection}_#{self.name}' " + 
									"name='#{namespace}_#{collection}[#{self.name}]'>\n"

			options = self.html_options.gsub(/ /,'').split(',')
			html_str += "<option value=''>Please select...</option>\n" 

			options.each do |option|
				if option == self.html_default and not value
					html_str += "<option value='#{option}' selected>#{option}</option>\n"
				elsif option == value 
					html_str += "<option value='#{option}' selected>#{option}</option>\n"
				else
					html_str += "<option value='#{option}'>#{option}</option>\n"
				end
			end
			html_str += "</select>\n"

		else

			html_str = "<input type='#{self.dtype.name}' " + 
									"id='#{namespace}_#{collection}_#{self.name}' " + 
									"name='#{namespace}_#{collection}[#{self.name}]' "

			html_str += "required " if self.html_required # @@@ ????
			if value
				html_str += "value='#{value}' "  
			elsif self.html_default
				html_str += "value='#{self.html_default}' "
			end
			html_str += "validationMessage='#{self.html_validation_msg}' " if not self.html_validation_msg.empty?
			html_str += "placeholder='#{self.html_placeholder}' " if not self.html_placeholder.empty?
			html_str += "pattern='#{self.html_pattern}' " if not self.html_pattern.empty?
			html_str += "min='#{self.html_min}' " if not self.html_min.empty?
			html_str += "max='#{self.html_max}' " if not self.html_max.empty?
			html_str += "step='#{self.html_step}' " if not self.html_step.empty?
			if self.html_class != ''
    		html_str += "class='#{self.html_class}' " 
			else
				if self.dtype.default_class != ''
					html_str += "class='#{self.dtype.default_class}' "
				end
			end
			html_str += " /> <br />\n"
		end

		html_str
	end

	def widget_string(namespace, collection)
		if dtype.widget
			widget_str = %(var #{namespace}_#{collection}_#{self.name} = $('\##{namespace}_#{collection}_#{self.name}').#{self.dtype.widget.name}({#{self.dtype.widget_option}})).gsub(/^ /,'').gsub(/\n/,'') 
			widget_str += ".data('kendoMultiSelect')" if self.dtype.name == 'multiselect' 
			widget_str += ";\n"
		end
		widget_str
	end

	def rails_type
		self.dtype.rtype.name
	end

	def create_model(namespace, collection_name)
    fd = File.open('templates/models/object.rb.erb')
    template = fd.read
    fd.close

    renderer = ERB.new(template, nil, '-')
    fd = File.open("app/models/#{namespace.downcase}/#{collection_name.downcase}.rb", 'w')
    fd.puts renderer.result(binding)
    fd.close
	end

	def after_create
    @namespace = self.collection.namespace.name
    @collection_name = self.collection.name

		return if @namespace == 'Admin'

		# DB
		db_obj = "#{@namespace.downcase}_#{@collection_name.downcase.pluralize}"
#		column_name = self.name.downcase
		column_name = self.name
		rtype = self.dtype.rtype.name
		ActiveRecord::Migration.add_column(db_obj, column_name, rtype)

		dtype = self.dtype.name
		if [ 'lookup', 'masterdetail' ].include?(dtype)
			collection = Admin::Collection.find_by_name(@collection_name)

			self.name =~ /(.*)_id/
			associate_name = $1.capitalize
			associate = Admin::Collection.find_by_name(associate_name)
			#collection.associate_cid = associate.id
			#collection.associate_type = dtype
			#collection.save!
		end

		# belongs_to?
    @associated_objects = []
		fields =  Admin::Field.find_all_by_collection_id(self.collection.id)
    fields.each do |field|
      if field.name.downcase =~ /(.*)_id/
      	@associated_objects << $1
			end
    end

		create_model(@namespace, @collection_name) 
	end

	def after_destroy
    @namespace = self.collection.namespace.name
    @collection_name = self.collection.name

    return if @namespace == 'Admin'

    # DB
    db_obj = "#{@namespace.downcase}_#{@collection_name.downcase.pluralize}"
    #column_name = self.name.downcase
    column_name = self.name
		rtype = self.dtype.rtype.name
	  ActiveRecord::Migration.remove_column(db_obj, column_name)

    dtype = self.dtype.name
		if ['lookup', 'masterdetail'].include?(dtype)
      collection = Admin::Collection.find_by_name(@collection_name)
      #collection.associate_cid = nil
      #collection.associate_type = nil
      #collection.save!
    end


    @associated_objects = []
    fields =  Admin::Field.find_all_by_collection_id(self.collection.id)
    fields.each do |field|
      if field.name.downcase =~ /(.*)_id/
        @associated_objects << $1
      end
    end

		create_model(@namespace, @collection_name)
	end

end
