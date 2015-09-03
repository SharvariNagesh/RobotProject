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
		table = Table.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testToGetTableBreadthFromTableStaticIntance() {
		assertEquals(5, table.getBreadth());
	}
	@Test
	public void testToGetTableWidthFromTableStaticIntance() {
		assertEquals(5, table.getBreadth());
	}

}
