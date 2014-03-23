#!/usr/bin/ruby

require 'rubygems'
require 'ftpfxp'

# File info
UPLOAD_FILE_DIRECTORY = "/home/llu/Downloads/GBF/upload/"
DOWNLOAD_FILE_DIRECTORY = "/home/llu/Downloads/GBF/download/"
SERVER_UPLOAD_FILE_DIRECTORY = "/FromCardioDx/"
SERVER_DOWNLOAD_FILE_DIRECTORY = "/FromCardioDx/"
FILE_NAME = "*.xml"

# Server info
SERVER_DOMAIN_NAME = "www.gbf-inc.com"
SERVER_FTPS_LOGIN = "cardiodx"
SERVER_FTPS_PASSWORD = "cut3Puppy!79"
SERVER_FTPS_PORT = 21

ftp = Net::FTPFXPTLS.new
ftp.passive=true
#ftp.debug_mode=true
ftp.connect(SERVER_DOMAIN_NAME, SERVER_FTPS_PORT)
ftp.login(SERVER_FTPS_LOGIN, SERVER_FTPS_PASSWORD)

Dir.glob(UPLOAD_FILE_DIRECTORY + FILE_NAME).each do |putFile|
	#puts File.basename(putFile)
	ftp.puttextfile(putFile, SERVER_UPLOAD_FILE_DIRECTORY + "#{File.basename(putFile)}")
end

ftp.nlst(SERVER_DOWNLOAD_FILE_DIRECTORY + FILE_NAME).each do |getFile|
	#puts File.basename(getFile)
	ftp.gettextfile(getFile, DOWNLOAD_FILE_DIRECTORY + "#{File.basename(getFile)}")
end

ftp.close()
