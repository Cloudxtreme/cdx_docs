#!/usr/bin/ruby

require 'sqlite3'
require 'date'

debug = false
dumpsql = false

today = Date.today
yesterday = Date.today-1
btime = Time.local(yesterday.year, yesterday.mon, yesterday.mday)
etime = Time.local(today.year, today.mon, today.mday)

#btime = Time.local(2010,8,23)
#etime = Time.local(2010,8,28)

puts  "============================="
puts "#{btime.strftime("%a, %m/%d/%y")} - #{etime.strftime("%a, %m/%d/%y")}"
puts  "============================="
puts "\n"

ibtime = btime.to_i
ietime = etime.to_i

db = SQLite3::Database.new( "/var/lib/trac/it/db/trac.db" )

#########################
# Ticket Count
#########################
sql=%Q(select * from ticket where time between #{ibtime} and #{ietime} order by time desc)

rows = db.execute2(sql)
puts "# of New Tickets: #{rows.size-1}"

columns = nil
i=0
db.execute2(sql) do |row|
  if columns.nil?
    columns = row
  else
    i=i+1
    puts "    #{i}: #{row[14]}" if debug
  end
end
puts "\n" 

#########################
# By Department
#########################
sql=%Q(select component, count(*)
        from ticket
        where time between #{ibtime} and #{ietime}
        group by component
        order by count(*) desc;
    )

puts sql if dumpsql

rows = db.execute2(sql)

puts "  By Department:"
columns = nil
db.execute2(sql) do |row|
  if columns.nil?
    columns = row
  else
    puts "    #{row[0]}: #{row[1]}"
  end
end
puts "\n" 

#########################
# By Type
##########################
sql=%Q(select version, count(*)
        from ticket
        where time between #{ibtime} and #{ietime}
        group by version
        order by count(*) desc;
    )

puts sql if dumpsql

rows = db.execute2(sql)

puts "  By Type:"
columns = nil
db.execute2(sql) do |row|
  if columns.nil?
    columns = row
  else
    puts "    #{row[0]}: #{row[1]}"
  end
end
puts "\n"



#########################
# Ticket Modified
##########################
sql=%Q(
  select distinct t.summary, c.time, count(*)
  from ticket t, ticket_change c
  where t.id = c.ticket
  and c.time between  #{ibtime} and #{ietime}
  group by t.summary, c.time
  order by t.summary 
    )

puts sql if dumpsql

rows = db.execute2(sql)

puts "# of Tickets Modified: #{rows.size-1}"
columns = nil
db.execute2(sql) do |row|
  if columns.nil?
    columns = row
  else
    puts "    #{row[0]}: #{Time.at(row[1].to_i)}, #{row[2]}" if debug
  end
end
puts "\n"


#########################
# Ticket Closed
###########################
sql=%Q(
  select summary,status
  from ticket
  where time between #{ibtime} and #{ietime}
  and status = 'closed'
    )

puts sql if dumpsql

rows = db.execute2(sql)

puts "# of Tickets Closed: #{rows.size-1}"
columns = nil
db.execute2(sql) do |row|
  if columns.nil?
    columns = row
  else
    puts "    #{row[0]}: #{row[1]}" if debug
  end
end
puts "\n"


