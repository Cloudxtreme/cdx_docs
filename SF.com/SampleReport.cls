public class SampleReport {
	
    private String link;
    private String sType;
    private String dailyReportID = '00O40000003GOpo';
    private String weeklyReportID = '00O40000003GOp5';

    private Map<String, Integer> getTodaySamples() {
		
    	List<CADTest__c> cadTests;
    	if (sType == 'daily') {
    		cadTests = [select Id, Clinic__c from cadtest__c where cadtest__c.Date_Sample_Received__c = TODAY ];
    		//cadTests = [select Id, Clinic__c from cadtest__c where cadtest__c.Date_Sample_Received__c = 2012-09-19 limit 10 ];
    		link = '<a href=https://na2.salesforce.com/' + dailyReportID + '>Detail</a>';
    	} else if (sType == 'weekly') {
    		cadTests = [select Id, Clinic__c from cadtest__c where cadtest__c.Date_Sample_Received__c = LAST_WEEK ];
    		link = '<a href=https://na2.salesforce.com/' + weeklyReportID + '>Detail</a>';
    	}
    	
    	System.debug('cadTest ===> ' + cadTests.size());		
		Map<String, Integer> territory2count = new Map<String, Integer>();
		for (CADTest__c cad : cadTests) {
			Account account = [select Territory__c from account where Id = :cad.Clinic__c limit 1];
			if (territory2count.containsKey(account.Territory__c)) {
				Integer i = territory2count.get(account.Territory__c);
				territory2count.put(account.Territory__c, ++i);
			} else {
				territory2count.put(account.Territory__c, 1);
			}
		}
    	return territory2count;
    }
    
   	private void sendSampleEmail(String ter, String[] emails, String msgBody, Integer trfCount) {
	    Messaging.SingleEmailMessage mail = new Messaging.Singleemailmessage();
	    mail.setToAddresses(emails);
	    mail.setSenderDisplayName('Hub Hub');
	    //mail.setCcAddresses(ccAddresses);
	    mail.setSubject('Report: ' + sType.capitalize() + ' Samples Received: ' + ter);
	    mail.setHtmlBody('Run at: ' + DateTime.now().format() + '<br>' +
	                     'Sample(s) Received Today: ' + trfCount + '<br>' +
	                     'Daily Sample Report: '+ link + '<br>' +
	                     msgBody);
	    Messaging.sendEmail(new Messaging.Singleemailmessage[] {mail});
	}
	
	private String[] getEmails(List <User> users) {
		String[] emails = new String[] {};
		for (User user : users) {
			emails.add(user.Email);
		}
		return emails;
	}
	
	public void run(String inType) {
		
		sType = inType;
		Map <String, Integer> territory2count = this.getTodaySamples();

		Integer vpTotal = 0;
		String vpStr = '';
	
		// find VP Role (there should be only one)	
		UserRole vpRole = [select Id from UserRole where Name = 'VP Sales' limit 1];
		
		// find all RM Roles under the VP
		List <UserRole> rmRoles = [select Id, Name from UserRole where ParentRoleId = :vpRole.Id];
		
		for (UserRole rmRole: rmRoles) {
			Integer rmTotal = 0;
			String rmStr = '';
			String region = rmRole.Name;
			System.debug(' Region ===> ' + region);
			
			// find all TM Roles under this RM
			List <UserRole> tmRoles = [select Id, Name from UserRole where ParentRoleId = :rmRole.Id];
			
			for (UserRole tmRole: tmRoles) {
				
				// find all TMs
				
				List <User> tms = [select Id, Name, Email from User where UserRoleId = :tmRole.Id];
				
				for (User tm: tms) {
					Integer tmTotal = 0;  
					
					Pattern tmPattern = Pattern.compile('TM - (.*), (.*)'); // Regular expression
					Matcher tmRoleMatcher = tmPattern.matcher(tmRole.Name);
					if (tmRoleMatcher.matches()) {
						String territory = tmRoleMatcher.group(1) + ' - ' + tmRoleMatcher.group(2);
						System.debug('Territory ===> ' + territory);
						
						if (territory2count.size() > 0) {
							tmTotal += territory2count.get(territory);
							String[] emails = new String[] { tm.Email };
							//this.sendSampleEmail(tmRole.Name, emails, '', tmTotal);
							rmStr += '<li>' + territory + ': ' + tmTotal + '</li>';
						}
					}
					rmTotal += tmTotal;
				}
			}
			List <User> rms = [select Email from User where UserRoleId = :rmRole.Id ];
//			String[] emails = this.getEmails(rms);
//emails = new String[] {'cchou@cardiodx.com', 'chialin668@gmail.com' };
//			this.sendSampleEmail(region, emails, '<ul>'+rmStr+'</ul>', rmTotal);
			vpStr += rmStr;
			vpTotal += rmTotal;
		}

		List <User> vps = [select Email from User where UserRoleId = :vpRole.Id ];
		String[] emails = this.getEmails(vps);
 		//this.sendSampleEmail('CardioDx', emails, '<ul>'+vpStr+'</ul>', vpTotal);
 		
	}
}
// How to run:
//  SampleReport sr = new SampleReport();
//  sr.run('daily'); | sr.run('weekly');
