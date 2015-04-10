package project.warehouse_manager;

public class tableCreation {
	
	// System users
	static String[] usersTable = {"firstName","lastName","username","password"};
	static String[][] users = {
								{"Fernando","Gonzales","jfgonzal","pass"},
								{"Carson","Kirkpatrick","kirk","pass"}
								};
	// Customers
	static String[] customerTable = {"firstName","lastName","email"};
	static String[][] customers = {
								{"John","Doe","jdoe@gmail.com"},
								{"Jane","Dorian","jdor@gmail.com"},
								{"Harry","Harriot","hhar@gmail.com"},
								{"Jericho","Swain","jswa@gmail.com"},
								{"Annie","Hastur","ahas@gmail.com"},
								{"Malcom","Graves","mgra@gmail.com"},
								{"Sarah","Fortune","sfor@gmail.com"},
								{"Shauna","Vayne","svay@gmail.com"},
								{"Edmundo","Mundo","emun@gmail.com"},
								{"Fiora","Laurent","flau@gmail.com"}
								};
	
	static String[] unitsTable = {"description","customerId","warehouseId","occupied","dateReceived","pickupDate","priority","inQueue","positionInQueue"};
	
	public void generateLargeWarehouseUnitsInsertStatements(){
		
		for(int i = 1; i<=20; i++){
			System.out.println("INSERT INTO units(id, description, customerId, warehouseId, occupied, dateReceived, pickupDate, priority, inQueue, positionInQueue) values("
					+ i + ", 'empty unit',0,1,0,'null','null',0,0,0);");
		}
	}
	
	public void generateSmallWarehouseUnitsInsertStatements(){
		
		for(int i = 200; i<=205; i++){
			System.out.println("INSERT INTO units(id, description, customerId, warehouseId, occupied, dateReceived, pickupDate, priority, inQueue, positionInQueue) values("
					+ i + ", 'empty unit',0,2,0,'null','null',0,0,0);");
		}
	}
	
	public void generateUserInsertStatements(){
		
		for(String[] user : users){
		System.out.println("INSERT INTO users("+ usersTable[0]+ 
				", " + usersTable[1] + ", " + usersTable[2]  + ", " + usersTable[3] +
				") VALUES('"+ user[0] + "', '" + user[1] + "', '" + user[2] + "', '" + user[3] + "');");	
		}
	}
	
	public void generateCustomerInsertStatements(){
		
		for(String[] customer : customers){
		System.out.println("INSERT INTO customer("+ customerTable[0]+ 
				", " + customerTable[1] + ", " + customerTable[2] +
				") VALUES('"+ customer[0] + "', '" + customer[1] +
				"', '" + customer[2] + "');");	
		}
	}
	
	
}

