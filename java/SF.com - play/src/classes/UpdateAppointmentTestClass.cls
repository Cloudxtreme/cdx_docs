@isTest
private class UpdateAppointmentTestClass {

    static testMethod void myUnitTest() {
        System.debug('Adding Account, Contact with name TESTContact');
		Account a = new Account(Name='TESTACCOUNT', BillingState='CA');
		insert a;
		a = [select id from account where name='TESTACCOUNT'];
		
		Contact c = new Contact(LastName='TESTCONTACT', MailingState='CA', AccountId=a.id);
		insert c;
		c = [select id from contact where lastname = 'TESTCONTACT'];
		
		PhlebotomyAppointment__c p = new PhlebotomyAppointment__c(physician__c = c.id);
		insert p;
		
		p = [select clinic__c from phlebotomyappointment__c where physician__c = :c.id];
		System.assertNotEquals(p.clinic__c, null);
    }
}