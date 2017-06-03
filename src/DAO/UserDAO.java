package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.User;
import connect.JDBConnect;

public class UserDAO {
	public boolean checkEmail(String email){
		Connection myConn= JDBConnect.getConnection();
		String sql = "Select * From users Where user_email='"+email+"'";
		PreparedStatement ps;
		try {
			ps=myConn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				myConn.close();
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean insertUser(User u){
		Connection myConn=JDBConnect.getConnection();
		String sql= "Insert into users values(?,?,?,?)";
		try {
			PreparedStatement ps=myConn.prepareStatement(sql);
			ps.setLong(1, u.getUserID());
			ps.setString(2, u.getUserMail());
			ps.setString(3,u.getUserPass());
			ps.setBoolean(4, u.isUserRole());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public User login(String email,String password){
		Connection myConn= JDBConnect.getConnection();
		String sql= "Select * From users where user_email='" + email + "' and user_pass='"+password +"'";
		PreparedStatement ps;
		try {
			ps=myConn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				User u = new User();
				u.setUserID(rs.getLong("user_id"));
				u.setUserMail(rs.getString("user_email"));
				u.setUserPass(rs.getString("user_pass"));
				u.setUserRole(rs.getBoolean("user_role"));
				myConn.close();
				return u;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public User getUser(long userID){
		Connection conn= JDBConnect.getConnection();
		String sql= "select * from users where user_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, userID);
			ResultSet rs = ps.executeQuery();
			User u = new User();
			while(rs.next()){
				u.setUserMail(rs.getString("user_email"));
			}
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public static void main(String[] args) {
		UserDAO dao= new UserDAO();
		System.out.println(dao.getUser(1).getUserMail());
	}
}
