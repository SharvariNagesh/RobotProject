package my.project.robocontrol;

/**
 
 * This is the Robot class which will define the actual Robot. The Robot can be placed, 
 * it can move, turn RIGHT or LEFT. The Robot can also report it's position. A Robot's 
 * position is stored in XY coordinates which will be set when Robot is placed on a Table. 
 * Robot has a DIRECTION, which indicates the direction in which it is facing. When Robot
 * is made to move, it moves in the direction it is facing.
 *  
 * @author Sharvari Nagesh
 */

public class Robot {
private DIRECTIONS direction;	
private Coordinates xycoordinates;
	public Robot()
	{
		xycoordinates = new Coordinates(-1, -1);	
	}
	
	/*
	 * getCoordinates has to return a copy
	 */
	public Coordinates getCoordinates()
	{
		return xycoordinates;
	}
	
	public DIRECTIONS getDirection()
	{
		return direction;
	}
	//While placing the robot, command initiator should check whether they are placing the robot on the table or not. Robot will not check this.
	public void place(DIRECTIONS newdirection, Coordinates xy)
	{
			this.direction = newdirection;
			this.xycoordinates = xy;
	}

	public void move()
	{
		xycoordinates = direction.moveInDirection(xycoordinates);
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

	public boolean isRobotPlaced(){
		if (xycoordinates.isCoordinatesSet() && (direction != null)){
			return true;
		}
		return false;
	}
	
	/*
	 * Since Robot class does not check whether the move is on the table or not, it's coordinates can take -ve value
	 * So, while reporting, only direction is checked. If it is null, null is returned.
	 */
	public String report()
	{
		String reportPosition;
		if (direction != null){
			reportPosition = String.format("%d,%d %s",xycoordinates.getX(), xycoordinates.getY(), direction.toString());
			
			return reportPosition;
		}else{
			return null;
		   
		}
	}
}
