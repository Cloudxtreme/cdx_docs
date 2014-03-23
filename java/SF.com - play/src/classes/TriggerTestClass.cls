public class TriggerTestClass {
	static testMethod void testTriggers() {
		Account a = new Account(Name = 'a');
		insert a;
		Account b = new Account(Name = 'b');
		insert b;
		Account c = new Account(Name = 'c');
		Affiliated_Account__c d = new Affiliated_Account__c(Main_Account__c = a.Id, Affiliated_Practice_Account__c = b.Id, Role__c = 'Practice - Main');
		insert d;
		Contact e = new Contact(Lastname = 'e', AccountId = a.Id);
		insert e;
	}
}