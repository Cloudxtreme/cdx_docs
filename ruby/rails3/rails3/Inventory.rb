client = Databasedotcom::Client.new("config/databasedotcom.yml")
client.authenticate :username => 'hub@cardiodx.com', :password => 'test789'

client.materialize("User")
client.materialize("CustomerInventory__c")
client.materialize("CustomerInventory__History")

puts SFDC_Models::CustomerInventory__c.count
#puts SFDC_Models::CustomerInventory__History.count

$id2login = {}
users = SFDC_Models::User.all
users.each do |user|
	$id2login[user.Id] = user.Name
end

def mytest(inventories)
	inventories.each do |inventory|
		ci_histories = SFDC_Models::CustomerInventory__History.query("ParentId = '#{inventory.Id}'")
		#ci_histories = SFDC_Models::CustomerInventory__History.query("ParentId = 'a0I40000000D1VaEAK'")
		ci_histories.each do |history|
			if history.NewValue =~ /Expired - Need to Discard/
				puts "#{inventory.Id} -  #{history.CreatedDate} (#{$id2login[history.CreatedById]}): #{history.OldValue} --> #{history.NewValue}\n"
			end
		end
	end
end


#inventories = SFDC_Models::CustomerInventory__c.query("ID != NULL limit 50")
inventories = SFDC_Models::CustomerInventory__c.all

while inventories.next_page?
  puts inventories.size
  mytest(inventories)
  inventories = inventories.next_page
end

puts inventories.size
mytest(inventories)

