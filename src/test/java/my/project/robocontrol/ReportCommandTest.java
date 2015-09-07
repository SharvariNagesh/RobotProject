package my.project.robocontrol;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReportCommandTest {
	private Robot robot;
	private RoboCommands placeCmd;
	private RoboCommands leftCmd;
	private RoboCommands reportCmd;
	@Before
	public void setUp() throws Exception {
		robot = new Robot();
		placeCmd = new PlaceCommand(robot,"PLACE 3,3,SOUTH");
		leftCmd = new LeftCommand(robot, "LEFT");
		reportCmd = new ReportCommand(robot, "REPORT");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBasicReportCommandImplementation() {
		placeCmd.execute();
	    assertEqual("3,3,SOUTH", reportCmd.execute());
	}

}