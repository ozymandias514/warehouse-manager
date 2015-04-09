package project.warehouse_manager;

import project.warehouse_manager.exceptions.*;

public interface WarehouseManager {
	Customer getCustomer(String email) throws CustomerNotFoundException;
	boolean customerExists(String email);
	void addCustomer(Customer customer) throws CustomerAlreadyExistsException;
	void deleteCustomer(String email) throws CustomerNotFoundException;
	void assignUnitToCustomer(int unitNumber, String customerEmail, Warehouse warehouse) 
			throws UnitAlreadyOwnedException, CustomerNotFoundException, UnitDoesNotExistException;
	void removeUnitFromCustomer(int unitNumber, String customerEmail, Warehouse warehouse) 
			throws UnitNotOwnedException, CustomerNotFoundException, UnitDoesNotExistException;
	void moveUnitContents(Warehouse warehouse1, Warehouse warehouse2, 
			int unitNumber1, int unitNumber2) throws UnitDoesNotExistException, UnitAlreadyOwnedException;
}
