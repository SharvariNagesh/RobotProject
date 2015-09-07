package my.project.robocontrol;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RightCommandTest {
	private Robot robot;
	private RoboCommands placeCmd;
	private RoboCommands rightCmd;
	
	@Before
	public void setUp() throws Exception {
		robot = new Robot();
		placeCmd = new PlaceCommand(robot, "PLACE 5,5,NORTH");
		rightCmd = new RightCommand(robot,"RIGHT");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testForRobotLeftTurnTest() {
		placeCmd.execute();
		rightCmd.execute();
		assertEquals("5,5 EAST", robot.report());
	}

	@Test
	public void testForRightTurnWhenRobotIsNotPlaced() {
		Robot robot2 = new Robot();
		RoboCommands rightCmd = new RightCommand(robot2, "RIGHT");
		rightCmd.execute();
		assertEquals(null, robot.report());
	}
	
	@Test
	public void testForRightTurnWhenRobotIsNotInitializedNoExceptionShouldBeThrown() {
		Robot robot2 = null;
		RoboCommands rightCmd = new RightCommand(robot2, "RIGHT");
		rightCmd.execute();
		
	}
}
