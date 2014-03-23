trigger UpdatePaymentDetail on PaymentDetail__c (before insert) {	
	for (PaymentDetail__c p:Trigger.new) {
		if (p.Payer__c != null && (p.Payer__c.equals('Primary Insurance') || p.Payer__c.equals('Secondary Insurance'))) {
			String s = p.Payer__c.replaceAll('Insurance$', '').trim();
			
			List<InsuranceDetail__c> ins = [Select Id, Patient_Case__c, type__c, insurance__c
		    	                            From InsuranceDetail__c
		        	                        where patient_case__c = :p.Patient_Case__c
		            	                    and type__c = :s 
		            	                    and Insurance_Terminated__c != true];
        	String error = '';
        	if (ins.size() == 0) {
        		error = 'No insurance associated with this patient case with the type - ' + p.Payer__c;
        	} else if (ins.size() > 1) {
        		error = 'More than one insurance associated with this patient case with the type - ' + p.Payer__c;
        	} else {
        		p.Plan__c = ins[0].insurance__c;
        	}
        
        	if (!error.equals('')) {p.addError(error);}
		}
	}
}