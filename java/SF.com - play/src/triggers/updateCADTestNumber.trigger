trigger updateCADTestNumber on CADTest__c (after delete, after insert, after update) {
       //if insert or delete, update the # of cad tests on account and contact 
       //only if not "no test" and "no pay" = false
		if (Trigger.isDelete || Trigger.isInsert) {
			for (CADTest__c c : Trigger.isDelete? Trigger.old : Trigger.new) {
				if (c.Test_Status__c=='Completed' && c.Do_Not_Bill__c == false) {
					//find account and contact info 
					Account a = [select id, num_of_Corus_CAD_Tests__c from account where id = :c.Clinic__c];
					Contact con = [select id, num_of_Corus_CAD_Tests__c from contact where id = :c.Physician__c];
	
			    	if (Trigger.isDelete) {
			    		a.num_of_Corus_CAD_Tests__c--;
			    	 	con.num_of_Corus_CAD_Tests__c--;
					} else {
					 	a.num_of_Corus_CAD_Tests__c++;
			    	 	con.num_of_Corus_CAD_Tests__c++; 
					}
				
					update a;
					update con;
				} //end if
				
				// do asymptomatic
				if (Trigger.isInsert) {
					if (c.Calculated_Patient_Age__c != null && c.Gender__c != null) {
					Integer asx = 0;
					if(c.Asymptomatic_Risk_G1__c > 0) { asx++; }
					if(c.Asymptomatic_Risk_G2__c > 0) { asx++; }
					if(c.Asymptomatic_Risk_G3__c > 0) { asx++; }
					if(c.Asymptomatic_Risk_G4__c > 0) { asx++; }
					if(c.Asymptomatic_Risk_G5__c > 0) { asx++; }
					if(c.Asymptomatic_Risk_G6__c > 0) { asx++; }
					if(c.Asymptomatic_Risk_G7__c > 0) { asx++; }
					if(c.Asymptomatic_Risk_G8__c > 0) { asx++; }
	
					//get cadtest
					CADTest__c new_c = [select id, symptomatic_analysis__c from CADTest__c where id = :c.id];
					
						if (c.Symptomatic_ICDs__c > 0) {
							new_c.Symptomatic_Analysis__c = 'Symptomatic';
						} else if (c.Atypical_Symptomatic_ICDs__c > 0 && asx > 0)	{
							new_c.Symptomatic_Analysis__c = 'Symptomatic';
						} else if (c.Abnormal_ICDs__c > 0) {
							new_c.Symptomatic_Analysis__c = 'High Risk Asymptomatic';
						} else if (asx >= 3) {
							new_c.Symptomatic_Analysis__c = 'High Risk Asymptomatic';
						} else if ((asx >= 2 && c.Calculated_Patient_Age__c>=50 && c.Gender__c == 'Male') ||
								   (asx >= 2 && c.Calculated_Patient_Age__c>=60 && c.Gender__c == 'Female')) {
						    new_c.Symptomatic_Analysis__c = 'High Risk Asymptomatic';				
						} else {
							new_c.Symptomatic_Analysis__c = 'Low Risk Asymptomatic';
						}
						   update new_c;
					}
				} // end isinsert trigger
			} //end for
		} else {
			//if CAD Test is updated, then redo all the numbers
			for (Integer i = 0; i < Trigger.old.size(); i++) {
				CADTest__c old_c = Trigger.old[i];
				CADTest__c new_c = Trigger.new[i];
				
				//did test status, do not bill, clinic change? if so, then update
				if (old_c.Test_Status__c != new_c.Test_Status__c || old_c.Do_Not_Bill__c != new_c.Do_Not_Bill__c ||
				    old_c.Clinic__c != new_c.Clinic__c) {				    	

					Contact con = [select id, num_of_Corus_CAD_Tests__c from contact where IsDeleted = false and id = :new_c.Physician__c];
					Double temp = 0;
					if (con.num_of_Corus_CAD_Tests__c != null) {temp = con.num_of_Corus_CAD_Tests__c;}

					if ((old_c.Test_Status__c != new_c.Test_Status__c || old_c.Do_Not_Bill__c != new_c.Do_Not_Bill__c) 
						&& new_c.Test_Status__c=='Completed' && !new_c.Do_Not_Bill__c) {
					    con.num_of_Corus_CAD_Tests__c = ++temp;
					 	update con;
					} else if (old_c.Test_Status__c=='Completed' && !old_c.Do_Not_Bill__c){
						con.num_of_Corus_CAD_Tests__c = --temp;
						update con;
					}

					//Integer temp = 0;
					//for (List<CADTest__c> cclist : [select id from CADTest__c where physician__c=:new_c.Physician__c 
					//	                                and isDeleted = false and test_status__c = 'Completed' 
					//	                                and do_not_bill__c = false limit 900]) {
					//		temp += cclist.size();
					//	}
					//	con.num_of_Corus_CAD_Tests__c = temp;
					//	update con;
					
					//update clinic
					if (new_c.clinic__c != null) {
						Double tempb = 0;
						Account a = [select id, num_of_Corus_CAD_Tests__c from account where IsDeleted = false and id = :new_c.Clinic__c];
						//for(list<CADTest__c> clist: [select id from CADTest__c where clinic__c = :a.id and test_status__c = 'Completed' and do_not_bill__c = false]) {
						//	temp += clist.size();
						//}
						for (Contact c: [select id, num_of_Corus_CAD_Tests__c from Contact where AccountId = :a.id and num_of_Corus_CAD_Tests__c > 0]) {
						 	tempb += c.num_of_Corus_CAD_Tests__c;
						}
						a.num_of_Corus_CAD_Tests__c = tempb;
						update a;
					}
				
					//update old clinic if changed
					if (old_c.clinic__c != null && old_c.clinic__c != new_c.clinic__c) {
						Double tempb = 0;
						Account a = [select id, num_of_Corus_CAD_Tests__c from account where IsDeleted = false and id = :old_c.Clinic__c];
						//for(list<CADTest__c> clist : [select id from CADTest__c where clinic__c = :a.id and test_status__c = 'Completed' and do_not_bill__c = false]) {
						//	temp += clist.size();
						//}
						for (Contact c: [select id, num_of_Corus_CAD_Tests__c from Contact where AccountId = :a.id and num_of_Corus_CAD_Tests__c > 0]) {
						 	tempb += c.num_of_Corus_CAD_Tests__c;
						}
						a.num_of_Corus_CAD_Tests__c = tempb;
						update a;
					}
				}
				
				//now update patient name if it's been changed - propogate to patient case
				if (old_c.patient_name__c != new_c.patient_name__c) {
					List<PatientCase__c> plist = [select id, patient_full_name__c from PatientCase__c where cad_test__c = :old_c.id];
					if (!plist.isEmpty()) { 
						plist[0].patient_full_name__c = new_c.patient_name__c; 
						update plist[0];
					}
				}
				
				//if something changed
				if (old_c.First_Diagnosis_Code__c != new_c.First_Diagnosis_Code__c || 
					old_c.Second_Diagnosis_Code__c != new_c.Second_Diagnosis_Code__c ||
					old_c.Third_Diagnosis_Code__c != new_c.Third_Diagnosis_Code__c ||
					old_c.Fourth_Diagnosis_Code__c != new_c.Fourth_Diagnosis_Code__c ||
					old_c.Calculated_Patient_Age__c != new_c.Calculated_Patient_Age__c || 
					old_c.Gender__c != new_c.Gender__c) {
			
					if (new_c.Calculated_Patient_Age__c != null && new_c.Gender__c != null) {
					//get cadtest
					CADTest__c c = [select id, symptomatic_analysis__c from CADTest__c where id = :new_c.id];
											
					Integer asx = 0;
					if(new_c.Asymptomatic_Risk_G1__c > 0) { asx++; }
					if(new_c.Asymptomatic_Risk_G2__c > 0) { asx++; }
					if(new_c.Asymptomatic_Risk_G3__c > 0) { asx++; }
					if(new_c.Asymptomatic_Risk_G4__c > 0) { asx++; }
					if(new_c.Asymptomatic_Risk_G5__c > 0) { asx++; }
					if(new_c.Asymptomatic_Risk_G6__c > 0) { asx++; }
					if(new_c.Asymptomatic_Risk_G7__c > 0) { asx++; }
					if(new_c.Asymptomatic_Risk_G8__c > 0) { asx++; }
	
					if (new_c.Symptomatic_ICDs__c > 0) {
						c.Symptomatic_Analysis__c = 'Symptomatic';
					} else if (new_c.Atypical_Symptomatic_ICDs__c > 0 && asx > 0)	{
						c.Symptomatic_Analysis__c = 'Symptomatic';
					} else if (new_c.Abnormal_ICDs__c > 0) {
						c.Symptomatic_Analysis__c = 'High Risk Asymptomatic';
					} else if (asx >= 3) {
						c.Symptomatic_Analysis__c = 'High Risk Asymptomatic';
					} else if ((asx >= 2 && new_c.Calculated_Patient_Age__c>=50 && new_c.Gender__c == 'Male') ||
							   (asx >= 2 && new_c.Calculated_Patient_Age__c>=60 && new_c.Gender__c == 'Female')) {
					    c.Symptomatic_Analysis__c = 'High Risk Asymptomatic';				
					} else {
						c.Symptomatic_Analysis__c = 'Low Risk Asymptomatic';
					}
					   update c;
					}
				}//end if
			}//end for
		}
}