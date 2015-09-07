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
		report = robot.report();
		return report;
	}

}
