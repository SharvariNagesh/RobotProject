package my.project.robocontrol;

/**
 * 
 * Table is a singleton class. So it can be accessed from everywhere without instantiating. 
 * Table has length and breadth, which can be set. By default, length and breadth will be
 * set to 5.
 *  
 * Table provides methods to set it's size, get it's length and breadth and to check whether 
 * a (X,Y) co-ordinate lies within the table.
 * 
 * @author Sharvari Nagesh
 */

public class Table {
	private static Table instance;
	private int width = 5;
	private int breadth = 5;
	private Table(){} // constructor is private to make sure no more table instances are created
	public static synchronized Table getInstance()
	{
		if (instance == null)
		{
			instance = new Table();
		}
		return instance;
	 
	}
	public void setSize(int x, int y){
		if (x>0 && y>0)
		{
		  width = x;
		  breadth = y;
		}
	}
	public boolean isOnTable(Coordinates xy)
	{
		int x = xy.getX();
		int y = xy.getY();
		return ((x<= width && x>=0) &&( y<=breadth && y>=0))?  true :  false;
	}
	public int getWidth(){
		return width;
	}
	public int getBreadth(){
		return breadth;
	}
}
