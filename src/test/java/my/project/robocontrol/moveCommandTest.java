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
		placeCmd = new PlaceCommand(robot, "PLACE 5,5,SOUTH");
		moveCmd = new MoveCommand(robot, "MOVE");
		reportCmd = new ReportCommand(robot, "REPORT");
	}

	@After
	public void tearDown() throws Exception {
		robot = null;
		placeCmd = null;
		moveCmd = null;
	}

	@Test
	public void testMoveCommand() {
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
}
