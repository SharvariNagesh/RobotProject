package my.project.robocontrol;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TableTest {

	Table table; 
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testToGetTableBreadthFromTableStaticIntance() {
		assertEquals(0, Table.getInstance().getBreadth());
	}

}
