#! /bin/sh
# $Id: asterisk,v 1.2 2004/07/18 20:24:07 Gregory Boehnlein <damin@nacs.net>
#
# asterisk      start the asterisk PBX
#
# Sun Jul 18 2004 Gregory Boehnlein <damin@nacs.net>
# - Updated Version to 1.2
# - Added test for safe_asterisk
# - Changed "stop gracefully" to "stop now"
# - Added support for -U and -G command line options
# - Modified "reload" to call asterisk -rx 'reload' 

PATH=/usr/local/sbin:/usr/local/bin:/sbin:/bin:/usr/sbin:/usr/bin
NAME=asterisk
DESC="Asterisk PBX"
DAEMON=/usr/sbin/asterisk

test -x $DAEMON || exit 0

set -e

case "$1" in
  start)
        echo -n "Starting $DESC: "
        start-stop-daemon --start --exec $DAEMON -- $ASTARGS
        echo "$NAME."
        ;;
  stop)
        echo -n "Stopping $DESC: "
        $DAEMON -rx 'stop now' > /dev/null 2> /dev/null && echo -n "$NAME"
        echo "."
        exit 0
        ;;
  reload)
        echo "Reloading $DESC configuration files."
        $DAEMON -rx 'reload' > /dev/null 2> /dev/null
        ;;
  restart|force-reload)
        $DAEMON -rx 'restart gracefully' > /dev/null 2> /dev/null && echo -n "$NAME"
        ;;
  *)
        N=/etc/init.d/$NAME
        echo "Usage: $N {start|stop|restart|reload|force-reload}" >&2
        exit 1
        ;;
esac

exit 0
