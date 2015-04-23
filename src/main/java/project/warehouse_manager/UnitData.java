package project.warehouse_manager;

import java.util.Calendar;

public class UnitData {
	private int id;
	private String description;
	private int customerId;
	private int warehouseId;
	private int occupied;
	private String dateReceived;
	private Calendar pickUpDate;
	private int inQueue;
	private int positionInQueue;
	private int priority;
	
	public UnitData(int id, String description, int customerId, int warehouseId, int occupied, 
			String dateReceived, String pickUpDateString, int inQueue){
		this.id = id;
		this.description = description;
		this.customerId = customerId;
		this.warehouseId = warehouseId;
		this.occupied = occupied;
		this.dateReceived = dateReceived;
		if (pickUpDateString == null || pickUpDateString.equals("null")) {
			this.pickUpDate = null;
		} else {
			String[] s = pickUpDateString.split("/");
			int day   = Integer.parseInt(s[0]);
			int month = Integer.parseInt(s[1]);
			int year  = Integer.parseInt(s[2]);
			pickUpDate = Calendar.getInstance();
			pickUpDate.set(year, month-1, day);
		}
		this.inQueue = inQueue;
		this.positionInQueue = 0;
		this.priority = 0;
		
	}

	public void setId(int id) {
	    this.id = id;
	}
	
	public int getId() {
	    return id;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public String getDescription() {
	    return description;
	}
	
	public void setCustomerId(int customerId){
		this.customerId = customerId;
	}
	
	public int getCustomerId(){
		return customerId;
	}
	
	public void setWarehouseId(int warehouseId){
		this.warehouseId = warehouseId;
	}
	
	public int getWarehouseId(){
		return warehouseId;
	}
	
	public void setOccupied(int occupied){
		this.occupied = occupied;
	}
	
	public int getOccupied(){
		return occupied;
	}
	
	public void setDateReceived(String dateReceived){
		this.dateReceived = dateReceived;
	}
	
	public String getDateReceived(){
		return dateReceived;
	}
	
	public void setPickUpDate(Calendar pickUpDate){
		this.pickUpDate = pickUpDate;
	}
	
	public Calendar getPickUpDate(){
		return pickUpDate;
	}
	
	public void setInQueue(int inQueue){
		this.inQueue = inQueue;
	}
	
	public int getInQueue(){
		return inQueue;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}

	public void setPositionInQueue(int positionInQueue) {
		this.positionInQueue = positionInQueue;
	}

	public int getPositionInQueue() {
		return positionInQueue;
	}
	
}