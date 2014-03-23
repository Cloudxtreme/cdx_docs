client = Databasedotcom::Client.new("config/databasedotcom.yml")
client.authenticate :username => 'hub@cardiodx.com', :password => 'test789'
client.materialize("Account")

$oldt2newt = {
    'Kentucky' => 'NoKY - KY',
    'Arizona' => 'Phoenix East - AZ',
    'Georgia' => 'Atlanta West - GA',
    'Illinois' => 'Chicago - IL',
    'Louisiana' => 'Baton Rouge - LA',
    'North Carolina' => 'Raleigh - NC',
    'Pennsylvania' => 'Harrisburg - PA',
		'Colorado' => 'House',
		'Houston' => 'House',
		'Maryland' => 'House',
		'Minnesota' => 'House',
		'Washington' => 'House',
		'Wisconsin' => 'House'
}

def rename_territory(accounts)
	modified_str = ''
	unchanged_str = ''

	accounts.each do |account|
		if $oldt2newt[account.Territory__c]
			modified_str += "#{account.Id}\t#{account.Territory__c}\t#{account.Name}\n" 
			puts "Rename #{account.Id} - #{account.Territory__c} --> #{$oldt2newt[account.Territory__c]}"
			account.Territory__c = $oldt2newt[account.Territory__c]
			begin
				account.save
			rescue Exception => e
				puts "=====> #{account.Id} #{account.Name}"
				puts e.message
			end
		else
			unchanged_str += "#{account.Id}\t#{account.Territory__c}\t#{account.Name}\n"
		end
	end

	File.open('modified.log', 'a') { |f|  f.puts modified_str }  
	File.open('unchanged.log', 'a') { |f|  f.puts unchanged_str }  

end

File.open('modified.log', 'w') { |f|  f.puts '' }  
File.open('unchanged.log', 'w') { |f|  f.puts ''}  

puts SFDC_Models::Account.count
accounts = SFDC_Models::Account.all
#accounts = SFDC_Models::Account.query("ID != NULL limit 50")

while accounts.next_page? 
	puts accounts.size
	rename_territory(accounts)
	accounts = accounts.next_page
end

puts accounts.size
rename_territory(accounts)
