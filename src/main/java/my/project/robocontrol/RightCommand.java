package my.project.robocontrol;

public class RightCommand implements RoboCommands {
private Robot robot;

	public RightCommand(Robot robot, String command)
	{
	   this.robot = robot;
	}
	public void execute()
	{
	   robot.turnRight();
	}
}
