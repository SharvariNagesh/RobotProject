package my.project.robocontrol;

/**
 * 
 * @author Sharvari Nagesh
 * This is the Robot class which will have methods to move, turn, place robot
 *
 */
enum POSITION
{
	NORTH,EAST,SOUTH,WEST
	
}
public class Robot {
private POSITION position;	
	public void Robot()
	{
	 //constructor	
	}
	public void place(POSITION pos, int x, int y)
	{
		//to be written
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
		//to be written
		String str ="Testing";
		return str;
	}
}
