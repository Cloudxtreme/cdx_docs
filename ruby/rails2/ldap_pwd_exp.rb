#!/usr/bin/ruby -w
#
# wajig install ruby rdoc irb libopenssl-ruby
# rubygems: wget http://rubyforge.org/frs/download.php/69365/rubygems-1.3.6.tgz
#   gem install ruby-net-ldap -no-rdoc --no-ri
#
require 'rubygems'
require 'net/ldap'
require 'net/smtp'
require 'rmail'

# http://www.ruby-forum.com/topic/77821
AD_EPOCH      = 116_444_736_000_000_000
AD_MULTIPLIER = 10_000_000

# convert a Time object to AD's epoch
def time2ad(time)
  (time.to_i * AD_MULTIPLIER) + AD_EPOCH
end

# convert from AD's time string to a Time object
def ad2time(time)
  Time.at((time.to_i - AD_EPOCH) / AD_MULTIPLIER)
end

conf = {
	:host=>'ldap.cardiodx.com',
	:port=>636,
	:base=>'dc=cardiodx,dc=com',
	:auth=> {
  	:method => :simple,
  	:username=>'cdxtest@cardiodx.com',
  	:password=>'CDx7357!'
	},
	:encryption => :simple_tls
}

ldap=Net::LDAP.new(conf)
if (ldap.bind)
  puts 'logon'
else
  puts 'failed'
end

def sec2dhms(secs)
  time = secs.round          # Get rid of microseconds
  sec = time % 60            # Extract seconds
  time /= 60                 # Get rid of seconds
  mins = time % 60           # Extract minutes
  time /= 60                 # Get rid of minutes
  hrs = time % 24            # Extract hours
  time /= 24                 # Get rid of hours
  days = time                # Days (final remainder)
  [days, hrs, mins, sec]     # Return array [d,h,m,s]
end

def send_mail(email, name, subject, message)

  if not email
    email='sstichler@cardiodx.com'
    message = "ERROR: Email address NOT found for '#{name}' on Wiki page: Employee_Numbers!!"
    puts message
    name = "admin"
  end

  puts "Sending out notification to: #{email} (#{name})"
  mail=RMail::Message.new()
  mail.body=message
  mail.header.from = 'sstichler@cardiodx.com (Steven Stichler)'
  mail.header.subject = subject
  mail.header.to = "#{email}@cardiodx.com"

  smtp = Net::SMTP.start('mail', 25)
  smtp.send_message mail.to_s, mail.header.from, email
  smtp.finish

end


# ldapsearch -LLL -H ldap://pdc.cardiodx.com:389 -b 'dc=cardiodx,dc=com' "(ObjectClass=user)" -D 'CDX\cdxtest' -w 'CDx7357!' | less
results = ldap.search(:base => 'dc=cardiodx,dc=com', :filter => '(ObjectClass=user)')

# userAccountControl
# 512   Enabled Account
# 514   Disabled Account
# 544   Enabled, Password Not Required
# 546   Disabled, Password Not Required
# 66048 Enabled, Password Doesn't Expire
# 66050 Disabled, Password Doesn't Expire
# 66080 Enabled, Password Doesn't Expire & Not Required
# 66082 Disabled, Password Doesn't Expire & Not Required
#
linux_users = []
mac_users = []
remote_users = []

linux_msg = %Q(
How to change currently logged-in user password in Ubuntu 10.04[lucid lynx]

  1. Select your username on the top right-hand corner of your desktop. click on your username.
  2. User details window opens >> click on "Change Password..."
  3. Password change window will appear, enter your password and click on "Change Password..."
)

mac_msg = %Q(
Resetting a user's password in OS X Lion and Mountain Lion

  Important: Passwords for administrator accounts should not be blank.

  1. Log in with an administrator account. Tip: If you don't know the password of any administrator accounts, 
			see "Resetting the original administrator account password" below.
  2. From the Apple menu choose System Preferences.
  3. From the View menu choose Users & Groups.
  4. Click the lock button if it appears locked; enter the administrator password.
  5. Select the name of the user whose password you want to change.
  6. Click the Reset Password button or the Change Password button.
  7. Enter a new password in both the New Password and Verify fields, and add a Password Hint if desired.
  8. Click the Reset Password button or the Change Password button.
)

windows_msg = %Q(
How to change currently logged-in user password in Windows (XP or 7)

  If you have a limited account

  1. Open User Accounts in Control Panel.
  2. Click Change my password.
  3. Type your current password.
  4. Type the new password (in both fields).
  5. **OPTIONAL** You can enter a description or meaningful text to help you remember your password.
  6. Click Change Password.
)


results.each do |entry|
	if entry.objectCategory.to_s =~ /CN=Person/ and entry.pwdLastSet[0].to_i > 0
		now = Time.now
		pwlastset = ad2time(entry.pwdLastSet[0].to_i)
		if (now - pwlastset > 60*60*24*120) and entry.userAccountControl[0].to_i==512
			#puts entry.attribute_names
			exp_days = 180 - sec2dhms(now - pwlastset)[0] -1
			# #{entry.uid}
			
			msg = "#{entry.givenname}, \n\nYour password will expire in #{exp_days} days.\n\n"
			if linux_users.include?(entry.uid.to_s)
				msg += linux_msg
			elsif mac_users.include?(entry.uid.to_s)
				msg += mac_msg
			elsif remote_users.include?(entry.uid.to_s)
				msg = msg
			else
				msg += windows_msg
			end
			msg += "\nIf you have any questions/problems, please contact IT (x0930 or it_support@cardiodx.com)"
			msg += "\n\nThanks,\n\n-ss"
			if entry.uid.to_s == 'cchou'
				send_mail(entry.uid.to_s, entry.givenname.to_s, "IT Notification - Your password will be expired in #{exp_days}", msg)
			end
		end
	end
end





