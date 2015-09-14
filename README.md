ABOUT THE ROBOT PROJECT:
  
  This is a project to simulate a simple Robot. This document describes the project specifications, design, requirements and steps to compile and run the code.

SPECIFICATIONS:

   The code controls a simulated Robot. The Robot has to be placed on a table on which Robot will move around. Default size of the table is 5 x 5 units. The position on table is denoted by (x,y) coordinates. For example, (0,0) is the south west corner and (5,5) is the northeastern corner of the table. Code assumes that there is no other obstruction on the table and after placing, Robot can move, turn right or left on the table.

   Robot takes commands from the user either in a file passed as an argument or from the command line. If no file is passed as an argument, commands will be taken from command line. Commands can be given to the Robot in any order and Robot will move/turn/report accordingly. Any invalid command or commands before a PLACE command or commands resulting in Robot moving out of the table will be ignored.

The commands Robot takes are as follows:

1. PLACE x,y,direction
2. MOVE
3. LEFT
4. RIGHT
5. REPORT

  PLACE x,y,direction : PLACE command is the first valid command for the Robot. (x,y) denotes the X&Y coordinate of the Table where Robot is placed. Program has to make sure that Robot is placed within the Table. The direction is the direction in which Robot is facing, which can be one of (NORTH,EAST,SOUTH,WEST). Before a valid PLACE command is executed, program does not allow execution of other commands like MOVE, LEFT, RIGHT on the Robot. A new PLACE command will make the Robot be placed in a new Position facing the direction provided in the new PLACE command. A PLACE command without a proper (x,y) coordinate value and direction will be ignored.

   MOVE : MOVE command makes the Robot move one unit in the direction it is facing. Code has to make sure the move does not make the Robot fall off the table. For example, if Robot is placed in (3,3) coordinate facing NORTH, a move would result in moving the Robot north resulting in coordinates (3,4). Similarly, a move for a Robot facing EAST with (3,3) coordinates will take the Robot to (4,3) position.

   LEFT: Left command makes the Robot turn to its left. If Robot is facing NORTH, a left turn will make it face WEST.

  RIGHT: Right command makes the Robot turn to its right. If Robot is facing NORTH, a right turn will make it face EAST.

  REPORT: A Report command to the Robot will print the current position of the Robot and the direction it is facing. If Report command is given to the Robot which is not placed on the Table, the code will announce that "Robot is not placed on the table".

  When commands are given to the program using command line, "EXIT" can be used to exit from the program.


ENVIRONMENT TO COMPILE & RUN THE CODE
  The code is developed and tested on WINDOWS 7 machine with Oracle JDK 1.8.4. Because Java is portable, this code should theoretically compile and run on any platform. This code is known to be incompatible with versions lesser than Java 1.5.

  The code is successfully compiled and tested with oracle jdk7 and oracle jdk 8.


   To Compile and run the code one needs to have a proper Java installed on their machine. JDK 8 and JRE 8 installation instructions can be found here : https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html

   To build the software using gradle, one has to have the latest gradle software installed on their machine. Gradle download and installation details can be found in this website: https://docs.gradle.org/current/userguide/installation.html.

   After the environment is set, one can build the application and run its unit test cases using below command from the Project root directory:

   $gradle build

   An executable jar RobotProject.jar file will be created under:  RobotProject/build/libs/ folder.


TO RUN THE PROGRAM:
   To run the jar file execute below command

	$java -jar RobotProject.jar [file name]

   Here [file name] is an optional parameter to the executable. This file is a command file, which will have commands for the robot. It can have any number of PLACE,MOVE,LEFT,RIGHT,REPORT commands in it. Each command should be in a new line without any preceding blank spaces.

An example RoboCommand.txt might look like:

RoboCommand.txt :
PLACE 2,2,NORTH
RIGHT
MOVE
MOVE
LEFT
REPORT


   Any invalid command or commands which result in robot moving out of the table will be ignored. Commands can be typed either in capital letters or lowercase letters. PLACE command needs X&Y coordinates and the direction in which Robot is facing. X&Y should be two integers from 0-5 and direction can be one of (North, East, South, West). X & Y coordinates and direction should be separated by a comma.
 
  While executing the jar file, if file name is not passed, then the program will ask for inputs from the user from command line.

example:
$ java -jar RobotProject.jar
Enter commands to control your ROBOT(enter EXIT to exit the code):

   A user can enter commands to control the robot. EXIT command is used to exit from the program when running in the command mode.

  For every REPORT command, program will print the current Robot position in the format of X,Y DIRECTION, where X,Y are x&y coordinates of the robot and DIRECTION is the direction in which Robot is currently facing.

  example:
	Robot Position :4,4 SOUTH


