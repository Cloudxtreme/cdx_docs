trigger validateTestMaterial on TestMaterial__c (after insert, after update) {
     //for (TestMaterial__c tm : Trigger.new) {
     List<Case> cases = new List<Case>();
     TestMaterial__c tm;
     String error;
     
     List<TestMaterial__c> tms = new List<TestMaterial__c>(); 
     for (Integer i = 0; i < Trigger.new.size(); i++) {
        if (Trigger.isUpdate) {
            TestMaterial__c oldTm = Trigger.old[i];
            TestMaterial__c newTm = Trigger.new[i];
            // for update, if lot number or cad test is changed, validate the inventory
            if (oldTm.kit_lot_number__c == newTm.kit_lot_number__c && oldTm.cadtest__c == newTm.cadtest__c) {
                continue;
            }
        }
        tm = Trigger.new[i];
        tms.add(tm);
     }
     
     List<TestMaterial__c> tms1 = new List<TestMaterial__c>(); 
     Set<String> ids = new Set<String>();  
     // check if the lot number is entered or not 
     for (Integer i=0; i<tms.size(); i++) {
        tm = tms.get(i);
        if (tm.kit_lot_number__c == null) {
            error = 'Missing kit lot number';
            Case c = new Case(subject = error, issue__c = 'Inventory', origin='Other', description = error,  cad_test__c =  tm.CADTest__c, test_material__c = tm.id);
            cases.add(c); 
        } else {
            ids.add(tm.kit_lot_number__c);
            tms1.add(tm);
        }
     }
     
     List<TestMaterial__c> tms2 = new List<TestMaterial__c>();
     // check if the lot number entered is valid or not 
     List<LotMasterRecord__c> lmrs = [select name from LotMasterRecord__c];
     List<String> masterIds = new List<String>();
     for (Integer i=0; i<lmrs.size(); i++) {
         masterIds.add (lmrs.get(i).name);
     }
     ids.removeAll (masterIds);
     for (TestMaterial__c tm1 : tms1) {
        if (ids.contains (tm1.kit_lot_number__c)) {
            error = 'Invalid lot number ';  
            Case c = new Case(subject = error, issue__c='Inventory', origin='Other', description = 'Invalid lot number '+tm1.kit_lot_number__c ,  cad_test__c =  tm1.CADTest__c, test_material__c = tm1.id);
            cases.add(c); 
        } else {
            tms2.add(tm);
        }            
     }   
     
    Set<ID> tmKeys = new Set<ID>();
     for (TestMaterial__c tm1 : tms2) {
        tmKeys.add(tm1.id); 
     }                                    
     
     tms = [select id, kit_lot_number__c, Customer_Inventory__c, CADTest__r.lab_name__c, CADTest__r.clinic__c
            from TestMaterial__c
            where id IN :tmKeys];
    
     Map<String, ID> lmrMap = new Map<String, ID>();
     for (LotMasterRecord__c lmr : lmrs) {
        lmrMap.put (lmr.name, lmr.id);  
     }
     
    Case c;
    for (TestMaterial__c tm1 : tms) {
        if (tm1.Customer_Inventory__c == null) {
            if (tm1.CADTest__r.clinic__c == null)   {
                // neither lab or clinic exists
                if (tm1.CADTest__r.lab_name__c == null) {
                     error = 'Missing Inventory due to missing account and lab';
                // lab exists, but has no inventory
                } else {
                     error = 'No Customer Inventory exists for the lot number '+ tm1.kit_lot_number__c +' at the lab ';
                }
            } else { 
                if (tm1.CADTest__r.lab_name__c != null) {
                    // if both exist, either no inventory at both place or exist at both places
                    List<CustomerInventory__c> cis = [select id  from CustomerInventory__c 
                                                where lot_number__c = :lmrMap.get(tm1.kit_lot_number__c) 
                                                and account__c = :tm1.CADTest__r.lab_name__c and total_available__c > 0];
                    // both clinic and lab exist, but has no inventory 
                    if (cis.isEmpty()) {
                         error = 'No Customer Inventory exists for the lot number '+ tm1.kit_lot_number__c +' at the account or lab ';
                    // both clinic and lab exist, but has inventory at both places
                    } else {
                         error = 'Inventory with the lot number '+ tm1.kit_lot_number__c +' exist at both the account and the lab ';
                    }
                // clinic exists, but has no inventory
                } else {
                     error = 'No Customer Inventory exists for the lot number '+ tm1.kit_lot_number__c +' at the account ';
                }
            }
            c = new Case(subject = 'Missing inventory', issue__c='Inventory', origin='Other', description = error,  cad_test__c =  tm1.CADTest__c, test_material__c = tm1.id);
            cases.add(c);
        }   
    }   
    
    insert cases;
}