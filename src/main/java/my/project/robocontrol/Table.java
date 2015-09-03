package my.project.robocontrol;



/**
 * 
 * @author Sharvari Nagesh
 * 
 * Table is a singleton class. So it can be accessed from everywhere. Table has length and breadth, 
 * which can be set. By default, length and breadth will be set to 5.
 * Robot class refers to table class while moving, to check if the move is within the table.
 * Table provides methods to check whether the (X,Y) co-ordinate lies within the table.
 *
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
		width = x;
		breadth = y;
	}
	public int getWidth(){
		return width;
	}
	public int getBreadth(){
		return breadth;
	}
}
