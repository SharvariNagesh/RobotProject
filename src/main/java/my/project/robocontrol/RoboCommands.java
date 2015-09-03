package my.project.robocontrol;

/**
 * 
 * @author Sharvari Nagesh
 * 
 * This is the interface which declares the methods for controlling Robot.
 * Concrete Robot control commands for controlling Robot will be implementing this interface.
 * Robot Control will be using command design pattern.
 *
 */
public interface RoboCommands {

	public void execute();
}

