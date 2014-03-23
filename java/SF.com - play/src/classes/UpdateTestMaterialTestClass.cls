public class UpdateTestMaterialTestClass {

    static testMethod void testUpdateTestMaterial() {

        // need CADTest, Account, Lot, Inventory, Contact
        LotMasterRecord__c lmr = new LotMasterRecord__c (name = 'TESTLOT001');
        insert lmr;

        Account acct = new Account (name = 'TESTACCT001', BillingState='CA');
        insert (acct);
       
        Contact cont = new Contact (LastName = 'TESTCONTACT001', MailingState='CA');
        insert (cont);

        CADTest__c cad = new CADTest__c(name = 'TESTTRF1', Physician__c = cont.id,  Clinic__c = acct.id, Test_Status__c = 'Completed');
        insert (cad);
        
        // need CADTest, Account, Lot, Inventory, Contact

        CustomerInventory__c ci = new CustomerInventory__c (lot_number__c = lmr.id,
                                                                account__c = acct.id);
        insert ci;
        
        TestMaterial__c tm = new TestMaterial__c (kit_lot_number__c = 'TESTLOT001', CADTest__c = cad.id);
        
        test.starttest();
        insert tm;
        /*
        tm = [select Customer_Inventory__c from TestMaterial__c 
                                    where kit_lot_number__c = 'TESTLOT001' and cadtest__c = :cad.id]; 
        System.assertNotEquals(tm.customer_inventory__c, null);
        */
        
        // test setting inventory to null
        tm.Kit_Lot_Number__c = 'DOESNOTEXIST';
        update tm;
        tm = [select Customer_Inventory__c from TestMaterial__c where id = :tm.id];
        System.assertEquals(tm.customer_inventory__c, null);
        
        test.stoptest(); 
    }
}