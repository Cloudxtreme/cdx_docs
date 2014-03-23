http://www2.origogeneris.com:4000/relay_recipients.html


bash-completion-20050121-1mdk.noarch.rpm

postfix:
	postfix-2.1.5-5mdk.x86_64.rpm	The package(s) are already installed
	postfix-ldap-2.1.5-5mdk.x86_64.rpm

openldap
	openldap-clients-2.2.23-3mdk.x86_64.rpm

cyrus:
	tcp_wrappers-7.6-25mdk.x86_64.rpm 
	lib64net-snmp5-5.2.1-2mdk.x86_64.rpm 
	lib64lm_sensors3-2.9.0-4mdk.x86_64.rpm 
	
	perl-Cyrus-2.2.10-2.102mdk.x86_64.rpm
	cyrus-imapd-2.2.10-2.102mdk.x86_64.rpm
	cyrus-imapd-utils-2.2.10-2.102mdk.x86_64.rpm
	cyrus-sasl-2.1.19-9mdk.x86_64.rpm


misc:
	telnet-client-krb5-1.3.6-4mdk.x86_64.rpm
	bind-utils-9.3.0-7mdk.x86_64.rpm (??)
	nscd-2.3.4-6mdk.x86_64.rpm

pam:
	pam_ldap-170-4mdk.x86_64.rpm
	nss_ldap-220-4mdk.x86_64.rpm
	lib64dbnss4.2-4.2.52-6mdk.x86_64.rpm
	

postfix:
	/etc/postfix
	main.cf
	master.cf
	ldap-aliases.cf


openldap
	/etc/openldap
	ldap.conf
	ldapserver

	/etc
	ldap.conf
	ldap.secret

	
pam:
	system-auth
	nsswitch.conf

cyrus:
	cyrus.conf
	imapd.conf
	services
	

nscd:
	nscd.conf
	

service postfix start


***cyrus: read cyrus.txt


service nscd start


chkconfig postfix on
chkconfig cyrus-imapd on
chkconfig saslauthd on
chkconfig nscd on


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


tail -f /var/log/mail/*

ldapsearch -x -b "dc=cardiodx,dc=com" "(ObjectClass=*)" -ZZ


postmap -v -q srao ldap:/etc/postfix/ldap-aliases.cf
