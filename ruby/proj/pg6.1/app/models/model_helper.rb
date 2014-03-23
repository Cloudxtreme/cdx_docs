module ModelHelper    

  module ClassMethods
		def my_parents # An array of parent obj names
			ns_base = self.to_s.split('::').first
			self.reflect_on_all_associations.map{|m| "#{ns_base}::#{m.class_name}" if m.macro==:belongs_to}
		end

		def my_children # An array of child obj names
			ns_base = self.to_s.split('::').first
			self.reflect_on_all_associations.map{|m| "#{ns_base}::#{m.class_name}" if m.macro==:has_many}
		end

		def has_2way_association?(parent) # NOT a lut
			return nil if parent.nil?

			klass = parent.constantize
			klass.my_children.include?(self.to_s) 
		end

		# lut:true, 2way:false, others:nil ---> Admin::Field.is_lut?('Admin::Collection')
		def is_lut?(parent)
			return nil if parent.nil?

			klass = parent.constantize
			if klass.my_children.include?(self.to_s) == true 
				return false
			elsif self.my_parents.include?(parent) == true # @@@@ ???
				return true
			else
				return nil
			end
		end

		def find_parent(parents, column_name)
      if column_name =~ /(.*)_id/
        parents.each do |parent|
          if parent.downcase.include? $1
            return parent
          end
        end
      end
		end

		# lut:true, 2way:false, others:nil
		def is_this_col_lut?(parents, column_name)
			parent = find_parent(parents, column_name)
			return self.is_lut?(parent)
		end

		def is_this_col_2way?(parents, column_name)
			parent = find_parent(parents, column_name)
			return self.has_2way_association?(parent)
		end
		
		def get_lut_data(parents, column_name)
			parent = find_parent(parents, column_name)
			klass = parent.constantize
			return klass.all.collect {|p| [ p.name, p.id ] }
		end

		def get_parent_name(parents, column_name, value)
			parent = find_parent(parents, column_name)
			klass = parent.constantize
			klass.find_name_by_id(value)
		end

		def display_columns
			self.column_names - %w[ id created_at created_by modified_by modified_at updated_at ]
		end

		def datatable_columns # aoColumns
			mdata = ''
			self.display_columns.each { |key| mdata += "{ 'mData': '#{key}' }," }
			mdata
		end

		def url
			'/' + self.base_class.to_s.downcase.gsub('::', '/').pluralize
		end
  end

  def self.included(receiver)
    receiver.extend ClassMethods
  end
end
