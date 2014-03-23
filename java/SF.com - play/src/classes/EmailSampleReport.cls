public class EmailSampleReport {

	//east coast
    public static final Map<String,String> elist1 = new Map<String, String> {
		'Georgia'=>'dburgess@cardiodx.com',
		'Illinois'=>'lschoch@cardiodx.com',
		'Kentucky'=>'ktackett@cardiodx.com',
		'Louisiana'=>'mkemp@cardiodx.com',
		'Minnesota'=>'lschoch@cardiodx.com',
		'North Carolina'=>'rkelsey@cardiodx.com',
		'Ohio'=>'kmiller@cardiodx.com',
		'Pennsylvania' => 'jeberhard@cardiodx.com',
		'South Carolina'=>'bbarnette@cardiodx.com'
	}; 
    
    //west coast  
    public static final Map<String,String> elist2 = new Map<String, String> {
    	'House'=>'lschoch@cardiodx.com',
		'Arizona'=> 'duane@cardiodx.com',
		'Colorado'=> 'lschoch@cardiodx.com',
		'Dallas'=>'dbredthauer@cardiodx.com',
		'Houston'=>'khebert@cardiodx.com',
		'Southern CA'=> 'jbear@cardiodx.com'
	}; 
           
    /* Master List 
        'House'=>'lschoch@cardiodx.com',
		'Arizona'=> 'duane@cardiodx.com',
		'Colorado'=> 'kbaughman@cardiodx.com',
		'Dallas'=>'dbredthauer@cardiodx.com',
		'Houston'=>'khebert@cardiodx.com',
		'Georgia'=>'dburgess@cardiodx.com',
		'Illinois'=>'sfrydryk@cardiodx.com',
		'Kentucky'=>'ktackett@cardiodx.com',
		'Louisiana'=>'mkemp@cardiodx.com',
		'Minnesota'=>'bolson@cardiodx.com',
		'North Carolina'=>'rkelsey@cardiodx.com',
		'Ohio'=>'kmiller@cardiodx.com',
		'Pennsylvania' => 'jeberhard@cardiodx.com',
		'Southern CA'=> 'jbear@cardiodx.com',
		'South Carolina'=>'bbarnette@cardiodx.com'  
    */
                                                                 
    public static final String weekdayreportlink = '<a href=https://na2.salesforce.com/00O400000023fup>Click Here</a>';
    public static final String weekendreportlink = '<a href=https://na2.salesforce.com/00O400000023gHP>Click Here</a>';
    private String link = weekdayreportlink;
    
    private String getWeekday() {
    	List<String> weekdays = new List<String> {'Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'};
    	Integer i = math.mod(Date.newInstance(1900,1,7).daysBetween(Date.today()), 7);
    	system.debug('Today is a ' + weekdays.get(i));
 		return weekdays.get(i);
    }
    
    private Map<String, Integer> getTodaySamples() {
    	Date d = Date.today();
    	
    	//if monday then pick another report and query 2 days past
    	if (getWeekday() == 'Monday') {
    		d = d - 2;
    		link = weekendreportlink;
    	 }
 		System.debug('query date =' + d);
 		
    	List<CADTest__c> ss = [select cadtest__c.Id, cadtest__c.Physician__c from cadtest__c where cadtest__c.Date_Sample_Received__c >= :d];
		System.debug(ss.size() + ' samples found');
		
		//<territory, # of cad>
		Map<String, Integer> mp = new Map<String, Integer>();
		for (CADTest__c cad : ss) {
			Contact con = [select contact.id, contact.Territory_1__c from contact where contact.id = :cad.Physician__c];
			if (mp.containsKey(con.Territory_1__c)) {
				Integer i = mp.get(con.Territory_1__c);
				mp.put(con.Territory_1__c, ++i);
			} else {
				mp.put(con.Territory_1__c, 1);
			}
		}
    	return mp;
    }
    
    private void sendSampleEmail(String ter, String addr, Integer num) {
	    Messaging.SingleEmailMessage mail = new Messaging.Singleemailmessage();
	    String[] plist = new String[] {addr};
	    String[] clist = new String[] {'blin@cardiodx.com', 'jschoenmoser@cardiodx.com'};
	    mail.setToAddresses(plist);
	    mail.setCcAddresses(cList);
	    mail.setSenderDisplayName('Hub Hub');
	    //mail.setBccSender(true);
	    mail.setSubject('Report: Daily Samples Received run at ' + DateTime.now().format());
	    mail.setHtmlBody('<Strong>Daily Samples Received</strong><br><br>Run at: ' + DateTime.now().format() + '<br>' +
	    				 'Territory: ' + ter + '<br>' +
	                     'Sample(s) Received Today: ' + num + '<br>' +
	                     'Daily Sample Report: '+ link + '<br><br>' +
	                     '<small>NOTE: Monday\'s report will also include any samples received on the prior Saturday.</small>');
	    Messaging.sendEmail(new Messaging.Singleemailmessage[] {mail});
    }
    
    public static void mailReport(String whatcoast) {
    	EmailSampleReport e = new EmailSampleReport();
    	Map<String, Integer> m = e.getTodaySamples();
    	Map<String,String> elist = elist1; //defaults to west coast
    	if (whatcoast != null && whatcoast.equals('East')) {elist = elist2;}

        for(String ter: m.keySet()) {
        	if (elist.get(ter) == null) {continue;}
        	system.debug('Territory: ' + ter);
        	system.debug('Address: ' + elist.get(ter));
        	e.sendSampleEmail(ter, elist.get(ter), m.get(ter));
        }
    }
}