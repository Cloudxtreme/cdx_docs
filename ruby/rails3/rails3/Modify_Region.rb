client = Databasedotcom::Client.new("config/databasedotcom.yml")
client.authenticate :username => 'hub@cardiodx.com', :password => 'test789'

client.materialize("User")
client.materialize("UserRole")
client.materialize("Account")

vp_role = SFDC_Models::UserRole.query("Name = 'VP Sales'").first
rm_roles = SFDC_Models::UserRole.query("ParentRoleId = '#{vp_role.Id}'")

$territory2region = {}
rm_roles.each do |rm_role|
  rm_role.Name =~ /RM - (.*)/
	region = $1
  rm = SFDC_Models::User.query("UserRoleId = '#{rm_role.Id}'").first
  puts "  #{rm.Name}" if rm
  tm_roles = SFDC_Models::UserRole.query("ParentRoleId = '#{rm_role.Id}'")
  tm_roles.each do |tm_role|
    user = SFDC_Models::User.query("UserRoleId = '#{tm_role.Id}'").first
    tm_role.Name =~ /TM - (.*), (.*)/
    territory = "#{$1} - #{$2}"
		puts "\t'#{territory}' => '#{region}',"
		$territory2region[territory] = region
  end
end


def modify_region(accounts)
	accounts.each do |account|
		if $territory2region[account.Territory__c]
			if $territory2region[account.Territory__c] == account.Region__c
				puts "#{account.Id} ==> has correct region"
			else
				begin
					puts "#{account.Id}: #{account.Territory__c}"
					account.Region__c = $territory2region[account.Territory__c]
					account.save
				rescue Exception => e
					puts e.message
				end
			end
		elsif account.Territory__c == 'House'
			puts "#{account.Id} ==> House"
		elsif account.Region__c == nil
      puts "#{account.Id} ==> empty region"
		else
			puts "#{account.Id} ==> skip (#{account.Territory__c})"
		end
	end
end

################################################################################
puts SFDC_Models::Account.count

accounts = SFDC_Models::Account.all
#accounts = SFDC_Models::Account.query("ID != NULL limit 50")

while accounts.next_page?
  puts accounts.size
	modify_region(accounts)
  accounts = accounts.next_page
end

puts accounts.size
modify_region(accounts)


