package project.warehouse_manager;

import java.sql.*;

public class Users extends DatabaseHandler{
	
	//authenticate the user
	public boolean authenticate(String username, String password) throws SQLException{
	
			rs = st.executeQuery("SELECT COUNT(*) AS total FROM users WHERE username ='" +
									username + "' AND password = '"+ password + "';");
			int total = rs.getInt("total");

			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){}
			
			if(total != 0)	{
				return true;
			}else{
				return false;
			}
	}
	
	// gets the user id from the username
	public int getIdFromUsername(String username) throws SQLException{
		

			rs = st.executeQuery("SELECT id FROM users WHERE username ='" +
					username + "';");
			int userId = rs.getInt("id") ;
			
  			try{
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){}
  			
  			return userId;
 	
	}
	
	// gets the user data from the user id
	public String[] getDataFromId(int userId) throws SQLException{

			rs = st.executeQuery("SELECT * FROM users WHERE id =" + userId + ";");
			String[] data = {rs.getString("firstName"),rs.getString("lastName"),rs.getString("username"),rs.getString("password")};
		
  			try{
  				
  				rs.close();
  				st.close();
  				}
  			catch(Exception e){	}
  			return data;
	}
}
