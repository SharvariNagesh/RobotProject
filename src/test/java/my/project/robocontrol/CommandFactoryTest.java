package my.project.robocontrol;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Rule;

public class CommandFactoryTest {

	private Robot robot;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		robot = new Robot();
	}

	@After
	public void tearDown() throws Exception {
		robot = null;
	}

	@Test
	public void testForCommandFactoryImplementation() {
		CommandFactory cmdFactory = CommandFactory.getInstance();
		RoboCommands rc = cmdFactory.getCommand(robot, "MOVE");
		assertNotNull(rc);
		assertTrue( rc instanceof MoveCommand);
		
	}
	
	@Test
	public void testForCommandFactoryImplementationWhenWrongCommandIsPassed() {
		CommandFactory cmdFactory = CommandFactory.getInstance();
		RoboCommands rc = cmdFactory.getCommand(robot, "MVE");
		assertNull(rc);
	}

	@Test
	public void testForCommandFactoryImplementationForExitCommand() {
		CommandFactory cmdFactory = CommandFactory.getInstance();
		RoboCommands rc = cmdFactory.getCommand(robot, "EXIT");
		assertNotNull(rc);
		
	}
	
	
	
}
