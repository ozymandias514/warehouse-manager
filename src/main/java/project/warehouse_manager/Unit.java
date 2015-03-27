package project.warehouse_manager;


public class Unit {
	private int number;
	private String descriptionOfItems;
	private Date deliveryDate;
	private boolean occupied;
	private boolean inQueue;
	private int positionInQueue;
	
	/**
	 * @param number
	 */
	public Unit(int number) {
		this.number = number;
		this.descriptionOfItems = null;
		this.deliveryDate = null;
		this.occupied = false;
		this.inQueue = false;
		this.positionInQueue = 0;
	}
	
	/**
	 * @param number
	 * @param deliveryDate
	 * @param descriptionOfItems
	 */
	public Unit(int number, Date deliveryDate, String descriptionOfItems) {
		this.number = number;
		this.descriptionOfItems = descriptionOfItems;
		this.deliveryDate = deliveryDate;
		this.occupied = false;
		this.inQueue = false;
		this.positionInQueue = 0;
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
	
	/**
	 * @return
	 */
	public int getPositionInQueue() {
		return positionInQueue;
	}
	
	/**
	 * @param 
	 */
	public void setPositionInQueue(int pos) {
		this.positionInQueue = pos;
	}

}