trigger AffiliatedAccountContactInfo on Affiliated_Account__c (after insert) {
	    Contact[] c;
	    Set<String> accountList = new Set<String>();
	    for(Affiliated_Account__c trigP : Trigger.new) {
		if(trigP.Role__c.contains('Practice')) {
			accountList.add(trigP.Main_Account__c);
		}
	    }
	    c = [Select Id, AccountId from Contact where AccountId in :accountList];
	    Map<String, Set<String>> contactMap = new Map<String, Set<String>>();
	    for(Contact cont : c) {
			if (!contactMap.containsKey(cont.AccountId)) {
				Set<String> s = new Set<String>();
				s.add(cont.Id);
				contactMap.put(cont.AccountId, s);
			}
			else {
				Set<String> s = contactMap.get(cont.AccountId);
				s.add(cont.Id);
				contactMap.put(cont.AccountId, s);
			}
	    }
	    Practicing_Locations__c[] pls = new Practicing_Locations__c[0];
	    Related_Contact__c[] rcs = new Related_Contact__c[0];
	    for(Affiliated_Account__c trigP : Trigger.new) {
		if(trigP.Role__c.contains('Practice')) {
			if(contactMap.containsKey(trigP.Main_Account__c)) {
				for(String contact : contactMap.get(trigP.Main_Account__c)) {
				    Practicing_Locations__c pl = new Practicing_Locations__c(Practice__c = trigP.Affiliated_Practice_Account__c, Provider__c = contact);
				    pls.add(pl);
				    rcs.add(new Related_Contact__C(Account__c = trigP.Affiliated_Practice_Account__c, Contact__C = contact));
				
				}
			}
	    }	}
	    insert pls;
	    insert rcs;
		
}