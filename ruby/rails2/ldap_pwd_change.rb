#!/usr/bin/ruby -w
#
# wajig install ruby rdoc irb libopenssl-ruby
# rubygems: wget http://rubyforge.org/frs/download.php/69365/rubygems-1.3.6.tgz
#   gem install ruby-net-ldap -no-rdoc --no-ri
#
require 'rubygems'
require 'net/ldap'

oldPass = 'CDx7357!'
password = "\"" + 'CDx7357#' + "\""
username = 'cdxtest'

conf = {
	:host=>'ldap.cardiodx.com',
	:port=>636,
	:base=>'dc=cardiodx,dc=com',
	:auth=> {
  	:method => :simple,
  	:username=>"#{username}@cardiodx.com",
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



password.length.times{|i| oldPass+= "#{password[i..i]}\000" } # encoding password in format Microsoft wants

#results = ldap.search(:base => 'dc=cardiodx,dc=com', :filter => '(ObjectClass=user)')
results = ldap.search(:base => 'dc=cardiodx,dc=com', :filter=> "(sAMAccountName=#{username})" )

results.each do |entry|
	puts entry.cn	
end

exit

# Microsoft requires that in one operation, you delete the old password then add the new one
ops = [[:delete, :unicodePwd, oldPass],[:add, :unicodePwd, newPass]] 
ldap.modify :dn => dn, :operations => ops
puts ldap.get_operation_result.code 



