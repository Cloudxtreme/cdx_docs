

~~~~~~~~~~~~~~~~~~
for ubuntufw
~~~~~~~~~~~~~~~~~~

Enable natting and firewall: 
	firewall.txt

Enable IPSec: 
	ipsec.txt

Enable DMZ:
  firewall_dmz.txt
  firewall_dmz_1.txt (w/ variables)

Enable load balancer;
  load-balencing_1.txt

Managle for DMZs (so xo traffic will always go through xo interface and vice versa):
	mangle.txt

Squid:
  squid.txt

	vi /etc/init.d/firewall
        # config for squid
        iptables -t nat -A PREROUTING -i $int_if -p tcp --dport 80 -j DNAT --to 10.10.37.2:3128
        iptables -t nat -A PREROUTING -i $cc_if -p tcp --dport 80 -j REDIRECT --to-port 3128
        iptables -t nat -A PREROUTING -i $xo_if -p tcp --dport 80 -j REDIRECT --to-port 3128

  Squid reporting:
	  reporting.txt

  Squid Guard:
    squid_guard.txt
    NOTE: apparmor doesn't support squidguard

Traffice Control:
  traffic_control_subnet.txt
