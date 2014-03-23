module ModelHelper    

  module ClassMethods

		def namespace_base
			self.to_s.split('::').first
		end

		def downcase_namespace_base
			self.to_s.split('::').first.downcase
		end

		def capitalized_name
			self.to_s.split('::').last.capitalize
		end

    def downcase_name
      self.to_s.split('::').last.downcase
    end

    def capitalized_plural
      self.to_s.split('::').last.capitalize.pluralize
    end

		def me_as_foreign_key
			"#{self.to_s.split('::').last.downcase}_id"	
		end

		def system_columns
			%w[ created_at updated_at created_by updated_by ]
		end

		def display_columns
			self.column_names - %w[ id created_at created_by modified_by modified_at updated_at ]
		end

		def datatable_columns # aoColumns
			mdata = ''
			self.display_columns.each { |key| mdata += "{ 'mData': '#{key}' }," }
			mdata
		end

		def base_url
			'/' + self.base_class.to_s.downcase.gsub('::', '/').pluralize
		end

		def index_url
			base_url
		end

		def edit_url(id)
			"#{base_url}/#{id}/edit"
		end

		def new_url
			"#{base_url}/new"
		end

		def object_path(value)
			"#{self.base_url}/#{value}"
		end

		def my_associates # including LUT
			associates = []
			self.reflect_on_all_associations.each do |m|
				associates << "#{namespace_base}::#{m.class_name}" if m.macro==:belongs_to
			end
			associates
		end

		def my_children # An array of child obj names
			children = []
      self.reflect_on_all_associations.each do |m|
        children << "#{namespace_base}::#{m.class_name}" if m.macro==:has_many
        children << "#{namespace_base}::#{m.class_name}" if m.macro==:has_one
      end
      children
		end

  	def get_final_value(column_name, value)
    	if column_name =~ /.*_at/
      	# should be changed to user timezone (not system timezone)
      	return value.localtime.strftime("%Y-%m-%d %H:%M:%S")

    	elsif column_name =~ /(.*)_id/
      	self.my_associates.each do |associate|
        	if associate.downcase.include? $1
						associate_obj = associate.constantize
						#logger.info ".......> #{associate}, #{value}: #{associate_obj.find_by_id(value)}"
						if associate_obj.find_by_id(value)
          		return associate_obj.find_by_id(value).name
						else 
 							#return '### Error!!' # @@@@ should raise exception!
 							return '-----' 
						end
        	end
      	end

    	else
      	return value

    	end
  	end

		def my_child_objects
			my_children.collect {|child| child.constantize }
		end

		def is_lut_obj?(associate_obj)
			return nil if associate_obj.nil?
			associate_obj.my_children.include?(self.to_s)==true ? false : true
		end

		def is_parent_obj?(parent_obj) # NOT a lut
			return nil if parent_obj.nil? 
			parent_obj.my_children.include?(self.to_s) 
		end

		def find_associates(column_name)
      if column_name =~ /(.*)_id/
        self.my_associates.each do |parent|
          if parent.downcase.include? $1
            return parent
          end
        end
      end
		end

		def find_associate_obj(column_name)
			find_associates(column_name).nil? ? nil : find_associates(column_name).constantize
		end

		# lut:true, foreign_key:false, others:nil
		def is_lut_column?(column_name)
			associate_obj = find_associate_obj(column_name)
			return self.is_lut_obj?(associate_obj)
		end

		def is_foreign_key?(column_name)
			associate_obj = find_associate_obj(column_name)
			return self.is_parent_obj?(associate_obj)
		end
		
    def foreign_keys 
			all_keys = my_associates.collect {|associate| associate.to_s.split('::').last.downcase + '_id' }
			fkeys = []
			all_keys.each do |key|
				fkeys << key if not is_lut_column?(key)
			end
			fkeys
    end

		def selection_data(column_name) # eigher LUT or parent
			parent_obj = find_associate_obj(column_name)
			return parent_obj.all.collect {|p| [ p.name, p.id ] }.sort
		end

  end

  def self.included(receiver)
    receiver.extend ClassMethods
  end
end
