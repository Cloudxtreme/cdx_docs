#/bin/bash

stserver='storage1'
kvmsrvs='kvmsrv1 kvmsrv3 kvmsrv4'

USAGE="Usage: \n"
USAGE="$USAGE\tcdxvm {mount|umount} host, mount/umount iSCSI device\n"
USAGE="$USAGE\tcdxvm {start|stop|view} host\n"
USAGE="$USAGE\tcdxvm migrate {live|cold} host dest\n"
USAGE="$USAGE\tcdxvm create master host, [master=lucid64,hardy64,...]\n" 
USAGE="$USAGE\tcdxvm destroy host\n"
USAGE="$USAGE\tcdxvm available\n"
USAGE="$USAGE\tcdxvm iscsi\n"
USAGE="$USAGE\tcdxvm list\n"
USAGE="$USAGE\tcdxvm load\n"

action=$1

runningsrv=''
function is_running() {
  host=$1
  for kvm in $kvmsrvs
  do 
    ssh root@$kvm 'virsh list 2> /dev/null' | grep " $host " > /dev/null 2>&1
    if [ $? == 0 ]; then
      runningsrv=$kvm
      return 0
    fi
  done
  return 1
}

function export_lvm() {
  host=$1
  tid=`ssh root@$stserver 'cat /proc/net/iet/volume' | grep $host | head -1 | awk '{print $1}' | awk -F: '{print $2}'`
  if [ !$tid ]; then
    max_tid=`ssh root@$stserver 'cat /proc/net/iet/volume' | head -1 | awk '{print $1}' | awk -F: '{print $2}'`
    let next_tid=max_tid+1
    lv=`ssh root@$stserver 'lvscan' | grep "'\/dev\/vg[0-9]\/$host'"  | awk '{print $2}' | sed s/\'//g`
    echo "$stserver: Exporting $lv..."
    ssh root@$stserver "ietadm --op new --tid=$next_tid --params Name=storage1.$host"
    ssh root@$stserver "ietadm --op new --tid=$next_tid --lun=0 --params Path=$lv"
    echo
  fi
  return 0
}

function unexport_lvm() {
  host=$1
  tid=`ssh root@storage1 'cat /proc/net/iet/volume' | grep $host | head -1 | awk '{print $1}' | awk -F: '{print $2}'`
  if [ $tid ]; then
    echo "Deleting tid:$tid from $stserver."
    ssh root@$stserver "ietadm --op delete --tid=$tid"
  fi
  return 0
}

