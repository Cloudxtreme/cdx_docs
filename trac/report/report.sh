#!/bin/bash

/root/trac_report/report.rb > /tmp/report.out 2>&1

mailx -s "Trac Report - IT (`date +%m-%d`)" it@cardiodx.com < /tmp/report.out 


