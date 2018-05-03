package DB_manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

import Beans.*;
import DB_connect.databank;

public class User_Manager {
	
	public static boolean loginVerify(String username, String password, String fachrolle) throws SQLException {
		boolean status = false;
		Connection  con= databank.getInstance();
		Statement st = con.createStatement();
		String SQL_login="Select user_username, user_password, user_taetigkeit from user where user_username= '"+username+"' and user_password= '"+password+"' and user_taetigkeit = '"+fachrolle+"';";
		ResultSet rs = st.executeQuery(SQL_login);
		status = rs.next();
		return status;
		
	}
	
	public static User getUser(String loginUsername) throws SQLException {
		User myUser = null;
		Connection  con= databank.getInstance();
		Statement st = con.createStatement();
		String SQL="select user_id, user_vorname, user_nachname, user_tel, user_email, user_taetigkeit,"
				+ "user_land, user_stadt, user_plz, user_adresse, user_username from user where user_username='"+loginUsername +"';";
		ResultSet rs = st.executeQuery(SQL);
		if(rs.next()) {
			myUser = new User();
			myUser.setUser_id(rs.getInt(1));
			myUser.setUser_vorname(rs.getString(2));
			myUser.setUser_Nachname(rs.getString(3));
			myUser.setUser_tel(rs.getString(4));
			myUser.setUser_email(rs.getString(5));
			myUser.setUser_taetigkeit(rs.getString(6));
			myUser.setUser_land(rs.getString(7));
			myUser.setUser_stadt(rs.getString(8));
			myUser.setUser_plz(rs.getInt(9));
			myUser.setUser_adresse(rs.getString(10));
			myUser.setUser_username(rs.getString(11));
			
			
		}
		con.close();
		return myUser;
	}
	public static int getUserId(String username) throws SQLException {
		String SQLGetId="";
		Connection  con= databank.getInstance();
		Statement st = con.createStatement();
		SQLGetId = " select user_id from user where user_username='"+ username+"';";
		ResultSet rs = st.executeQuery(SQLGetId);
		return rs.getInt(1);
	}
	
}
