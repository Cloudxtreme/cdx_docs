#!/usr/bin/perl -w
#
# Adds a new polycom ip500 phone
#
#

use strict;

my $usage = "$0 mac_address extension\n";
die($usage) if(@ARGV != 2);
my $mac_address = shift;
my $extension = shift;

$mac_address =~ s/://g;
$mac_address = lc $mac_address;
die("Mac address:$mac_address doesn't appear to be of the right length\n") if(length($mac_address) != 12);

system("sed 's/XXXX/$extension/g' mac_address.cfg > $mac_address.cfg");
system("sed 's/XXXX/$extension/g' phoneXXXX.cfg > phone$extension.cfg");

