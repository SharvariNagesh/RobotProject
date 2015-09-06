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
	public void test() {
		placeCmdTest = new PlaceCommand(robot, "PLACE 3,3,EAST");
		placeCmdTest.execute();
		assertEquals("3,3 EAST", robot.report());
	}

}
