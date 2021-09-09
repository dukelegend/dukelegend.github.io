package entity;
/*
 * 图书评价信息
 */
public class Evaluates {
	private long id;
	private String ISBN;
	private String Cid;//客户id
	private String time;//评论时间
	private String context;//评价内容
	private int level;//评分等级
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getCid() {
		return Cid;
	}
	public void setCid(String cid) {
		Cid = cid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
}
