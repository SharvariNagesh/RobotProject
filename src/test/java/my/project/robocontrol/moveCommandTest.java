package my.project.robocontrol;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class moveCommandTest {
private Robot robot;
private RoboCommands placeCmd;
private RoboCommands moveCmd;
private RoboCommands reportCmd;
	@Before
	public void setUp() throws Exception {
		robot = new Robot();
		
		moveCmd = new MoveCommand(robot, "MOVE");
		reportCmd = new ReportCommand(robot, "REPORT");
		Table.getInstance().setSize(5, 5);
	}

	@After
	public void tearDown() throws Exception {
		robot = null;
		placeCmd = null;
		moveCmd = null;
	}

	@Test
	public void testMoveCommand() {
		placeCmd = new PlaceCommand(robot, "PLACE 5,5,SOUTH");
		placeCmd.execute();
		moveCmd.execute();
		assertEquals("5,4 SOUTH", reportCmd.execute());
		
	}

	@Test
	public void testToMoveARobotWhichIsNotInitialized()
	{
		Robot robot2 = null;
		 RoboCommands placeCmd2 = new PlaceCommand(robot2,"PLACE 5,5,NORTH");
		 RoboCommands moveCmd2 = new MoveCommand(robot2,"Move");
		 RoboCommands reportCmd2 = new ReportCommand(robot2,"REPORT");
		placeCmd2.execute();
		moveCmd2.execute();
		assertEquals("Robot not placed on the Table",reportCmd2.execute());
	}
	
	@Test
	public void testForMoveWhenRobotIsNotPlaced() {
		Robot robot2 = new Robot();
		RoboCommands moveCmd2 = new MoveCommand(robot2,"MOVE");
		RoboCommands reportCmd2 = new ReportCommand(robot2, "REPORT");
		moveCmd2.execute();
		assertEquals("Robot not placed on the Table",reportCmd2.execute());
	}
	
	@Test
	public void testToMoveRobotOutOfTheTable() {
		placeCmd = new PlaceCommand(robot, "PLACE 5,5,SOUTH");
		RoboCommands left = new LeftCommand(robot,"LEFT");
		
		placeCmd.execute();
		left.execute();
		moveCmd.execute();
		assertEquals("5,5 EAST", reportCmd.execute());
		
	}
	
	@Test
	public void testToMoveRobotInNorthDirection() {
		placeCmd = new PlaceCommand(robot, "PLACE 0,0,NORTH");
		placeCmd.execute();
		moveCmd.execute();
		assertEquals("0,1 NORTH", reportCmd.execute());
	}
	
	@Test
	public void testToMoveRobotInEASTDirection() {
		placeCmd = new PlaceCommand(robot, "PLACE 0,0,EAST");
		placeCmd.execute();
		moveCmd.execute();
		assertEquals("1,0 EAST", reportCmd.execute());
	}
	
	@Test
	public void testToMoveRobotInWestDirection() {
		placeCmd = new PlaceCommand(robot, "PLACE 3,3,WEST");
		placeCmd.execute();
		moveCmd.execute();
		assertEquals("2,3 WEST", reportCmd.execute());
	}
	
	@Test
	public void testToMoveRobotInSouthDirection() {
		placeCmd = new PlaceCommand(robot, "PLACE 2,2,SOUTH");
		placeCmd.execute();
		moveCmd.execute();
		assertEquals("2,1 SOUTH", reportCmd.execute());
	}
	
	//Some more tests to move Robot out of Table in all direction
	
	@Test
	public void testToMoveRobotOutOfTableFromSouth() {
		placeCmd = new PlaceCommand(robot, "PLACE 0,0,SOUTH");
		placeCmd.execute();
		moveCmd.execute();
		assertEquals("0,0 SOUTH", reportCmd.execute());
	}
	
	@Test
	public void testToMoveRobotOutOfTableFromNorth() {
		placeCmd = new PlaceCommand(robot, "PLACE 3,5,NORTH");
		placeCmd.execute();
		moveCmd.execute();
		assertEquals("3,5 NORTH", reportCmd.execute());
	}
	
	@Test
	public void testToMoveRobotOutOfTableFromEast() {
		placeCmd = new PlaceCommand(robot, "PLACE 5,2,EAST");
		placeCmd.execute();
		moveCmd.execute();
		assertEquals("5,2 EAST", reportCmd.execute());
	}
	
	@Test
	public void testToMoveRobotOutOfTableFromWest() {
		placeCmd = new PlaceCommand(robot, "PLACE 0,4,WEST");
		placeCmd.execute();
		moveCmd.execute();
		assertEquals("0,4 WEST", reportCmd.execute());
	}
	
}
