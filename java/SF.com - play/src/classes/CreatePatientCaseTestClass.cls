@isTest
private class CreatePatientCaseTestClass {

    static testMethod void myUnitTest() {
		System.debug('Adding Contact with name TESTContact');
		Contact c = new Contact(LastName='TESTCONTACT', MailingState='CA');
		insert c;
		c = [select id from contact where lastname = 'TESTCONTACT'];
		
		System.debug('Adding CADTest object with the TRF id TESTTRF1');
		CADTest__c newCADTest = new CADTest__c(name = 'TESTTRF1', Physician__c = c.id, Patient_Name__c = 'TEST PATIENT');
		insert newCADTest;
		newCADTest = [select id from CADTest__c where name = :newCADTest.Name];
		
		System.debug('Adding PatientCase object associated with CADTest');
		PatientCase__c p = new PatientCase__c(CAD_Test__c = newCADTest.id);
		insert p;
		
	    //no insert the record again and see if it throws an error
	    PatientCase__c p2 = new PatientCase__c(CAD_Test__c = newCADTest.id);
	    try {
	    	insert p2;
	    } catch (DMLException e) {
	    	System.debug(e);
	    }
	    
	    //test appeal creation when status is appeals for premier source
	    p = [select id from PatientCase__c where CAD_Test__c = :newCADTest.id];
	    Carrier__c car = new Carrier__c(Name='MEDICARE1');
        insert car;
        car = [select id from Carrier__c where name='MEDICARE1'];
        
        Plan__c plan = new Plan__c(Carrier__c = car.id, name = 'MEDICARE1', Address__c = 'ADDRESS',
                                City__c = 'CITY', State__c = 'ID', Zip_Code__c = '99999',
                                Phone__c = '9999999999');
        insert plan;
        plan = [select id from Plan__c where name='MEDICARE1'];
		
		InsuranceDetail__c in1 = new InsuranceDetail__c(Patient_Case__c = p.id, Type__c = 'Primary',
		                                                Insurance__c = plan.id);
		insert in1;
		
		p.Status__c = 'Claim in Appeal';
		update p;
		
    }
}