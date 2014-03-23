trigger negativeInventoryCheck on CustomerInventory__c (after insert, after update) {
    CustomerInventory__c[] invs = Trigger.new;

    for (CustomerInventory__c inv:invs){

        if (inv.total_available__c < 0 ) {
            Case c = new Case();
            c.subject = 'Negative Inventory';
            c.issue__c = 'Inventory';
            c.origin = 'Other';
            c.description = 'Remaining inventory is negative';
            c.customer_inventory__c = inv.id;
            c.ownerid = UserInfo.getUserId();
            insert c;
        }
    }
}