$TTL 3D
@       IN      SOA     mentorware.com. root.mentorware.com. (
                        200408038       ; serial, todays date + todays serial #
                        8H              ; refresh, seconds
                        2H              ; retry, seconds
                        4W              ; expire, seconds
                        1D )            ; minimum, seconds
                NS      mentorware.com.
                NS      ns2.psi.net.
                MX      10 mentorware.com.  ; Primary Mail Exchanger
                TXT     "Mentorware Corporation"

localhost       A       127.0.0.1

fc3          A       192.168.2.56
        
mentorware.com.     A       192.168.2.2
ns              A       192.168.2.11
;www             A       207.159.141.192

ftp             CNAME   mentorware.com.
mail            CNAME   mentorware.com.
news            CNAME   mentorware.com.

funn            A       192.168.2.2

;
;       Workstations
;
ws-177200       A       192.168.2.200
                MX      10 mentorware.com.   ; Primary Mail Host
ws-177201       A       192.168.2.201
                MX      10 mentorware.com.   ; Primary Mail Host
ws-177202       A       192.168.2.202
                MX      10 mentorware.com.   ; Primary Mail Host
ws-177203       A       192.168.2.203
                MX      10 mentorware.com.   ; Primary Mail Host
ws-177204       A       192.168.2.204
                MX      10 mentorware.com.   ; Primary Mail Host
ws-177205       A       192.168.2.205
                MX      10 mentorware.com.   ; Primary Mail Host
; {Many repetitive definitions deleted - SNIP}
ws-177250       A       192.168.2.250
                MX      10 mentorware.com.   ; Primary Mail Host
ws-177251       A       192.168.2.251
                MX      10 mentorware.com.   ; Primary Mail Host
ws-177252       A       192.168.2.252
                MX      10 mentorware.com.   ; Primary Mail Host
ws-177253       A       192.168.2.253
                MX      10 mentorware.com.   ; Primary Mail Host
ws-177254       A       192.168.2.254
                MX      10 mentorware.com.   ; Primary Mail Host

