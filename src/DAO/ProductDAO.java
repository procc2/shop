package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.JDBConnect;
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
	public static void main(String[] args) throws SQLException {
		ProductDAO dao= new ProductDAO();
		for(Product p: dao.getListProductbyCategory(1)){
			System.out.println(p.getProductID()+ " - " + p.getProductName());
		}
		System.out.println(dao.countProductbyCategory(1));
	}
}
