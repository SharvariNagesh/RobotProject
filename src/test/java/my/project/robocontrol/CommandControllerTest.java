package my.project.robocontrol;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CommandControllerTest {
	private CommandController cmdController;
	private Robot robot;
	private String fileName;
	
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

	/*contents of RobotCommands.txt ::w
	 * 
	 * PLACE 3,3,SOUTH
	 * MOVE
	 * MOVE
	 * LEFT
	 * REPORT
	 */
	@Test
	public void testToCheckBasicCommandControl() {
		
		fileName = "dataForTest/RobotCommands.txt";
		cmdController = new CommandController(robot,fileName);
		assertEquals("3,1 EAST", cmdController.executeCommands());
	}


	/*contents of RobotWrongCommands.txt
	 * 
	 * PLACE 3,3,SOUTH
	 * MOVE
	 * MVE
	 * LEFT
	 * REPORT
	 */
	@Test
	public void testToCheckCommandControlWhenWrongCommandIsPassed() {
		
		fileName = "dataForTest/RobotWrongCommands.txt";
		cmdController = new CommandController(robot,fileName);
		assertEquals("3,2 EAST", cmdController.executeCommands());
	}
	
	/*contents of RobotWrongCommands.txt
	 * 
	 * 
	 * MOVE
	 * MOVE
	 * LEFT
	 * REPORT
	 */
	@Test
	public void testToCheckCommandControlWithoutPlacingTheRobot() {
		
		fileName = "dataForTest/RobotCommandsWithoutPlaceCmd.txt";
		cmdController = new CommandController(robot,fileName);
		assertEquals("Robot not placed on the Table", cmdController.executeCommands());
	}
	
	/*contents of RobotWrongCommands.txt
	 * 
	 * PLACE 20,20,NORTH 
	 * MOVE
	 * MOVE
	 * LEFT
	 * REPORT
	 */
	@Test
	public void testToCheckCommandControlWhenRobotIsPlacedOutOfTable() {
		
		fileName = "dataForTest/RobotCommandsWitRobotPlacedOutOfTable.txt";
		cmdController = new CommandController(robot,fileName);
		assertEquals("Robot not placed on the Table", cmdController.executeCommands());
	}
	
	/*contents of RobotWrongCommands.txt
	 * 
	 * PLACE 5,5,NORTH 
	 * MOVE
	 * MOVE
	 * LEFT
	 * REPORT
	 */
	@Test
	public void testToCheckCommandWhenRobotIsMadeToMoveOutOfTable() {
		
		fileName = "dataForTest/RobotCommandsWitRobotMoveOutOfTable.txt";
		cmdController = new CommandController(robot,fileName);
		assertEquals("5,5 WEST", cmdController.executeCommands());
	}
	

	@Test
	public void testToCheckCommandControlWhenNonExistentFileIsPassedToTheFunction() {
		
		fileName = "dataForTest/RobotCommandsNonExistent.txt";
		cmdController = new CommandController(robot,fileName);
		assertEquals(null, cmdController.executeCommands());
	}
	
	/*contents of RobotCommandsWithoutPlaceParameters.txt
	 * 
	 * PLACE
	 * MOVE
	 * MOVE
	 * LEFT
	 * REPORT
	 */
	@Test
	public void testToCheckCommandWhenRobotIsPlacedWithoutParameters() {
		
		fileName = "dataForTest/RobotCommandsWithoutPlaceParameters.txt";
		cmdController = new CommandController(robot,fileName);
		assertEquals("Robot not placed on the Table", cmdController.executeCommands());
	}
}
