package my.project.robocontrol;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RobotTest {

	Robot robot;
	
	@Before
	public void setUp() throws Exception {
		robot = new Robot();
	}

	@After
	public void tearDown() throws Exception {
		robot = null;
	}

	@Test
	public void testToCreateARobotAndPlaceIt() {
	  POSITION pos = POSITION.valueOf("NORTH");
	  robot.place(pos, 0, 0);
	  assertEquals("0,0 NORTH", robot.report());
	}
	
	@Test
	public void testToTurnRobotFacingNorthAndThenTurnRight() {
	  POSITION pos = POSITION.valueOf("NORTH");
	  robot.place(pos, 0, 0);
	  robot.turnRight();
	  assertEquals("0,0 EAST", robot.report());
	}

	@Test
	public void testToTurnRobotFacingWestAndThenTurnRight() {
	  POSITION pos = POSITION.valueOf("WEST");
	  robot.place(pos, 0, 0);
	  robot.turnRight();
	  assertEquals("0,0 NORTH", robot.report());
	}
}
