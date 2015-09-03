package my.project.robocontrol;

/**
 * 
 * @author Sharvari Nagesh
 * This is the Robot class which will have methods to move, turn, place robot.
 * An Enum is used to describe the directions. Enum Position has also a X & Y coordinate inside it.
 * ENUMs were introduced from Java 1.5. So this program is not compatible with java older than version 1.5
 */
enum POSITION
{
	NORTH,EAST,SOUTH,WEST;
	private int xCoordinate, yCoordinate;
	public void setXY(int x, int y){
		xCoordinate = x;
		yCoordinate = y;
	}
	public int getX()
	{
		return xCoordinate;
	}
	public int getY()
	{
		return yCoordinate;
	}
}
public class Robot {
protected POSITION position;	

	public void Robot()
	{
		
	 //constructor	
	}
	
	//While placing the robot, command initiator should check whether they are placing the robot on the table or not. Robot will not check this.
		public void place(POSITION pos, int x, int y)
	{
		position = pos;
		position.setXY(x, y);
	
	}

	public void move()
	{
		//to be written
	}
	
	public void turnRight()
	{
		//to be written
	}
	public void turnLeft()
	{
		//to be written
	}
	public String report()
	{
		String reportPosition;
		reportPosition = String.format("%d,%d %s",position.getX(), position.getY(), position.toString());
		
		System.out.println("Current position of the Robot :" + reportPosition);
		return reportPosition;
	}
}
