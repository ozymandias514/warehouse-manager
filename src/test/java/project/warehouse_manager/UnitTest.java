package project.warehouse_manager;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UnitTest {
	Unit unit;
	int testNumber;
	Date testDate;
	Date testDate2;
	String testDescription;
	
	@Before
	public void setUp() throws Exception {
		testNumber = 5;
		testDate = new Date(1,27,2015);
		testDate2 = new Date(1,1,1);
		testDescription = "this is a description";
	}

	@Test
	public void testConstructor1() {
		unit = new Unit(testNumber);
		assertEquals(unit.getNumber(), testNumber);
	}
	
	@Test
	public void testConstructor2() {
		unit = new Unit();
		assertEquals(unit.getNumber(), testNumber);
		assertEquals(unit.getDeliveryDate(), testDate);
		assertEquals(unit.getDescriptionOfItems(), testDescription);
	}

	@Test
	public void testGetNumber() {
		unit = new Unit();
		assertEquals(unit.getNumber(), testNumber);
	}

	@Test
	public void testSetNumber() {
		unit = new Unit();
		unit.setNumber(8);
		assertEquals(unit.getNumber(), 8);
	}

	@Test
	public void testGetDescriptionOfItems() {
		unit = new Unit();
		assertEquals(unit.getDescriptionOfItems(), testDescription);
	}

	@Test
	public void testSetDescriptionOfItems() {
		unit = new Unit();
		unit.setDescriptionOfItems("HELLO");
		assertEquals(unit.getDescriptionOfItems(), "HELLO");
	}

	@Test
	public void testGetDeliveryDate() {
		unit = new Unit();
		assertEquals(unit.getDeliveryDate(), testDate);
	}

	@Test
	public void testSetDeliveryDate() {
		unit = new Unit();
		unit.setDeliveryDate(testDate2);
		assertEquals(unit.getDeliveryDate(), testDate2);
	}

	@Test
	public void testIsOccupied() {
		unit = new Unit();
		assertFalse(unit.isOccupied());
		unit.setOccupied(true);
		assertTrue(unit.isOccupied());
	}

	@Test
	public void testSetOccupied() {
		unit = new Unit();
		unit.setOccupied(true);
		assertTrue(unit.isOccupied());
		unit.setOccupied(false);
		assertFalse(unit.isOccupied());
	}

	@Test
	public void testIsInQueue() {
		unit = new Unit();
		assertFalse(unit.isInQueue());
		unit.setInQueue(true);
		assertTrue(unit.isInQueue());
	}

	@Test
	public void testSetInQueue() {
		unit = new Unit();
		unit.setInQueue(true);
		assertTrue(unit.isInQueue());
		unit.setInQueue(false);
		assertFalse(unit.isInQueue());
	}

}
