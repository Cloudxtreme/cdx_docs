public class TransferInventoryTestClass {

    static testMethod void testTransferInventory() {

        // need CADTest, Account, Lot, Inventory, Contact
        LotMasterRecord__c lmr = new LotMasterRecord__c (name = 'TESTLOT001');
        insert lmr;
        
        List<String> names = new List<String>();
        names.add('TESTACCT001');
        names.add('TESTACCT002');
        names.add('TESTACCT003');
        List<Account> accts = new List<Account>(); 
        for (String n : names) {
        	accts.add(new Account (name = n));
        }
        insert accts;
        
        List<CustomerInventory__c> cis = new List<CustomerInventory__c>();
    	cis.add(new CustomerInventory__c (lot_number__c = lmr.id, account__c = accts.get(0).id, total_used__c = 2, total_transferred__c = 20));
    	cis.add(new CustomerInventory__c (lot_number__c = lmr.id, account__c = accts.get(2).id, total_used__c = 2, total_transferred__c = 20));
        insert cis;
		
        test.starttest();

        // test valid transfer amount
        CustomerInventory__c ciFound = cis.get(0);
        try {
            ciFound.transfer_amount__c = -10;
            update ciFound;

        } catch (DMLException de) {
            System.assertEquals (de.getDmlMessage(0), 'Transfer amount can not be negative or zero');
            System.debug( 'ERROR---- ' + de.getDmlMessage(0));

            ciFound.transfer_amount__c = null;
        }


        // test valid transfer amount
        Account newAcctFound2 = accts.get(1);
        try {
            ciFound.transfer_amount__c = ciFound.total_transferred__c + 10;
            ciFound.transfer_to_account__c = newAcctFound2.id;
            update ciFound;

        } catch (DMLException de) {
            System.assertEquals (de.getDmlMessage(0), 'Transfer amount can not be more than existing inventory');
            System.debug( 'ERROR---- ' + de.getDmlMessage(0));

            ciFound.transfer_amount__c = null;
            ciFound.transfer_to_account__c = null;
        }

        // test valid transfer amount
        try {
            ciFound.transfer_amount__c = null;
            ciFound.transfer_to_account__c = newAcctFound2.id;

            update ciFound;

        } catch (DMLException de) {
            System.assertEquals (de.getDmlMessage(0), 'Please specify transfer amount as destination Account has been specified');
            System.debug( 'ERROR---- ' + de.getDmlMessage(0));

            ciFound.transfer_amount__c = null;
            ciFound.transfer_to_account__c = null;
        }

        // test valid transfer amount
        try {
            ciFound.total_transferred__c = 20;
            ciFound.total_used__c = 2;
            
            ciFound.transfer_amount__c = 1;
            ciFound.transfer_to_account__c = null;
            update ciFound;

        } catch (DMLException de) {
//            System.assertEquals (de.getDmlMessage(0), 'Please specify destination Account ');
            System.debug( 'ERROR---- ' + de.getDmlMessage(0));

            ciFound.transfer_amount__c = null;
            ciFound.transfer_to_account__c = null;
        }
        
        // Testing transfer to new inventory
        ciFound.total_transferred__c = 20;
        ciFound.total_used__c = 2;
        ciFound.transfer_amount__c = 2;
        ciFound.transfer_to_account__c = newAcctFound2.id;

//        update ciFound;
        
 //       CustomerInventory__c ciFound1 = [select total_transferred__c, lot_number__c from CustomerInventory__c
 //                                           where account__c = :newAcctFound2.id];
 //       System.assertNotEquals(ciFound1, null);

        // transfer to existing inventory
        Account newAcctFound3 = accts.get(2);
        ciFound.total_transferred__c = 20;
        ciFound.total_used__c = 2;
        ciFound.transfer_amount__c = 3;
        ciFound.transfer_to_account__c = newAcctFound3.id;
        
        newAcctFound3.Default_Low_Inv_Threshold__c = null;
        newAcctFound3.Low_Inventory_Threshold__c = null;

//        update ciFound;
        test.stoptest();

//        CustomerInventory__c ciFound4 = [select total_transferred__c from CustomerInventory__c
 //                                           where account__c = :newAcctFound3.id];
 //       System.assertEquals(ciFound4.total_transferred__c, (ciFound.total_transferred__c + 3));
    }
}