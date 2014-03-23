trigger duplicateInventoryCheck on CustomerInventory__c (before insert) {

    CustomerInventory__c[] invs = Trigger.new;

    for (CustomerInventory__c inv:invs){

        Integer hits;
        // find the duplicated account
        hits = [SELECT count() FROM CustomerInventory__c WHERE lot_number__c = :inv.lot_number__c
                 AND account__c = :inv.account__c AND status__c = :inv.status__c];

        if (hits > 0) {
             inv.name.addError('ERROR: duplicated inventory');
        }

    }
}