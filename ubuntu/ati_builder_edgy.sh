#!/bin/bash
apt-get update
apt-get install module-assistant build-essential wget
apt-get install fakeroot dh-make debconf libstdc++5 linux-headers-$(uname -r)

wget -c https://a248.e.akamai.net/f/674/9206/0/www2.ati.com/drivers/linux/ati-driver-installer-8.32.5-x86.x86_64.run
(NOTE: get it from ATI website!!!!)
chmod +x ati-driver-installer-8.32.5-x86.x86_64.run
./ati-driver-installer-8.32.5-x86.x86_64.run --buildpkg Ubuntu/edgy

dpkg -i xorg-driver-fglrx_8.32.5-1_i386.deb fglrx-kernel-source_8.32.5-1_i386.deb fglrx-control_8.32.5-1_i386.deb

rm /usr/src/fglrx-kernel*.deb

module-assistant prepare
module-assistant update
module-assistant build fglrx
module-assistant install fglrx

depmod -a

aticonfig --initial
aticonfig --overlay-type=Xv


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Section "Extensions"
        Option  "Composite" "Disable"
EndSection

Section "ServerFlags"
        Option  "AIGLX" "off"
EndSection


  162  vi sources.list
  163  wget http://ubuntu.beryl-project.org/root@lupine.me.uk.gpg -O- | sudo apt-key add -
  164   wget http://download.tuxfamily.org/3v1deb/DD800CD9.gpg -O- | sudo apt-key add -
  165  wajig update
  166  sudo apt-get install xserver-xgl
  167  sudo apt-get install beryl emerald-themes

  169  beryl-manager 
  170  glxinfo 
  171  glxinfo | grep direct
  172  vi /etc/X11/xorg.conf

