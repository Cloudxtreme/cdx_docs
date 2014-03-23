

NOTE: scaffold.css will be generated when you run 'rails generate scaffold User name:string email:string'

pg6/app/assets/stylesheets$ cp ../../../../pg3/app/assets/stylesheets/scaffold.css .


vi session_controller.rb

    if user.nil?
      flash.now[:error] = "Invalid email/password combination."
      @title = "Sign In"
      render 'new'
    else
      # new page
      render 'new'
    end

vi application.html.erb

			:
			:
        <% if flash[:error] %>
          <div id="error_explanation">
          <h3>Error</h3>
          <ul>
            <% flash.each do |key,value| %>
              <li><%=key %>: <%=value%>
            <% end %>
            </ul>
          </div>
        <% end %>

        <%= yield %>
			:
			:


