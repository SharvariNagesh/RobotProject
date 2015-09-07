package my.project.robocontrol;

/**
 * 
 * @author Sharvari Nagesh
 * The LeftCommand is an implementation of command "LEFT".
 * It checks if the Robot is placed. If it is placed, then, it calls the Robot's function to turn it left.
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
