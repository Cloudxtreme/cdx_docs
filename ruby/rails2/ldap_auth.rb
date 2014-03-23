#!/usr/bin/ruby -w
#
# wajig install ruby rdoc irb libopenssl-ruby
# rubygems: wget http://rubyforge.org/frs/download.php/69365/rubygems-1.3.6.tgz
#   gem install ruby-net-ldap -no-rdoc --no-ri
#
require 'rubygems'
require 'net/ldap'

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


# ldapsearch -LLL -H ldap://pdc.cardiodx.com:389 -b 'dc=cardiodx,dc=com' "(ObjectClass=user)" -D 'CDX\cdxtest' -w 'CDx7357!' | less
results = ldap.search(:base => 'dc=cardiodx,dc=com', :filter => '(ObjectClass=user)')

results.each do |entry|
	if entry.objectCategory.to_s =~ /CN=Person/ and entry.pwdLastSet[0].to_i > 0
		now = Time.now
		pwlastset = ad2time(entry.pwdLastSet[0].to_i)
		if now - pwlastset > 60*60*24*120
			#puts "#{entry.sAMAccountName}: (#{now}, #{pwlastset}) #{now - pwlastset}" 
			msg = "#{entry.cn}, \nYour password will expire in #{(180 - sec2dhms(now - pwlastset)[0])} days.\n\n"
			puts msg
		end
	end
end





