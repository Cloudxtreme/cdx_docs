#!/bin/bash

# 35 18   * * *   cchou   /home/cchou/ruby/rails/salesforce/DSR_Report.sh

export PATH=$PATH:/usr/local/rvm/bin

LOG=/tmp/DSR_Report.log
. ~/.bashrc
. /etc/profile.d/rvm.sh

cd ~/ruby/rails/salesforce 
bundle exec rails runner DSR_Report.rb today >> /tmp/DSR_Report.log 2>&1

