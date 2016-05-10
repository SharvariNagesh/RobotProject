package my.project.robocontrol;

/**
 * MoveCommand implements the RoboCommands interface. It takes care of calling the move function of the
 * Robot. Before calling the Robot's move function, this class makes sure, the new move is within the table,
 * and Robot is properly initialized and placed on the table.
 *  
 * To make sure the move is within the table, the class gets a copy of xy Coordinates of the Robot, moves
 * the robot in the direction it is facing and checks if the new XY coordinate lies within the Table.
 * 
 * @author Sharvari Nagesh
 *
 */
public class MoveCommand implements RoboCommands {
	private Robot robot;
	private String command;
	private Coordinates newXYCoordinates;
	private DIRECTIONS robotDirection;
	static
	{
		Robot tempRobot = null;
		CommandFactory.getInstance().registerCommand("MOVE", new MoveCommand(tempRobot, ""));
	}
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
  
  public MoveCommand createCommandObject(Robot robot, String commandLine)
	{
		return new MoveCommand(robot, commandLine);
	}
}
