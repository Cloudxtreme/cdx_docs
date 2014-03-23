#!/usr/bin/ruby -w

require 'date'
require 'rmail'
require 'net/smtp'

CDX_HOLIDAYS=[ Date.new(2009,1,1), Date.new(2009,1,2), Date.new(2009,2,16), Date.new(2009,5,25), Date.new(2009,7,3), Date.new(2009,9,7), Date.new(2009,11,25), Date.new(
2009,11,26), Date.new(2009,11,27), Date.new(2009,12,24), Date.new(2009,12,25), Date.new(2009,12,28), Date.new(2009,12,29), Date.new(2009,12,30), Date.new(2009,12,31), D
ate.new(2010,1,1) ]

msg_yes = <<END_OF_MSG_YES
This is an automated response to your email. If you are notifying CardioDx of a sample shipment, please PROCEED to ship the samples today. Ship samples to:

CardioDx, Inc.
Attn:  Sample Receiving
2500 Faber Place
Palo Alto, CA 94303 

If you have not already done so, please send the following information to samplereceipt@cardiodx.com:
Investigator Name_________________________
Institution Name_________________________
Institution Address_______________________
Date Sample Ship________________________
Subject ID's included in this shipment________________________
Name of Courier: Federal Express World Courier Other___________
Airbill Number(s)________________________________________________

If this information was all included in your first email to sample notification, no additional email is required.

Thanks for your continued support of this CardioDx sponsored Trial.

Lori 
END_OF_MSG_YES

msg_yes_but_not_tomorrow = <<END_OF_MSG_YES_BUT_NOT_TOMORROW
This is an automated response to your email. If you are notifying CardioDx of a sample shipment, please PROCEED to ship the samples today. HOWEVER, please do not ship t
omorrow as we will be unavailable to receive the samples.  Ship samples to:

CardioDx, Inc.
Attn:  Sample Receiving
2500 Faber Place
Palo Alto, CA 94303 

If you have not already done so, please send the following information to samplereceipt@cardiodx.com:
Investigator Name_________________________
Institution Name_________________________
Institution Address_______________________
Date Sample Ship________________________
Subject ID's included in this shipment________________________
Name of Courier: Federal Express World Courier Other___________
Airbill Number(s)________________________________________________

If this information was all included in your first email to sample notification, no additional email is required.

Thanks for your continued support of this CardioDx sponsored Trial.

Lori 
END_OF_MSG_YES_BUT_NOT_TOMORROW

msg_no = <<END_OF_MSG_NO
This is an automated response to your email. If you are notifying CardioDx of a sample shipment, please DO NOT ship the samples today as we will be unavailable to recei
ve them. You may safely ship the samples on SHIP_DATE.

Lori
END_OF_MSG_NO

def is_holiday?(chkdate=Date.today)
  return true if chkdate.wday==6 or chkdate.wday==0
  CDX_HOLIDAYS.each {|holiday| return true if chkdate == holiday}
  return false
end

def is_tomorrow_holiday?(chkdate=Date.today)
  return is_holiday?(chkdate+1)
end

def is_day_after_tomorrow_holiday?(chkdate=Date.today)
  return is_holiday?(chkdate+2)
end


def find_next_available_shipment_day(chkdate=Date.today)
  while is_holiday?(chkdate) or is_tomorrow_holiday?(chkdate) 
    chkdate+=1
  end
  return chkdate
end

# Fix RMail related classes to be more well behaved
class RMail::Address::List
  def to_s
    self.addresses.join(",")
  end
end
class RMail::Address
  def to_s
    self.format
  end
end

message = RMail::Parser.read(STDIN)
header=message.header
from=header.from
to=header.to
date=header.date
subject=header.subject
body=message.body

mail=RMail::Message.new()
if is_tomorrow_holiday? then
  available_date=find_next_available_shipment_day
  available_date_str=Date::MONTHNAMES[available_date.mon] + " #{available_date.day}, #{available_date.year}"
  msg_no=msg_no.gsub(/SHIP_DATE/, available_date_str)
  mail.body="#{msg_no}\n\n"
elsif is_day_after_tomorrow_holiday? then
  mail.body="#{msg_yes_but_not_tomorrow}\n\n"
else
  mail.body="#{msg_yes}\n\n"
end
#body.each("\n") {|line| mail.body += "> #{line}"}

mail.header.from = 'samplenotification@cardiodx.com (Sample Notification)'
mail.header.reply_to = 'samplereceipt@cardiodx.com (Sample Receipt)'
recipients=[from, 'cchou@cardiodx.com']
mail.header.to = recipients.join(',')
mail.header.subject="RE: #{subject}"

smtp = Net::SMTP.start('localhost', 25)
smtp.send_message mail.to_s, mail.header.from, recipients
smtp.finish


