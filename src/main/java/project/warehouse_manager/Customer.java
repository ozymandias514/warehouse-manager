package project.warehouse_manager;

import java.util.ArrayList;
import java.sql.*;

public class Customer extends DatabaseHandler{

	public Customer() {
		
	}
	
	//obtains all the data from all customers
  	public boolean getDataFromCustomer() throws SQLException{
  	
  			rs = st.executeQuery("SELECT * FROM customer;");
  			System.out.println("id    firstName         lastName        email");
  			System.out.print("---   ------------      -----------     ----------");
  			System.out.println();
  			while (rs.next()) {
  				  int id = rs.getInt("id");
  				  String firstName = rs.getString("firstName");
  				  String lastName = rs.getString("lastName");
  				  String email = rs.getString("email");
  				  System.out.printf("%d     %s		%s		%s", id, firstName, lastName, email);
  				  System.out.println();
  				}
  			try{
  			rs.close();
			st.close();
  			}catch(Exception e){
  				
  			}
  			return true;
  	}
  	
    //obtains all data from customers and returns the resultSet
  	public ArrayList<String> displayData() throws SQLException{
  		ArrayList<String> userData = new ArrayList<String>();
  	
  			rs = st.executeQuery("SELECT * FROM customer;");
  			while(rs.next()){
  			 userData.add(rs.getString("id"));
			 userData.add(rs.getString("firstName"));
			 userData.add(rs.getString("lastName"));
			 userData.add(rs.getString("email"));
  			}
  			try{
  	  			rs.close();
  				st.close();
  	  			}catch(Exception e){
  	  				
  	  			}
  			return userData;
		
  	}
  	
  	//adds a customer to the system
  	public boolean addCustomer(String firstName, String lastName, String email){
  		
  		//String emailExtension = "@gmail.com";
  		try {  			
  			st.executeUpdate("INSERT INTO customer(firstName, lastName, email) VALUES ('"+
  					firstName + "', '" + lastName + "', '"+ email + "');");	
  			return true;
  		}catch (SQLException e) {
  			e.printStackTrace();
  			return false;
  		}finally{
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){
  				
  			}
  		}	
  	}
  	
  	//adds a customer to the system
  	public boolean addCustomerWithId(int id, String firstName, String lastName, String email){
  		String taskAchieved = "failed";
  		//String emailExtension = "@gmail.com";
  		try {  			
  			st.executeUpdate("INSERT INTO customer(id, firstName, lastName, email) VALUES (" + id+ ", '"+
  					firstName + "', '" + lastName + "', '"+ email + "');");	
  			return true;
  		}catch (SQLException e) {
  			e.printStackTrace();
  			return false;
  		}finally{
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){
  				
  			}
  		}	
  	}
  	
  	//deletes a customer
  	public boolean deleteCustomer(int customerId){
  		Connection con;
  		Statement st = null;
  		ResultSet rs = null;
  		
  		try {
  			Class.forName("org.sqlite.JDBC");
  			con = DriverManager.getConnection("jdbc:sqlite:warehouse.db");
  			st = con.createStatement();
  		}catch(Exception e){
  			
  			}
  			
  		boolean taskAchieved = false;
  		try {
  			//empties the units associated with the customer first
  			//emptyUnitByCustomer(customerId);
  			// Need to purge the customers
  			// then deletes the customer from the database
  			st.executeUpdate("DELETE FROM customer WHERE id="+ customerId +";");		
  			taskAchieved = true;
  			return taskAchieved;
  		}catch (SQLException e) {
  			return taskAchieved;
  		}finally{
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){	}
  		}
  	}
  	
  	//sets a new first name for an existing customer
  	public boolean changeCustomerFirstName(int customerId, String newFirstName){
  		try {
  			st.executeUpdate("UPDATE customer SET firstName = '"+ newFirstName +
  					"' WHERE id = "+ customerId +";");		
  			return true;
  		}catch (SQLException e) {
  			return false;
  		}finally{
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){	}
  		}	
  	}
  	
  	//sets a new last name for an existing customer
  	public boolean changeCustomerLastName(int customerId, String newLastName){
  		try {
  			st.executeUpdate("UPDATE customer SET lastName = '"+ newLastName +
  					"' WHERE id = "+ customerId +";");			
  			return true;
  		}catch (SQLException e) {
  			return false;
  		} finally{
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){	}
  		}	 		
  	}
  	
  	//sets a new email for an existing customer
  	public boolean changeCustomerEmail(int customerId, String newEmail){
  		Connection con;
  		Statement st = null;
  		ResultSet rs = null;
  		
  		try {
  			Class.forName("org.sqlite.JDBC");
  			con = DriverManager.getConnection("jdbc:sqlite:warehouse.db");
  			st = con.createStatement();
  		}catch(Exception e){}
  		
  		try {
  			st.executeUpdate("UPDATE customer SET email = '"+ newEmail +
  					"' WHERE id = "+ customerId +";");			
  			return true;
  		}catch (SQLException e) {
  			return false;
  		}finally{
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){	}
  		}	
  	}
  	
  	//gets the customer id with the email
  	public String[] getDataByEmail(String email) throws SQLException{
  		String dataByEmail[] = new String[]{"","","",""};
  	
  			rs = st.executeQuery("SELECT * FROM customer WHERE email = '" + email + "';");
  			System.out.println();
  			dataByEmail[0] = rs.getString("id");
  			dataByEmail[1] = rs.getString("firstName");
  			dataByEmail[2] = rs.getString("lastName");
  			dataByEmail[3] = rs.getString("email");
  			//int id =rs.getInt("id");
  			//System.out.printf("id: "+ id);
  			
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){ }
  			
  			return dataByEmail;
  		
  	}
  	
  //gets the customer id with the email
  	public int getIdByEmail(String email) throws SQLException{
  		int userId= 0;
  
  			rs = st.executeQuery("SELECT * FROM customer WHERE email = '" + email + "';");
  			System.out.println();
  			userId = rs.getInt("id");
  		
			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){	}
  			return userId;
	 		
  	}
  	
  	//retrieves all customer data with an id
  	public String[] getCustomerData(int customerId) throws SQLException{
  		String[] customerDataString = {"","",""};
  	
  			rs = st.executeQuery("SELECT * FROM customer WHERE id = " + customerId + ";");
  			
  			customerDataString[0] =  rs.getString("firstName");
  			customerDataString[1] = rs.getString("lastName");
  			customerDataString[2] = rs.getString("email");
  
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){	}
  			
  			return customerDataString;
  		
  	}    
    
	// retrieving a unit by customer ID
	public int[] largeUnitsByCustomer(int customerId) throws SQLException{
		int[] largeWare = new int[5];
		int[] empty = new int[]{0};
		int i=0;
		
			rs = st.executeQuery("SELECT * FROM units WHERE customerId = " + customerId  +" AND warehouseId = 1;");
			while(rs.next()){
				largeWare[i] = rs.getInt("warehouseId");
				i++;
			}	

  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){	}
  			return largeWare;
	}
  	
	// retrieving a unit by customer ID
	public int[] smallUnitsByCustomer(int customerId) throws SQLException{
		int[] smallWare = new int[10];
		int[] empty = new int[]{0};
		int i=0;
	
			rs = st.executeQuery("SELECT * FROM units WHERE customerId = " + customerId  +" AND warehouseId = 2;");
			while(rs.next()){
				smallWare[i] = rs.getInt("warehouseId");
				i++;
				System.out.println(i);
			}
			
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){	}
  			return smallWare;
	}
}
