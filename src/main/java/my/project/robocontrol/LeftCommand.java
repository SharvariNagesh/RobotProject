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

    public LeftCommand(Robot robot, String placeCommand)
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
}
