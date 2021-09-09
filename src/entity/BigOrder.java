package entity;
/*
 * 大订单
 */
public class BigOrder {

	private String BOid;//大订单编号编号
	private String Rid;//收货信息id
	private String state;//状态
	private String expressid;//发货信息id
	private String delayTime;
	private String Cid;
	
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
}
