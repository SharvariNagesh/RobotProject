package my.project.robocontrol;

/*
 * This is the class which implements the command to place the robot
 */

public class PlaceCommand implements RoboCommands {
	private Robot robot;
	private String command ;
	public PlaceCommand(Robot robot, String command){
		this.robot = robot;
		this.command = command;
	}
	
	//This is the execute command implementation. 
	@Override
	public void execute(){
		
		String[] cmdAndParameters = command.split("[ ]+");
		String[] parameters = cmdAndParameters[1].split(",");
		
		try{
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
	}
}