package my.project.robocontrol;



/**
 * 
 * @author Sharvari Nagesh
 * 
 * Table is a singleton class. So it can be accessed from everywhere. Table has length and breadth. with can be set
 * Robot class refers to table class while moving, to check if the move is within the table.
 * Table provides methods to check whether the (X,Y) co-ordinate lies within the table.
 *
 */

public class Table {
	private static Table instance;
	private int WIDTH = 5;
	private int BREADTH = 5;
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
		
	}
	public int getWidth(){
		return 0;
	}
	public int getBreadth(){
		return 0;
	}
}
