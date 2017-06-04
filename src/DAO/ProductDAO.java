package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.JDBConnect;
import Model.Category;
import Model.Product;
public class ProductDAO {
	//get danh sách sản phẩm dựa vào mã danh mục
	public ArrayList<Product> getListProductbyCategory(long category_id) throws SQLException{
		Connection conn = JDBConnect.getConnection();
		String sql= "Select * From product where category_id = '"+category_id +"'";
		PreparedStatement ps= conn.prepareCall(sql);
		ResultSet rs= ps.executeQuery();
		ArrayList<Product> list =new ArrayList();
		while(rs.next()){
			Product product = new Product();
			product.setProductID(rs.getLong("id_product"));
			product.setProductName(rs.getString("product_name"));
			product.setProductImage(rs.getString("product_image"));
			product.setProductPrice(rs.getDouble("product_price"));
			product.setProductDescription(rs.getString("product_description"));
			product.setProductGender(rs.getLong("product_gender"));
			list.add(product);
		}
		return list;
	
	}
	public Product getProduct(long productID) throws SQLException {
        Connection connection = JDBConnect.getConnection();
        String sql = "SELECT * FROM product WHERE id_product = '" + productID + "'";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        Product product = new Product();
        while (rs.next()) {
            product.setProductID(rs.getLong("id_product"));
            product.setProductName(rs.getString("product_name"));
            product.setProductImage(rs.getString("product_image"));
            product.setProductPrice(rs.getDouble("product_price"));
            product.setProductDescription(rs.getString("product_description"));
            product.setProductGender(rs.getLong("product_gender"));
        }
        return product;
    }
	
	public ArrayList<Product> getListProductbyPage(long categoryID,int firstResult,int maxResult) throws SQLException{
		Connection connection = JDBConnect.getConnection();
		String sql = "SELECT * FROM product WHERE category_id = '" + categoryID + "' limit ?,?";
		PreparedStatement ps = connection.prepareCall(sql);
		ps.setInt(1, firstResult);
		ps.setInt(2, maxResult);
		ResultSet rs = ps.executeQuery();
		ArrayList<Product> list = new ArrayList();
		while (rs.next()) {
		Product product = new Product();
		product.setProductID(rs.getLong("id_product"));
		product.setProductName(rs.getString("product_name"));
		product.setProductImage(rs.getString("product_image"));
		product.setProductPrice(rs.getDouble("product_price"));
		product.setProductDescription(rs.getString("product_description"));
		product.setProductGender(rs.getLong("product_gender"));
		list.add(product);
		}
		return list;
	}
	// tính tổng sản phẩm
	public int countProductbyCategory(long categoryID) throws SQLException{
		Connection connection = JDBConnect.getConnection();
		String sql = "SELECT count(id_product) FROM product WHERE category_id = '" + categoryID + "'";
		PreparedStatement ps = connection.prepareCall(sql);
		ResultSet rs = ps.executeQuery();
		int count =0;
		while (rs.next()) {
		count = rs.getInt(1);
		}
		return count;
	}
	
	// insert Product
		public boolean insertProduct(Product c){
			Connection conn= JDBConnect.getConnection();
			String sql = "insert into product values(?,?,?,?,?,?,?)";
			try {
				PreparedStatement ps= conn.prepareStatement(sql);
				ps.setLong(1, c.getProductID());
				ps.setString(2, c.getProductName());
				ps.setString(3, c.getProductImage());
				ps.setLong(4, c.getCategoryID());
				ps.setDouble(5, c.getProductPrice());
				ps.setString(6, c.getProductDescription());
				ps.setLong(7, c.getProductGender());
				return ps.executeUpdate() == 1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
			
		}
		// update category
		public boolean updateProduct(Product p){
			Connection conn= JDBConnect.getConnection();
			String sql = "update product set product_name=?,product_image=?,product_price=?,product_description=?,category_id=? where id_product = ?";
			try {
				PreparedStatement ps= conn.prepareStatement(sql);
				ps.setString(1, p.getProductName() );
				ps.setString(2, p.getProductImage());
				ps.setDouble(3, p.getProductPrice());
				ps.setString(4, p.getProductDescription());
				ps.setLong(5, p.getCategoryID());
				ps.setLong(6, p.getProductID());
				return ps.executeUpdate() == 1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
			
		}
		//delte category
		public boolean deleteProduct(long id_product ){
			Connection conn= JDBConnect.getConnection();
			String sql ="Delete from  product where id_product = ?";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setLong(1,id_product );
				return ps.executeUpdate()==1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
	public static void main(String[] args) throws SQLException {
		ProductDAO dao= new ProductDAO();
//		for(Product p: dao.getListProductbyCategory(1)){
//			System.out.println(p.getProductID()+ " - " + p.getProductName());
//		}
		System.out.println(dao.updateProduct(new Product(7, 5, "Mipad 2", "", 200, "",1)));
	}
}
