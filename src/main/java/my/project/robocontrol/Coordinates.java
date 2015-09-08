package my.project.robocontrol;

public class Coordinates {
	private int xCoordinate, yCoordinate;
		
	public Coordinates(int x, int y)
	{
		xCoordinate = x;
		yCoordinate = y;
	}
	
	//Defining a copy constructor
	public Coordinates(Coordinates xy){
		this.xCoordinate = xy.getX();
		this.yCoordinate = xy.getY();
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
	public boolean isCoordinatesSet(){
		return ((xCoordinate >= 0) && (yCoordinate >=0))? true : false; 
	}
}
