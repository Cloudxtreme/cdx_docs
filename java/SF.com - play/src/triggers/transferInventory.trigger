trigger transferInventory on CustomerInventory__c (before insert, before update) {

    for (Integer i = 0; i < Trigger.new.size(); i++) {
       CustomerInventory__c inv = Trigger.new[i];

        if (inv.transfer_amount__c == null &&  inv.transfer_to_account__c != null ) {
        inv.transfer_amount__c.addError ('Please specify transfer amount as destination Account has been specified');

        // validate transfer amount
        } else if (inv.transfer_amount__c <= 0) {
            inv.transfer_amount__c.addError ('Transfer amount can not be negative or zero');

        } else if (inv.transfer_amount__c > inv.total_available__c) {
            inv.transfer_amount__c.addError ('Transfer amount can not be more than existing inventory');

        // validate transfer related fields
        // if transfer amount is specified, make sure there is a destination account
        } else if (inv.transfer_amount__c != null && inv.transfer_to_account__c == null ) {
            inv.transfer_to_account__c.addError ('Please specify destination Account ');
            
        } else if (inv.transfer_to_account__c != null && inv.transfer_to_account__c == inv.account__c) {
            inv.transfer_to_account__c.addError ('Can not transfer to the same Account');
      
        }
        // change any null field to 0 for easy update later
        if (inv.total_transferred__c == null) { inv.total_transferred__c = 0; }

        // handles transferring
        if (inv.transfer_amount__c != null && inv.transfer_to_account__c != null) {

            List<CustomerInventory__c> items = new List<CustomerInventory__c>();

            // check if the "to" account or TM already has inventory with the same lot number
            items = [SELECT   id, total_transferred__c, account__c from CustomerInventory__c
                     WHERE    lot_number__c = :inv.lot_number__c
                     AND account__c =  :inv.transfer_to_account__c 
                     AND status__c = :inv.transfer_status__c ] ;
            

            // update existing inventory
            if (items.size() > 0) {
                CustomerInventory__c existingInv = items.get(0);
                if (existingInv.total_transferred__c == null) { existingInv.total_transferred__c = 0; }
                existingInv.total_transferred__c = existingInv.total_transferred__c + inv.transfer_amount__c;

                update existingInv;

            // create a new inventory for the "to" account
            } else {            
                 
                
                // if this is first kit under the account and the low inventory threshold is 0, set the threshold to 1
                List<Account> accts = new List<Account>();
                accts = [SELECT   total_inventory__c, low_inventory_threshold__c,
                                  default_low_inv_threshold__c from Account
                         WHERE    id =  :inv.transfer_to_account__c ] ;
            
                // create the new inventory
                // this block of code has to be placed after the accts are retrieved (above) and before the
                // low inventory threshold is updated (below) to fix the bug #113
                CustomerInventory__c newInv = new CustomerInventory__c();
                newInv.lot_number__c = inv.lot_number__c;
                newInv.total_transferred__c = inv.transfer_amount__c;
                newInv.account__c = inv.transfer_to_account__c;
                newInv.status__c = inv.transfer_status__c;
                insert newInv;
                
                 // update the low inventory threshold
                 if (accts.size() > 0) {
                        Account toAccount = accts.get(0);
                        // update the low inventory threshold only if there is no existing inventory
                        // and the low inventory threshold has not been set
                        if (toAccount.total_inventory__c == 0 && 
                           (toAccount.low_inventory_threshold__c == 0 || toAccount.low_inventory_threshold__c == null)) {
                               if (toAccount.default_low_inv_threshold__c == null) {
                                   toAccount.default_low_inv_threshold__c = 1;
                               }
                               toAccount.low_inventory_threshold__c = toAccount.default_low_inv_threshold__c;
                               update toAccount;
                        }
                 }
              
            }

            // update the inventory in the "from" account
            inv.total_transferred__c = inv.total_transferred__c - inv.transfer_amount__c;

            // clear the form
            inv.transfer_amount__c = null;
            inv.transfer_to_account__c = null;
            inv.comment__c = null;
            inv.transfer_status__c = 'Active';
         }
    }

}