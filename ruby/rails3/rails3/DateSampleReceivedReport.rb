#
# rvm gemset use rails32
# bundle exec rails runner "eval(File.read 'test.rb')"
# bundle exec rails runner DateSampleReceivedReport.rb
#
client = Databasedotcom::Client.new("config/databasedotcom.yml")
client.authenticate :username => 'hub@cardiodx.com', :password => 'test789'

client.materialize("User")
client.materialize("UserRole")
client.materialize("Account")
client.materialize("Contact")
client.materialize("CADTest__c")

# for backward compatibility
oldt2newt = {
		'Kentucky' => 'NoKY - KY', 
		'Arizona' => 'Phoenix East - AZ',
		'Georgia' => 'Atlanta West - GA',
		'Illinois' => 'Chicago - IL',
		'Louisiana' => 'Baton Rouge - LA',
		'North Carolina' => 'Raleigh - NC',
		'Pennsylvania' => 'Harrisburg - PA'
}
				
date2territory2trfs = {}
#cad_tests = SFDC_Models::CADTest__c.query("Date_Sample_Received__c >= LAST_WEEK" )
cad_tests = SFDC_Models::CADTest__c.query("Date_Sample_Received__c >= TODAY" )
cad_tests.each do |cad_test|
	dst = cad_test.Date_Sample_Received__c
	trf = cad_test.Name
	account = SFDC_Models::Account.query("ID = '#{cad_test.Clinic__c}'").first
	territory = oldt2newt[account.Territory__c] ? oldt2newt[account.Territory__c] : account.Territory__c
	puts "#{dst}, #{territory}\t#{trf}"
	date2territory2trfs[dst] = Hash.new if date2territory2trfs[dst].nil?
	date2territory2trfs[dst][territory] = Array.new if date2territory2trfs[dst][territory].nil?
	date2territory2trfs[dst][territory].push(trf)
end

vp_role = SFDC_Models::UserRole.query("Name = 'VP Sales'").first
rm_roles = SFDC_Models::UserRole.query("ParentRoleId = '#{vp_role.Id}'")

total = 0
rm_roles.each do |rm_role|
	rm_total = 0
	puts "#{rm_role.Name}:" 
	rm = SFDC_Models::User.query("UserRoleId = '#{rm_role.Id}'").first
	puts "  #{rm.Name}" if rm
	tm_roles = SFDC_Models::UserRole.query("ParentRoleId = '#{rm_role.Id}'")
	tm_roles.each do |tm_role|
		tm_total = 0
		user = SFDC_Models::User.query("UserRoleId = '#{tm_role.Id}'").first
		tm_role.Name =~ /TM - (.*), (.*)/
		territory = "#{$1} - #{$2}"
		puts "    #{territory}: (#{user.Name})"
		date2territory2trfs.sort.each do |dst,territory2trfs|
			if territory2trfs[territory]
				puts "      #{dst}: #{territory2trfs[territory].size}" 
				tm_total += territory2trfs[territory].size
				rm_total += territory2trfs[territory].size
				total += territory2trfs[territory].size
			end
		end
		puts "    TM Total: #{tm_total}"
	end
	puts "  RM Total: #{rm_total}"
	puts ""
end

puts "CDx Total: #{total}"

exit


