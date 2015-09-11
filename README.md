ABOUT THE ROBOT PROJECT :

    	This is a project to simulate a simple Robot. This document describes the project specifications, design, requirements and steps to compile and run the code.

SPECIFICATIONS:

   The code controls a simulated Robot. The Robot has to be placed on a table and will move around on the table. Default size of the table is  5 x 5 units. The position on table is denoted by (x,y) coordinates. For example, (0,0) is the south west corner and (5,5) is the northeastern corner of the table. Code assumes that there is no other obstruction on the table and after placing, Robot can move, turn right or left on the table. 

    Robot takes commands from the user either in a file passed as an argument or from the command line. If no file is passed as an argument, commands will be taken from command line. Commands can be given to the Robot in any order and Robot will move/turn/report accordingly. Any invalid command or commands before a PLACE command or commands resulting in Robot moving out of the table will be ignored.

The commands Robot takes are as follows:

1. PLACE x,y,direction
2. MOVE
3. LEFT
4. RIGHT
5. REPORT

  PLACE x,y,direction : PLACE command is the first valid command for the Robot. (x,y) denotes the X&Y coordinate of the Table where Robot is placed. Program has to make sure that Robot is placed within the Table. The direction is the direction in which Robot is facing, which can be one of (NORTH,EAST,SOUTH,WEST). Before a valid PLACE command is executed, program should not allow execution of other commands like MOVE, LEFT, RIGHt on the Robot. A new PLACE command will make the Robot move to a new Position. A PLACE command without proper (x,y) coordinate value and direction will be ignored.
           
   MOVE : MOVE command makes the Robot move one unit in the direction it is facing. Code has to make sure the move does not make the Robot fall off the table. For example, if Robot is placed in (3,3) coordinate facing NORTH, a move would result in moving the Robot north resulting in coordinates (3,4). Similarly, for a Robot facing EAST with (3,3) coordinate will take the Robot to (4,3) position. 

   LEFT: Left command makes the Robot turn to it's left. If Robot is facing NORTH, a left turn will make it face WEST.

  RIGHT: Right command makes the Robot turn to it's right. If Robot is facing NORTH, a right turn will make it face EAST.

  REPORT: A Report command to the Robot will print the current position of the Robot and the direction it is facing. If Report command is given to the Robot which is not placed on the Table, the code will announce that "Robot is not placed on the table".

  When commands are given to the progam using command line, "EXIT" can be used to exit from the program. 

ENIVRONMENT TO COMPILE & RUN THE CODE

     The code is developed and tested on WINDOWS 7 machine with Oracle JDK 1.8.4. Because Java is portable, this code should theoritically compile and run on any platform. This code is known to be incompatible with versions lesser than Java 1.5.
 
  The code is successfully compiled and tested with oracle jdk7 and oracle jdk 8.

    
   To Compile and run the code one needs to have a proper Java installed on their machine. JDK 8 and JRE 8 installation instructions can be found here : https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html

   To build the software using gradle, one has to have the latest gradle software installed on their machine. Gradle download and installation details can be found in this website: https://docs.gradle.org/current/userguide/installation.html.

   After the environment is set, one can build the application and run it's unit test cases using below command from the Project root directory:
   
   $gradle build

   An executable jar RobotProject.jar file will be created under:  RobotProject/build/libs/ folder. 


TO RUN THE PROGRAM: 
   To run the jar file execute below command

	$java -jar RobotProject.jar  [file name]

   Here [file name] is an optional parameter to executable. This file is a command file, which will have commands for the robot. It can have any number of PLACE,MOVE,LEFT,RIGHT commands in it. 
An example RoboCommand.txt might look like:

RoboCommand.txt :
PLACE 2,2,NORTH
RIGHT
MOVE
MOVE
LEFT
REPORT
       

   Any invalid command or commands which result in robot moving out of the table will be ignored. Commands can be typed either in capital letters or lowercase letters. PLACE command needs X&Y coordinates and the direction in which Robot is facing. X&Y should be two integers from 0-5 and direction can be one of (North, East, South, West). X & Y coordinates and direction should be seperated by a comma.

    While executing the jar file, if file name is not passed, then the program will ask for inputs from the user from command line.

example:
$ java -jar RobotProject.jar
Enter commands to control your ROBOT(enter EXIT to exit the code):

   A user can enter commands to control the robot. EXIT command is used to exit from the program when running in the command mode.

  For every REPORT command, program will print the current Robot position in the format of X,Y DIRECTION, where X,Y are xy coordinates of the robot and DIRECTION is the direction in which Robot is currently facing. 

  example:
	Robot Position :4,4 SOUTH











