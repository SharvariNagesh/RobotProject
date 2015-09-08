package my.project.robocontrol;

/**
 * 
 * @author Sharvari Nagesh
 * MoveCommand implements the RoboCommands interface. It takes care of calling the move function of Robot
 * Before calling the Robot's move function, this class makes sure, the move is within the table
 * and all the players involved are properly set. 
 * To make sure the move is within the table, the class gets xy Coordinates of the robot, 
 * tries to move it the robot in the direction it is facing and checks if the new XY coordinate lies within the Table.
 */
public class MoveCommand implements RoboCommands {
	private Robot robot;
	private String command;
	private Coordinates newXYCoordinates;
	private DIRECTIONS robotDirection;
  public MoveCommand(Robot robot, String command)
  {
	this.robot = robot;
	this.command = command;
  }
  public String execute()
  {
	  if(robot!= null && robot.isRobotPlaced())
	  {
		  newXYCoordinates = new Coordinates(robot.getCoordinates());
		  robotDirection = robot.getDirection();
		  newXYCoordinates = robotDirection.moveInDirection(newXYCoordinates);
		  if(Table.getInstance().isOnTable(newXYCoordinates))
		  {
		    robot.move();
		  }
	  }
	return null;
  }
}
