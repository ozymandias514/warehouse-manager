package project.warehouse_manager;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Unit extends DatabaseHandler{
	
	public Unit() { 
		
	}
	
  	public ArrayList<String> displayLargeWarehouseData() throws SQLException{
  		ArrayList<String> largeUnitData = new ArrayList<String>();
  
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
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){
  			}
  			return largeUnitData;
  	}
  	
  	public ArrayList<UnitData> getAllLargeWarehouseUnits() throws ClassNotFoundException, SQLException{
		
  		String sql = "SELECT * FROM units WHERE warehouseId = 1";
  	    ResultSet rst;
  	    rst = st.executeQuery(sql);
  	    ArrayList<UnitData> UnitsList = new ArrayList<UnitData>();
  		while(rst.next()){
  			UnitData unitData = new UnitData(rst.getInt("id")
  					,rst.getString("description")
  					,rst.getInt("customerId")
  					,rst.getInt("warehouseId")
  					,rst.getInt("occupied")
  					,rst.getString("dateReceived")
  					,rst.getString("pickupDate")
  					,rst.getInt("inQueue")
  					);
  			UnitsList.add(unitData);
  		}
  		return UnitsList;
  	}
  	
  	public ArrayList<UnitData> getAllSmallWarehouseUnits() throws ClassNotFoundException, SQLException{
		
  		String sql = "SELECT * FROM units WHERE warehouseId = 2";
  	    ResultSet rst;
  	    rst = st.executeQuery(sql);
  	    ArrayList<UnitData> UnitsList = new ArrayList<UnitData>();
  		while(rst.next()){
  			UnitData unitData = new UnitData(rst.getInt("id")
  					,rst.getString("description")
  					,rst.getInt("customerId")
  					,rst.getInt("warehouseId")
  					,rst.getInt("occupied")
  					,rst.getString("dateReceived")
  					,rst.getString("pickupDate")
  					,rst.getInt("inQueue")
  					);
  			UnitsList.add(unitData);
  		}
  		
  		return UnitsList;
  	}
  	
  	public ArrayList<String> displaySmallWarehouseData() throws SQLException{
  		ArrayList<String> smallUnitData = new ArrayList<String>();
  
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
  			
  			try{
  				rs.close();
  				//st.close();
  				}
  			catch(Exception e){
  				System.out.println("Error closing the database");
  			}
  			return smallUnitData;
  	}
	
	//displays the empty units in the large warehouse
	public ArrayList<Integer> getEmptyUnitsInLarge() throws SQLException{
		ArrayList<Integer> largeUnitEmpty = new ArrayList<Integer>();

			rs = st.executeQuery("SELECT * FROM units WHERE warehouseID = 1 AND occupied = 0;");
			while (rs.next()) {
				largeUnitEmpty.add(rs.getInt("id"));
				  
			}
			
	
  			try{
  				rs.close();
  			//	st.close();
  				}
  			catch(Exception e){	}
  			return largeUnitEmpty;
	}
	
	//displays the empty units in the large warehouse
	public ArrayList<Integer> getEmptyUnitsInSmall() throws SQLException{
		ArrayList<Integer> smallUnitEmpty = new ArrayList<Integer>();
	
			rs = st.executeQuery("SELECT * FROM units WHERE warehouseID = 2 AND occupied = 0;");
			while (rs.next()) {
				smallUnitEmpty.add(rs.getInt("id"));
				  
			}
	
  			try{
  				rs.close();
  			//	st.close();
  				}
  			catch(Exception e){
  			}
  			return smallUnitEmpty;
	}
	
	// Customer units in small
	public ArrayList<Integer> getCustomerUnitsInSmall(int customerId) throws SQLException{
		ArrayList<Integer> smallUnitEmpty = new ArrayList<Integer>();
	
			rs = st.executeQuery("SELECT * FROM units WHERE warehouseID = 2 AND customerId = " + customerId + ";");
			while (rs.next()) {
				smallUnitEmpty.add(rs.getInt("id"));
				  
			}

  			try{
  				rs.close();
  			//	st.close();
  				}
  			catch(Exception e){
  			}
  			
  			return smallUnitEmpty;
	}
	
	//customer units in large
	public ArrayList<Integer> getCustomerUnitsInLarge(int customerId) throws SQLException{
		ArrayList<Integer> smallUnitEmpty = new ArrayList<Integer>();
	
			rs = st.executeQuery("SELECT * FROM units WHERE warehouseID = 1 AND customerId = " + customerId + ";");
			while (rs.next()) {
				smallUnitEmpty.add(rs.getInt("id"));
				  
			}
			
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){
  			}
  			return smallUnitEmpty;
	}
	
	// returns the amount of large warehouse units that are currently empty
	public int getNumberOfEmptyUnitsInLarge() throws SQLException{
		int emptyLargeWare = 0;

			rs = st.executeQuery("SELECT COUNT(*) AS total FROM units WHERE warehouseID = 1 AND occupied = 0;");
			emptyLargeWare = rs.getInt("total");

  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){
  			}
  			return emptyLargeWare;
	}
	
	// returns the amount of small warehouses that are currently empty
	public int getNumberOfEmptyUnitsInSmall() throws SQLException{
		int emptySmallWare = 0;
			rs = st.executeQuery("SELECT COUNT(*) AS total FROM units WHERE warehouseID = 2 AND occupied = 0;");

			emptySmallWare = rs.getInt("total");
			
			
			

  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){
  				System.out.println("Error closing the database");
  			}
  			return emptySmallWare;
	}
		
	//small units per customer id
	public int getNumberOfUnitsOwnedInSmallByCustomerId(int customerId) throws SQLException{
		int unitsInSmall = 0;
	
			rs = st.executeQuery("SELECT Count(*) AS total FROM units WHERE customerId = " + customerId  +" AND warehouseId = 2;");
			unitsInSmall = rs.getInt("total");
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){	}
  			return unitsInSmall;
	}
	
	//small units per customer id
	public int getNumberOfUnitsOwnedInLargeByCustomerId(int customerId) throws SQLException{
		int unitsInSmall = 0;
		
			rs = st.executeQuery("SELECT Count(*) AS total FROM units WHERE customerId = " + customerId  +" AND warehouseId = 1;");
			unitsInSmall = rs.getInt("total");
		
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){	}
  			return unitsInSmall;
	}
		
	// adds a customer and their belongings to a unit
	public boolean fillUnit(String description, int customerId, String pickupDate, int unitId){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		String date = dateFormat.format(cal.getTime());
		try {
			st.executeUpdate("UPDATE units SET description ='" + description + 
							 "', customerId = " + customerId + ", occupied = 1, dateReceived ='" +
							 date + "', pickupDate ='" + pickupDate + "'WHERE id =" + unitId + ";");	
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
  			try{
  				rs.close();
  				//st.close();
  				}
  			catch(Exception e){
  			}
  		}
	}
	
	// adds a customer and their belongings to a unit
	public boolean repopulateTables(List<UnitData> largeWarehouseUnitList,
			List<UnitData> smallWarehouseUnitList){
			
		try {
			
			for (UnitData unitData : largeWarehouseUnitList) {
				//converting the date into a string
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String date;
				if (unitData.getPickUpDate() == null) {
					date = "null";
				} else {
					date = dateFormat.format(unitData.getPickUpDate().getTime());
				}
				st.executeUpdate("UPDATE units SET description ='" + unitData.getDescription() + 
						 "', customerId = " + unitData.getCustomerId() + ", occupied = " + unitData.getOccupied() 
						 + ", dateReceived ='" + unitData.getDateReceived() + "', pickUpDate = '" + date 
						 + "' WHERE id =" + unitData.getId() + ";");
			}
			
			for (UnitData unitData : smallWarehouseUnitList) {
				//converting the date into a string
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String date;
				if (unitData.getPickUpDate() == null) {
					date = "null";
				} else {
					date = dateFormat.format(unitData.getPickUpDate().getTime());
				}
				st.executeUpdate("UPDATE units SET description ='" + unitData.getDescription() + 
						 "', customerId = " + unitData.getCustomerId() + ", occupied = " + unitData.getOccupied() 
						 + ", dateReceived ='" + unitData.getDateReceived() + "', pickUpDate = '" + date 
						 + "' WHERE id =" + unitData.getId() + ";");
			}
			
						
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
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
	public int totalUnitsByCustomer(int customerId) throws SQLException{
		int totalUnits = 0;
	
			rs = st.executeQuery("SELECT COUNT(*) AS total FROM units WHERE customerId = " + customerId  +";");
			totalUnits = rs.getInt("total");

  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){
 
  			}
  			return totalUnits;
	}
	
	// retrieving a unit by unit ID
	public ArrayList<String> unitsById(int unitId) throws SQLException{
		ArrayList<String> unitData = new ArrayList<String>();
	
			rs = st.executeQuery("SELECT * FROM units WHERE id = " + unitId  +";");
				  unitData.add(rs.getString("description"));
				  unitData.add(rs.getString("warehouseId"));
				  unitData.add(rs.getString("occupied"));
				  unitData.add(rs.getString("dateReceived"));
				  unitData.add(rs.getString("pickupDate"));
				  unitData.add(rs.getString("priority"));
				  unitData.add(rs.getString("inQueue"));
				  unitData.add(rs.getString("positionInQueue"));
				  
			
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){	}
  			return unitData;
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
  				st.close();
  				}
  			catch(Exception e){	}
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
	
	public int numberOfItemsInQueue() throws SQLException{
		int queued = 9000;
			rs = st.executeQuery("SELECT COUNT(*)  AS total FROM units WHERE inQueue = 1;");
			queued = rs.getInt("total");
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){	}
  			return queued;
	}
	
	// empties the small warehouse
	public boolean purgeSmall(){
		boolean success = false;
		try {
			//st.executeUpdate("UPDATE units SET description = 'empty unit', customerId = 0, occupied = 0, dateReceived = 'null', pickupDate = 'null' WHERE warehouseId = 2;");
			rs = st.executeQuery("SELECT * FROM units WHERE warehouseId = 1;");
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
	
		//changes whether the item is in queue or not
	/*
		public boolean changeQueueStatus(int queueStatus, int unitId){
			try {
				st.executeUpdate("UPDATE units SET inQueue = " + queueStatus + " WHERE id=" + unitId + ";");
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}finally{
	  			try{
	  				rs.close();
	  	//			st.close();
	  				}
	  			catch(Exception e){
	  			
	  			}
	  		}				
		}
		*/
		/*
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
		*/
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
}