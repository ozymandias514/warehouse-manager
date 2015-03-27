package project.warehouse_manager;
import java.sql.*;

public class DatabaseHandlerImpl {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public DatabaseHandlerImpl(){
		try{
			// database connection
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://192.185.5.78:3306/jfgonzal_test","jfgonzal_zera", "murtas12");
			System.out.println ("Database connection established");
			st = con.createStatement();
		}catch(Exception ex){
			System.out.println("Erro: " + ex);	
		}
	}
	/**
	 * 
	 */
	public void getData(){
		try{
			
			String query = "SELECT * FROM people";
			rs = st.executeQuery(query);
			System.out.println("Records from Database");
			while(rs.next()){
				String name = rs.getString("name");
				String age	= rs.getString("age");
				System.out.println("Name: " + name + " Age: " + age);
			}
			
		}catch(Exception ex){
			System.out.println(ex);
			
		}
		
	}
	/**
	 * 
	 */
	public static void fullUnit() {
		
	}
	/**
	 * 
	 */
	public static void updateDescription() {
		
	}

	/**
	 * 
	 */
	public static void updateDeliveryDate() {
		
	}

	/**
	 * 
	 */
	public static void updateDatabase() {
		
	}

	/**
	 * 
	 */
	public static void customerSearch() {
		
	}

	/**
	 * 
	 */
	public static void modifyCustomer() {
		
	}

	/**
	 * 
	 */
	public static void deleteCustomer() {
		
	}

	/**
	 * 
	 */
	public static void insertCustomer() {
		
	}

	/**
	 * 
	 */
	public static void removeUnit() {
		
	}
	
}
