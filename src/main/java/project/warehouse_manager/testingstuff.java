package project.warehouse_manager;


import project.warehouse_manager.exceptions.*;

public class testingstuff {

	public static void main(String[] args) {
		DatabaseHandlerImpl connect = new DatabaseHandlerImpl();
		connect.getData();
		/*
		DualWarehouseManager wm  = new DualWarehouseManager(100, 1000);
		String testName = "carson";
		String testEmail = "thug@thug.life";
		try {
			wm.addCustomer(new Customer(testName, testEmail));
			System.out.println(wm.customerExists(testEmail));
			
			wm.assignUnitToCustomer(5, testEmail, wm.getLargeWarehouse());
			System.out.println(wm.getCustomer(testEmail).getUnitsOwned()[0]);
			System.out.println(wm.getLargeWarehouse().getUnit(5).isOccupied());
		} catch (CustomerAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnitAlreadyOwnedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnitDoesNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		
	}
	

}
