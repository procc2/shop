package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.User;
import connect.JDBConnect;

public class UserDAO {
	public boolean checkEmail(String email){
		Connection conn= JDBConnect.getConnection();
		String sql= "Select * from users where user_email = '"+email+"'";
		PreparedStatement ps;
		try {
			ps = conn.prepareCall(sql);
			ResultSet rs =ps.executeQuery();
			while(rs.next()){
				conn.close();
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//phương thức thêm tài khoản
	
		public boolean insertUser(User a){
			Connection myConn= JDBConnect.getConnection();
			String sql= "Insert into users values(?,?,?,?)";
			System.out.println("insert complete");
			try {
				PreparedStatement ps= myConn.prepareStatement(sql);
				ps.setLong(1, a.getUserID());
				ps.setString(2, a.getUserMail());
				ps.setString(3, a.getUserPass());
				ps.setBoolean(4, a.isUserRole());
				ps.executeUpdate();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		// phương thức kiểm tra pass
		public User login(String email, String password) {
			Connection con = JDBConnect.getConnection();
			String sql = "select * from users where user_email='" + email + "' and user_pass='" + password + "'";
			PreparedStatement ps;
			try {
				ps = con.prepareCall(sql);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					User u=new User();
					u.setUserID(rs.getLong("user_id"));
					u.setUserMail(rs.getString("user_email"));
					u.setUserPass(rs.getString("user_pass"));
					u.setUserRole(rs.getBoolean("user_role"));
					con.close();
					return u;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	
}
