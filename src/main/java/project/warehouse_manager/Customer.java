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
  		}
  	}
  	
  	//adds a customer to the system
  	public void addCustomer(String firstName, String lastName, String email){
  		try {
  			st.executeUpdate("INSERT INTO customer(firstName, lastName, email) VALUES ('"+
  					firstName + "', '" + lastName + "', " + email + "'");			
  		}catch (SQLException e) {
  			e.printStackTrace();
  		}	
  		
  	}
  	
  	//deletes a customer
  	public void deleteCustomer(int customerId){
  		try {
  			//empties the units associated with the customer first
  			//emptyUnitByCustomer(customerId);
  			// Need to purge the customers
  			// then deletes the customer from the database
  			st.executeUpdate("DELETE FROM customer WHERE id="+ customerId +";");			
  		}catch (SQLException e) {
  			e.printStackTrace();
  		}			
  	}
  	
  	//sets a new first name for an existing customer
  	public void changeCustomerFirstName(int customerId, String newFirstName){
  		try {
  			st.executeUpdate("UPDATE customer SET firstName = '"+ newFirstName +
  					"' WHERE id = "+ customerId +";");			
  		}catch (SQLException e) {
  			e.printStackTrace();
  		}	
  		
  	}
  	
  	//sets a new last name for an existing customer
  	public void changeCustomerLastName(int customerId, String newLastName){
  		try {
  			st.executeUpdate("UPDATE customer SET lastName = '"+ newLastName +
  					"' WHERE id = "+ customerId +";");			
  		}catch (SQLException e) {
  			e.printStackTrace();
  		}	
  		
  	}
  	
  	//sets a new email for an existing customer
  	public void changeCustomerEmail(int customerId, String newEmail){
  		try {
  			st.executeUpdate("UPDATE customer SET email = '"+ newEmail +
  					"' WHERE id = "+ customerId +";");			
  		}catch (SQLException e) {
  			e.printStackTrace();
  		}			
  	}
  	
  	//gets the customer id with the email
  	public int getIdByEmail(String email){
  		try {
  			rs = st.executeQuery("SELECT id FROM customer WHERE email = '" + email + "';");
  			System.out.println();
  			int id =rs.getInt("id");
  			System.out.printf("id: "+ id);
  			return id;
  		
  		} catch (SQLException e) {
  			e.printStackTrace();
  		}
  		return 0;
  	}
  	
  	//retrieves all customer data with an id
  	public String[] getCustomerData(int customerId){
  		String[] customerDataString = {"","",""};
  		try {
  			
  			rs = st.executeQuery("SELECT * FROM customer WHERE id = " + customerId + ";");
  			System.out.println("id    firstName         lastName        email");
  			System.out.print("---   ------------      -----------     ----------");
  			System.out.println();
  			
  			customerDataString[0] =  rs.getString("firstName");
  			customerDataString[1] = rs.getString("lastName");
  			customerDataString[2] = rs.getString("email");
  						
  			return customerDataString;
  		} catch (SQLException e) {
  			e.printStackTrace();
  		}
  		
  		return customerDataString;
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