package my.project.robocontrol;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LeftCommandTest {
private Robot robot;
private RoboCommands placeCmd;
private RoboCommands leftCmd;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		robot = new Robot();
		placeCmd = new PlaceCommand(robot, "PLACE 5,5,NORTH");
		leftCmd = new LeftCommand(robot,"LEFT");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testForBasicLeftCommandImplementation() {
		placeCmd.execute();
		leftCmd.execute();
		assertEquals("5,5 WEST", robot.report());
		
	}

	@Test
	public void testForLeftTurnWhenRobotIsNotPlaced() {
		Robot robot2 = new Robot();
		RoboCommands leftCmd = new LeftCommand(robot2, "LEFT");
		leftCmd.execute();
		assertEquals(null, robot.report());
		
	}

	@Test
	public void testForLeftTurnWhenRobotIsNotInitializedNoExceptionShouldBeThrown() {
		Robot robot2 = null;
		RoboCommands leftCmd = new LeftCommand(robot2, "LEFT");
		leftCmd.execute();
		
	}
}
