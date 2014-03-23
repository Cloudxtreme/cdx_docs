#!/usr/bin/ruby -w
#

# wajig install ruby rdoc irb libopenssl-ruby
# rubygems: wget http://rubyforge.org/frs/download.php/69365/rubygems-1.3.6.tgz
#   gem install ruby-net-ldap -no-rdoc --no-ri

require 'rubygems'
require 'net/ldap'


h = {
:host=>'ldap.cardiodx.com',
:port=>636,
:base=>'dc=cardiodx,dc=com',
:auth=> {
  :method => :simple,
  :username=>'uid=chialin,ou=People,dc=cardiodx,dc=com',
  :password=>'secret07'
},
:encryption => :simple_tls
}

n=Net::LDAP.new(h)
if (n.bind)
  puts 'logon'
else
  puts 'failed'
end


