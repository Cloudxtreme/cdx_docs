public class ValidateTestMaterialTestClass {

    static testMethod void testValidateTestMaterial() {

        // need CADTest, Account, Lot, Inventory, Contact
        LotMasterRecord__c lmr = new LotMasterRecord__c (name = 'TESTLOT001');
        insert lmr;

        Account newAcct = new Account (name = 'TESTACCT001', BillingState='CA');
        insert (newAcct);
       
        Contact newContact = new Contact (LastName = 'TESTCONTACT001', MailingState='CA');
        insert (newContact);

        CADTest__c newCADTest = new CADTest__c(name = 'TESTTRF1', Physician__c = newContact.id,  Clinic__c = newAcct.id, Test_Status__c = 'Completed');
        insert (newCADTest);
        
        test.starttest();
        
        // test missing kit lot number
        TestMaterial__c tm; 
        List<Case> cs; 
        
        tm = new TestMaterial__c (CADTest__c = newCADTest.id);
        insert tm;
        
        cs = [select id from Case where CAD_Test__c = :newCADTest.id and subject = 'Missing kit lot number'];
    	System.assertNotEquals(cs.size(), 0);    
    	
        // test incorrect kit lot number
    	tm.Kit_Lot_Number__c = 'ALOTDOESNOTEXISTS'; 
    	update tm;
        cs = [select id from Case where CAD_Test__c = :newCADTest.id and subject = 'Invalid lot number'];
    	System.assertNotEquals(cs.size(), 0);    
    	
    	/*
        // check if there is an inventory that belong to the lot number and the account
    	tm.Kit_Lot_Number__c = 'TESTLOT001'; 
    	update tm;
        cs = [select id from Case where CAD_Test__c = :newCADTest.id and subject = 'Missing inventory'];
    	System.assertNotEquals(cs.size(), 0);    
    	*/
        
        test.stoptest(); 
        
    }
}