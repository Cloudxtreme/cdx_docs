trigger UpdateAppointment on PhlebotomyAppointment__c (before insert) {
   for (PhlebotomyAppointment__c p : Trigger.new ) {
        if (p.Physician__c != null && p.Clinic__c == null) {
        	Contact con = [select accountid from Contact where id = :p.Physician__c ];
            if (con != null && con.accountid != null) {
            	p.Clinic__c = con.accountid;
            }
        }
    }
}