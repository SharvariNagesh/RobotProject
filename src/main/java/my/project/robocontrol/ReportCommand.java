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
	
	public ReportCommand(Robot robot, String command)
	{
		
	}
	public String execute()
	{
		return null;
	}

}
