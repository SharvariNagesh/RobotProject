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

	/*First 2 test cases are for testing default value of the table Width and breadth.
	 * Since JUnit, does not execute test cases in order, if the first 2 test cases are not
	 * executed before other tests, these 2 test cases fail.
	 * For now, keeping it commented.
	*/
	/*@Test
	public void testToGetTableBreadthFromTableStaticIntance() {
		assertEquals(5, table.getBreadth());
	}
	@Test
	public void testToGetTableWidthFromTableStaticIntance() {
		assertEquals(5, table.getWidth());
	}
	*/
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
	@Test
	public void testToSetTableWidthWithALargeValueTableClassShouldSetTheNewValue() {
		int x = 2147483647; //This is the max value a java int can hold
		int y = table.getBreadth(); //Here keeping the y as before
		table.setSize(x, y); 
		assertEquals(x, table.getWidth());
	}
	
	@Test
	public void testToSetTableBreadthWithALargeValueTableClassShouldSetTheNewValue() {
		int y = 2147483647;
		int x = table.getWidth();
		table.setSize(x, y);
		assertEquals(y, table.getBreadth());
	}
	@Test
	public void testToSetTableWidthWith0ValueTableClassShouldNotTakeTheNewValue() {
		int oldX = table.getBreadth();
		int x = 0; //This is the max value a java int can hold
		int y = table.getBreadth(); //Here keeping the y as before
		table.setSize(x, y); 
		assertEquals(oldX, table.getWidth());
	}
	
	@Test
	public void testToSetTableBreadthWith0ValueTableClassShouldNotTakeTheNewValue() {
		int oldY = table.getBreadth();
		int y = 0;
		int x = table.getWidth();
		table.setSize(x, y);
		assertEquals(oldY, table.getBreadth());
	}
	
	@Test
	public void testTocheckIfASetOfCoordinatesIsOnTheTable(){
		table.setSize(10, 10);
		assertTrue(table.isOnTable(5, 5));
	}
	
	
}
