
server: 
	openssh-server
	samba-server

workstation:
	samba-client
	
dvd: 
	openldap-client
	openldap-servers
	pam_ldap

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

**for backing up

cd /etc

tar cvf ~/samba.tar samba
tar cvf ~/openldap.tar openldap
cp pam.d/system-auth ~
cp ldap.conf ~


cd ~
mkdir smbldap
mv ldap.conf smbldap/
mv system-auth smbldap/
mv *.tar smbldap
tar cvf smbldap.tar smbldap


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
***ftp files to /home/cchou


--
-- ldap
--

cd /etc/openldap/schema
ln -s /usr/share/openldap/schema/* .

~~~~~~~~~~~

--cd /etc
--mv ldap.conf ldap.conf.orig
--cp /home/cchou/ldap.conf-etc ldap.conf .



cd /etc/openldap
mv slapd.conf slapd.conf.orig
cp /home/cchou/slapd.conf .

--mv ldap.conf ldap.conf.orig
--cp /home/cchou/ldap.conf .

service ldap start

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

--
-- samba
--
cd /etc/samba
mv smb.conf smb.conf.orig
cp /home/cchou/smb.conf .

smbpasswd -w secret


net getlocalsid
[2005/03/16 23:45:19, 0] lib/smbldap.c:smbldap_search_suffix(1169)
  smbldap_search_suffix: Problem during the LDAP search:  (No such object)
SID for domain CDX-PDC is: S-1-5-21-576408918-2976637001-1654798064


mv smbldap.conf smbldap.conf.orig
cp /home/cchou/smbldap.conf .
vi smbldap.conf .

mv smbldap_bind.conf smbldap_bind.conf.orig
cp /home/cchou/smbldap_bind.conf .


smbldap-populate


vi smbusers
#root=administrator admin


smbpasswd -a Administrator



testparm

service smb start

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

cd /etc/pam.d
cp system-auth system-auth.orig
cp /home/cchou/system-auth .


cd /etc
vi nsswitch.conf
		passwd:     files ldap
		shadow:     files ldap
		group:      files ldap


mkdir /opt/samba
mkdir /opt/samba/netlogon
mkdir /opt/samba/profiles
chmod 1777 /opt/samba/profiles


cd /home/cchou
vi startup.bat


chkconfig smb on
chkconfig ldap on

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

slapcat

ldapsearch -x -b "dc=cardiodx,dc=com" "(ObjectClass=*)"

getent passwd | grep Administrator

smbldap-useradd -m -a david
smbldap-passwd david
??smbpasswd david
pdbedit -Lv david
id david
ls -al /home



smbldap-useradd -m -a ian
smbldap-passwd ian
ldapsearch -x -b 'uid=ian,ou=People,dc=cardiodx,dc=com' 
pdbedit -Lv ian


getent passwd
getent group
net groupmap list

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
** rebuild the db and test

service ldap stop
service smb stop

cd /var/lib
rm -rf ldap
mkdir ldap
chown ldap:ldap ldap
cd /etc/samba

service ldap start
service smb start


smbldap-populate


smbpasswd -a Administrator

getent passwd | grep Administrator
smbldap-useradd -m david
smbldap-passwd david

getent passwd
getent group
net groupmap list


id david
--ls -al /home
pdbedit -Lv david


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
** for adding a new machine
vi /etc/passwd
cchouxp$:x:1400:1400:Workstation:/dev/null:/bin/false


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-- join test -> not working
machine1$:x:1400:1400:Workstation:/dev/null:/bin/false
net rpc join -d 3 -S machine1 -U Administrator

