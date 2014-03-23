@isTest
private class TestEmailSampleReport {

    static testMethod void myUnitTest() {
    	Account a = new Account(Name='TESTACCOUNT', BillingState='CA', territory__c='House');
		insert a;
		a = [select id from account where name='TESTACCOUNT'];
		
		Contact c = new Contact(LastName='TESTCONTACT', MailingState='CA', AccountId = a.Id);
		insert c;
		c = [select id from contact where lastname = 'TESTCONTACT'];
		
		CADTest__c newCADTest = new CADTest__c(name = 'TESTTRF1', Physician__c = c.id, Clinic__c = a.id, Test_Status__c = 'Completed');
		newCADTest.Date_Sample_Received__c = Date.today();
		insert newCADTest;
		
        CADTest__c newCADTest2 = new CADTest__c(name = 'TESTTRF2', Physician__c = c.id, Clinic__c = a.id, Test_Status__c = 'Completed');
		newCADTest2.Date_Sample_Received__c = Date.today();
		insert newCADTest2;
		
		Test.starttest();
        EmailSampleReport.mailReport('East');
        //EmailSampleReport.mailReport('West');
        Test.stoptest();
    }
}