package my.project.robocontrol;

public class ExitCommand implements RoboCommands{
	private Robot robot;

	static
	{
		Robot tempRobot = null;
		CommandFactory.getInstance().registerCommand("EXIT", new ExitCommand(tempRobot, ""));
	}
	   
	   public ExitCommand(Robot robot, String commandLine)
	    {
	    	this.robot = robot;
	    }
		public String execute()
		{
			return null;
		}
		
		public ExitCommand createCommandObject(Robot robot, String commandLine)
		{
			return new ExitCommand(robot, commandLine);
		}

}
