package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class JDBConnect {
	
	public static Connection getConnection(){
		Connection myConn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			myConn=DriverManager.getConnection("jdbc:mysql://localhost:3309/shop","newuser","student");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myConn;
	}
	public static void main(String[] args) {
		System.out.println(getConnection());
	}	
	
}
