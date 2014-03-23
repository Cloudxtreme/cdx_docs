client = Databasedotcom::Client.new("config/databasedotcom.yml")
client.authenticate :username => 'hub@cardiodx.com', :password => 'test789'

client.materialize("User")
client.materialize("UserRole")

vp_role = SFDC_Models::UserRole.query("Name = 'VP Sales'").first
rm_roles = SFDC_Models::UserRole.query("ParentRoleId = '#{vp_role.Id}'")

rm_roles.each do |rm_role|
  puts "#{rm_role.Name}:"
  rm = SFDC_Models::User.query("UserRoleId = '#{rm_role.Id}'").first
  puts "  #{rm.Name}" if rm
  tm_roles = SFDC_Models::UserRole.query("ParentRoleId = '#{rm_role.Id}'")
  tm_roles.each do |tm_role|
    user = SFDC_Models::User.query("UserRoleId = '#{tm_role.Id}'").first
    tm_role.Name =~ /TM - (.*), (.*)/
    territory = "#{$1} - #{$2}"
		puts "\t\t'#{territory}' => '#{user.Username}',"
	#puts user.attributes
  end
end


