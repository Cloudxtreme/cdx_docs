module ApplicationHelper

	def find_value(parents, column_name, value)

		if column_name =~ /.*_at/
			# should be changed to user timezone (not system timezone)
			return value.localtime.strftime("%Y-%m-%d %H:%M:%S")

    elsif column_name =~ /(.*)_id/ 
      parents.each do |parent| 
				if parent.downcase.include? $1
#if parent.constantize.find_by_id(value)
					return parent.constantize.find_by_id(value).name 
#else 
# return '-'
#end
				end
			end 
		else

			return value
    end       

	end

	def get_lookup

	end

end
