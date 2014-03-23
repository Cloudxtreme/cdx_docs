class SessionsController < ApplicationController
  def new
		@title = 'Sign in'
  end

	def create
		user = User.authenticate(params[:session][:email], params[:session][:password])
		if user.nil?
			flash.now[:error] = "Invalid email/password combination."
			@title = "Sign In"
			render 'new'
		else
			# new page
			#render 'new'
			redirect_to :controller => 'hello', :action => 'world'
		end
	end

	def destroy
	end
end
