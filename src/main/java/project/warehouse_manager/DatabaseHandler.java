package project.warehouse_manager;

import java.sql.*;

public class DatabaseHandler {

	protected Connection con;
	protected Statement st;
	protected ResultSet rs;
	
	public DatabaseHandler(){
	try {
		
		Class.forName("org.sqlite.JDBC");
		con = DriverManager.getConnection("jdbc:sqlite:warehouse.db");
		st = con.createStatement();
	}catch(Exception e){
		
		System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		System.exit(0);
		}
	}	
}
