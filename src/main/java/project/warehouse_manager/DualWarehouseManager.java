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
//		if (id < 1) {
//			throw new CustomerNotFoundException();
//		}
		
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
	 * @param int 
	 * @return
	 * @throws UnitAlreadyOwnedException 
	 * @throws CustomerNotFoundException 
	 * @throws UnitDoesNotExistException 
	 */
	public void assignUnitToCustomer(int unitNumber, String customerEmail, Warehouse warehouse) 
			throws UnitAlreadyOwnedException, CustomerNotFoundException, UnitDoesNotExistException {
		//if (warehouse.getNumberOfUnitsInUse() < warehouse.getTotalNumberOfUnits())
		getCustomer(customerEmail).addUnit(unitNumber); //TEST THIS
		warehouse.occupyUnit(unitNumber);
		
//		if (customerId < 1) {
//			throw new CustomerNotFoundException();
//		}
//		
//		for (int i=0; i<customers.size(); i++) {
//			if (customers.get(i).getId() == customerId) {
//				customers.get(i).addUnit(unitNumber);
//				return;
//			}
//		}
//		
//		throw new CustomerNotFoundException();
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
		getCustomer(customerEmail).removeUnit(unitNumber); //TEST THIS
		warehouse.clearUnit(unitNumber);
		
//		if (customerId < 1) {
//			throw new CustomerNotFoundException();
//		}
//		
//		for (int i=0; i<customers.size(); i++) {
//			if (customers.get(i).getId() == customerId) {
//				customers.get(i).removeUnit(unitNumber);
//				return;
//			}
//		}
//		
//		throw new CustomerNotFoundException();
	}
	
	/**
	 * @param Warehouse 
	 * @param Warehouse 
	 * @param int 
	 * @param int 
	 * @return
	 */
	public void moveUnitContents(Warehouse warehouse1, Warehouse warehouse2, 
			int unitNumber1, int unitnumber2) {
		//implement this
	}

}