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

}
