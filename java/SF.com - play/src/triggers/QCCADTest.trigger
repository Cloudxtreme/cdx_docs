trigger QCCADTest on CADTest__c (after insert) {
	for (CADTest__c cad: Trigger.new) {
		//Check ICD9 codes
		String err = '';
		List<String> dcodes = new List<String>();
		dcodes.add(cad.First_Diagnosis_Code__c);
		dcodes.add(cad.Second_Diagnosis_Code__c);
		dcodes.add(cad.Third_Diagnosis_Code__c);
		dcodes.add(cad.Fourth_Diagnosis_Code__c);
		
		for(String testcode:dcodes) {
			if (testcode != null) {
				ICD9Code__c[] icd = [select id, status__c from ICD9Code__c where code__c = :testcode];
				if (icd.size() == 0) {err += 'Invalid Diagnosis Code - ' + testcode + ' \n';}
				else if (icd[0].Status__c.equals('I')) {err += 'Expired Diagnosis Code - ' + testcode + '\n'; }
			}
		}
		
		if (err.length() != 0) {
			Case c = new Case();
			c.CAD_Test__c = cad.Id;
			c.ownerid = UserInfo.getUserId();
			c.Subject = 'TRF Info Incomplete';
			c.origin = 'Other';
			c.Issue__c = 'TRF Info Incomplete';
			c.Description = err;
            insert c;
		}
		
		//now the data entry incomplete 
		String err2 = '';
		if (cad.Patient_Name__c == null || cad.Patient_Name__c.equals('')) {err2 = 'Missing patient name\n';}
		if (cad.Address__c == null || cad.Address__c.equals('')) {err2 += 'Missing patient address\n';}
		if (cad.City__c == null ||  cad.City__c.equals('')) {err2 += 'Missing city\n';}
		if (cad.State__c == null || cad.State__c.equals('')) {err2 += 'Missing state\n';}
		if (cad.Zip_Code__c == null || cad.Zip_Code__c.equals('')) {err2 += 'Missing zip code\n';}
		if (cad.Primary_Phone__c == null || cad.Primary_Phone__c.equals('')) {err2 += 'Missing patient phone\n';}
		if (cad.DOB__c == null ) {err2 += 'Missing DOB\n';}
		else if (cad.DOB__c >= System.today()) {err2+='DOB in the future\n';}
		if (cad.Date_Sample_Taken__c == null ) {
			err2 += 'Missing date sample taken\n';
		} else if (cad.Date_Sample_Taken__c >= System.today()) {
			err2 += 'Date sample taken in the future\n';
		} else if (cad.Date_Sample_Taken__c < System.today() - 5) {
			err2 += 'Date sample taken more than 6 days ago\n';
		}
		if (!cad.Do_Not_Bill__c && (cad.Method_of_Payment__c == null || cad.Method_of_Payment__c.equals(''))) {err2 += 'Missing Method of Payment\n';}
		if (cad.First_Diagnosis_Code__c == null || cad.First_Diagnosis_Code__c.equals('')) {err2 += 'Missing ICD Code\n';}
		
		Contact p = [select id, name, npi__c from contact where id = :cad.Physician__c];
		if (p.npi__c == null || p.npi__c.equals('')) {err2 += 'Missing physician npi\n';}
			
		if (err2.length() != 0) {
			Case c = new Case();
			c.ownerid = UserInfo.getUserId();
			c.CAD_Test__c = cad.Id;
			c.subject = 'Data Entry Incomplete';
			c.origin = 'Other';
			c.description = err2;
			insert c;
		}	
	}
}