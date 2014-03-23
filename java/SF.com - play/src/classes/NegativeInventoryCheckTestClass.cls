public class NegativeInventoryCheckTestClass {

    static testMethod void testTransferInventory() {

        LotMasterRecord__c newLot = new LotMasterRecord__c (name= 'TESTLOT001');
        insert newLot;
        LotMasterRecord__c newLotFound =  [select id from LotMasterRecord__c where name = :newLot.name];

        Account newAcct = new Account (name = 'TESTACCT001', BillingState='CA');
        insert newAcct;
        Account newAcctFound = [select id from Account where name = :newAcct.name];

        CustomerInventory__c ci = new CustomerInventory__c (lot_number__c = newLotFound.id,
                                                                account__c = newAcctFound.id,
                                                                total_transferred__c = 10, 
                                                                total_used__c = 12);
        test.starttest();
        insert ci;
        test.stoptest();
    }
}