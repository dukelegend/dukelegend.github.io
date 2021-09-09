package new_entity;

import java.util.List;

import entity.Orders;

public class NAllorders {
	private String BOid;//大订单编号编号
	private String Rid;//收货信息id
	private String state;//状态
	private String expressid;//发货信息id
	private String delayTime;
	private String Cid;
	private List<Orders> orders;
	private float totolprice;
	private String address;
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getTotolprice() {
		return totolprice;
	}
	public void setTotolprice(float totolprice) {
		this.totolprice = totolprice;
	}
	public String getBOid() {
		return BOid;
	}
	public void setBOid(String bOid) {
		BOid = bOid;
	}
	public String getRid() {
		return Rid;
	}
	public void setRid(String rid) {
		Rid = rid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getExpressid() {
		return expressid;
	}
	public void setExpressid(String expressid) {
		this.expressid = expressid;
	}
	public String getDelayTime() {
		return delayTime;
	}
	public void setDelayTime(String delayTime) {
		this.delayTime = delayTime;
	}
	public String getCid() {
		return Cid;
	}
	public void setCid(String cid) {
		Cid = cid;
	}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	
	

}
