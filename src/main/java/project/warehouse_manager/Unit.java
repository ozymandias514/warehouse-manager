package project.warehouse_manager;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Unit extends DatabaseHandler{
	private int number;
	private String descriptionOfItems;
	private Date deliveryDate;
	private boolean occupied;
	private boolean inQueue;
	
	
	//gets all data from units
	public void getData(){
		try {
			rs = st.executeQuery("SELECT * FROM units;");
			System.out.println("Units Data");
			System.out.print("----------");
			while (rs.next()) {
				
				  int id 				= rs.getInt("id");
				  String description 	= rs.getString("description");
				  int customerId 		= rs.getInt("customerId");
				  int warehouseId 		= rs.getInt("warehouseId");
				  int occupied 			= rs.getInt("occupied");
				  String dateReceived 	= rs.getString("dateReceived");
				  String pickupDate		= rs.getString("pickupDate");
				  int priority 			= rs.getInt("priority");
				  int inQueue 			= rs.getInt("inQueue");
				  int positionInQueue 	= rs.getInt("positionInQueue");
				  
				  System.out.println( "\nid		: " + id 
						  			+ "\ndescription	: " + description
						  			+ "\ncustomerId	: " + customerId
						  			+ "\nwarehouseId	: " + warehouseId
						  			+ "\noccupied	: " + occupied
						  			+ "\ndateReceived	: " + dateReceived
						  			+ "\npickupDate	: " + pickupDate
						  			+ "\npriority	: " + priority
						  			+ "\ninQueue		: " + inQueue
						  			+ "\npositionInQueue	: " + positionInQueue
						  			+ "\n--------------------------------------");
				}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//displays the empty units in the large warehouse
	public void getEmptyUnitsInLarge(){
		try {
			rs = st.executeQuery("SELECT * FROM units WHERE warehouseID = 1 AND occupied = 0;");
			System.out.println("Unit Data from the Large Warehouse");
			System.out.print("----------------------------------");
			while (rs.next()) {
				  int id				= rs.getInt("id");
				  int warehouseId 		= rs.getInt("warehouseId");
				  int occupied 			= rs.getInt("occupied");

				  
				  System.out.print( "\nid		: " + id 
						  			+ "\nwarehouseId	: " + warehouseId
						  			+ "\noccupied	: " + occupied
						  			+ "\n--------------------------------------");
				}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// Displays the empty units in the small warehouse
	public void getEmptyUnitsInSmall(){
		try {
			rs = st.executeQuery("SELECT * FROM units WHERE warehouseID = 2 AND occupied = 0;");
			System.out.println("Unit Data from the Small Warehouse");
			System.out.print("----------------------------------");
			while (rs.next()) {
				  int id				= rs.getInt("id");
				  int warehouseId 		= rs.getInt("warehouseId");
				  int occupied 			= rs.getInt("occupied");

				  
				  System.out.print( "\nid		: " + id 
						  			+ "\nwarehouseId	: " + warehouseId
						  			+ "\noccupied	: " + occupied
						  			+ "\n--------------------------------------");
				}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// adds a customer and their belongings to a unit
	public void fillUnit(String description, int customerId, String pickupDate, int unitId){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		String date = dateFormat.format(cal.getTime());
		
		try {
			st.executeUpdate("UPDATE units SET description ='" + description + 
							 "', customerId = " + 5 + ", occupied = 1, dateReceived ='" +
							 date + "', pickupDate ='" + pickupDate + "'WHERE id =" + unitId + ";");			
		}catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	
	//empties a unit, leaving it ready for more items
	public void removeUnit(int unitId){
		try {
			st.executeUpdate("UPDATE units SET description = 'empty unit', customerId = 0, occupied = 0, dateReceived = 'null', pickupDate = 'null' WHERE id =" + unitId + ";");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// retrieving a unit by customer ID
	public void unitsByCustomer(int customerId){
		try {
			rs = st.executeQuery("SELECT * FROM units WHERE customerId = " + customerId  +";");
			System.out.println("Units Data");
			System.out.print("----------");
			while (rs.next()) {
				  int id 				= rs.getInt("id");
				  String description 	= rs.getString("description");
				  int warehouseId 		= rs.getInt("warehouseId");
				  int occupied 			= rs.getInt("occupied");
				  String dateReceived 	= rs.getString("dateReceived");
				  String pickupDate		= rs.getString("pickupDate");
				  int priority 			= rs.getInt("priority");
				  int inQueue 			= rs.getInt("inQueue");
				  int positionInQueue 	= rs.getInt("positionInQueue");
				  
				  System.out.println( "\nid		: " + id 
						  			+ "\ndescription	: " + description
						  			+ "\ncustomerId	: " + customerId
						  			+ "\nwarehouseId	: " + warehouseId
						  			+ "\noccupied	: " + occupied
						  			+ "\ndateReceived	: " + dateReceived
						  			+ "\npickupDate	: " + pickupDate
						  			+ "\npriority	: " + priority
						  			+ "\ninQueue		: " + inQueue
						  			+ "\npositionInQueue	: " + positionInQueue
						  			+ "\n--------------------------------------");
				}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// alters the pickup date of a occupied unit
	public void changePickupDate(String pickupDate, int unitId){
		try {
			st.executeUpdate("UPDATE units SET pickupDate ='" + pickupDate + "' WHERE id = " + unitId + ";");			
		}catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	//allows for the altering of description
	public void changeDescription(String description, int unitId){
		try {
			st.executeUpdate("UPDATE units SET description ='" + description + "' WHERE id = " + unitId + ";");			
		}catch (SQLException e) {
			e.printStackTrace();
		}			
	}
	
	//retrieves all the items currently in queue
	public void itemsInQueue(){
		try {
			rs = st.executeQuery("SELECT * FROM units WHERE itemInQueue = 1;");
			System.out.println("Units Data");
			System.out.print("----------");
			while (rs.next()) {
				  int id 				= rs.getInt("id");
				  int customerId 		= rs.getInt("customerId");
				  int priority 			= rs.getInt("priority");
				  int inQueue 			= rs.getInt("inQueue");
				  int positionInQueue 	= rs.getInt("positionInQueue");
				  
				  System.out.println( "\nid		: " + id 
						  			+ "\ncustomerId	: " + customerId
						  			+ "\npriority	: " + priority
						  			+ "\ninQueue		: " + inQueue
						  			+ "\npositionInQueue	: " + positionInQueue
						  			+ "\n--------------------------------------");
				}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	// empties the small warehouse
		public void purgeSmall(){
			try {
				st.executeUpdate("DELETE FROM units WHERE warehouseId = 2");			
			}catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		
		// empties the large warehouse
		public void purgeLarge(){
			try {
				st.executeUpdate("DELETE FROM units WHERE warehouseId = 1");			
			}catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		
		//increases the priority in the row
		public void increasePriority(int unitId){
			try {
				rs = st.executeQuery("SELECT priority FROM units WHERE id = " + unitId + ";");
				
				int priority = rs.getInt("priority");
				priority +=1;
				st.executeUpdate("UPDATE units SET priority = " + priority + " WHERE id=" + unitId + ";");
					  		
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		//changes the position in Queue for an item
		public void changePosition(int newPositionInQueue, int unitId){
			try {
				st.executeUpdate("UPDATE units SET positionInQueue = " + newPositionInQueue + " WHERE id=" + unitId + ";");			
					  		
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		
		//changes whether the item is in queue or not
		public void changeQueueStatus(int queueStatus, int unitId){
			try {
				st.executeUpdate("UPDATE units SET inQueue = " + queueStatus + " WHERE id=" + unitId + ";");
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		
		// moves an item from a large warehouse unit to a small one
		public void moveToSmall(int largeUnitId, int smallUnitId){
			try {
				rs = st.executeQuery("SELECT * FROM units WHERE id = " + largeUnitId  +";");
			
				String description 	= rs.getString("description");
				int customerId 		= rs.getInt("customerId");
				String dateReceived 	= rs.getString("dateReceived");
				String pickupDate		= rs.getString("pickupDate");
				int priority 			= rs.getInt("priority");
				
				st.executeUpdate("UPDATE units SET description ='" + description + 
						"', customerId = " + customerId + ", occupied = 1, dateReceived ='" +
						dateReceived + "', pickupDate ='" + pickupDate + "', priority =" + 
						priority + " WHERE id =" + smallUnitId + ";");		
					  
				st.executeUpdate("UPDATE units SET description = 'empty unit', customerId = 0, occupied = 0, dateReceived = 'null', pickupDate = 'null' WHERE id =" + largeUnitId + ";");
						
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//empties all units pertaining to a specific customer
		public void emptyUnitByCustomer(int customerId){
			try {
				st.executeUpdate("UPDATE units SET description = 'empty unit', occupied = 0, dateReceived = 'null', pickupDate = 'null' WHERE customerId =" + customerId + ";");
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			
		}
	/**
	 * @param number
	 */
	public Unit(int number) {
		this.number = number;
		this.descriptionOfItems = null;
		this.deliveryDate = null;
		this.occupied = false;
		this.inQueue = false;
	}
	
	/**
	 */
	public Unit() {
		this.number = number;
		this.descriptionOfItems = descriptionOfItems;
		this.deliveryDate = deliveryDate;
		this.occupied = false;
		this.inQueue = false;
	}
	
	/**
	 * @return 
	 */
	public int getNumber() {
		return number;
	}
	
	/**
	 * @param 
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	
	/**
	 * @return 
	 */
	public String getDescriptionOfItems() {
		return descriptionOfItems;
	}
	
	/**
	 * @param 
	 */
	public void setDescriptionOfItems(String descriptionOfItems) {
		this.descriptionOfItems = descriptionOfItems;
	}
	
	/**
	 * @return 
	 */
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	
	/**
	 * @param 
	 */
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	/**
	 * @return
	 */
	public boolean isOccupied() {
	    return occupied;
	}
	
	/**
	 * @param 
	 */
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	
	/**
	 * @return
	 */
	public boolean isInQueue() {
	    return inQueue;
	}
	
	/**
	 * @param 
	 */
	public void setInQueue(boolean inQueue) {
		this.inQueue = inQueue;
	}

}