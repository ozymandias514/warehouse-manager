package project.warehouse_manager;

import java.util.*;

import project.warehouse_manager.exceptions.CustomerAlreadyExistsException;
import project.warehouse_manager.exceptions.CustomerNotFoundException;
import project.warehouse_manager.exceptions.UnitAlreadyOwnedException;
import project.warehouse_manager.exceptions.UnitDoesNotExistException;
import project.warehouse_manager.exceptions.UnitNotOwnedException;

public class DualWarehouseManager implements WarehouseManager {
	private Warehouse smallWarehouse;
	private Warehouse largeWarehouse;
	private List<Customer> customers;
	private Queue<Unit> waitingQueue;
	
	/**
	 * @param 
	 * @param 
	 */
	public DualWarehouseManager(int numOfSmallWHUnits, int numOfLargeWHUnits) {
		smallWarehouse = new FixedUnitWarehouse(numOfSmallWHUnits);
		largeWarehouse = new FixedUnitWarehouse(numOfLargeWHUnits);
		customers = new ArrayList<Customer>();
		waitingQueue = new PriorityQueue<Unit>();
	}
	
	/**
	 * @return
	 */
	public Warehouse getSmallWarehouse() {
		return smallWarehouse;
	}
	
	/**
	 * @return
	 */
	public Warehouse getLargeWarehouse() {
		return largeWarehouse;
	}
	
	/**
	 * @param 
	 * @throws CustomerNotFoundException 
	 */
	public Customer getCustomer(String email) throws CustomerNotFoundException {
		if (!customerExists(email)) {
			throw new CustomerNotFoundException();
		}
		
		for (Customer customer : customers) {
			if (customer.getEmail() == email) {
				return customer;
			}
		}
		
		return null; //should never get here
	}
	
	/**
	 * @param
	 */
	public boolean customerExists(String email) {
		for (Customer c : customers) {
			if (c.getEmail() == email) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @param 
	 * @param 
	 * @return
	 * @throws CustomerAlreadyExistsException 
	 */
	public void addCustomer(Customer customer) throws CustomerAlreadyExistsException {
		if (customerExists(customer.getEmail())) {
			throw new CustomerAlreadyExistsException();
		}
		customers.add(customer);
	}
	
	/**
	 * @param 
	 * @throws CustomerNotFoundException 
	 */
	public void deleteCustomer(String email) throws CustomerNotFoundException {
		customers.remove(customers.indexOf(getCustomer(email)));
	}
	
	/**
	 * @param int 
	 * @return
	 * @throws UnitAlreadyOwnedException 
	 * @throws CustomerNotFoundException 
	 * @throws UnitDoesNotExistException 
	 */
	public void assignUnitToCustomer(int unitNumber, String customerEmail, Warehouse warehouse) 
			throws UnitAlreadyOwnedException, CustomerNotFoundException, UnitDoesNotExistException {
		if (warehouse.getUnit(unitNumber).isOccupied()) {
			throw new UnitAlreadyOwnedException();
		}
		if (warehouse.getNumberOfUnitsInUse() < warehouse.getTotalNumberOfUnits()) {
			getCustomer(customerEmail).addUnit(unitNumber);
			warehouse.occupyUnit(unitNumber);
		} else {
			//throw new WarehouseFullException();
		}
		
	}
	
	/**
	 * @param int 
	 * @param int 
	 * @return
	 * @throws UnitNotOwnedException 
	 * @throws CustomerNotFoundException 
	 * @throws UnitDoesNotExistException 
	 */
	public void removeUnitFromCustomer(int unitNumber, String customerEmail, Warehouse warehouse) 
			throws UnitNotOwnedException, CustomerNotFoundException, UnitDoesNotExistException {
		getCustomer(customerEmail).removeUnit(unitNumber);
		warehouse.clearUnit(unitNumber);
	}
	
	/**
	 * moves from warehouse1 (unitnumber1) to warehouse2 (unitnumber2)
	 * @param Warehouse 
	 * @param Warehouse 
	 * @param int 
	 * @param int 
	 * @return
	 * @throws UnitDoesNotExistException 
	 * @throws UnitAlreadyOwnedException 
	 */
	public void moveUnitContents(Warehouse warehouse1, Warehouse warehouse2, 
			int unitNumber1, int unitNumber2) 
			throws UnitDoesNotExistException, UnitAlreadyOwnedException {
		if (warehouse2.getUnit(unitNumber2).isOccupied()) {
			throw new UnitAlreadyOwnedException();
		}
		if (warehouse2.getNumberOfUnitsInUse() < warehouse2.getTotalNumberOfUnits()) {
			Unit warehouse1Unit = warehouse1.getUnit(unitNumber1);
			Unit warehouse2Unit = warehouse2.getUnit(unitNumber2);
			
			warehouse2Unit.setDeliveryDate(warehouse1Unit.getDeliveryDate());
			warehouse2Unit.setDescriptionOfItems(warehouse1Unit.getDescriptionOfItems());
			warehouse2Unit.setOccupied(warehouse1Unit.isOccupied());
			
			warehouse1.clearUnit(unitNumber1);
		} else {
			//queue
		}
	}
	
	public void checkQueue() {
		if (smallWarehouse.getNumberOfUnitsInUse() >= smallWarehouse.getTotalNumberOfUnits()) {
			return;
		} else {
			//move next unit in queue
			checkQueue();
		}
	}

}