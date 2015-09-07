package my.project.robocontrol;

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
