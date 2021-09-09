package new_entity;

public class NBook_SalesBook {
	private String ISBN;
	private String name;
	private String author;
	private String press;
	private float price;
	private String image;
	private String bookSize;
	private String publishTime;
	private float nowprice;
	private int rnum;//剩余量
	private int snum;//售卖量
	private int isDBooks;//是否是做活动的书
	private String description;
	private String typeid;
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getBookSize() {
		return bookSize;
	}
	public void setBookSize(String bookSize) {
		this.bookSize = bookSize;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public float getNowprice() {
		return nowprice;
	}
	public void setNowprice(float nowprice) {
		this.nowprice = nowprice;
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
	
}
