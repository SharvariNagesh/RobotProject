package my.project.robocontrol;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TableTest {

	Table table; 
	Coordinates xy;
	
	@Before
	public void setUp() throws Exception {
		table = Table.getInstance();
		xy = new Coordinates(-1,-1);
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
		xy.setXY(5, 5);
		assertTrue(table.isOnTable(xy));
	}
	
	@Test
	public void testTocheckIfASetOfCoordinatesIsNotOnTheTable(){
		table.setSize(10, 10);
		xy.setXY(15, 15);
		assertFalse(table.isOnTable(xy));
	}
	
	@Test
	public void testToCheckNegetiveNoIsNotOnTheTable(){
		table.setSize(10, 10);
		xy.setXY(-3, -10);
		assertFalse(table.isOnTable(xy));
	}
	
	@Test
	public void testToCheckIfYCoordinate0IsOnTheTable(){
		table.setSize(10, 10);
		xy.setXY(3, 0);
		assertTrue(table.isOnTable(xy));
	}
	
	@Test
	public void testToCheckIfBothCoordinate0IsOnTheTable(){
		table.setSize(10, 10);
		xy.setXY(0, 0);
		assertTrue(table.isOnTable(xy));
	}
	@Test
	public void testToCheckIfXCoordinate0IsOnTheTable(){
		table.setSize(10, 10);
		xy.setXY(0, 10);
		assertTrue(table.isOnTable(xy));
	}
	
	@Test
	public void testToCheckIfXYCoordinateMaxIsOnTheTable(){
		table.setSize(10, 10);
		xy.setXY(10, 10);
		assertTrue(table.isOnTable(xy));
	}
}
