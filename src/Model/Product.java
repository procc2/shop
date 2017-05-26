package Model;

public class Product {
	private long productID;
	private long categoryID;
	private String productName;
	private String productImage;
	public long getProductID() {
		return productID;
	}
	public void setProductID(long productID) {
		this.productID = productID;
	}
	public long getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductImage() {
		return productImage;
	}
	public Product(){
		
	}
	public Product(long productID, long categoryID, String productName, String productImage, double productPrice,
			String productDescription) {
		super();
		this.productID = productID;
		this.categoryID = categoryID;
		this.productName = productName;
		this.productImage = productImage;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	private double productPrice;
	private String productDescription;
}
