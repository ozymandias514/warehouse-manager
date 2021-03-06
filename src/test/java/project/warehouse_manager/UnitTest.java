package project.warehouse_manager;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class UnitTest {
	Unit unit;
	
	@Before
	public void setUp() throws Exception {
		unit = new Unit();
	}

	@Test
	public void testDisplayLargeWarehouseData() throws SQLException {
		ArrayList<String> largeUnitData = new ArrayList<String>();
		largeUnitData = unit.displayLargeWarehouseData();
		assertEquals(unit.displayLargeWarehouseData(), largeUnitData);
	}

	@Test
	public void testGetAllLargeWarehouseUnits() throws ClassNotFoundException, SQLException {
		ArrayList<UnitData> UnitsList = new ArrayList<UnitData>();
		UnitsList = unit.getAllLargeWarehouseUnits();
		assertEquals(UnitsList, UnitsList);
	}

	@Test
	public void testGetAllSmallWarehouseUnits() throws ClassNotFoundException, SQLException {
		ArrayList<UnitData> UnitsList = new ArrayList<UnitData>();
		UnitsList = unit.getAllSmallWarehouseUnits();
		assertEquals(UnitsList, UnitsList);
	}

	@Test
	public void testDisplaySmallWarehouseData() throws SQLException {
		ArrayList<String> smallUnitData = new ArrayList<String>();
		smallUnitData = unit.displaySmallWarehouseData();
		assertEquals(unit.displaySmallWarehouseData(), smallUnitData);
	}

	@Test
	public void testGetEmptyUnitsInLarge() throws SQLException {
		ArrayList<Integer> largeUnitEmpty = new ArrayList<Integer>();
		largeUnitEmpty = unit.getEmptyUnitsInLarge();
		assertEquals(unit.getEmptyUnitsInLarge(),largeUnitEmpty);
	}

	@Test
	public void testGetEmptyUnitsInSmall() throws SQLException {
		ArrayList<Integer> smallUnitEmpty = new ArrayList<Integer>();
		smallUnitEmpty = unit.getEmptyUnitsInSmall();
		assertEquals(unit.getEmptyUnitsInSmall(),smallUnitEmpty);
	}

	@Test
	public void testGetCustomerUnitsInSmall() throws SQLException {
		ArrayList<Integer> smallUnitEmpty = new ArrayList<Integer>();
		smallUnitEmpty = unit.getCustomerUnitsInSmall(13);
		assertEquals(unit.getCustomerUnitsInSmall(13),smallUnitEmpty);
	}

	@Test
	public void testGetCustomerUnitsInLarge() throws SQLException {
		ArrayList<Integer> smallUnitEmpty = new ArrayList<Integer>();
		smallUnitEmpty = unit.getCustomerUnitsInLarge(13);
		assertEquals(unit.getCustomerUnitsInLarge(13),smallUnitEmpty);
	}

	@Test
	public void testGetNumberOfEmptyUnitsInLarge() throws SQLException {
		int emptyLargeWare = 0;
		emptyLargeWare = unit.getNumberOfEmptyUnitsInLarge();
		assertEquals(unit.getNumberOfEmptyUnitsInLarge(),emptyLargeWare);
	}

	@Test
	public void testGetNumberOfEmptyUnitsInSmall() throws SQLException {
		int emptySmallWare = 0;
		emptySmallWare = unit.getNumberOfEmptyUnitsInSmall();
		assertEquals(unit.getNumberOfEmptyUnitsInSmall(), emptySmallWare);
	}

	@Test
	public void testGetNumberOfUnitsOwnedInSmallByCustomerId() throws SQLException {
		int unitsInSmall = 0;
		unitsInSmall = unit.getNumberOfUnitsOwnedInSmallByCustomerId(1);
		assertEquals(unit.getNumberOfUnitsOwnedInSmallByCustomerId(1), unitsInSmall);
	}

	@Test
	public void testGetNumberOfUnitsOwnedInLargeByCustomerId() throws SQLException {
		int unitsInLarge = 0;
		unitsInLarge = unit.getNumberOfUnitsOwnedInLargeByCustomerId(1);
		assertEquals(unit.getNumberOfUnitsOwnedInLargeByCustomerId(1), unitsInLarge);
	}

	@Test
	public void testFillUnit() {
		assertTrue(unit.fillUnit("testing the world", 13, "19/21/2099", 19));
	}

	@Test
	public void testRepopulateTables() throws ClassNotFoundException, SQLException {
		ArrayList<UnitData> largeWarehouseUnitList = unit.getAllLargeWarehouseUnits();
		ArrayList<UnitData> smallWarehouseUnitList = unit.getAllSmallWarehouseUnits();
		
		assertTrue(unit.repopulateTables(largeWarehouseUnitList, smallWarehouseUnitList));
	}

	@Test
	public void testRemoveUnit() {
		assertTrue(unit.removeUnit(19));
	}

	@Test
	public void testTotalUnitsByCustomer() throws SQLException {
		int totalUnits = 0;
		totalUnits = unit.totalUnitsByCustomer(1);
		assertEquals(unit.totalUnitsByCustomer(1),totalUnits);
	}

	@Test
	public void testUnitsById() throws SQLException {
		ArrayList<String> unitData = new ArrayList<String>();
		unitData = unit.unitsById(1);
		assertEquals(unit.unitsById(1),unitData);
	}

	@Test
	public void testChangePickupDate() {
		assertTrue(unit.changePickupDate("10/11/2100", 19));
	}

	@Test
	public void testChangeDescription() {
		assertTrue(unit.changeDescription("A lot of pizza", 19));
	}

	@Test
	public void testNumberOfItemsInQueue() throws SQLException {
		int queued = 0;
		queued = unit.numberOfItemsInQueue();
		assertEquals(unit.numberOfItemsInQueue(),queued);
	}

	@Test
	public void testPurgeSmall() {
		assertTrue(unit.purgeSmall());
	}
/*
	Too destructive to test
	@Test
	public void testPurgeLarge() {
//		fail("Not yet implemented");
	}

*/	

	@Test
	public void testEmptyUnitByCustomer() {
		assertTrue(unit.emptyUnitByCustomer(1));
	}

}
