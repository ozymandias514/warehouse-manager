package project.warehouse_manager;

import project.warehouse_manager.exceptions.UnitDoesNotExistException;

public interface Warehouse {
	Unit[] getUnits();
	Unit getUnit(int unitNumber) throws UnitDoesNotExistException;
	void occupyUnit(int unitNumber) throws UnitDoesNotExistException;
	void clearUnit(int unitNumber) throws UnitDoesNotExistException;
	int getNumberOfUnitsInUse();
	int getTotalNumberOfUnits();
}
