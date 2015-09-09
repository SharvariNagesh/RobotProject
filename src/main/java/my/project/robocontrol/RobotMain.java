package my.project.robocontrol;
/**
 * 
 * @author Sharvari Nagesh
 *
 */
public class RobotMain {

	public static void main(String[] args) {
		Robot robot = new Robot();
		CommandController robotCommandController;
		
		if (args.length >1)
		{
			robotCommandController = new CommandController(robot, args[1]);
		}
		else
		{
			robotCommandController = new CommandController(robot, null);
		}
		robotCommandController.executeCommands();
		
	}

}
