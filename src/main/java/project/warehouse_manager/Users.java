package project.warehouse_manager;

import java.sql.*;

public class Users extends DatabaseHandler{

	// prints out all data pertaining to users
	public void displayDataFromUsers(){
		try {
			rs = st.executeQuery("SELECT * FROM users;");
			System.out.println("id    firstName         lastName        username     password");
			System.out.print("---   ------------      -----------     ----------   --------");
			System.out.println();
			while (rs.next()) {
				  int id = rs.getInt("id");
				  String firstName = rs.getString("firstName");
				  String lastName = rs.getString("lastName");
				  String username = rs.getString("username");
				  String password = rs.getString("password");
				  System.out.printf("%d     %s		%s	%s         %s", id, firstName, lastName, username, password);
				  System.out.println();
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){
  				System.out.println("Error closing the database");
  			}
  		}	
	}
	
	//authenticate the user
	public boolean authenticate(String username, String password){
		try{
			rs = st.executeQuery("SELECT COUNT(*) AS total FROM users WHERE username ='" +
									username + "' AND password = '"+ password + "';");
			int total = rs.getInt("total");

			if(total != 0)	{
				return true;
			}else{
				return false;
			}
		}catch (SQLException e){
			e.printStackTrace();
			return false;
		}finally{
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){
  				System.out.println("Error closing the database");
  			}
  		}	
	}
	
	// gets the user id from the username
	public int getIdFromUsername(String username){
		
		try {
			rs = st.executeQuery("SELECT id FROM users WHERE username ='" +
					username + "';");
			int userId = rs.getInt("id") ;
			return userId;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){
  				System.out.println("Error closing the database");
  			}
  		}	
			return 0;
	}
	
	// gets the user data from the user id
	public String[] getDataFromId(int userId){

		String[] fluke = null;
		try {
			rs = st.executeQuery("SELECT * FROM users WHERE id =" + userId + ";");
			String[] data = {rs.getString("firstName"),rs.getString("lastName"),rs.getString("username"),rs.getString("password")};
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
  			try{
  				
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){
  				System.out.println("Error closing the database");
  			}
  		}	
			return fluke;
	}
}
