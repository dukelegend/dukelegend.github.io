package entity;
/*
 * 在售图书
 */
public class SalesBook {
	private String ISBN;
	private float price;
	private int rnum;//剩余量
	private int snum;//售卖量
	private int isDBooks;//是否是做活动的书
	private String description;
	private String typeid;
	private String sjdate;
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	public int getIsDBooks() {
		return isDBooks;
	}
	public void setIsDBooks(int isDBooks) {
		this.isDBooks = isDBooks;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	public String getSjdate() {
		return sjdate;
	}
	public void setSjdate(String sjdate) {
		this.sjdate = sjdate;
	}
	
	
}
