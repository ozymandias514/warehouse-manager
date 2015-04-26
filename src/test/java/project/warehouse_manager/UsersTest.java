package project.warehouse_manager;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class UsersTest {
	Users users;
	String[] userData1 = new String[4];
	String[] userData2 = new String[4];
	
	@Before
	public void setUp() throws Exception {
		users = new Users();
		userData1[0] = "Fernando";
		userData1[1] = "Gonzales";
		userData1[2] = "jfgonzal";
		userData1[3] = "pass";
		userData2[0] = "Carson";
		userData2[1] = "Kirkpatrick";
		userData2[2] = "kirk";
		userData2[3] = "pass";
	}

	@Test
	public void testAuthenticate() throws SQLException {
		assertFalse(users.authenticate("dahaiguo", "fgcu"));
		assertTrue(users.authenticate("kirk", "pass"));
		assertTrue(users.authenticate("jfgonzal", "pass"));
	}

	@Test
	public void testGetIdFromUsername() throws SQLException {
		assertEquals(users.getIdFromUsername("jfgonzal"), 1);
		assertEquals(users.getIdFromUsername("kirk"), 2);
	}

	@Test
	public void testGetDataFromId() throws SQLException {
		assertEquals(users.getDataFromId(1), userData1);
		assertEquals(users.getDataFromId(2), userData2);
	}

}
