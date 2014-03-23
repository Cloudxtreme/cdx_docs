@isTest
private class UpdateCADTestNumTestClass {

    static testMethod void myUnitTest() {
        System.debug('Adding Account, Contact with name TESTContact');
		Account a = new Account(Name='TESTACCOUNT', BillingState='CA');
		insert a;
		a = [select id from account where name='TESTACCOUNT'];
		
		Contact c = new Contact(LastName='TESTCONTACT', MailingState='CA', AccountId=a.id);
		insert c;
		c = [select id from contact where lastname = 'TESTCONTACT'];
		
		System.debug('Adding CADTest object with the TRF id TESTTRF1'); //V85.33,V85.34,V85.35
		CADTest__c newCADTest = new CADTest__c(name = 'TESTTRF1', Physician__c = c.id, Clinic__c = a.id, Test_Status__c = 'Completed',
											   First_Diagnosis_Code__c='786.05', Second_Diagnosis_Code__c='401.1', 
											   Third_Diagnosis_Code__c='272.0', Fourth_Diagnosis_Code__c='278.00',
											   Gender__c = 'Male',
											   DOB__c = Date.parse('1/1/1900'), Date_Sample_Taken__c=Date.parse('8/15/10'));
		insert newCADTest;
		newCADTest = [select id, clinic__c, physician__c, test_status__c from CADTest__c where name = :newCADTest.Name];
		
		//insert a cad test
		a = [select id, num_of_Corus_CAD_Tests__c from account where name='TESTACCOUNT'];
		c = [select id, num_of_Corus_CAD_Tests__c from contact where lastname = 'TESTCONTACT'];		
        System.assertEquals(a.num_of_Corus_CAD_Tests__c, 1);
        System.assertEquals(c.num_of_Corus_CAD_Tests__c, 1);      
        
        //delete a cad test
        delete newCADTest;
        a = [select id, num_of_Corus_CAD_Tests__c from account where name='TESTACCOUNT'];
		c = [select id, num_of_Corus_CAD_Tests__c from contact where lastname = 'TESTCONTACT'];		
        System.assertEquals(a.num_of_Corus_CAD_Tests__c, 0);
        System.assertEquals(c.num_of_Corus_CAD_Tests__c, 0);      
        
        //create 2 cadtests, update one of them
        newCADTest = new CADTest__c(name = 'TESTTRF2', Physician__c = c.id, Clinic__c = a.id, Test_Status__c = 'Completed',
        							First_Diagnosis_Code__c='277.7', Second_Diagnosis_Code__c='433.10', 
									Third_Diagnosis_Code__c='414.01', Fourth_Diagnosis_Code__c = 'V17.3', Gender__c = 'Male',
								    DOB__c = Date.parse('1/1/1900'), Date_Sample_Taken__c=Date.parse('8/15/10'));
		insert newCADTest;
		
        newCADTest = new CADTest__c(name = 'TESTTRF3', Physician__c = c.id, Clinic__c = a.id, Test_Status__c = 'Completed',
       								First_Diagnosis_Code__c='305.1', Second_Diagnosis_Code__c='400.20', 
									Third_Diagnosis_Code__c='277.7', Gender__c = 'Male',
								    DOB__c = Date.parse('1/1/1900'), Date_Sample_Taken__c=Date.parse('8/15/10'));
		insert newCADTest;
		newCADTest = [select id, clinic__c, physician__c, test_status__c from CADTest__c where name = :newCADTest.Name];
		
        //update a cad test
        newCADTest.Test_Status__c = 'In Progress';
        newCADTest.Do_Not_Bill__c = true;
        update newCADTest;  
        
        a = [select id, num_of_Corus_CAD_Tests__c from account where name='TESTACCOUNT'];
		c = [select id, num_of_Corus_CAD_Tests__c from contact where lastname = 'TESTCONTACT'];		
        System.assertEquals(a.num_of_Corus_CAD_Tests__c, 1);
        System.assertEquals(c.num_of_Corus_CAD_Tests__c, 1);    
        
        //reset cad test
        Account a2 = new Account(Name='TESTACCOUNT2', BillingState='CA');
		insert a2;
		a2 = [select id from account where name='TESTACCOUNT2'];
		c.AccountId = a2.id;
		update c;
		
		newCADTest.Test_Status__c = 'Completed';
        newCADTest.Do_Not_Bill__c = false;
        newCADTest.Clinic__c = a2.id;
        newCADTest.First_Diagnosis_Code__c = '401.1';
        newCADTest.Second_Diagnosis_Code__c = '272.2';
        newCADTest.Third_Diagnosis_Code__c = '278.00';
        newCADTest.Fourth_Diagnosis_Code__c = '277.7';
        newCADTest.Gender__c = 'Male';
        newCADTest.DOB__C = Date.parse('1/1/1900');
        newCADTest.Date_Sample_Taken__c=Date.parse('8/15/10');
        update newCADTest;
        
        a2 = [select id, num_of_Corus_CAD_Tests__c from account where name='TESTACCOUNT2'];	
        System.assertEquals(a2.num_of_Corus_CAD_Tests__c, 2);
        
        //create patient case, test patient name update
        PatientCase__c p = new PatientCase__c(cad_test__c = newCADTest.Id);
        insert p;
        
        newCADTest.Patient_Name__c = 'TEST PATIENT';
        update newCADTest;
        
    }
}