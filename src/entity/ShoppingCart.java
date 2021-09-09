package entity;
/*
 * 购物车
 */
public class ShoppingCart {

	private String id;//购物车编号
	private String Cid;
	private String ISBN;
	private int num;//数量
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCid() {
		return Cid;
	}
	public void setCid(String cid) {
		Cid = cid;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
