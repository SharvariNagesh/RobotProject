package my.project.robocontrol;

/**
 * 
 * @author Sharvari Nagesh
 * This is the Robot class which will have methods to move, turn, place robot.
 * An Enum is used to describe the directions. Enum Position has also a X & Y coordinate inside it.
 * ENUMs were introduced from Java 1.5. So this program is not compatible with java older than version 1.5
 */

public class Robot {
private DIRECTIONS direction;	
private Coordinates xycoordinates;
	public Robot()
	{
		xycoordinates = new Coordinates(-1, -1);	
	}
	
	//While placing the robot, command initiator should check whether they are placing the robot on the table or not. Robot will not check this.
	public void place(DIRECTIONS newdirection, Coordinates xy)
	{
			this.direction = newdirection;
			this.xycoordinates = xy;
	}

	public void move()
	{
		xycoordinates = direction.move(xycoordinates);
	}
	
	public void turnRight()
	{
		int index = direction.ordinal();
		index = (index + 1) % direction.NOOFDIRECTIONS;
		direction = DIRECTIONS.values()[index];
	}
	public void turnLeft()
	{
		int index = direction.ordinal();
		index = ((index - 1) >=0)? (index -1) : (direction.NOOFDIRECTIONS -1);
		direction = DIRECTIONS.values()[index];
	}
	public String report()
	{
		String reportPosition;
		if (xycoordinates.isCoordinatesSet() || (direction != null)){
			reportPosition = String.format("%d,%d %s",xycoordinates.getX(), xycoordinates.getY(), direction.toString());
			System.out.println("Current position of the Robot :" + reportPosition);
			return reportPosition;
		}else{
			return("Robot Not Placed Properly On The Table");
		}
	}
}
