class AdminsController < ApplicationController
  def index
  end

	def getr
		Rails.application.routes.routes.map do |j|
 			puts "#{j.name} - #{j.defaults} #{j.verb}"
		end
	end

	def setr
		Rails.application.reload_routes!
	end

	def rmr
		
	end
end
