client = Databasedotcom::Client.new("config/databasedotcom.yml")
client.authenticate :username => 'hub@cardiodx.com', :password => 'test789'

client.materialize("User")
client.materialize("UserRole")
client.materialize("Account")


vp_role = SFDC_Models::UserRole.query("Name = 'VP Sales'").first
rm_roles = SFDC_Models::UserRole.query("ParentRoleId = '#{vp_role.Id}'")

$terr2uid = {}
rm_roles.each do |rm_role|
  rm = SFDC_Models::User.query("UserRoleId = '#{rm_role.Id}'").first
  tm_roles = SFDC_Models::UserRole.query("ParentRoleId = '#{rm_role.Id}'")
  tm_roles.each do |tm_role|
    user = SFDC_Models::User.query("UserRoleId = '#{tm_role.Id}'").first
    tm_role.Name =~ /TM - (.*), (.*)/
    territory = "#{$1} - #{$2}"
    #puts "\t\t'#{territory}' => '#{user.Id}',"
		$terr2uid[territory] = user.Id
  end
end

$terr2uid.each do |territory,uid|
	accounts = SFDC_Models::Account.query("OwnerId = '#{uid}'")
	puts "#{uid}: #{accounts.size}"
	accounts.each do |account|
		#if account.Territory__c != territory and account.Territory__c != 'House' and $terr2uid[account.Territory__c]
		if account.Territory__c != territory and $terr2uid[account.Territory__c]
			puts "#{account.Id} (#{account.Territory__c})  #{account.OwnerId} ---> #{$terr2uid[account.Territory__c]}}"  
			begin
				#account.OwnerId = $terr2uid[account.Territory__c]
				#account.save
    	rescue Exception => e
     		puts e.message
    	end
		end
	end
end


