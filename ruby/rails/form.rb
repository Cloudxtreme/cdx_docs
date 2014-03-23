

  # <%=select_tag "people", options_from_collection_for_select(Admin::Type.all, "id", "name") %>
	# <%=  f.select(:data_type, options_for_select(Admin::Type.all.collect {|p| [ p.name, p.id ] })) %>                                               

Field
  |
  +-----> Type

For admin/fields/_form.html.erb:

	Replace 
    <%= f.text_field :data_type %>
	With
	  <%= f.select(:data_type, Admin::Type.all.collect {|p| [ p.name, p.id ] }, { :include_blank => true }) %>

	  <%= f.select(:data_type, Admin::Type.all.collect {|p| [ p.name, p.id ] }) %>


For admin/fields/index.html.erb
	Replace
		<%= admin_field.data_type %>
	With
		<%= Admin::Type.find(admin_field.data_type).name %>



