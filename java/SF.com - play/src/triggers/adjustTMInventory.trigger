trigger adjustTMInventory on TestMaterial__c (after insert, after delete, after update) {

    if (Trigger.isDelete || Trigger.isInsert) {
        Set<ID>  ciIDs = new Set<ID>();
        for (TestMaterial__c tm : Trigger.isInsert? Trigger.new : Trigger.old ) {
            ciIDs.add (tm.customer_inventory__c);   
        }
        
        //  TASK: should make sure lot number and cad match
        List<CustomerInventory__c> ciList= [select id,  total_used__c from CustomerInventory__c
                                            where id IN :ciIDs];
        for (CustomerInventory__c ci : ciList) {
            ci.total_used__c = (ci.total_used__c == null? 0 : ci.total_used__c);    
            if (Trigger.isInsert) {
                ci.total_used__c ++;
            } else {
                ci.total_used__c --;
            }
            update ci;
        }
    } else {
        Set<ID> oldIDs = new Set<ID>();         
        Set<ID> newIDs = new Set<ID>();         
        
        for (Integer i = 0; i < Trigger.old.size(); i++) {
            TestMaterial__c oldTm = Trigger.old[i];
            TestMaterial__c newTm = Trigger.new[i];
 
            // kit lot number, customer inventory, cadtest
            if (oldTm.kit_lot_number__c != newTm.kit_lot_number__c || 
                oldTm.customer_inventory__c != newTm.customer_inventory__c ||
                oldTm.cadtest__c != newTm.cadtest__c) {
                
                oldIDS.add (oldTm.customer_inventory__c);
                newIDS.add (newTm.customer_inventory__c);
            }
        }
        
        List<CustomerInventory__c> ciList = [select total_used__c from CustomerInventory__c where id IN :oldIDs]; 
        List<CustomerInventory__c> ciUpdates = new List<CustomerInventory__c>();
        for (CustomerInventory__c ci : ciList) {
            ci.total_used__c = (ci.total_used__c == null? 0 : ci.total_used__c);    
            ci.total_used__c--; 
            ciUpdates.add(ci);
        }   
                
        ciList = [select total_used__c from CustomerInventory__c where id IN :newIDs];
        for (CustomerInventory__c ci : ciList) {
            ci.total_used__c = (ci.total_used__c == null? 0 : ci.total_used__c);    
            ci.total_used__c++; 
            ciUpdates.add(ci);
        }
        
        update ciUpdates;
    }

}