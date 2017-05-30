package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

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
	public static void main(String[] args) throws SQLException {
		new BillDAO().insertBill(new Bill(0,0,0,"pay","home",new Timestamp(new Date().getTime())));
	}
}
