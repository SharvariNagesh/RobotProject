package my.project.robocontrol;

public class Coordinates {
	private int xCoordinate, yCoordinate;
		
	public Coordinates(int x, int y)
	{
		xCoordinate = x;
		yCoordinate = y;
	}
	public void setXY(int x,int y)
	{
		xCoordinate = x;
		yCoordinate = y;
	}
	public int getX(){
		return xCoordinate;
	}
	public int getY(){
		return yCoordinate;
	}
	public void incrementX(){
		xCoordinate++;
	}
	public void incrementY(){
		yCoordinate++;
	}
	public void decrementX(){
		xCoordinate--;
	}
	public void decrementY(){
		yCoordinate--;
	}
}
