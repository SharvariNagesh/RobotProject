package my.project.robocontrol;

public enum DIRECTIONS{
	NORTH
	{
		public Coordinates move(Coordinates xy){
			xy.incrementY();
			return xy;
		}
			
	},
	EAST
	{
		public Coordinates move(Coordinates xy){
			xy.incrementX();
			return xy;
		}
	},
	SOUTH
	{
		public Coordinates move(Coordinates xy){
			xy.decrementY();
			return xy;
		}
	},
	
	WEST
	{
		public Coordinates move(Coordinates xy){
			xy.decrementX();
			return xy;
		}
	};
	public final int NOOFDIRECTIONS = 4;
	public abstract Coordinates move(Coordinates xy);
}