package new_entity;

public class NShoppingCart_Book {


	private String id;//���ﳵ���
	private String Cid;
	private NBook_SalesBook nBook_SalesBook;
	private int num;//����
	private float totolprice;//�۸�
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
	
	public NBook_SalesBook getnBook_SalesBook() {
		return nBook_SalesBook;
	}
	public void setnBook_SalesBook(NBook_SalesBook nBook_SalesBook) {
		this.nBook_SalesBook = nBook_SalesBook;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public float getTotolprice() {
		return totolprice;
	}
	public void setTotolprice(float totolprice) {
		this.totolprice = totolprice;
	}
	

}
