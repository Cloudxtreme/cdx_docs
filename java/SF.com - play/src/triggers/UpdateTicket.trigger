trigger UpdateTicket on Case (before insert) {
	//Trigger will auto fill account, contact, patient info when a ticket is created for a cadtest
	for (Case c : Trigger.new ) {
		
		//set business hours
		BusinessHours csHours = [select Id from businesshours where name = 'Customer Service Hours'];
        c.BusinessHoursId = csHours==null?null:csHours.Id;

        if (c.CAD_Test__c != null) {
        	//find the associated cadtest and autopopulate fields
        	CADTest__c cadtest = [select id, clinic__c, physician__c, patient_name__c, primary_phone__c,
        	                      date_sample_received__c, test_status__c from CADTest__c where id = :c.CAD_Test__c];
            if (c.AccountId == null) {c.AccountId = cadtest.Clinic__c; }
            if (c.ContactId == null) {c.ContactId = cadtest.Physician__c; }
            if (c.Patient__c == null) {c.Patient__c = cadtest.Patient_Name__c; }
            if (c.Patient_Phone__c == null) {c.Patient_Phone__c = cadtest.Primary_Phone__c; }
            
            String dsd = '';
            if (cadtest.date_sample_received__c != null) { dsd = cadtest.date_sample_received__c.format(); }
            String status = '';
            if (cadtest.Test_Status__c != null) { status = cadtest.Test_Status__c; } 
            if (c.Additional_Patient_Info__c == null) {c.Additional_Patient_Info__c = 'Date Sample Received - ' +
            										   dsd + '\nTest Status - ' + status + '\n'; }
        }
    }
}