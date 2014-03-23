trigger duplicateLotMasterCheck on LotMasterRecord__c (before insert) {

    LotMasterRecord__c[] invls = Trigger.new;

    for (LotMasterRecord__c invl:invls){

        Integer hits;
        // find the duplicated account
        hits = [SELECT count() FROM LotMasterRecord__c WHERE name = :invl.name];

        if (hits > 0) {
             invl.name.addError('ERROR: duplicated lot master record');
        }

    }
}