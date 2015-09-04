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
	  DIRECTIONS pos = DIRECTIONS.valueOf("NORTH");
	  robot.place(pos, 0, 0);
	  assertEquals("0,0 NORTH", robot.report());
	}
	
	@Test
	public void testToTurnRobotFacingNorthAndThenTurnRight() {
	  DIRECTIONS pos = DIRECTIONS.valueOf("NORTH");
	  robot.place(pos, 0, 0);
	  robot.turnRight();
	  assertEquals("0,0 EAST", robot.report());
	}

	@Test
	public void testToTurnRobotFacingWestAndThenTurnRight() {
	  DIRECTIONS pos = DIRECTIONS.valueOf("WEST");
	  robot.place(pos, 0, 0);
	  robot.turnRight();
	  assertEquals("0,0 NORTH", robot.report());
	}
	
	@Test
	public void testToTurnLeftRobotFacingWest() {
	  DIRECTIONS pos = DIRECTIONS.valueOf("WEST");
	  robot.place(pos, 0, 0);
	  robot.turnLeft();
	  assertEquals("0,0 SOUTH", robot.report());
	}

	@Test
	public void testToTurnLeftRobotFacing() {
	 DIRECTIONS pos = DIRECTIONS.valueOf("NORTH");
	  robot.place(pos, 0, 0);
	  robot.turnLeft();
	  assertEquals("0,0 WEST", robot.report());
	}
}
