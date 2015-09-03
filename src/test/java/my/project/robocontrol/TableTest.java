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
	
	@Test
	public void testToSetTableWidthAndBreadthAndCheckBreadthFromTableStaticIntance() {
		table.setSize(10, 10);
		assertEquals(10, table.getBreadth());
	}
	@Test
	public void testToSetTableWidthAndBreadthAndCheckWidthFromTableStaticIntance() {
		table.setSize(10, 10);
		assertEquals(10, table.getWidth());
	}
	
	@Test
	public void testToSetTableWidthWithANegetiveValueTableClassShouldIgnoreTheNegetiveValue() {
		int x = table.getWidth();
		table.setSize(-10, 10);
		assertEquals(x, table.getWidth());
	}
	
	@Test
	public void testToSetTableBreadthWithANegetiveValueTableClassShouldIgnoreTheNegetiveValue() {
		int y = table.getBreadth();
		table.setSize(10, -10);
		assertEquals(y, table.getBreadth());
	}
}
