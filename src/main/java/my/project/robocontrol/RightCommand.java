package my.project.robocontrol;

public class RightCommand implements RoboCommands {
private Robot robot;

	public RightCommand(Robot robot, String command)
	{
	   this.robot = robot;
	}
	public void execute()
	{
		if(robot.isRobotPlaced())
		{
			robot.turnRight();
		}
	   
	}
}
