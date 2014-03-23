client = Databasedotcom::Client.new("config/databasedotcom.yml")
client.authenticate :username => 'hub@cardiodx.com', :password => 'test789'

client.materialize("User")
client.materialize("UserRole")
client.materialize("Account")

vp_role = SFDC_Models::UserRole.query("Name = 'VP Sales'").first
rm_roles = SFDC_Models::UserRole.query("ParentRoleId = '#{vp_role.Id}'")

$zip2old2new = {}
count = 0
file = File.new("Q4-12_Alignments.csv", "r")
while (line = file.gets)
	line =~ /(.*),(.*),(.*),(.*),(.*),(.*)/
	if $6 == 'Yes' and $4 != $5
		#puts "#{$1}: #{$4} #{$5}"
		old2new = [ $4, $5 ]
		$zip2old2new[$1] = old2new 
		count += 1
	end
end
puts "Total: #{count}"


def acct_alignment(accounts)
	accounts.each do |account|
		if $zip2old2new[account.BillingPostalCode] 
			if $zip2old2new[account.BillingPostalCode][0] == account.Territory__c
				puts "#{account.Id}: #{account.BillingPostalCode}, #{$zip2old2new[account.BillingPostalCode].to_s}"
				account.Territory__c = $zip2old2new[account.BillingPostalCode][1]
				begin
					account.save
				rescue Exception => e
          puts e.message
        end
			elsif $zip2old2new[account.BillingPostalCode][1] == account.Territory__c
				#puts "#{account.Id}: #{account.BillingPostalCode} ^^^^ Correct territory!"
			else
				puts "#{account.Id}: #{account.BillingPostalCode} ===> Territory not found in file!"
			end
		end
	end
end


puts SFDC_Models::Account.count

accounts = SFDC_Models::Account.all
#accounts = SFDC_Models::Account.query("ID != NULL limit 50")

while accounts.next_page?
  puts accounts.size
	acct_alignment(accounts)
  accounts = accounts.next_page
end

puts accounts.size
acct_alignment(accounts)


