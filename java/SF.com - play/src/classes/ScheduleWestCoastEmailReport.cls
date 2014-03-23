global class ScheduleWestCoastEmailReport implements Schedulable{

	global void execute(SchedulableContext sc) {
    	EmailSampleReport.mailReport('West');
    }
}