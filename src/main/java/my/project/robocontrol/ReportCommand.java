package my.project.robocontrol;

/**
 * 
 * @author Sharvari Nagesh
 * ReportCommand class implements RoboCommands interface(execute() method). 
 * ReportCommand takes care of calling report method of the Robot.
 * It also handles calling the report function on null objects. 
 * calling report method without placing the Robot is also handled by this class.
 * Report Command is responsible for displaying the position in proper format.
 *
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
		report = new String("Robot Not Placed Properly On The Table");
		System.out.println(report);
		return report;
	}
}
