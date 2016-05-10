package my.project.robocontrol;

/**
 * The LeftCommand is an implementation of commandInterface, RoboCommands. This class takes care of 
 * calling the robot's method to turn "LEFT". This class checks if the Robot is placed properly before
 * executing Robot's methods.
 *
 * @author Sharvari Nagesh
 * 
 */
public class LeftCommand implements RoboCommands{
private Robot robot;

static
{
	Robot tempRobot = null;
	CommandFactory.getInstance().registerCommand("LEFT", new LeftCommand(tempRobot, ""));
}
    public LeftCommand(Robot robot, String commandLine)
    {
    	this.robot = robot;
    }
	public String execute()
	{
		if(robot!= null && robot.isRobotPlaced())
		{
			robot.turnLeft();
		}
		return null;
	}
	
	public LeftCommand createCommandObject(Robot robot, String commandLine)
	{
		return new LeftCommand(robot, commandLine);
	}
}