DESIGN DISCUSSION:

  The main classes of Robot project are Robot, Table, RoboCommands, and CommandController.

  The main function creates an instance of a Robot and passes it to a CommandController. If a file name is passed to main as an argument, it is passed to the CommandController to read commands from. If no arguments are provided, then Command Controller will read from the system input.

   Then the CommandController's executeCommand() method reads commands either from a file or from user input, parses the command, encapsulates the command in an appropriate command object and executes the command.

   An interface "RoboCommands" is defined for commands. Each command accepted by Robot is defined as a separate Command class and they implement the RoboCommands interface.

   The command classes takes the command, interprets it, checks for all conditions like whether Robot is placed properly, or whether a move of the robot results in the Robot falling off the table etc. and executes the command.

   The "Robot" class represents the robot of our simulation. The Robot has a position and a direction. Robot stores its position in the form of (x,y) coordinates. A class "Coordinates" is used to define (x,y) coordinates. Robot can be facing in one of NORTH/EAST/SOUTH/WEST directions. To store the Robot's direction an enum, "DIRECTIONS" is defined. Since an enum is used to store the directions, there are predefined set of directions supported by the code. Any invalid value will not be accepted into the enum variable.

  Enum DIRECTIONS also defines a method called moveInDirection(). If you pass a (x,y) coordinate to this function, depending on the direction, it knows which (x,y) value to increment/decrement to make the Robot move in that direction.



   By using an enum, the code is cleaner, readable, reduces error. Enhancing the Robot code to include more directions need changes only to the enum DIRECTIONS.

   Initial plan was to include both Coordinates and Directions inside a single enum. To make the code more readable and clean, I decided to separate (x,y) coordinates and directions.

   Robot has following methods
    1. place, which sets the (x,y) coordinates and directions
    2. move, which will call the moveInDirection() of the enum and passes the (x,y) coordinates to it.
    3. turnRight, makes it set the value direction to next direction in the enum to its right.
    4. turnLeft, makes Robot to set the value of direction to next direction to its left.
    5. Report, will make the Robot announce it's (x,y) coordinates and it's direction.

   In addition to the above function, Robot has two get methods to get its direction and coordinates. It also defines a method called isRobotPlaced() which will return true if a PLACE command is already executed on the Robot.

   The Table class is a singleton class. Instance of Table need not be created and can be accessed from anywhere. Singleton implementation is used for Table, so that there is only one table exists even if more Robots are added and Table need not be instantiated. The entire code uses a single Table instance, without passing the instance of table around. Table has a default size of 5 x 5 units. But it also provides a set method to change the size of the Table, though it is not used in the code. Idea is, if required, it can be used in the future. Table also provides a method called isOnTable(), which takes (x,y) coordinates and tells whether it lies within the table or not.

   My Initial plan of making Table a Singleton class is because both commands and Robot classes can access the table. But then decided that Robot should not know about Table and it should be a simple robot which moves, turns and reports its position. I am not sure, giving a setSize for table is a good idea. If different objects keep changing the table size, it might become a problem.

   Here the Robot does not know anything about the table. It just knows how to move, turn or set/get it's parameters. It is the responsibility of the Command implementation class to make sure the Robot is always on the Table and the move and turn commands are delivered to Robot only after its first PLACE command.

  Robot Project is implemented using command design pattern. Command design pattern helps creating an abstraction of robot and its command implementations. Command design patter also decouples the main function from the Robot. All that a main has to do is, create a robot and its handler and handler will take care of controlling the Robot. This also makes adding new commands, enhancing a command, creating more robots if required in future very easy. For example, if MOVE is enhanced to take a parameter like "MOVE 2" to indicate moving two steps in future, this can be done with changes only to Move Command implementation class.

   Usually in command design implementations, the commands will be stored in an array list first and then extracted one by one to execute. This also, enables undoing of the commands. I had planned to have an array list but thought, since the code is also taking an input from the command line, and a report command from command line needs an immediate reply, commands need to be executed as soon as the user types it without storing it internally.

   The part I liked is the designing and implementation of command interfaces. Most of the decision making happens in these classes and it also makes the code cleaner.


LICENSE:

This is free and unencumbered software released into the public domain.

Anyone is free to copy, modify, publish, use, compile, sell, or
distribute this software, either in source code form or as a compiled
binary, for any purpose, commercial or non-commercial, and by any
means.

In jurisdictions that recognize copyright laws, the author or authors
of this software dedicate any and all copyright interest in the
software to the public domain. We make this dedication for the benefit
of the public at large and to the detriment of our heirs and
successors. We intend this dedication to be an overt act of
relinquishment in perpetuity of all present and future rights to this
software under copyright law.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE.

For more information, please refer to <http://unlicense.org/>
