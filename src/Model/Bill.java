package Model;

import java.sql.Timestamp;

public class Bill {
	private long billID;
	private long userID;
	private double total;
	private String payment;
	private Timestamp date;
	private String address;
	public Bill(){
		
	}
	public Bill(long billID, long userID, double total, String payment, String address, Timestamp date) {
		super();
		this.billID = billID;
		this.userID = userID;
		this.total = total;
		this.payment = payment;
		this.address = address;
		this.date = date;
		
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	public long getBillID() {
		return billID;
	}
	public void setBillID(long billID) {
		this.billID = billID;
	}
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
}
