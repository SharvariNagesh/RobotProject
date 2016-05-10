package my.project.robocontrol;

import java.util.*;

public class CommandFactory {

	private static CommandFactory cmdFactory;
	private static HashMap commandList = new HashMap();
	private CommandFactory(){
		
	} // constructor is private to make sure no more table instances are created
	
	public static synchronized CommandFactory getInstance()
	{
		if (cmdFactory == null)
		{
			cmdFactory = new CommandFactory();
			registerCommands();
		}
		return cmdFactory;
	}
	
	public static void registerCommands()
	{
		try
	
		{
			Class.forName("my.project.robocontrol.MoveCommand");
			Class.forName("my.project.robocontrol.LeftCommand");
			Class.forName("my.project.robocontrol.RightCommand");
			Class.forName("my.project.robocontrol.ReportCommand");
			Class.forName("my.project.robocontrol.PlaceCommand");
		}
		catch (ClassNotFoundException any)
		{
			any.printStackTrace();
		}
	}
	public void registerCommand(String cmd, RoboCommands roboCmd)
	{
		commandList.put(cmd, roboCmd);
	}
	
	public RoboCommands getCommand(Robot robot, String commandLine)
	{
		String command = commandLine.split("[ ]+")[0];
		return ((RoboCommands)commandList.get(command)).createCommandObject(robot, commandLine);
	}
	
}
