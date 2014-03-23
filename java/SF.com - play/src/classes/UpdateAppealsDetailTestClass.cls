@isTest
private class UpdateAppealsDetailTestClass {

    static testMethod void myUnitTest() {
    	Carrier__c car = new Carrier__c(Name='MEDICARE1');
        insert car;
        car = [select id from Carrier__c where name='MEDICARE1'];
        
        Plan__c p = new Plan__c(Carrier__c = car.id, name = 'MEDICARE1', Address__c = 'ADDRESS',
                                City__c = 'CITY', State__c = 'ID', Zip_Code__c = '99999',
                                Phone__c = '9999999999');
        insert p;
        p = [select id from Plan__c where name='MEDICARE1'];
    	
        Account a = new Account(Name='TESTACCOUNT', BillingState='CA');
        insert a;
        a = [select id from account where name='TESTACCOUNT'];
        
		Contact c = new Contact(LastName='TESTCONTACT', MailingState='CA');
		insert c;
		c = [select id from contact where lastname = 'TESTCONTACT'];
		
		CADTest__c newCADTest = new CADTest__c(name = 'TESTTRF', Clinic__c = a.id, Physician__c = c.id);
		insert newCADTest;
		newCADTest = [select id from CADTest__c where name = 'TESTTRF'];
		
		PatientCase__c pc = new PatientCase__c(CAD_Test__c = newCADTest.id);
		insert pc;
		pc = [select id from patientcase__c where cad_test__c = :newCADTest.id];
		
		InsuranceDetail__c in1 = new InsuranceDetail__c(Patient_Case__c = pc.id, Type__c = 'Primary',
		                                                Insurance__c = p.id);
		insert in1;
		InsuranceDetail__c in2 = new InsuranceDetail__c(Patient_Case__c = pc.id, Type__c = 'Secondary',
		                                                Insurance__c = p.id);
		insert in2;
		InsuranceDetail__c in3 = new InsuranceDetail__c(Patient_Case__c = pc.id, Type__c = 'Secondary',
		                                                Insurance__c = p.id);   
		insert in3;
		 
		AppealDetail__c ap1 = new AppealDetail__c(Patient_Case__c = pc.id);
		try {   
		ap1.Insurance_Type__c = 'Secondary';
		insert ap1;
		} catch (DMLException e) {
			System.debug(e);
		}                   
		try {
		ap1.Insurance_Type__c = 'Other';
		insert ap1;    
		} catch (DMLException e) {
			System.debug(e);
		} 
		  
		ap1.Insurance_Type__c = 'Primary';
		insert ap1;
    }
}