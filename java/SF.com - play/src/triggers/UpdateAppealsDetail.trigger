trigger UpdateAppealsDetail on AppealDetail__c (before insert) {
	for (AppealDetail__c a:Trigger.new) {
		//find insurance details
		List<InsuranceDetail__c> ins = [Select Id, Type__c, Patient_Case__c, Insurance__c From InsuranceDetail__c where patient_case__c = :a.Patient_Case__c
		                                and type__c = :a.Insurance_Type__c and Insurance_Terminated__c != true];
        String error = '';
        if (ins.size() == 0) {
        	error = 'No insurance associated with this patient case with the type - ' + a.Insurance_Type__c;
        } else if (ins.size() > 1) {
        	error = 'More than one insurance associated with this patient case with the type - ' + a.Insurance_Type__c;
        } else {
        	a.Plan__c = ins[0].insurance__c;
        }
        
        if (!error.equals('')) {a.addError(error);}
	}
}