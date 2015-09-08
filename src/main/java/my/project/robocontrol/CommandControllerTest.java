package my.project.robocontrol;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CommandControllerTest {
	private CommandController cmdController;
	private static Robot robot;
	private String fileName;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	  robot = new Robot();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

/*contents of RobotCommands.txt ::w
 * 
 * PLACE 3,3,SOUTH
 * MOVE
 * MOVE
 * LEFT
 * REPORT
 */
	@Test
	public void testToCheckBasicConstructorOfCommandControl() {
		fileName = "RobotCommands.txt";
		cmdController = new CommandController(robot,fileName);
		assertEquals("Robot Position :3,1 EAST", cmdController.executeCommands());
	}

}
