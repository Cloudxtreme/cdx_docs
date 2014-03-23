global class ScheduleEastCoastEmailReport implements Schedulable{

	global void execute(SchedulableContext sc) {
    	EmailSampleReport.mailReport('East');
    }
}