trigger updateTestMaterial on TestMaterial__c (before insert, before update) {

//	set<ID> ids = Trigger.new.keySet();
	//List <TestMaterial__c> tms = [select id, CADTest__r.clinic__c, ]
	
	CustomerInventory__c ci;
    for (TestMaterial__c tm : Trigger.new) {

        List<LotMasterRecord__c> lmrList = [select id from LotMasterRecord__c where name = :tm.kit_lot_number__c];
        List<CADTest__c> ctList = [select clinic__c, lab_name__c from CADTest__c where id = :tm.CADTest__c];

        if (!lmrList.isEmpty() && !ctList.isEmpty()) {
            LotMasterRecord__c lmr = lmrList.get(0);
            CADTest__c ct = ctList.get(0);
            List<CustomerInventory__c> ciList = [select id, total_used__c from CustomerInventory__c
                                                where lot_number__c = :lmr.id and account__c = :ct.clinic__c
                                                and total_available__c > 0];
            List<CustomerInventory__c> ciList2 = [select id, total_used__c from CustomerInventory__c
                                                where lot_number__c = :lmr.id and account__c = :ct.Lab_Name__c
                                                and total_available__c > 0];

            if (!ciList.isEmpty() && ciList2.isEmpty()) {
                ci = ciList.get(0);
                // assign customer inventory to the test kit
                tm.customer_Inventory__c = ci.id;
            } else if (ciList.isEmpty() && !ciList2.isEmpty()) {
                ci = ciList2.get(0);
                tm.customer_Inventory__c = ci.id;
            } else {
            	//both exists. so let the users decide. 
                //tm.customer_Inventory__c = null;
            }
        } else {
            tm.customer_Inventory__c = null;
        }
    }
}