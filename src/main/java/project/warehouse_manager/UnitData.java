package project.warehouse_manager;

import java.util.Date;
import java.util.Calendar;

public class UnitData {
	private int id;
	private String description;
	private int customerId;
	private int warehouseId;
	private int occupied;
	private String dateReceived;
	private Date pickUpDate;
	private int priority;
	private int inQueue;
	private int positionInQueue;
	
	public UnitData(int id, String description, int customerId, int warehouseId, int occupied, 
			String dateReceived, String pickUpDate, int inQueue){
		
		this.id = id;
		this.description = description;
		this.customerId = customerId;
		this.warehouseId = warehouseId;
		this.occupied = occupied;
		this.dateReceived = dateReceived;
		if (pickUpDate == null || pickUpDate.equals("null")) {
			this.pickUpDate = null;
		} else {
			String[] splitDate = pickUpDate.split("/");
			int day   = Integer.parseInt(splitDate[0]);
			int month = Integer.parseInt(splitDate[1]);
			int year  = Integer.parseInt(splitDate[2]);
			this.pickUpDate = new Date(year, month, day);
		}
		this.inQueue = inQueue;
	}

	// unit id methods ------------------------------------------------------
	public void setId(int id) {
	    this.id = id;
	}
	
	public int getId() {
	    return id;
	}
	
	// description methods -------------------------------------------------
	public void setDescription(String description){
		this.description = description;
	}
	
	public String getDescription() {
	    return description;
	}
	
	// customer Id methods -------------------------------------------------
	public void setCustomerId(int customerId){
		this.customerId = customerId;
	}
	
	public int getCustomerId(){
		return customerId;
	}
	
	// warehouseId methods-------------------------------------------------
	public void setWarehouseId(int warehouseId){
		this.warehouseId = warehouseId;
	}
	
	public int getWarehouseId(){
		return warehouseId;
	}
	
	// occupied methods ---------------------------------------------------
	public void setOccupied(int occupied){
		this.occupied = occupied;
	}
	
	public int getOccupied(){
		return occupied;
	}
	
	// date received methods ----------------------------------------------
	public void setDateReceived(String dateReceived){
		this.dateReceived = dateReceived;
	}
	
	public String getDateReceived(){
		return dateReceived;
	}
	
	// pick up date methods ----------------------------------------------
	public void setPickUpDate(String date){
		//this.pickUpDate = new Date(pickUpDate);
		this.pickUpDate.setTime(Date.parse(date));
	}
	
	public Date getPickUpDate(){
		return pickUpDate;
	}
	
	// priority methods ----------------------------------------------
	public void setPriority(int priority){
		this.priority = priority;
	}
	
	public int getPriority(){
		return priority;
	}
	
	// inQueue methods ----------------------------------------------
	public void setInQueue(int inQueue){
		this.inQueue = inQueue;
	}
	
	public int getInQueue(){
		return inQueue;
	}
	
	// position In Queue methods ----------------------------------------------
	public void setPositionInQueue(int positionInQueue){
		this.positionInQueue = positionInQueue;
	}
	
	public int getPositionInQueue(){
		return positionInQueue;
	}
}