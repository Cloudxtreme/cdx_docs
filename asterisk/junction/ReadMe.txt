asterisk junction

http://www.junctionnetworks.com/knowledgebase/pstn-gateway/pbx-configuration/asterisk-configuration-iax
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

cd /usr/share/asterisk/keys/

mv iax.conf iax.conf.orig
grep -v ';' iax.conf.orig > iax.conf

# more iax.conf
[general]
bandwidth=low
jitterbuffer=no
forcejitterbuffer=no
autokill=yes
register => cardiodx:shnMAZzT@iax.jnctn.net

[jnctn]
type=user
auth=rsa
inkeys=jnctn
context=cdx-default

[jnctn_out]
type=peer
host=iax.jnctn.net
username=cardiodx
secret=shnMAZzT

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

mv extensions.conf extensions.conf.orig
# more extensions.conf
[general]
static=yes
writeprotect=no


[default]
exten => _1NXXNXXXXXX,1,Set(CALLERID(num)=15555551234)
exten => _1NXXNXXXXXX,2,Dial(IAX2/jnctn_out/${EXTEN})
exten => _1NXXNXXXXXX,3,Congestion()
exten => _1NXXNXXXXXX,103,Busy()


[cdx-default]
exten => _1NXXNXXXXXX,1,Playback(beep)
exten => _1NXXNXXXXXX,2,SayDigits(${EXTEN})
exten => _1NXXNXXXXXX,3,Goto(testdtmf|s|1)



asterisk -rvvvvv
restart now

asterisk -rvvvvv
dial 14088883248

