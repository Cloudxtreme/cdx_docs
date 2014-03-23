class AdminsController < ApplicationController
  def index
  end

	def getr
		Rails.application.routes.routes.map do |j|
 			puts "#{j.name} - #{j.defaults} #{j.verb}"
		end
	end

	def setr

		logger.info '~~~~~~~> start'
		Rails.application.reload_routes!

		ActionDispatch::Reloader.cleanup!
		ActionDispatch::Reloader.prepare!
		logger.info '~~~~~~~> end'

	end

	def rmr
		
	end
end
