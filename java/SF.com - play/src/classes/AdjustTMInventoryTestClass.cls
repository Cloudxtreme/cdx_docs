public class AdjustTMInventoryTestClass {

    static testMethod void testAdjustTMInventory() {

        // need CADTest, Account, Lot, Inventory, Contact
        List<String> names = new List<String>();
        names.add('TESTLOT001');
        names.add('TESTLOT002');
        List<LotMasterRecord__c> lmrs = new List<LotMasterRecord__c>(); 
        for (String n : names) {
        	lmrs.add(new LotMasterRecord__c (name = n));
        }
        insert lmrs;

        Account newAcct = new Account (name = 'TESTACCT001', BillingState='CA');
        insert (newAcct);
       
        Contact newContact = new Contact (LastName = 'TESTCONTACT001', MailingState='CA');
        insert (newContact);

        CADTest__c newCADTest = new CADTest__c(name = 'TESTTRF1', Physician__c = newContact.id,  Clinic__c = newAcct.id, Test_Status__c = 'Completed');
        insert (newCADTest);
        
        List<CustomerInventory__c> cis = new List<CustomerInventory__c>();
        List<ID> lmrIds = new List<ID>();
        for (LotMasterRecord__c lmr: lmrs) {
        	cis.add(new CustomerInventory__c (lot_number__c = lmr.id, account__c = newAcct.id, total_used__c = 0));
        	lmrIds.add(lmr.id);
        }
        insert cis;
        
        // test insert
        test.starttest();
        System.assertEquals(cis.get(0).total_used__c, 0);
        insert new TestMaterial__c (kit_lot_number__c = names.get(0), CADTest__c = newCADTest.id);
        TestMaterial__c tm = [select Customer_Inventory__r.total_used__c, Customer_Inventory__r.id, kit_lot_number__c from TestMaterial__c 
                                    where kit_lot_number__c = :names.get(0) and cadtest__c = :newCADTest.id]; 
        //System.assertEquals(tm.Customer_Inventory__r.id, cis.get(0).id);
        //System.assertEquals(tm.Customer_Inventory__r.total_used__c, 1);
       
        // test update
        System.assertEquals(cis.get(1).total_used__c, 0);
        tm.kit_lot_number__c = names.get(1);
        update tm;
        //tm = [select Customer_Inventory__r.id, Customer_Inventory__r.total_used__c from TestMaterial__c 
        //        where kit_lot_number__c = :names.get(1) and cadtest__c = :newCADTest.id]; 
        //System.assertEquals(tm.Customer_Inventory__r.id, cis.get(1).id);
        //System.assertEquals(tm.Customer_Inventory__r.total_used__c, 1);
        
        // test delete
        /*
        ID ciId = tm.Customer_Inventory__r.id;
        delete tm;
        CustomerInventory__c tmCI = [select id, total_used__c from CustomerInventory__c where id = :ciId];
        System.assertEquals(tmCI.total_used__c, 0);
        */
 
        test.stoptest(); 
        
    }
}