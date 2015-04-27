package project.warehouse_manager;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	Customer customer;
	
	@Before
	public void setUp() throws Exception {
		customer = new Customer();
	}
	
	@Test
	public void addCustomerWithId(){
		try{
			customer.deleteCustomer(12);
		}catch(Exception e){}
		assertTrue(customer.addCustomerWithId(12, "test","teskinson","ttesk@gmail.com"));
	}

	@Test
	public void testAddCustomer() {
		assertTrue(customer.addCustomer("Jonathan", "Joestar", "jojo@gmail.com"));
	}

	@Test
	public void testGetDataByEmail() throws SQLException {
		Customer customer = new Customer();
		String dataByEmail[] = new String[]{"","","",""};
		dataByEmail[0] = "1";
		dataByEmail[1] = "John";
		dataByEmail[2] = "Doe";
		dataByEmail[3] = "jdoe@gmail.com";

		assertEquals(customer.getDataByEmail("jdoe@gmail.com"), dataByEmail);
	}

	@Test
	public void testGetIdByEmail() throws SQLException {
		assertEquals(customer.getIdByEmail("unique@gmail.com"), 13);
	}

	@Test
	public void testGetCustomerData() throws SQLException {
		Customer customer = new Customer();
		String customerData[] = new String[]{"","",""};
		customerData[0] = "test";
		customerData[1] = "testkinson";
		customerData[2] = "unique@gmail.com";

		assertEquals(customer.getCustomerData(13), customerData);
	}

	@Test
	public void testLargeUnitsByCustomer() throws SQLException {
		Customer customer = new Customer();
		int[] largeWare = new int[5];
		assertArrayEquals(customer.largeUnitsByCustomer(13),largeWare);
	}

	@Test
	public void testSmallUnitsByCustomer() throws SQLException {
		Customer customer = new Customer();
		int[] smallWare = new int[5];
		assertArrayEquals(customer.largeUnitsByCustomer(13),smallWare);
	}
	
	@Test
	public void testChangeCustomerFirstName() {
		try{
			customer.addCustomerWithId(12, "test","teskinson","ttesk@gmail.com");
		}catch(Exception e){
			
		}
		assertTrue(customer.changeCustomerFirstName(12, "Jonathan"));
	}

	@Test
	public void testChangeCustomerLastName() {
		try{
			customer.addCustomerWithId(12, "test","teskinson","ttesk@gmail.com");
		}catch(Exception e){
			
		}
		assertTrue(customer.changeCustomerLastName(12, "Joestar"));
	}

	@Test
	public void testChangeCustomerEmail() {
		try{
			customer.addCustomerWithId(12, "test","teskinson","ttesk@gmail.com");
		}catch(Exception e){}
		Customer customer = new Customer();
		assertTrue(customer.changeCustomerEmail(12, "jojo@gmail.com"));
	}

	@Test
	public void testDeleteCustomer() {
		try{
			customer.addCustomerWithId(12, "test","teskinson","ttesk@gmail.com");
		}catch(Exception e){}

		Customer customer = new Customer();
		assertTrue(customer.deleteCustomer(12));
	}
	
	@Test
	public void testDisplayData() throws SQLException {
		ArrayList<String> userData = new ArrayList<String>();
		userData = customer.displayData();
		assertEquals(customer.displayData(),userData);
	}
}