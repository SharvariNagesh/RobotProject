package my.project.robocontrol;

/**
 * 
 * @author Sharvari Nagesh
 * ReportCommand class implements RoboCommands interface(execute() method). 
 * ReportCommand takes care of calling report method of the Robot.
 * It also handles calling the report function on null objects. 
 * calling report method without placing the Robot is also handled by this class
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
		report ="Robot not placed on the Table";
		System.out.println("Robot Position :" + report);
		return report;
		
	}

}
