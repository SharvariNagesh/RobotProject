package my.project.robocontrol;

/**
 * 
 * @author Sharvari Nagesh
 * MoveCommand implements the RoboCommands interface. It takes care of calling the move function of Robot
 * Before calling the Robot's move function, this class makes sure, the move is valid, within the table
 * and all the players involved are properly set.
 */
public class MoveCommand implements RoboCommands {
	private Robot robot;
	private String command;
	
  public MoveCommand(Robot robot, String command)
  {
	this.robot = robot;
	this.command = command;
  }
  public String execute()
  {
	 robot.move();
	return null;
  }
}
