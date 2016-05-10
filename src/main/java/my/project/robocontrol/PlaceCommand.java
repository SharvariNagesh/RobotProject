package my.project.robocontrol;

/**
 * 
 * This class implements the interface RoboCommands. This is the class which takes care of 
 * placing the Robot properly on the table. It reads the arguments for command "PLACE" and 
 * checks for the following things before placing the Robot on the table :.
 *  1.The XY coordinates have valid integer values.
 * 	2.Direction mentioned in the command is valid and is an accepted direction by the Robot.
 * 	3. XY coordinate mentioned in the PLACE command lies within the table.
 * If any of the above checks fail, PlaceCommand ignores the "PLACE" command.
 * 
 * 
 *  @author Sharvari Nagesh
 */

public class PlaceCommand implements RoboCommands {
	private Robot robot;
	private String command ;
	
	static
	{
		Robot tempRobot = null;
		CommandFactory.getInstance().registerCommand("PLACE", new PlaceCommand(tempRobot, ""));
	}
	
	public PlaceCommand(Robot robot, String command){
		this.robot = robot;
		this.command = command;
	}
	
	public PlaceCommand createCommandObject(Robot robot, String commandLine)
	{
		return new PlaceCommand(robot, commandLine);
	}
	
	//This is the execute command implementation. 
	@Override
	public String execute(){
		
	
		try{
			String[] cmdAndParameters = command.split("[ ]+");
			String[] parameters = cmdAndParameters[1].split(",");
			
			//If a non integer is passed as parameter, Integer.parseInt throws an error and this command will be ignored
		  
			int xCoordinate = Integer.parseInt(parameters[0]);
			int yCoordinate = Integer.parseInt(parameters[1]);
		
			//If the direction is not valid, it throws an exception which will be caught by the catch block
			DIRECTIONS facing = DIRECTIONS.valueOf(parameters[2]); 
		    
			Coordinates xy = new Coordinates(xCoordinate,yCoordinate);
	   
			if (Table.getInstance().isOnTable(xy)){
				robot.place(facing, xy);
			}
			//If the coordinates pased is out of the table, the PLACE command is ignored
		
		}catch(NullPointerException npe){
			//Nothing is done here. The command is ignored
		}catch(IllegalArgumentException iae){
			//If illegal arguments are passed, the command will be ignored
			
		}catch( ArrayIndexOutOfBoundsException aiob){
			// If insufficient arguments are passed, command is ignored
		}
		catch(Exception e){
			//All other Exceptions are caught here and ignored.
		}
		return null;
	}
}