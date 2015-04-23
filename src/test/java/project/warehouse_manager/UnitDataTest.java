package project.warehouse_manager;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class UnitDataTest {
	UnitData unit;
	int testUnitNum;
	String testDescription;
	int testCustomerId;
	int testWarehouseId;
	int testOccupied;
	String testReceivedDate;
	String testPickUpDate;
	int testInQueue;
	int testPositionInQueue;
	int testPriority;
	
	@Before
	public void setUp() throws Exception {
		testUnitNum = 1;
		testDescription = "hello";
		testCustomerId = 34;
		testWarehouseId = 2;
		testOccupied = 1;
		testReceivedDate = "23/4/2015";
		testPickUpDate = "28/4/2015";
		testInQueue = 0;
		testPositionInQueue = 5;
		testPriority = 3;
		unit = new UnitData(testUnitNum, testDescription, testCustomerId, testWarehouseId, 
				testOccupied, testReceivedDate, testPickUpDate, testInQueue);
	}

	@Test
	public void testConstructor() {
		unit = new UnitData(testUnitNum, testDescription, testCustomerId, testWarehouseId, 
				testOccupied, testReceivedDate, testPickUpDate, testInQueue);
		assertEquals(unit.getId(), testUnitNum);
		assertEquals(unit.getDescription(), testDescription);
		assertEquals(unit.getCustomerId(), testCustomerId);
		assertEquals(unit.getWarehouseId(), testWarehouseId);
		assertEquals(unit.getOccupied(), testOccupied);
		assertEquals(unit.getDateReceived(), testReceivedDate);
		
		String[] s = testPickUpDate.split("/");
		int day   = Integer.parseInt(s[0]);
		int month = Integer.parseInt(s[1])-1;
		int year  = Integer.parseInt(s[2])-1900;
		assertEquals(unit.getPickUpDate().getTime().getYear(),  year);
		assertEquals(unit.getPickUpDate().getTime().getMonth(), month);
		assertEquals(unit.getPickUpDate().getTime().getDate(),  day);
		
		assertEquals(unit.getInQueue(), testInQueue);
		
		unit = new UnitData(testUnitNum, testDescription, testCustomerId, testWarehouseId, 
				testOccupied, testReceivedDate, null, testInQueue);
		assertNull(unit.getPickUpDate());
		unit = new UnitData(testUnitNum, testDescription, testCustomerId, testWarehouseId, 
				testOccupied, testReceivedDate, "null", testInQueue);
		assertNull(unit.getPickUpDate());
	}

	@Test
	public void testSetId() {
		unit.setId(testUnitNum);
		assertEquals(unit.getId(), testUnitNum);
	}

	@Test
	public void testGetId() {
		unit.setId(testUnitNum);
		assertEquals(unit.getId(), testUnitNum);
	}

	@Test
	public void testSetDescription() {
		unit.setDescription(testDescription);
		assertEquals(unit.getDescription(), testDescription);
	}

	@Test
	public void testGetDescription() {
		unit.setDescription(testDescription);
		assertEquals(unit.getDescription(), testDescription);
	}

	@Test
	public void testSetCustomerId() {
		unit.setCustomerId(testCustomerId);
		assertEquals(unit.getCustomerId(), testCustomerId);
	}

	@Test
	public void testGetCustomerId() {
		unit.setCustomerId(testCustomerId);
		assertEquals(unit.getCustomerId(), testCustomerId);
	}

	@Test
	public void testSetWarehouseId() {
		unit.setWarehouseId(testWarehouseId);
		assertEquals(unit.getWarehouseId(), testWarehouseId);
	}

	@Test
	public void testGetWarehouseId() {
		unit.setWarehouseId(testWarehouseId);
		assertEquals(unit.getWarehouseId(), testWarehouseId);
	}

	@Test
	public void testSetOccupied() {
		unit.setOccupied(testOccupied);
		assertEquals(unit.getOccupied(), testOccupied);
	}

	@Test
	public void testGetOccupied() {
		unit.setOccupied(testOccupied);
		assertEquals(unit.getOccupied(), testOccupied);
	}

	@Test
	public void testSetDateReceived() {
		unit.setDateReceived(testReceivedDate);
		assertEquals(unit.getDateReceived(), testReceivedDate);
	}

	@Test
	public void testGetDateReceived() {
		unit.setDateReceived(testReceivedDate);
		assertEquals(unit.getDateReceived(), testReceivedDate);
	}

	@Test
	public void testSetPickUpDate() {
		String[] s = testPickUpDate.split("/");
		int day   = Integer.parseInt(s[0]);
		int month = Integer.parseInt(s[1]);
		int year  = Integer.parseInt(s[2]);
		Calendar pickUp = Calendar.getInstance();
		pickUp.set(year, month, day);
		
		unit.setPickUpDate(pickUp);

		assertEquals(unit.getPickUpDate().getTime().getYear(),  year-1900);
		assertEquals(unit.getPickUpDate().getTime().getMonth(), month);
		assertEquals(unit.getPickUpDate().getTime().getDate(),  day);
	}

	@Test
	public void testGetPickUpDate() {
		String[] s = testPickUpDate.split("/");
		int day   = Integer.parseInt(s[0]);
		int month = Integer.parseInt(s[1]);
		int year  = Integer.parseInt(s[2]);
		Calendar pickUp = Calendar.getInstance();
		pickUp.set(year, month, day);
		
		unit.setPickUpDate(pickUp);

		assertEquals(unit.getPickUpDate().getTime().getYear(),  year-1900);
		assertEquals(unit.getPickUpDate().getTime().getMonth(), month);
		assertEquals(unit.getPickUpDate().getTime().getDate(),  day);
	}

	@Test
	public void testSetInQueue() {
		unit.setInQueue(testInQueue);
		assertEquals(unit.getInQueue(), testInQueue);
	}

	@Test
	public void testGetInQueue() {
		unit.setInQueue(testInQueue);
		assertEquals(unit.getInQueue(), testInQueue);
	}

	@Test
	public void testSetPriority() {
		unit.setPriority(testPriority);
		assertEquals(unit.getPriority(), testPriority);
	}

	@Test
	public void testGetPriority() {
		unit.setPriority(testPriority);
		assertEquals(unit.getPriority(), testPriority);
	}

	@Test
	public void testSetPositionInQueue() {
		unit.setPositionInQueue(testPositionInQueue);
		assertEquals(unit.getPositionInQueue(), testPositionInQueue);
	}

	@Test
	public void testGetPositionInQueue() {
		unit.setPositionInQueue(testPositionInQueue);
		assertEquals(unit.getPositionInQueue(), testPositionInQueue);
	}

}
