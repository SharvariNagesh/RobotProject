package my.project.robocontrol;

/**
 * The RightCommand is an implementation of commandInterface, RoboCommands. This class takes care of 
 * calling the robot's method to turn "RIGHT". This class checks if the Robot is placed properly before
 * executing Robot's methods.
 *
 * @author Sharvari Nagesh
 * 
 */
public class RightCommand implements RoboCommands {
private Robot robot;

static
{
	Robot tempRobot = null;
	CommandFactory.getInstance().registerCommand("RIGHT", new RightCommand(tempRobot, ""));
}
	public RightCommand(Robot robot, String command)
	{
	   this.robot = robot;
	}
	
	public RightCommand createCommandObject(Robot robot, String commandLine)
	{
		return new RightCommand(robot, commandLine);
	}
	
	public String execute()
	{
		if(robot!= null && robot.isRobotPlaced())
		{
			robot.turnRight();
		}
		return null;
	   
	}
}
