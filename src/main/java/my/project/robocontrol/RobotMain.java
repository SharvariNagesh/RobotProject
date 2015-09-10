package my.project.robocontrol;
/**
 * RobotMain implements the main() method. This takes care of creating a robot, a commandController
 * to control the robot and calls the executeCommands() method of the CommandController.
 * If the user has passed a argument, which is supposed to be a file containing commands, the same
 * will be passed to CommandController of the robot.
 *  
 * @author Sharvari Nagesh
 *
 */
public class RobotMain {

	public static void main(String[] args) {
		Robot robot = new Robot();
		CommandController robotCommandController;
		
		if (args.length > 0)
		{
			robotCommandController = new CommandController(robot, args[0]);
		}
		else
		{
			robotCommandController = new CommandController(robot, null);
		}
		robotCommandController.executeCommands();
		
	}

}
