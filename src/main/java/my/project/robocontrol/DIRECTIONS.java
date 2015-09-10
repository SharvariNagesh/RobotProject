package my.project.robocontrol;

/**
 * Robot directions are defined in the enum DIRECTIONS. This way, directions are predefined.
 * Randrom values can not be assigned to enum variables. enum makes it easy to add new directions
 * in future. For adding new directions, the only file which needs to be touched is DIRECTIONS.java.
 * If NORTHEAST has to be added as a direction, add it in between NORTH AND EAST enums and define
 * a proper moveInDirection() method. and update NOOFDIRECTIONS.
 * 
 * ENUMs were introduced from Java 1.5. So this program is not compatible with java older than version 1.5
 * 
 * @author Sharvari Nagesh
 *
 */
public enum DIRECTIONS{
	NORTH
	{
		public Coordinates moveInDirection(Coordinates xy){
			xy.incrementY();
			return xy;
		}
			
	},
	EAST
	{
		public Coordinates moveInDirection(Coordinates xy){
			xy.incrementX();
			return xy;
		}
	},
	SOUTH
	{
		public Coordinates moveInDirection(Coordinates xy){
			xy.decrementY();
			return xy;
		}
	},
	
	WEST
	{
		public Coordinates moveInDirection(Coordinates xy){
			xy.decrementX();
			return xy;
		}
	};
	public final int NOOFDIRECTIONS = 4;
	public abstract Coordinates moveInDirection(Coordinates xy);
}