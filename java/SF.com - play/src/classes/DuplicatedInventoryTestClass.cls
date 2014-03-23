public class DuplicatedInventoryTestClass {

    static testMethod void testDuplication() {

        LotMasterRecord__c newLot = new LotMasterRecord__c (name= 'TESTLOT123');
        insert newLot;
        LotMasterRecord__c newLotFound =  [select id from LotMasterRecord__c where name = :newLot.name];

        Account newAcct = new Account (name = 'TESTACCT123', billingcountry='US', billingstate='CA');
        insert newAcct;
        Account newAcctFound = [select id from Account where name = :newAcct.name];

        CustomerInventory__c newCI = new CustomerInventory__c (lot_number__c = newLotFound.id,

                                      account__c = newAcctFound.id,
                                      status__c = 'Active');
        insert newCI;

        CustomerInventory__c dupCI = new CustomerInventory__c (lot_number__c = newLotFound.id,

                                      account__c = newAcctFound.id,
                                      status__c = 'Active');

        test.starttest();
        try {
            // insert an existing record again
            insert dupCI;
        } catch (DMLException de) {
          System.assertEquals (de.getDmlMessage(0), 'ERROR: duplicated inventory');
            System.debug( 'ERROR---- ' + de.getDmlMessage(0));
        }
        test.stoptest();
    }
}