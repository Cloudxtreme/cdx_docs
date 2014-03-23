new machine server
To recover bioinformatics:


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Backup:

tar cvf - /etc/mdadm/* | ssh cchou@bioinformatics 'cat - > /tmp/etc.tar'
ssh cchou@bioinformatics 'cat /tmp/abc/etc.tar' | tar xvf -

use "--exclude=/dev/*" to create empty dirs for:
	/dev
	/sys
	/proc


tar --exclude="/dev/*" --exclude="/proc/*" --exclude="/sys/*" -czvf - / | ssh cchou@srikardesktop 'cat - > /tmp/root.i386.tar.gz'


  402  cd i386/
  407  tar --exclude="./dev/*" --exclude="./proc/*" --exclude="./sys/*" -czvf ../i386.tar.gz .


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Recover:

mdadm to create 2 partitions:
	/boot
	/root

dd if=mbr of=/dev/sda bs=446 count=1 (so we won't destory the partition table)

mount and untar with "--numeric-owner" flag to preserve the uid

modify /etc/mdadm/mdadm.conf to have the correct id

