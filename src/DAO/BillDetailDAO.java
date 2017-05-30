package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.BillDetail;
import connect.JDBConnect;

public class BillDetailDAO {
	public void insertBillDetail(BillDetail BillDetail) throws SQLException{
		Connection conn= JDBConnect.getConnection();	
		String sql = "insert into bill_detail values(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, BillDetail.getBillDetailID());
		ps.setLong(2, BillDetail.getBillID());
		ps.setLong(3, BillDetail.getProductID());
		ps.setDouble(4, BillDetail.getPrice());
		ps.setInt(5, BillDetail.getQuantity());
		ps.executeUpdate();
		
	}
	public static void main(String[] args) throws SQLException {
		new BillDetailDAO().insertBillDetail(new BillDetail(1, 1, 1, 1, 1));
	}
}
