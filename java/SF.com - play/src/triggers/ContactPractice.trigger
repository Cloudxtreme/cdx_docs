trigger ContactPractice on Contact (after insert, after update) {
	    Set<String> accountList = new Set<String>();
		
	    for(Contact trigC : Trigger.new) {
		if(trigC.AccountId != null && (Trigger.isInsert || trigC.AccountId != Trigger.oldMap.get(trigC.Id).AccountId)) {
			accountList.add(trigC.accountId);
		}
	    }
	    Affiliated_Account__c[] partnerList = [SELECT Main_Account__c, Affiliated_Practice_Account__c FROM Affiliated_Account__c where Main_Account__c in :accountList and Role__C like 'Practice%'];
	    Map<String, Set<String>> partnerMap = new Map<String, Set<String>>();
	    for(Affiliated_Account__c ap : partnerList) {
			if (!partnerMap.containsKey(ap.Main_Account__c)) {
				Set<String> s = new Set<String>();
				s.add(ap.Affiliated_Practice_Account__c);
				partnerMap.put(ap.Main_Account__c, s);
			}
			else {
				Set<String> s = partnerMap.get(ap.Main_Account__c);
				s.add(ap.Affiliated_Practice_Account__c);
				partnerMap.put(ap.Main_Account__c, s);
			}
	    }
	    Practicing_Locations__c[] pls = new Practicing_Locations__c[0];
	    Related_Contact__c[] rcs = new Related_Contact__c[0];
	    for(Contact trigC : Trigger.new) {
		if(trigC.AccountId != null && (Trigger.isInsert || trigC.AccountId != Trigger.oldMap.get(trigC.Id).AccountId)) {
			if(partnerMap.containsKey(trigC.AccountId)) {
				for(String partner : partnerMap.get(trigC.AccountId)) {
				    Practicing_Locations__c pl = new Practicing_Locations__c(Practice__c = partner, Provider__c = trigC.Id);
				    pls.add(pl);
				    Related_Contact__c rc = new Related_Contact__c(Account__c = partner, Contact__c = trigC.Id);
				    rcs.add(rc);
				}
			}
		}
	    }
	    insert pls;
	    insert rcs;
		
}