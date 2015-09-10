package my.project.robocontrol;

/**

 * ReportCommand class implements RoboCommands interface. This class is responsible for getting the 
 * Robot's position and format the text before printing.
 * ReportCommand takes care of handling REPORT invocation on uninitialized Robot or Robot which
 * is not placed on the table properly.  In such cases, it prints the proper message for the user.
 * 
 * @author Sharvari Nagesh
 */

public class ReportCommand implements RoboCommands {
	Robot robot;
	String report;
	public ReportCommand(Robot robot, String command)
	{
		this.robot = robot;
	}
	public String execute()
	{
		if(robot != null){
			report = robot.report();
			if(report != null){
				
				System.out.println("Robot Position :" + report);
				return report;
			}
			
		}
		report ="Robot not placed on the Table";
		System.out.println("Robot Position :" + report);
		return report;
		
	}

}
