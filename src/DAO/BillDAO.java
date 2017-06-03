package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import Model.Bill;
import Model.Bill;
import connect.JDBConnect;

public class BillDAO {
	public void insertBill(Bill bill) throws SQLException{
		Connection conn= JDBConnect.getConnection();
		String sql="Insert into bill values (?,?,?,?,?,?) ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, bill.getBillID());
		ps.setLong(2, bill.getUserID());
		ps.setDouble(3, bill.getTotal());
		ps.setString(4, bill.getPayment());
		ps.setString(5, bill.getAddress());
		ps.setTimestamp(6, bill.getDate());
		ps.executeUpdate();	
	}
	public ArrayList<Bill> getListBill() throws SQLException{
			Connection connection= JDBConnect.getConnection();
			String sql =" SELECT * FROM BILL";
			PreparedStatement stm= connection.prepareCall(sql);
			ResultSet rs =stm.executeQuery();
			ArrayList<Bill> list =new ArrayList<>();
			while(rs.next()){
				Bill b= new Bill();
				b.setBillID(rs.getLong("bill_ID"));
				b.setUserID(rs.getLong("user_ID"));
				b.setTotal(rs.getDouble("total"));
				b.setAddress(rs.getString("address"));
				b.setPayment(rs.getString("payment"));
				b.setDate(rs.getTimestamp("date"));
				list.add(b);
			}
			return list;
		}
	// update category
		public boolean updateBill(Bill b){
			Connection conn= JDBConnect.getConnection();
			String sql = "update bill set user_ID=?,payment=?,address=? where bill_ID = ?";
			try {
				PreparedStatement ps= conn.prepareStatement(sql);
				ps.setLong(1, b.getUserID() );
				ps.setString(2,b.getPayment() );
				ps.setString(3, b.getAddress());
				ps.setLong(4, b.getBillID());
				return ps.executeUpdate() == 1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
			
		}
		//delte category
		public boolean deleteBill(long bill_id ){
			Connection conn= JDBConnect.getConnection();
			String sql ="Delete from  bill where bill_ID = ?";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setLong(1,bill_id );
				return ps.executeUpdate()==1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
			
		}
		
	
	public static void main(String[] args) throws SQLException {
		BillDAO dao = new BillDAO();
		
		ArrayList<Bill> list= dao.getListBill();
		list.get(1).getBillID();
		for(Bill b : list ){
			System.out.println(b.getUserID());
		}
	}
}