case "$action" in
  test) 
    # for testing my scripts
    host=$2
    tid=`ssh root@storage1 'cat /proc/net/iet/volume' | grep $host | head -1 | awk '{print $1}' | awk -F: '{print $2}'`
    if [ !$tid ]; then
      echo "No tid "
    fi
    ;;
  start)
    host=$2
    # checking
    if [ -z $host ]; then
       echo -e $USAGE
       exit 1
    fi
    
    is_running $host
    if [ $? = '0' ]; then
      echo "ERROR: $host is already running on $runningsrv!!"
      echo 
      exit 1
    fi

    rsync root@$stserver:/root/xml/$host.xml .

    # iscsi
    export_lvm $host
    sleep 1
    iscsiadm -m discovery -t st -p $stserver > /dev/null 2>&1
    iscsiadm -m node -T $stserver.$host -l
    iscsiadm -m session | grep ' $host'
    sleep 1

    # kvm
    virsh define $host.xml 2> /dev/null
    virsh start $host 2> /dev/null
    sleep 2
    virt-viewer -c qemu:///system $host &
    virsh list 2> /dev/null
    ;;

  stop)
    host=$2
    # checking
    if [ -z $host ]; then
       echo -e $USAGE
       exit 1
    fi

    is_running $host
    if [ $? = '1' ]; then
      echo "ERROR!! $host is not running on ($kvmsrvs).  Start it first!"
      echo
      exit 1
    fi

    if [[ $runningsrv != `hostname` ]]; then
      echo "ERROR!! $host is running on $runningsrv.  Stop it from there!"
      echo 
      exit 1
    fi

    # kvm
    virsh shutdown $host 2> /dev/null
    virsh destroy $host 2> /dev/null
    sleep 2
    virsh undefine $host 2> /dev/null
    
    # iscsi
    iscsiadm -m session | grep $host
    if [ $? == 0 ]; then
      iscsiadm -m node -T $stserver.$host -u    
      iscsiadm -m session
    fi
    echo 
    unexport_lvm $host
    echo
    ;;

  view)
    host=$2
    # checking
    if [ -z $host ]; then
       echo -e $USAGE
       exit 1
    fi

    is_running $host
    if [ $? = '1' ]; then
      echo "ERROR!! $host is not running on ($kvmsrvs).  Start it first!"
      echo
      exit 1
    fi
    
    virt-viewer -c qemu+ssh://root@$runningsrv/system $host &
    ;;

  available)
    ssh root@$stserver "cd /root/xml; ls *.xml" | grep -v master | awk -F. '{print $1}'
    ;;

  iscsi)
   echo "Available ....."
   ssh root@$stserver 'cat /proc/net/iet/volume | grep tid | sort' | awk '{print "  ",$1,$2}'
   echo

   for kvm in $kvmsrvs
   do
     echo "============ $kvm ============="
     ssh root@$kvm 'iscsiadm -m session 2> /dev/null' | awk '{print "  ",$4}'
     echo
   done
   ;;

  list)
   echo
   for kvm in $kvmsrvs
   do
     echo "============ $kvm ============="
     ssh root@$kvm 'virsh list 2> /dev/null' 
     #ssh root@$kvm 'iscsiadm -m session 2> /dev/null' | awk '{print $4}' | awk -F. '{print "\tiscsi:",$2}'
     echo
   done
   ;;

  load)
   for kvm in $kvmsrvs
   do
     echo "============ $kvm ============="
     ssh root@$kvm 'uptime 2> /dev/null'
     echo
   done
   ;;

  migrate)
   mtype=$2
   host=$3
   dest=$4

   if [ -z $host ] || [ -z $mtype ] || [ -z $dest ]; then
     echo -e $USAGE
     exit 1
   fi

    is_running $host
    if [ $? = '1' ]; then
      echo "ERROR!! $host is not running on ($kvmsrvs).  Start it first!"
      echo
      exit 1
    fi

    if [[ $runningsrv != `hostname` ]]; then
      echo "ERROR!! $host is running on $runningsrv.  Migrate it from there!"
      echo 
      exit 1
    fi

   case "$mtype" in
     live)
      echo "Connect iSCSI from $dest..."
      ssh root@$dest "iscsiadm -m node -T storage1.$host -l"
      sleep 1
      echo 

      echo "Migrating...."
      virsh migrate --live $host qemu+ssh://$dest/system

      echo "Disconnect iSCSI from `hostname`..."
      iscsiadm -m node -T storage1.$host -u
      echo
      ;;
     cold)
      echo -e 'cold migration not supported at this time'
      ;;
   esac
   ;;

  create)
   master=$2
   host=$3
   if [ -z $master ] || [ -z $host ]; then
     echo -e $USAGE
     exit 1
   fi

   supported_master="hardy64 lucid64 win2003 winxp rdlims cclvm"
   match='false'
   for h in $supported_master
   do
     if [ $master = $h ]; then
       match='true'
     fi
   done

   if [ $match = 'false' ]; then
     echo "Supported master: $supported_master"
     exit 1
   fi

   echo "Creating LVM...."
   vgnum=`echo $RANDOM%2+1 | bc` # vg1 or vg2

   size='0G'
   if [ $master = 'hardy64' ] || [ $master = 'lucid64' ]; then 
     size='6G'
   elif [ $master = 'win2003' ]; then
     size='56G'
   else # other windows machines
     size='26G'
   fi
   ssh root@$stserver "lvcreate -L+$size -i 3 -n $host vg$vgnum"

   echo "Copy image from $master-master..."
   ssh root@$stserver "dd if=/dev/vg0/$master-master bs=10M | pv > /dev/vg$vgnum/$host"
   echo
   
   export_lvm $host

   XML_HOME=/root/xml
   ssh root@$stserver "cp /root/xml/$master-master.template $XML_HOME/$host.xml"
   uuid=`uuidgen`
   mac=`./genmac.py`
   echo "UUID: $uuid, MAC: $mac"
   ssh root@$stserver "sed -ie 's/MASTER/$host/g' $XML_HOME/$host.xml"
   ssh root@$stserver "sed -ie 's/UUID/$uuid/g' $XML_HOME/$host.xml"
   ssh root@$stserver "sed -ie 's/MAC/$mac/g' $XML_HOME/$host.xml"
   echo "Please remember to rename the machine to $host"
   ./cdxvm.sh start $host
   echo
   ;;
  
  destroy)
   host=$2

   is_running $host
   if [ $? = '0' ]; then
     echo "ERROR: $host is running on $runningsrv.  Stop it first!!"
     echo 
     exit 1
   fi

   if [ -z $host ]; then
     echo -e $USAGE
     exit 1
   fi

   echo -n "Are you sure you want to delete $host (Y/N)? "
   read answer

   if [ $answer ] && [ $answer = 'Y' ]; then  
     echo "Deleting $host..."
     lv=`ssh root@$stserver 'lvscan' | grep "'\/dev\/vg[0-9]\/$host'"  | awk '{print $2}' | sed s/\'//g`
     ssh root@$stserver "lvremove -f $lv"
     ssh root@$stserver "rm /root/xml/$host.xml"
     echo "Done!"
     echo
   else 
     echo "Do nothing!!"
     echo
   fi

   ;;
  mount)
   host=$2
   if [ -z $host ]; then
     echo -e $USAGE
     exit 1
   fi

   export_lvm $host
   iscsiadm -m discovery -t st -p $stserver > /dev/null 2>&1
   iscsiadm -m node -T $stserver.$host -l
   iscsiadm -m session 
   echo 
   ;;

  umount)
   host=$2
   if [ -z $host ]; then
     echo -e $USAGE
     exit 1
   fi

   iscsiadm -m node -T $stserver.$host -u
   echo
   unexport_lvm $host
   echo 
   iscsiadm -m session
   echo
   ;;
  *)
    echo -e $USAGE
    exit 1
    ;;
esac

rsync root@$stserver:/root/xml/genmac.py .
rsync root@$stserver:/root/xml/cdxvm.sh .

exit 0


