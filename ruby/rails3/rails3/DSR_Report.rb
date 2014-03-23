# 
# bundle exec rails runner DSR_Report.rb
#

unless ARGV.size == 1
	puts 'Usage: bundle exec rails runner DSR_Report.rb today|yesterday|this_week|last_week'
  exit
end

qtype = ARGV[0]

client = Databasedotcom::Client.new("config/databasedotcom.yml")
client.authenticate :username => 'hub@cardiodx.com', :password => 'test789'

client.materialize("User")
client.materialize("UserRole")
client.materialize("Account")
client.materialize("Contact")
client.materialize("CADTest__c")

def sendMail(email, subject, body)
	body = "=== #{subject} ===\n" + 
				body
	body += "---\n"
	body += "Script ran at: #{DateTime.now}\n"
	body += "Weekly Report: https://na2.salesforce.com/00O40000003GOp5\n"
	body += "Daily Report: https://na2.salesforce.com/00O40000003GOpo\n" 

	Pony.mail(
  	:from => 'Chialin Chou <cchou@cardiodx.com>', 
  	:to => email,
		:cc => 'cchou@cardiodx.com',
  	:via => :smtp,
  	:via_options => { :address => 'smtp.cardiodx.com', :port => '25' },
  	:subject => subject,
  	:body => body
	)
end

date_str = Date.today
case qtype
	when 'today'
		date_str = Date.today
	when 'yesterday'
		date_str = Date.today - 1
	else
		date_str = Date.today
end	

date2territory2trfs = {}
if ['today', 'yesterday', 'this_week', 'last_week'].include?(qtype)
	#cad_tests = SFDC_Models::CADTest__c.query("Date_Sample_Received__c >= LAST_WEEK" )
	cad_tests = SFDC_Models::CADTest__c.query("Date_Sample_Received__c = #{qtype}" )
else
	puts "Wrong query type: #{qtype}"
	exit
end 


cad_tests.each do |cad_test|
	dst = cad_test.Date_Sample_Received__c
	trf = cad_test.Name
	account = SFDC_Models::Account.query("ID = '#{cad_test.Clinic__c}'").first
	territory = account.Territory__c
	puts "#{dst}, #{territory}\t#{trf}"
	date2territory2trfs[dst] = Hash.new if date2territory2trfs[dst].nil?
	date2territory2trfs[dst][territory] = Array.new if date2territory2trfs[dst][territory].nil?
	date2territory2trfs[dst][territory].push(trf)
end

vp_role = SFDC_Models::UserRole.query("Name = 'SVP Sales'").first
vps = SFDC_Models::User.query("UserRoleId = '#{vp_role.Id}'")
rm_roles = SFDC_Models::UserRole.query("Name like 'RM%' and ParentRoleId = '#{vp_role.Id}'")

vp_total = 0
vpstr = ''
rm_roles.each do |rm_role|
	rm_total = 0
	rmstr = "\n"
	rmstr += "#{rm_role.Name}:\n" 
	rm = SFDC_Models::User.query("UserRoleId = '#{rm_role.Id}'").first
	rmstr += "  #{rm.Name}\n" if rm
	tm_roles = SFDC_Models::UserRole.query("ParentRoleId = '#{rm_role.Id}'")
	tm_roles.each do |tm_role|
		tm_total = 0
		tm = SFDC_Models::User.query("UserRoleId = '#{tm_role.Id}'").first
		tm_role.Name =~ /TM - (.*), (.*)/
		territory = "#{$1} - #{$2}"
		rmstr += "    #{territory}: \n" if ['this_week', 'last_week'].include?(qtype)
		date2territory2trfs.sort.each do |dst,territory2trfs|
			if territory2trfs[territory]
				rmstr += "      #{dst}: #{territory2trfs[territory].size}\n" if ['this_week', 'last_week'].include?(qtype)
				tm_total += territory2trfs[territory].size
				rm_total += territory2trfs[territory].size
				vp_total += territory2trfs[territory].size
				tmstr = "Sample(s) received: #{territory2trfs[territory].size}\n"
				#puts "--> Sending email to: #{tm.Email}....."
				#sendMail 'cchou@cardiodx.com', "Sample Report (#{qtype.gsub(/_/, ' ').capitalize}) #{date_str}", tmstr
			end
		end
		if ['this_week', 'last_week'].include?(qtype)
			rmstr += "      TM total: #{tm_total}\n"
		else
			rmstr += "    #{territory}: #{tm_total}\n"
		end
	end
	rmstr += "  RM total: #{rm_total}\n"
	rmstr += "\n"
	vpstr += rmstr
	puts "\n\nSending email to: #{rm.Email}....."
	puts rmstr
	#sendMail 'cchou@cardiodx.com', "Sample Report (#{qtype.gsub(/_/, ' ').capitalize}) #{date_str}", rmstr
	sendMail rm.Email, "Sample Report (#{qtype.gsub(/_/, ' ').capitalize}) #{date_str}", rmstr
end

vpstr += "CDx total: #{vp_total}\n"
vpstr += "\n"
vps.each do |vp|
	puts "Sending email to: #{vp.Email}"
	#sendMail 'cchou@cardiodx.com', "Sample Report (#{qtype.gsub(/_/, ' ').capitalize}) #{date_str}", vpstr
	sendMail vp.Email, "Sample Report (#{qtype.gsub(/_/, ' ').capitalize}) #{date_str}", vpstr
end

exit


