trigger AffiliatedAccount on Affiliated_Account__c (after insert, after update, after delete) {
	if(Trigger.isInsert) {
		Affiliated_Account__c[] toAdd = new Affiliated_Account__c[0];
		for(Affiliated_Account__c ac : Trigger.New) {
			if(ac.Main_Account__c != null && ac.Affiliated_Practice_Account__c != null) {
				Integer found = [Select count() from Affiliated_Account__c where Main_Account__c = :ac.Affiliated_Practice_Account__c AND Affiliated_Practice_Account__c = :ac.Main_Account__c];
				if(found == 0) {
					if(ac.Role__c == 'Practice - Main')
					toAdd.add(new Affiliated_Account__c(Main_Account__c = ac.Affiliated_Practice_Account__c, Affiliated_Practice_Account__c = ac.Main_Account__c, Role__c = 'Practice - Satellite'));
					if(ac.Role__c == 'Practice - Satellite')
					toAdd.add(new Affiliated_Account__c(Main_Account__c = ac.Affiliated_Practice_Account__c, Affiliated_Practice_Account__c = ac.Main_Account__c, Role__c = 'Practice - Main'));
					if(ac.Role__c == 'Lab')
					toAdd.add(new Affiliated_Account__c(Main_Account__c = ac.Affiliated_Practice_Account__c, Affiliated_Practice_Account__c = ac.Main_Account__c, Role__c = 'Practice'));
					if(ac.Role__c == 'Practice')
					toAdd.add(new Affiliated_Account__c(Main_Account__c = ac.Affiliated_Practice_Account__c, Affiliated_Practice_Account__c = ac.Main_Account__c, Role__c = 'Lab'));
					if(ac.Role__c == 'Hospital')
					toAdd.add(new Affiliated_Account__c(Main_Account__c = ac.Affiliated_Practice_Account__c, Affiliated_Practice_Account__c = ac.Main_Account__c, Role__c = 'Physician Practice'));
					if(ac.Role__c == 'Physician Practice')
					toAdd.add(new Affiliated_Account__c(Main_Account__c = ac.Affiliated_Practice_Account__c, Affiliated_Practice_Account__c = ac.Main_Account__c, Role__c = 'Hospital'));
				}
			}
		}
		insert toAdd;
	}
	else if(Trigger.isUpdate) {
		Affiliated_Account__c[] toUpdate = new Affiliated_Account__c[0];
		for(Affiliated_Account__c ac : Trigger.New) {
			if(ac.Main_Account__c != null && ac.Affiliated_Practice_Account__c != null && (ac.Affiliated_Practice_Account__c != Trigger.oldMap.get(ac.Id).Affiliated_Practice_Account__c || ac.Role__c != Trigger.oldMap.get(ac.Id).Role__C)) {
				Affiliated_Account__c[] updates = [Select Id, Affiliated_Practice_Account__c, Main_Account__c from Affiliated_Account__c where Main_Account__c = :Trigger.oldMap.get(ac.Id).Affiliated_Practice_Account__c AND Affiliated_Practice_Account__c = :Trigger.oldMap.get(ac.Id).Main_Account__C];
				for(Affiliated_Account__c a : updates) {
					a.Affiliated_Practice_Account__c = ac.Main_Account__c;
					if(ac.Role__c == 'Practice - Main')
						a.Role__c = 'Practice - Satellite';
					if(ac.Role__c == 'Practice - Satellite')
						a.Role__c = 'Practice - Main';
					if(ac.Role__c == 'Lab')
						a.Role__c = 'Practice';
					if(ac.Role__c == 'Practice')
						a.Role__c = 'Lab';
					if(ac.Role__c == 'Hospital')
						a.Role__c = 'Physician Practice';
					if(ac.Role__c == 'Physician Practice')
						a.Role__c = 'Hospital';
					toUpdate.add(a);
				}
			}
		}
		update toUpdate;
	}
	else if(Trigger.isDelete) {
		Affiliated_Account__c[] toDelete = new Affiliated_Account__c[0];
		for(Affiliated_Account__c ac : Trigger.Old) {
			if(ac.Main_Account__c != null && ac.Affiliated_Practice_Account__c != null) {
				Affiliated_Account__c[] deletes = [Select Id, Affiliated_Practice_Account__c, Main_Account__c from Affiliated_Account__c where Main_Account__c = :ac.Affiliated_Practice_Account__c AND Affiliated_Practice_Account__c = :ac.Main_Account__c];
				for(Affiliated_Account__c a : deletes) {
					toDelete.add(a);
				}
			}
		}
		delete toDelete;
	}		
}