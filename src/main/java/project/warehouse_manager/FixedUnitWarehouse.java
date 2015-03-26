package project.warehouse_manager;

import project.warehouse_manager.exceptions.UnitDoesNotExistException;


public class FixedUnitWarehouse implements Warehouse {
	private Unit[] units;
	private int numberOfUnitsInUse;
	private int totalNumberOfUnits;
	
	/**
	 * @param 
	 */
	public FixedUnitWarehouse(int numberOfUnits) {
		units = new Unit[numberOfUnits];
		for (int i=0; i<numberOfUnits; i++) {
			units[i] = new Unit(i+1);
		}
		numberOfUnitsInUse = 0;
		totalNumberOfUnits = numberOfUnits;
	}
	
	
	/**
	 * @return
	 */
	public Unit[] getUnits() {
		return units;
	}
	
	/**
	 * @param 
	 * @throws UnitDoesNotExistException 
	 */
	public Unit getUnit(int unitNumber) throws UnitDoesNotExistException {
		if (unitNumber < 1 || unitNumber > units.length) {
			throw new UnitDoesNotExistException();
		}
		for (Unit unit : units) {
			if (unit.getNumber() == unitNumber) {
				return unit;
			}
		}
		return null; //should never get to this theoretically
	}
	
	/**
	 * @param
	 * @throws UnitDoesNotExistException 
	 */
	public void occupyUnit(int unitNumber) throws UnitDoesNotExistException {
		getUnit(unitNumber).setOccupied(true);
		numberOfUnitsInUse++;
	}
	
	/**
	 * @param 
	 * @throws UnitDoesNotExistException 
	 */
	public void clearUnit(int unitNumber) throws UnitDoesNotExistException {
		getUnit(unitNumber).setOccupied(false);
		getUnit(unitNumber).setDescriptionOfItems(null);
		getUnit(unitNumber).setDeliveryDate(null);
		getUnit(unitNumber).setCustomerId(0);
		numberOfUnitsInUse--;
	}
	
	
	/**
	 * @return 
	 */
	public int getNumberOfUnitsInUse() {
		return numberOfUnitsInUse;
	}
	
	/**
	 * @return
	 */
	public int getTotalNumberOfUnits() {
		return totalNumberOfUnits;
	}
	
	/**
	 * @return
	 */
	public void setTotalNumberOfUnits(int totalNumberOfUnits) {
		this.totalNumberOfUnits = totalNumberOfUnits;
	}
	
}