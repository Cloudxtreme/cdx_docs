trigger createPatientCase on PatientCase__c (before insert, after update) {
	//for (PatientCase__c p : Trigger.new) {
    for (Integer i = 0; i < Trigger.new.size(); i++) {
    	PatientCase__c p = Trigger.new[i];
    	
		if (Trigger.isBefore) {
	        //a cadtest can only have one patient case, check if a patient case has been created for this cadtest
	        Integer j = [select count() from PatientCase__c where CAD_Test__c = :p.CAD_Test__c];
	        if (j != 0) { p.addError('A patient case has already been created for this CADTest'); }
	        
	        //add the patient name to enable search
	        CADTest__c c = [select id, patient_name__c from CADTest__c where id = :p.CAD_Test__c];
	        p.Patient_Full_Name__c = c.patient_name__c;
		}
			
		if (Trigger.isUpdate) { 
			Map <String, String> ss = new Map<String, String> {
				'Denied - LOMN/Chart Notes' => 'LOMN/Chart Notes',
				'Denied - Investigation' => 'Investigation',
				'Denied - Provider Not Contracted' => 'Provider Not Contracted',
				'Approved' => 'In-Network Processing',
				'Paid' => 'Underpayment'
			};
			
			// underpayment, in-network processing and provider not contracted appeals will auto-assign to Victoria
			Map <String, String> su = new Map<String, String> {
				'Denied - LOMN/Chart Notes' => 'Shubha Shetty',
				'Denied - Investigation' => 'Shubha Shetty',
				'Denied - Provider Not Contracted' => 'Victoria McGill',
				'Approved' => 'Victoria McGill',
				'Paid' => 'Victoria McGill'
			};
			
			PatientCase__c oldp = Trigger.old[i];
			if (p.Status__c =='Claim in Appeal' && oldp.Status__c != 'Claim in Appeal') {
				String uname = su.get(p.Primary_Status__c);
				if (uname == null) {uname = 'Victoria McGill'; }
				User u = [select id from User where name = :uname];
				AppealDetail__c ad  = new AppealDetail__c();
				ad.Patient_Case__c = p.id;
				ad.OwnerId = u.id;
				ad.Appeal_Type__c = 'First Appeal';
				ad.Insurance_Type__c = 'Primary';
			 	ad.Appeal_Reason__c = ss.get(p.Primary_Status__c);
				insert ad;
			}
		}
	}//end for
}//end trigger