client = Databasedotcom::Client.new("config/databasedotcom.yml")
client.authenticate :username => 'hub@cardiodx.com', :password => 'test789'

client.materialize("User")
client.materialize("CustomerInventory__c")

file = File.new('inventory_input.txt', "r")
file.each do |line|
	line =~ /(.*) (.*)/
	inventory = SFDC_Models::CustomerInventory__c.query("Id = '#{$1}'").first
	if inventory.Status__c == 'Expired - Need to Discard'
		puts "#{$1}: #{inventory.Status__c} --> #{$2}"
		begin
			inventory.Status__c = $2
			inventory.save
		rescue Exception => e
   	 puts e.message
  	end
	end
end


