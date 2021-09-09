package entity;
/*
 * ����
 */
public class Orders1 {

	private String oid;//�������
	private String BOid;//�󶩵�id
	private String ISBN;
	private String state;//״̬
	private float price;
	private String createTime;//����ʱ��
	private String zdTime;//�Զ��ջ�ʱ��
	private String remarks;//����
	private int num;
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getBOid() {
		return BOid;
	}
	public void setBOid(String bOid) {
		BOid = bOid;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getZdTime() {
		return zdTime;
	}
	public void setZdTime(String zdTime) {
		this.zdTime = zdTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
