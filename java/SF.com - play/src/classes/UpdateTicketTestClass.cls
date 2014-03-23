@isTest
private class UpdateTicketTestClass {
	
    static testMethod void myUnitTest() {
		System.debug('Adding Account, Contact with name TESTContact');
		Account a = new Account(Name='TESTACCOUNT', BillingState='CA');
		insert a;
		a = [select id from account where name='TESTACCOUNT'];
		
		Contact c = new Contact(LastName='TESTCONTACT', MailingState='CA');
		insert c;
		c = [select id from contact where lastname = 'TESTCONTACT'];
		
		System.debug('Adding CADTest object with the TRF id TESTTRF1');
		CADTest__c newCADTest = new CADTest__c(name = 'TESTTRF1', Physician__c = c.id, Clinic__c = a.id);
		newCADTest.Date_Sample_Received__c = Date.parse('1/1/2009');
		newCADTest.Patient_Name__c = 'NEWPATIENT NAME';
		newCADTest.Primary_Phone__c = '(000)000-0000';
		newCADTest.Test_Status__c = 'In Progress';
		insert newCADTest;
		newCADTest = [select id, clinic__c, physician__c, patient_name__c, primary_phone__c, date_sample_received__c, test_status__c from CADTest__c where name = :newCADTest.Name];
		
		System.debug('Create ticket associated with CADTest');
		Case ticket = new Case(CAD_Test__c = newCADTest.id);
		insert ticket;
		
		ticket = [select id, accountid, contactid, patient__c, patient_phone__c, additional_patient_info__c, businessHoursId from case where cad_test__c = :newCADTest.id].get(0);
        System.assertEquals(ticket.AccountId, newCADTest.Clinic__c);
        System.assertEquals(ticket.ContactId, newCADTest.Physician__c);
        System.assertEquals(ticket.patient__c, newCADTest.Patient_Name__c);
        System.assertEquals(ticket.patient_phone__c, newCADTest.Primary_Phone__c);
        System.assert(ticket.additional_patient_info__c != null);
        System.assert(ticket.BusinessHoursId != null);
    }
    
}