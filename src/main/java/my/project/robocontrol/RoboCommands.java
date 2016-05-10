package my.project.robocontrol;

/**
 * 
 * Robot Control project will be using command design pattern.
 * This is the interface which declares the methods for controlling Robot.
 * Concrete Robot control commands for controlling Robot will be implementing this interface.
 * This design will decouple Robot handling from the main function. All the concrete command
 * implementations has to implement the method execute(), which makes executing the commands
 * easy and straight forward.
 * 
 * @author Sharvari Nagesh
 *
 */
public interface RoboCommands {

	public String execute();
	public RoboCommands createCommandObject(Robot robot, String commandLine);
	
}

