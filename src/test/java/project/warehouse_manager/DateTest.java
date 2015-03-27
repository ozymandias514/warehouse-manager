package project.warehouse_manager;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DateTest {
	int testDay;
	int testMonth;
	int testYear;
	Date date;
	
	@Before
	public void setUp() throws Exception {
		testDay = 26;
		testMonth = 1;
		testYear = 2015;
	}

	@Test
	public void testConstructor() {
		date = new Date(testDay, testMonth, testYear);
		assertEquals(date.getDay(), testDay);
		assertEquals(date.getMonth(), testMonth);
		assertEquals(date.getYear(), testYear);
	}

	@Test
	public void testGetDay() {
		date = new Date(testDay, testMonth, testYear);
		assertEquals(date.getDay(), testDay);
	}

	@Test
	public void testSetDay() {
		date = new Date(testDay, testMonth, testYear);
		date.setDay(25);
		assertEquals(date.getDay(), 25);
	}

	@Test
	public void testGetMonth() {
		date = new Date(testDay, testMonth, testYear);
		assertEquals(date.getMonth(), testMonth);
	}

	@Test
	public void testSetMonth() {
		date = new Date(testDay, testMonth, testYear);
		date.setMonth(6);
		assertEquals(date.getMonth(), 6);
	}

	@Test
	public void testGetYear() {
		date = new Date(testDay, testMonth, testYear);
		assertEquals(date.getYear(), testYear);
	}

	@Test
	public void testSetYear() {
		date = new Date(testDay, testMonth, testYear);
		date.setYear(2010);
		assertEquals(date.getYear(), 2010);
	}

	@Test
	public void testGetDateInDays() {
		date = new Date(testDay, 1, testYear);
		Date date2 = new Date(testDay, 2, testYear);
		assertTrue(date.getDateInDays() < date2.getDateInDays());
		date.setMonth(3);
		date2.setMonth(4);
		assertTrue(date.getDateInDays() < date2.getDateInDays());
		date.setMonth(5);
		date2.setMonth(6);
		assertTrue(date.getDateInDays() < date2.getDateInDays());
		date.setMonth(7);
		date2.setMonth(8);
		assertTrue(date.getDateInDays() < date2.getDateInDays());
		date.setMonth(9);
		date2.setMonth(10);
		assertTrue(date.getDateInDays() < date2.getDateInDays());
		date.setMonth(11);
		date2.setMonth(12);
		assertTrue(date.getDateInDays() < date2.getDateInDays());
	}

	@Test
	public void testGetDateAsString() {
		date = new Date(testDay, testMonth, testYear);
		String dateString = testMonth+"/"+testDay+"/"+testYear;
		assertEquals(date.getDateAsString(), dateString);
	}

}
