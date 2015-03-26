package project.warehouse_manager;

import java.util.ArrayList;
import java.util.List;

import project.warehouse_manager.exceptions.UnitNotOwnedException;
import project.warehouse_manager.exceptions.UnitAlreadyOwnedException;

public class Customer {
	private int id;
	private String name;
    private String email;
    private List<Integer> unitsOwned;

    /**
     * @param 
     * @param 
     */
    public Customer(String name, String email) {
    	this.id = 0;
    	this.name = name;
    	this.email = email;
    	unitsOwned = new ArrayList<Integer>();
    }

    /**
     * @return
     */
    public int getId() {
    	return id;
    }

    /**
     * @param 
     */
    public void setId(int id) {
    	this.id = id;
    }

    /**
     * @return
     */
    public String getName() {
    	return name;
    }

    /**
     * @param 
     */
    public void setName(String name) {
    	this.name = name;
    }

    /**
     * @return
     */
    public String getEmail() {
    	return email;
    }

    /**
     * @param 
     */
    public void setEmail(String email) {
    	this.email = email;
    }

    /**
     * @return
     */
    public Integer[] getUnitsOwned() {
    	return unitsOwned.toArray(new Integer[0]);
    }

    /**
     * @param 
     * @throws UnitNotOwnedException 
     */
    public void addUnit(int unitNumber) throws UnitAlreadyOwnedException {
    	if (!isUnitOwned(unitNumber)) {
    		unitsOwned.add(unitNumber);
    	} else {
    		throw new UnitAlreadyOwnedException();
    	}
    }

    /**
     * @param 
     * @throws UnitNotOwnedException 
     */
    public void removeUnit(int unitNumber) throws UnitNotOwnedException {
    	if (isUnitOwned(unitNumber)) {
    		unitsOwned.remove(unitsOwned.indexOf(unitNumber));
    	} else {
    		throw new UnitNotOwnedException();
    	}
    }

    /**
     * @param 
     */
    public boolean isUnitOwned(int unitNumber) {
        return unitsOwned.contains(unitNumber);
    }

}