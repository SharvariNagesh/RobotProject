package my.project.robocontrol;

/**
 * 
 * @author Sharvari Nagesh
 *
 *This is the class which will read commands from a file and create appropriate instances of 
 *commands and executes them.
 *If the file is not passed for this class, it reads the command from input Stream.
 *In case entering the commands for the program, user can use "EXIT" to exit from the program.
 *
 */


import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class CommandController {
private Robot robot;
private String fileName;
private Scanner inputScanner;
private String output;

   public CommandController(Robot rbt, String fileName)
   {
	   this.robot = rbt;
	 try{
		 if(fileName != null)
		 {
		    inputScanner = new Scanner(new File(fileName));
		 }else
		 {
			 inputScanner = new Scanner(System.in);
			 System.out.println("Enter commands to control your ROBOT:");
		 }
	 }catch(FileNotFoundException fe)
	 {
		 System.out.println("Please provide a valid file. " + fileName +" could not be found");
	 }
   }
   
   public String executeCommands()
   {
	   RoboCommands roboCommand;
	   while(true)
	   {
		   roboCommand = getNextCommand();
		   if (roboCommand != null)
		   {
			   output = roboCommand.execute();
		   }else{
			   return output;
		   }
	   }
	 
   }
 
   public RoboCommands getNextCommand()
   {
	   RoboCommands roboCommand=null;
	   boolean commandFound = false;
	 
	   
	   while(!commandFound)
	   {
		   if (!inputScanner.hasNextLine()){
			   return null;
		   } 
		   
		   String commandLine = inputScanner.nextLine().toUpperCase();
		   String command = commandLine.split("[ ]+")[0];
		   commandFound = true;
		   switch(command)
		   {
		   case "PLACE":
			   roboCommand = new PlaceCommand(robot,commandLine);
			   break;
			   
		   case "MOVE":
			   roboCommand = new MoveCommand(robot,commandLine);
			   break;
		   case "LEFT":
			   roboCommand = new LeftCommand(robot,commandLine);
			   break;
		   case "RIGHT" :
			   roboCommand = new RightCommand(robot,commandLine);
			   break;
		   case "REPORT" :
			   roboCommand = new ReportCommand(robot,commandLine);
			   break;
		   case "EXIT" :
			   //This case is used to exit the code when user is inputing from the commandline.
			   break;
			   //If any other invalid command is passed then, next line is read from the command file
		   default:
			   commandFound = false;
			   break;
		   
		   }
   }
	   return roboCommand;
   }
}
