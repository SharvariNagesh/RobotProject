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

	public RightCommand(Robot robot, String command)
	{
	   this.robot = robot;
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
