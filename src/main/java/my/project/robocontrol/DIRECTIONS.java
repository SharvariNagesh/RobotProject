package my.project.robocontrol;

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