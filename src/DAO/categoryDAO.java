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
		String sql =" SELECT * FROM CATEGORY";
		PreparedStatement stm= connection.prepareCall(sql);
		ResultSet rs =stm.executeQuery();
		ArrayList<Category> list =new ArrayList<>();
		while(rs.next()){
			Category category= new Category();
			category.setCategoryID(rs.getLong("category_id"));
			category.setCategoryName(rs.getString("category_name"));
			list.add(category);
		}
		return list;
	}
	// insert Category
	public boolean insertCategory(Category c){
		Connection conn= JDBConnect.getConnection();
		String sql = "insert into category values(?,?)";
		try {
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setLong(1, c.getCategoryID());
			ps.setString(2, c.getCategoryName());
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	// update category
	public boolean updateCategory(long categoryID,String categoryName){
		Connection conn= JDBConnect.getConnection();
		String sql = "update category set category_name=? where category_id = ?";
		try {
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, categoryName );
			ps.setLong(2, categoryID);
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	//delte category
	public boolean deleteCategory(long category_id ){
		Connection conn= JDBConnect.getConnection();
		String sql ="Delete from  category where category_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1,category_id );
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public static void main(String[] args) throws SQLException {
		categoryDAO dao =new categoryDAO();
//		for(int i=5;i<7;i++){
//			dao.insertCategory(new Category(i,"Category "+i));
//		}
		System.out.println(dao.updateCategory(6,"Sony"));
		System.out.println(dao.deleteCategory(5));
	}
}
