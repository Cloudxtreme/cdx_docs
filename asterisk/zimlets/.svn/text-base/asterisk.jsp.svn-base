<%@ page language="java"
         import="java.io.*,java.net.*,java.util.*,javax.sip.*,javax.sip.address.*,javax.sip.header.*,javax.sip.message.*,java.security.MessageDigest,java.security.NoSuchAlgorithmException,javax.naming.*,javax.naming.directory.*,java.util.Hashtable" 
%>
<%@ taglib prefix="z" uri="/WEB-INF/zimbra.tld" %>
<z:zimletconfig var="config" action="list" zimlet="com_zimbra_asterisk"/>
<%

	final class Invite {

		private Request request;
		private String sipHost;
		private String from;
		private String to;
		private String toList;
		private String user;
		private String pass;
		private String login;
		public String myAddress;
		public String myBaseDN;
		public String ldapServer;
		private Boolean debug;

	public String ldapSearch(String url, String base, String filter, String attr) {

		try {
		    DirContext ctx = new InitialDirContext();
			SearchControls sc = new SearchControls();
			sc.setSearchScope(SearchControls.SUBTREE_SCOPE);

	   	 	NamingEnumeration enumer = ctx.search(url+base, filter, sc);

        	try {
				while (enumer.hasMore()) {
					SearchResult sr = (SearchResult)enumer.next();
					Attributes attributes=sr.getAttributes();
					return attributes.get(attr).get().toString();
				}
			} catch (NamingException e) {
				e.printStackTrace();
				return null;
			}
		
	  	  	ctx.close();

		} catch (NamingException e) {
	    	e.printStackTrace();
			return null;
		}

		return null;
    }



	public String call(String sipHost, String caller, String callee, boolean debug) {
        Socket smtpSocket = null;  
        DataOutputStream os = null;
        DataInputStream is = null;

        try {
            smtpSocket = new Socket(sipHost, 5038);
            os = new DataOutputStream(smtpSocket.getOutputStream());
            is = new DataInputStream(smtpSocket.getInputStream());
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + sipHost);
	    	e.printStackTrace();
			return null;
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " +  sipHost);
	    	e.printStackTrace();
			return null;
        }

        if (smtpSocket != null && os != null && is != null) {
            try {
				os.writeBytes("Action: Login\r\n");
				os.writeBytes("Username: test\r\n");
				os.writeBytes("Secret: footest\r\n");
				os.writeBytes("\r\n");
				
				os.writeBytes("Action: Originate\r\n");
				os.writeBytes("Channel: SIP/" + caller + "\r\n");
				os.writeBytes("Variable: CALLERID(num)=" + caller + "\r\n");
				os.writeBytes("Exten: " + callee + "\r\n");
				os.writeBytes("Context: default\r\n");
				os.writeBytes("Priority: 1\r\n");
				os.writeBytes("\r\n");

				while(is.readLine() != null) {
					String retStr = is.readLine();
					if (retStr.matches(".*failed")) {
						if (debug)
							System.out.println("Call rejected");
						os.writeBytes("Action: Logoff\r\n");
						os.writeBytes("\r\n");
						return "Rejected by caller.";

					} else if (retStr.matches(".*queued")) {
						if (debug)
							System.out.println("Call accepted");
						os.writeBytes("Action: Logoff\r\n");
						os.writeBytes("\r\n");
						return "Calling " + callee;
					} else {
						//System.out.println(retStr);
					}
				}
				
        		os.close();
                is.close();
                smtpSocket.close();   

            } catch (UnknownHostException e) {
                System.err.println("Trying to connect to unknown host: " + e);
	    		e.printStackTrace();
				return null;
            } catch (IOException e) {
                System.err.println("IOException:  " + e);
	    		e.printStackTrace();
				return null;
            }
        }
		return "Unknown error";
    }           
	


		public String init(String args[]) {

			myAddress = args[0];
			myBaseDN = args[1];
			ldapServer = args[2];
			sipHost = args[3];
			toList = args[4];
			login = args[5];
			String prefix = args[6];
			String dbg = args[7];

			// get the phone number for the caller
			String ldapPhoneNumber = this.ldapSearch( "ldap://"+ldapServer+":389/", myBaseDN, "(uid="+login+")", "telephoneNumber");
			if (ldapPhoneNumber == null) {
				String msgStr = "ldapServer: " + ldapServer
							+ ", myBaseDN: " + myBaseDN
							+ ", login: " + login;
				System.out.println("Failed to retrieve phone number from ldap!! "+msgStr+"]\n\n");
				return "LDAP failed";
			}

			from=ldapPhoneNumber;

			user = from;
			pass = from + "polycom";
			
			if (dbg.equals("true")) {
            	String msgStr = "myAddress: " + myAddress
					+ ", myBaseDN: " + myBaseDN
					+ ", ldapServer: " + ldapServer
					+ ", sipHost: " + sipHost
					+ ", from: " + from
					+ ", toList: " + toList
					+ ", user: " + user
					+ ", pass: "+ pass
					+ ", login: "+ login
					+ ", prefix: "+ prefix
					+ ", dbg: " + dbg;

				System.out.println ("Asterisk debug mode on\n\n"+msgStr+"\n\n");
				debug = true;
			} else {
				debug = false;
			}

			if (debug)  {
				System.out.println("Calling from " + from + " to " + toList);
			}

			String retStr=this.call(sipHost, from, toList, debug);
			if(retStr==null) {
				System.out.println("Call failed!!  From " + from + " to " + toList);
				return "Call failed!! From " + from + " to " + toList;
			} else {
				System.out.println("Call successfully established from " + from + " to " + toList);
				return retStr;
			}
		}
	}

	Map zConfig = (Map) request.getAttribute("config");
	String sipHost = (String) ((Map) zConfig.get("global")).get("sipHost");
	String myAddress = (String) ((Map) zConfig.get("global")).get("myAddress");
	String myBaseDN = (String) ((Map) zConfig.get("global")).get("myBaseDN");
	String ldapServer = (String) ((Map) zConfig.get("global")).get("ldapServer");
	String prefix = (String) ((Map) zConfig.get("global")).get("prefix");
	String debug = (String) ((Map) zConfig.get("global")).get("debug");

	// cc NOTE: reverse from and to
	String to = request.getParameter("to");
	String login = request.getParameter("login");

	to = java.net.URLDecoder.decode(to, "UTF8");
	login = java.net.URLDecoder.decode(login, "UTF8");

	to = to.replace("(", "");
	to = to.replace(")", "");
	to = to.replace("-", "");
	to = to.replace(".", "");
	to = to.trim();

	String args[] = {myAddress, myBaseDN, ldapServer, sipHost, to, login, prefix, debug};
	String foo = new Invite().init(args);
	out.println(foo);
%>

