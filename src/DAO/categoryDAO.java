package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import Model.Category;
import connect.JDBConnect;

public class categoryDAO {
	public ArrayList<Category> getListCategory() throws SQLException{
		Connection connection= JDBConnect.getConnection();
		String sql =" SELECT * FROM SHOP";
		PreparedStatement stm= connection.prepareCall(sql);
		ResultSet rs =stm.executeQuery();
		ArrayList<Category> list =new ArrayList<>();
		while(rs.next()){
			Category category= new Category();
			category.setCategoryID(rs.getInt("category_id"));
			category.setCategoryName(rs.getString("category_name"));
			list.add(category);
		}
		return list;
	}
	public static void main(String[] args) throws SQLException {
		categoryDAO dao =new categoryDAO();
		for(Category ds : dao.getListCategory()){
			System.out.println(ds.getCategoryID() + " - " + ds.getCategoryName());
		}
	}
}
