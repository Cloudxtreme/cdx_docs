@isTest
private class QCCADTestTestClass {

    static testMethod void myUnitTest() {
    	ICD9Code__c code = new ICD9Code__c(Code__c='1', status__c='C');
    	insert code;
    	code = new ICD9Code__c(Code__c='2', status__c='I');
    	insert code;
    	
    	
		Account a = new Account(Name='TESTACCOUNT', BillingState='CA');
		insert a;
		a = [select id from account where name='TESTACCOUNT'];
		
		Contact c = new Contact(LastName='TESTCONTACT', MailingState='CA');
		insert c;
		c = [select id from contact where lastname = 'TESTCONTACT'];
		
		CADTest__c newCADTest = new CADTest__c(name = 'TESTTRF1', Physician__c = c.id, Clinic__c = a.id, Test_Status__c = 'Completed');
		newCADTest.First_Diagnosis_Code__c = '1';
		newCADTest.Second_Diagnosis_Code__c = '2';
		newCADTEst.Third_Diagnosis_Code__c = '3';
		insert newCADTest;
        
		//test future
		newCADTest = new CADTest__c(name = 'TESTTRF2', Physician__c = c.id, Clinic__c = a.id, Test_Status__c = 'Completed');
		newCADTest.DOB__c = System.today() + 1;
		newCADTest.Date_Sample_Taken__c = System.today() + 1;
		insert newCADTest;
		
		//test past
		newCADTest = new CADTest__c(name = 'TESTTRF3', Physician__c = c.id, Clinic__c = a.id, Test_Status__c = 'Completed');
		newCADTest.Date_Sample_Taken__c = System.today() - 7;
		insert newCADTest;
		
		List<CADTest__c> cids = [select id from CADTest__c where name in ('TESTTRF1', 'TESTTRF2', 'TESTTRF3')];
		Case[] ca = [select id, subject, description from case where cad_test__c in (:cids[0].id, :cids[1].id, :cids[2].id)];
	    System.assert(ca.size() > 0 ); 
	    for(Case cc:ca ){
	    	System.debug(cc.subject);
	    	System.debug(cc.description);
	    }   
    }
}