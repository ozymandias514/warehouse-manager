package project.warehouse_manager;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import project.warehouse_manager.exceptions.UnitAlreadyOwnedException;
import project.warehouse_manager.exceptions.UnitNotOwnedException;

public class CustomerTest {

	Customer customer;
	String testName1;
	String testEmail1;
	String testName2;
	String testEmail2;
	
	@Before
	public void setUp() throws Exception {
		testName1 = "Carson Kirkpatrick";
		testEmail1 = "cdkirkpa@eagle.fgcu.edu";
		testName2 = "Fernando Gonzales";
		testEmail2 = "jfgonzal@eagle.fgcu.edu";
	}

	@Test
	public void testConstructor() {
		customer = new Customer();
		assertEquals(customer.getName(), testName1);
		assertEquals(customer.getEmail(), testEmail1);
	}

	@Test
	public void testGetName() {
		customer = new Customer();
		assertEquals(customer.getName(), testName1);
	}

	@Test
	public void testSetName() {
		customer = new Customer();
		customer.setName(testName2);
		assertEquals(customer.getName(), testName2);
		
	}

	@Test
	public void testGetEmail() {
		customer = new Customer();
		assertEquals(customer.getEmail(), testEmail1);
	}

	@Test
	public void testSetEmail() {
		customer = new Customer();
		customer.setEmail(testEmail2);
		assertEquals(customer.getEmail(), testEmail2);
	}

	@Test
	public void testGetUnitsOwned() throws UnitAlreadyOwnedException {
		customer = new Customer();
		customer.addUnit(1);
		assertTrue(Arrays.deepEquals(customer.getUnitsOwned(), new Integer[]{1}));
		customer.addUnit(567);
		assertTrue(Arrays.deepEquals(customer.getUnitsOwned(), new Integer[]{1, 567}));
	}

	@Test
	public void testAddUnit() throws UnitAlreadyOwnedException {
		customer = new Customer();
		customer.addUnit(1);
		assertTrue(customer.isUnitOwned(1));
	}
	
	@Test (expected = UnitAlreadyOwnedException.class)
	public void testAddUnitWithException() throws UnitAlreadyOwnedException {
		customer = new Customer();
		customer.addUnit(1);
		customer.addUnit(1);
	}

	@Test
	public void testRemoveUnit() throws UnitAlreadyOwnedException, UnitNotOwnedException {
		customer = new Customer();
		customer.addUnit(1);
		customer.addUnit(2);
		customer.removeUnit(1);
		assertFalse(customer.isUnitOwned(1));
	}
	
	@Test (expected = UnitNotOwnedException.class)
	public void testRemoveUnitWithException() throws UnitNotOwnedException {
		customer = new Customer();
		customer.removeUnit(5);
	}

	@Test
	public void testIsUnitOwned() throws UnitAlreadyOwnedException {
		customer = new Customer();
		customer.addUnit(1);
		assertTrue(customer.isUnitOwned(1));
	}

}
