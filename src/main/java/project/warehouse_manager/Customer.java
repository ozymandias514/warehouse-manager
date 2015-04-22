package project.warehouse_manager;

import java.util.ArrayList;
import java.sql.*;
import java.util.List;

import project.warehouse_manager.exceptions.UnitNotOwnedException;
import project.warehouse_manager.exceptions.UnitAlreadyOwnedException;

public class Customer extends DatabaseHandler{
	private String name;
    private String email;
    private List<Integer> unitsOwned;

  //obtains all the data from all customers
  	public void getDataFromCustomer(){
  		try {
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
  		} catch (SQLException e) {
  			e.printStackTrace();
  		}finally{
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){
  				System.out.println("Error closing the database");
  			}
  		}			
  	}
  	
    //obtains all data from customers and returns the resultSet
  	public ArrayList<String> displayData(){
  		ArrayList<String> userData = new ArrayList<String>();
  		try {
  			rs = st.executeQuery("SELECT * FROM customer;");
  			while(rs.next()){
  			 userData.add(rs.getString("id"));
			 userData.add(rs.getString("firstName"));
			 userData.add(rs.getString("lastName"));
			 userData.add(rs.getString("email"));
  			}
  			return userData;
  		} catch (SQLException e) {
  			e.printStackTrace();
  			return null;
  		}finally{
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){
  				System.out.println("Error closing the database");
  			}
  		}
  	}
  	
  	//adds a customer to the system
  	public String addCustomer(String firstName, String lastName, String email){
  		String taskAchieved = "failed";
  		String emailExtension = "@gmail.com";
  		try {  			
  			st.executeUpdate("INSERT INTO customer(firstName, lastName, email) VALUES ('"+
  					firstName + "', '" + lastName + "', '"+ email + "');");	
  			taskAchieved = "was a success";
  			return taskAchieved;
  		}catch (SQLException e) {
  			e.printStackTrace();
  			return taskAchieved;
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
  	public String deleteCustomer(int customerId){
  		String taskAchieved = "has failed";
  		try {
  			//empties the units associated with the customer first
  			//emptyUnitByCustomer(customerId);
  			// Need to purge the customers
  			// then deletes the customer from the database
  			st.executeUpdate("DELETE FROM customer WHERE id="+ customerId +";");		
  			taskAchieved = "was succesful";
  			return taskAchieved;
  		}catch (SQLException e) {
  			e.printStackTrace();
  			return taskAchieved;
  		}finally{
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){
  				System.out.println("Error closing the database");
  			}
  		}			
  	}
  	
  	//sets a new first name for an existing customer
  	public void changeCustomerFirstName(int customerId, String newFirstName){
  		try {
  			st.executeUpdate("UPDATE customer SET firstName = '"+ newFirstName +
  					"' WHERE id = "+ customerId +";");			
  		}catch (SQLException e) {
  			e.printStackTrace();
  		}finally{
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){
  				System.out.println("Error closing the database");
  			}
  		}	
  	}
  	
  	//sets a new last name for an existing customer
  	public void changeCustomerLastName(int customerId, String newLastName){
  		try {
  			st.executeUpdate("UPDATE customer SET lastName = '"+ newLastName +
  					"' WHERE id = "+ customerId +";");			
  		}catch (SQLException e) {
  			e.printStackTrace();
  		}finally{
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){
  				System.out.println("Error closing the database");
  			}
  		}	
  		
  	}
  	
  	//sets a new email for an existing customer
  	public void changeCustomerEmail(int customerId, String newEmail){
  		try {
  			st.executeUpdate("UPDATE customer SET email = '"+ newEmail +
  					"' WHERE id = "+ customerId +";");			
  		}catch (SQLException e) {
  			e.printStackTrace();
  		}finally{
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){
  				System.out.println("Error closing the database");
  			}
  		}			
  	}
  	
  	//gets the customer id with the email
  	public String[] getDataByEmail(String email){
  		String dataByEmail[] = new String[]{"","","",""};
  		try {
  			rs = st.executeQuery("SELECT * FROM customer WHERE email = '" + email + "';");
  			System.out.println();
  			dataByEmail[0] = rs.getString("id");
  			dataByEmail[1] = rs.getString("firstName");
  			dataByEmail[2] = rs.getString("lastName");
  			dataByEmail[3] = rs.getString("email");
  			//int id =rs.getInt("id");
  			//System.out.printf("id: "+ id);
  			
  			return dataByEmail;
  		
  		} catch (SQLException e) {
  			e.printStackTrace();
  		}finally{
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){
  				System.out.println("Error closing the database");
  			}
  		}
  		return dataByEmail;
  	}
  	
  //gets the customer id with the email
  	public int getIdByEmail(String email){
  		int userId= 0;
  		try {
  			rs = st.executeQuery("SELECT * FROM customer WHERE email = '" + email + "';");
  			System.out.println();
  			userId = rs.getInt("id");
  			return userId;
  		
  		} catch (SQLException e) {
  			e.printStackTrace();
  		}finally{
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){
  		
  			}
  		}
  		return userId;
  	}
  	
  	//retrieves all customer data with an id
  	public String[] getCustomerData(int customerId){
  		String[] customerDataString = {"","",""};
  		try {
  			
  			rs = st.executeQuery("SELECT * FROM customer WHERE id = " + customerId + ";");
  			
  			customerDataString[0] =  rs.getString("firstName");
  			customerDataString[1] = rs.getString("lastName");
  			customerDataString[2] = rs.getString("email");
  						
  			return customerDataString;
  		} catch (SQLException e) {
  			e.printStackTrace();
  		}finally{
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){
  				System.out.println("Error closing the database");
  			}
  		}
  		
  		return customerDataString;
  	}    
    
	// retrieving a unit by customer ID
	public int[] largeUnitsByCustomer(int customerId){
		int[] largeWare = new int[5];
		int[] empty = new int[]{0};
		int i=0;
		try {
			rs = st.executeQuery("SELECT * FROM units WHERE customerId = " + customerId  +" AND warehouseId = 1;");
			while(rs.next()){
				largeWare[i] = rs.getInt("warehouseId");
				i++;
			}
			return largeWare;
		}catch (SQLException e) {
			
			e.printStackTrace();
			return empty;
		}finally{
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){
  				System.out.println("Error closing the database");
  			}
  		}
	
	}
  	
	// retrieving a unit by customer ID
	public int[] smallUnitsByCustomer(int customerId){
		int[] smallWare = new int[10];
		int[] empty = new int[]{0};
		int i=0;
		try {
			rs = st.executeQuery("SELECT * FROM units WHERE customerId = " + customerId  +" AND warehouseId = 2;");
			while(rs.next()){
				smallWare[i] = rs.getInt("warehouseId");
				i++;
				System.out.println(i);
			}
			return smallWare;
		}catch (SQLException e) {
			e.printStackTrace();
			return empty;
		}finally{
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){
  				System.out.println("Error closing the database");
  			}
  		}
	
	}
  	
	
	
    /**
     * @param 
     * @param 
     */
    public Customer() {
    	this.name = name;
    	this.email = email;
    	unitsOwned = new ArrayList<Integer>();
    }
    /**
     * @return
     */
    public String getName() {
    	return name;
    }

    /**
     * @param 
     */
    public void setName(String name) {
    	this.name = name;
    }

    /**
     * @return
     */
    public String getEmail() {
    	return email;
    }

    /**
     * @param 
     */
    public void setEmail(String email) {
    	this.email = email;
    }

    /**
     * @return
     */
    public Integer[] getUnitsOwned() {
    	return unitsOwned.toArray(new Integer[0]);
    }

    /**
     * @param 
     * @throws UnitNotOwnedException 
     */
    public void addUnit(int unitNumber) throws UnitAlreadyOwnedException {
    	if (!isUnitOwned(unitNumber)) {
    		unitsOwned.add(unitNumber);
    	} else {
    		throw new UnitAlreadyOwnedException();
    	}
    }

    /**
     * @param 
     * @throws UnitNotOwnedException 
     */
    public void removeUnit(int unitNumber) throws UnitNotOwnedException {
    	if (isUnitOwned(unitNumber)) {
    		unitsOwned.remove(unitsOwned.indexOf(unitNumber));
    	} else {
    		throw new UnitNotOwnedException();
    	}
    }
    /**
     * @param 
     */
    public boolean isUnitOwned(int unitNumber) {
        return unitsOwned.contains(unitNumber);
    }

}