
autocomplete	 AutoComplete		 text	 kendoAutoComplete	 string	
dropdownlist	 DropDownList		 text	 kendoDropDownList	 string		



html_options:
$ rails console production
ActiveRecord::Migration.add_column(:admin_fields, :html_options, :string)

http://cchoudesktop:3000/admin/fields/
http://cchoudesktop:3000/admin/fields/new
	html_options
	HTML Options
	DType: text
	Place holder: Separate with commons



html default:
ActiveRecord::Migration.add_column(:admin_fields, :html_default, :string)

