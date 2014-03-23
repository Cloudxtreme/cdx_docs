public class DuplicatedLotMasterTestClass {

    static testMethod void testDuplication() {
     
        try {
                LotMasterRecord__c newLot = new LotMasterRecord__c (name= 'LOT123');
                insert newLot;
                
                LotMasterRecord__c dupLot = new LotMasterRecord__c (name = newLot.name);
         
                test.starttest();
                // insert an existing record again
                insert dupLot;
                test.stoptest();
        
        } catch (DMLException de) {
            for (Integer i = 0; i < de.getNumDml(); i++) {
                // Process exception here
                System.debug(LoggingLevel.INFO, 'ERROR---- ' + de.getDmlMessage(i)); 
            }
        }
    }
}