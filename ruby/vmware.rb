#!/usr/local/rvm/rubies/ruby-1.9.3-p194/bin/ruby

require 'rubygems'
require 'net/ssh'

machines = ["esxi02", "esxi03", "esxi04", "esxi05"]

machines.each do |machine|

	puts "======== #{machine} ========"
	begin
  	ssh = Net::SSH.start("#{machine}.cardiodx.com", 'root')
	
		# list the VMs
  	outstr = ssh.exec!("vim-cmd vmsvc/getallvms")
		rlines = outstr.split("\n")
		rlines.each do |rline|
			if rline =~ /(\d+)\s+(\S*)\s+(\[.*\]\s\S*)\s+(\S*)\s+\S*/
				id=$1; name=$2; guest=$4

				# running or not?
				outstr1 = ssh.exec!("vim-cmd /vmsvc/power.getstate #{id}")
				power = (outstr1 =~ /Powered on/) ? 'Up' : 'Down'

				newline = "%2d%15s%22s%7s" % [id, name, guest, power]
				puts newline
			end
		end
 	 	ssh.close
	rescue Exception => e
  	puts "Unable to connect to #{@hostname} using #{@username}/#{@password}"
		puts e.message
	end

	puts ''
end
