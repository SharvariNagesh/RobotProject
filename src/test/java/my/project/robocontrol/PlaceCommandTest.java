package my.project.robocontrol;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlaceCommandTest {
RoboCommands placeCmdTest;
Robot robot ;
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
	}

	@Test
	public void testBasicPlaceCommandImplementation() {
		placeCmdTest = new PlaceCommand(robot, "PLACE 3,3,EAST");
		placeCmdTest.execute();
		assertEquals("3,3 EAST", robot.report());
	}
	
	@Test
	public void testWrongDirectionValueInPlaceCommand() {
		placeCmdTest = new PlaceCommand(robot, "PLACE 3,3,EEEAST");
		placeCmdTest.execute();
		assertEquals(null, robot.report());
	}

	@Test
	public void testNonIntegerXCoordinateValueInPlaceCommand() {
		placeCmdTest = new PlaceCommand(robot, "PLACE A,3,EEEAST");
		placeCmdTest.execute();
		assertEquals(null, robot.report());
	}
	
	@Test
	public void testNoDirectionValueInPlaceCommand() {
		placeCmdTest = new PlaceCommand(robot, "PLACE 5,3");
		placeCmdTest.execute();
		assertEquals(null, robot.report());
	}
	
	@Test
	public void testToPlaceRobotOutOfTheTableSurface() {
		placeCmdTest = new PlaceCommand(robot, "PLACE 50,3,WEST");
		placeCmdTest.execute();
		assertEquals(null, robot.report());
	}
	
	@Test
	public void testToPlaceUnInitializedRobot() {
		Robot robot2 = null;
		placeCmdTest = new PlaceCommand(robot2, "PLACE 50,3,WEST");
		placeCmdTest.execute();
		
	}
	

}

