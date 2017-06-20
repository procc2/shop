package Model;

public class Category {
	private long categoryID;
	private String categoryName;
	private long productGender;
	public Category(){
		
	}
	public Category(long categoryID, String categoryName,long productGender) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.productGender = productGender;
	}	
	public long getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public long getProductGender() {
		return productGender;
	}
	public void setProductGender(long productGender) {
		this.productGender = productGender;
	}
}
