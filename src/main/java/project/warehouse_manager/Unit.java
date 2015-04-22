package project.warehouse_manager;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class Unit extends DatabaseHandler{
	private int number;
	private String descriptionOfItems;
	private Date deliveryDate;
	private boolean occupied;
	private boolean inQueue;
	
	
  	public ArrayList<String> displayLargeWarehouseData(){
  		ArrayList<String> largeUnitData = new ArrayList<String>();
  		try {
  			rs = st.executeQuery("SELECT * FROM units WHERE warehouseId = 1;");
  			while(rs.next()){ 
  				largeUnitData.add(rs.getString("id"));
  				largeUnitData.add(rs.getString("description"));
  				largeUnitData.add(rs.getString("customerId"));
  				largeUnitData.add(rs.getString("warehouseId"));
  				largeUnitData.add(rs.getString("occupied"));
  				largeUnitData.add(rs.getString("dateReceived"));
  				largeUnitData.add(rs.getString("pickupDate"));
  				largeUnitData.add(rs.getString("priority"));
  				largeUnitData.add(rs.getString("inQueue"));
  				largeUnitData.add(rs.getString("positionInQueue"));
  			}
  			return largeUnitData;
  		} catch (SQLException e) {
  			e.printStackTrace();
  			return null;
  		}finally{
  			try{
  				rs.close();
  				//st.close();
  				}
  			catch(Exception e){
  				System.out.println("Error closing the database");
  			}
  		}
  	}
  	
  	public ArrayList<UnitData> getAllUnits() throws ClassNotFoundException, SQLException{
		
  		String sql = "SELECT * FROM units WHERE warehouseId = 1";
  	    ResultSet rst;
  	    rst = st.executeQuery(sql);
  	    ArrayList<UnitData> UnitsList = new ArrayList<>();
  		while(rst.next()){
  			UnitData unitData = new UnitData(rst.getInt("id")
  					,rst.getString("description")
  					,rst.getInt("customerId")
  					,rst.getInt("warehouseId")
  					,rst.getInt("occupied")
  					,rst.getString("dateReceived")
  					,rst.getString("pickupDate")
  					,rst.getInt("priority")
  					,rst.getInt("inQueue")
  					,rst.getInt("positionInQueue")
  					);
  			UnitsList.add(unitData);
  		}
  		
  		return UnitsList;
  	}
  	
  	public ArrayList<String> displaySmallWarehouseData(){
  		ArrayList<String> smallUnitData = new ArrayList<String>();
  		try {
  			rs = st.executeQuery("SELECT * FROM units WHERE warehouseId = 2;");
  			while(rs.next()){ 
  				smallUnitData.add(rs.getString("id"));
  				smallUnitData.add(rs.getString("description"));
  				smallUnitData.add(rs.getString("customerId"));
  				smallUnitData.add(rs.getString("warehouseId"));
  				smallUnitData.add(rs.getString("occupied"));
  				smallUnitData.add(rs.getString("dateReceived"));
  				smallUnitData.add(rs.getString("pickupDate"));
  				smallUnitData.add(rs.getString("priority"));
  				smallUnitData.add(rs.getString("inQueue"));
  				smallUnitData.add(rs.getString("positionInQueue"));
  			}
  			return smallUnitData;
  		} catch (SQLException e) {
  			e.printStackTrace();
  			return null;
  		}finally{
  			try{
  				rs.close();
  				//st.close();
  				}
  			catch(Exception e){
  				System.out.println("Error closing the database");
  			}
  		}
  	}
	//gets all data from units
	public void getData(){
		try {
			rs = st.executeQuery("SELECT * FROM units;");
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
		}finally{
  			try{
  				rs.close();
  				//st.close();
  				}
  			catch(Exception e){
  				System.out.println("Error closing the database");
  			}
  		}
	}
	
	
	//displays the empty units in the large warehouse
	public ArrayList<Integer> getEmptyUnitsInLarge(){
		ArrayList<Integer> largeUnitEmpty = new ArrayList<Integer>();
		try {
			rs = st.executeQuery("SELECT * FROM units WHERE warehouseID = 1 AND occupied = 0;");
			while (rs.next()) {
				largeUnitEmpty.add(rs.getInt("id"));
				  
			}
			return largeUnitEmpty;
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
  			try{
  				rs.close();
  			//	st.close();
  				}
  			catch(Exception e){
  				System.out.println("Error closing the database");
  			}
  		}
	}
	
	//displays the empty units in the large warehouse
	public ArrayList<Integer> getEmptyUnitsInSmall(){
		ArrayList<Integer> smallUnitEmpty = new ArrayList<Integer>();
		try {
			rs = st.executeQuery("SELECT * FROM units WHERE warehouseID = 2 AND occupied = 0;");
			while (rs.next()) {
				smallUnitEmpty.add(rs.getInt("id"));
				  
			}
			return smallUnitEmpty;
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
  			try{
  				rs.close();
  			//	st.close();
  				}
  			catch(Exception e){
  			}
  		}
	}
	
	// Customer units in small
	public ArrayList<Integer> getCustomerUnitsInSmall(int customerId){
		ArrayList<Integer> smallUnitEmpty = new ArrayList<Integer>();
		try {
			rs = st.executeQuery("SELECT * FROM units WHERE warehouseID = 2 AND customerId = " + customerId + ";");
			while (rs.next()) {
				smallUnitEmpty.add(rs.getInt("id"));
				  
			}
			return smallUnitEmpty;
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
  			try{
  				rs.close();
  			//	st.close();
  				}
  			catch(Exception e){
  			}
  		}
	}
	
	//customer units in large
	public ArrayList<Integer> getCustomerUnitsInLarge(int customerId){
		ArrayList<Integer> smallUnitEmpty = new ArrayList<Integer>();
		try {
			rs = st.executeQuery("SELECT * FROM units WHERE warehouseID = 1 AND customerId = " + customerId + ";");
			while (rs.next()) {
				smallUnitEmpty.add(rs.getInt("id"));
				  
			}
			return smallUnitEmpty;
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
  			try{
  				rs.close();
  			//	st.close();
  				}
  			catch(Exception e){
  			}
  		}
	}
	
	// returns the amount of large warehouse units that are currently empty
	public int getNumberOfEmptyUnitsInLarge(){
		int emptyLargeWare = 0;
		try {
			rs = st.executeQuery("SELECT COUNT(*) AS total FROM units WHERE warehouseID = 1 AND occupied = 0;");
			emptyLargeWare = rs.getInt("total");
			
			return emptyLargeWare;
		}catch (SQLException e) {
			e.printStackTrace();
			return emptyLargeWare;
		}finally{
  			try{
  				rs.close();
  			//	st.close();
  				}
  			catch(Exception e){
  				System.out.println("Error closing the database");
  			}
  		}
	}
	
	// returns the amount of small warehouses that are currently empty
	public int getNumberOfEmptyUnitsInSmall(){
		int emptySmallWare = 0;
		try {
			rs = st.executeQuery("SELECT COUNT(*) AS total FROM units WHERE warehouseID = 2 AND occupied = 0;");

			emptySmallWare = rs.getInt("total");
			
			return emptySmallWare;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return emptySmallWare;
		}finally{
  			try{
  				rs.close();
  			//	st.close();
  				}
  			catch(Exception e){
  				System.out.println("Error closing the database");
  			}
  		}
	}
		
	//small units per customer id
	public int getNumberOfUnitsOwnedInSmallByCustomerId(int customerId){
		int unitsInSmall = 0;
		try {
			rs = st.executeQuery("SELECT Count(*) AS total FROM units WHERE customerId = " + customerId  +" AND warehouseId = 2;");
			unitsInSmall = rs.getInt("total");
		
			return unitsInSmall;
			
		}catch (SQLException e) {
			e.printStackTrace();
			
			return unitsInSmall;
		}finally{
  			try{
  				rs.close();
  			//	st.close();
  				}
  			catch(Exception e){
  				System.out.println("Error closing the database");
  			}
  		}
	}
	
	//small units per customer id
	public int getNumberOfUnitsOwnedInLargeByCustomerId(int customerId){
		int unitsInSmall = 0;
		try {
			rs = st.executeQuery("SELECT Count(*) AS total FROM units WHERE customerId = " + customerId  +" AND warehouseId = 1;");
			unitsInSmall = rs.getInt("total");
		
			return unitsInSmall;
			
		}catch (SQLException e) {
			e.printStackTrace();
			
			return unitsInSmall;
		}finally{
  			try{
  				rs.close();
  			//	st.close();
  				}
  			catch(Exception e){
  				System.out.println("Error closing the database");
  			}
  		}
	}
		
	// adds a customer and their belongings to a unit
	public boolean fillUnit(String description, int customerId, String pickupDate, int unitId){
		boolean status = false;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		String date = dateFormat.format(cal.getTime());
		
		try {
			st.executeUpdate("UPDATE units SET description ='" + description + 
							 "', customerId = " + customerId + ", occupied = 1, dateReceived ='" +
							 date + "', pickupDate ='" + pickupDate + "'WHERE id =" + unitId + ";");	
			status = true;
			return status;
		}catch (SQLException e) {
			e.printStackTrace();
			return status;
		}finally{
  			try{
  				rs.close();
  				//st.close();
  				}
  			catch(Exception e){
  			}
  		}	
	}
	
	
	//empties a unit, leaving it ready for more items
	public boolean removeUnit(int unitId){
		boolean success = false;
		try {
			st.executeUpdate("UPDATE units SET description = 'empty unit', customerId = 0, occupied = 0, dateReceived = 'null', pickupDate = 'null' WHERE id =" + unitId + ";");
			success = true;
			return success;
		}catch (SQLException e) {
			e.printStackTrace();
			return success;
		}finally{
  			try{
  				rs.close();
  			//	st.close();
  				}
  			catch(Exception e){
 
  			}
  		}
	}
	
	// retrieving a unit by customer ID
	public int totalUnitsByCustomer(int customerId){
		int totalUnits = 0;
		try {
			rs = st.executeQuery("SELECT COUNT(*) AS total FROM units WHERE customerId = " + customerId  +";");
			totalUnits = rs.getInt("total");

			return totalUnits;
		}catch (SQLException e) {
			e.printStackTrace();
			return totalUnits;
		}finally{
  			try{
  				rs.close();
  			//	st.close();
  				}
  			catch(Exception e){
 
  			}
  		}
	}
	
	// retrieving a unit by unit ID
	public ArrayList<String> unitsById(int unitId){
		ArrayList<String> unitData = new ArrayList<String>();
		try {
			rs = st.executeQuery("SELECT * FROM units WHERE id = " + unitId  +";");
				  unitData.add(rs.getString("description"));
				  unitData.add(rs.getString("warehouseId"));
				  unitData.add(rs.getString("occupied"));
				  unitData.add(rs.getString("dateReceived"));
				  unitData.add(rs.getString("pickupDate"));
				  unitData.add(rs.getString("priority"));
				  unitData.add(rs.getString("inQueue"));
				  unitData.add(rs.getString("positionInQueue"));
				  
				  return unitData;
		}catch (SQLException e) {
			e.printStackTrace();
			return unitData;
		}finally{
  			try{
  				rs.close();
  			//	st.close();
  				}
  			catch(Exception e){
  				
  			}
  		}
	}
	
	
	
	// alters the pickup date of a occupied unit
	public boolean changePickupDate(String pickupDate, int unitId){
		boolean status = false;
		try {
			st.executeUpdate("UPDATE units SET pickupDate ='" + pickupDate + "' WHERE id = " + unitId + ";");	
			status = true;
			return status;
		}catch (SQLException e) {
			e.printStackTrace();
			return status;
		}finally{
  			try{
  				rs.close();
  			//	st.close();
  				}
  			catch(Exception e){
  				
  			}
  		}	
	}
	
	//allows for the altering of description
	public boolean changeDescription(String description, int unitId){
		boolean status = false;
		try {
			st.executeUpdate("UPDATE units SET description ='" + description + "' WHERE id = " + unitId + ";");	
			status = true;
			return status;
		}catch (SQLException e) {
			e.printStackTrace();
			return status;
		}finally{
  			try{
  				rs.close();
  			//	st.close();
  				}
  			catch(Exception e){
  				
  			}
  		}			
	}
	
	//retrieves all the items currently in queue
	public void itemsInQueue(){
		try {
			rs = st.executeQuery("SELECT * FROM units WHERE itemInQueue = 1;");
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
		}finally{
  			try{
  				rs.close();
  			//	st.close();
  				}
  			catch(Exception e){
  				
  			}
  		}
		
	}
	
	public int numberOfItemsInQueue(){
		int queued = 9000;
		try {
			rs = st.executeQuery("SELECT COUNT(*)  AS total FROM units WHERE inQueue = 1;");
			queued = rs.getInt("total");
			return queued;
		}catch (SQLException e) {
			e.printStackTrace();
			return queued;
		}finally{
  			try{
  				rs.close();
  		//		st.close();
  				}
  			catch(Exception e){
  				
  			}
  		}
		
	}
	
	// empties the small warehouse
	public boolean purgeSmall(){
		boolean success = false;
		try {
			st.executeUpdate("UPDATE units SET description = 'empty unit', customerId = 0, occupied = 0, dateReceived = 'null', pickupDate = 'null' WHERE warehouseId = 2;");
			success = true;
			return success;
		}catch (SQLException e) {
			e.printStackTrace();
			return success;
		}finally{
  			try{
  				rs.close();
  			//	st.close();
  				}
  			catch(Exception e){
 
  			}
  		}
	}
	
	// empties the large warehouse
	public boolean purgeLarge(){
		boolean success = false;
		try {
			st.executeUpdate("UPDATE units SET description = 'empty unit', customerId = 0, occupied = 0, dateReceived = 'null', pickupDate = 'null' WHERE warehouseId = 1;");
			success = true;
			return success;
		}catch (SQLException e) {
			e.printStackTrace();
			return success;
		}finally{
  			try{
  				rs.close();
  			//	st.close();
  				}
  			catch(Exception e){
 
  			}
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
			}finally{
	  			try{
	  				rs.close();
	  	//			st.close();
	  				}
	  			catch(Exception e){
	  				
	  			}
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
			}finally{
	  			try{
	  				rs.close();
	  	//			st.close();
	  				}
	  			catch(Exception e){
	  			
	  			}
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
			}finally{
	  			try{
	  				rs.close();
	  	//			st.close();
	  				}
	  			catch(Exception e){
	  				System.out.println("Error closing the database");
	  			}
	  		}	
		}
		
		//empties all units pertaining to a specific customer
		public boolean emptyUnitByCustomer(int customerId){
			try {
				st.executeUpdate("UPDATE units SET description = 'empty unit', occupied = 0, dateReceived = 'null', pickupDate = 'null' WHERE customerId =" + customerId + ";");
				return true;
			}catch (SQLException e) {
				e.printStackTrace();
				return false;
			}finally{
	  			try{
	  				rs.close();
	  	//			st.close();
	  				}
	  			catch(Exception e){
	  				System.out.println("Error closing the database");
	  			}
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