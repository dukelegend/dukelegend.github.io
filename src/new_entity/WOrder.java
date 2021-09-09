package new_entity;

import java.util.List;

import entity.BigOrder;
import entity.Orders;
import entity.Rinformation;

public class WOrder {

	private List<Orders> order;
	private BigOrder bigorder;
	private float total;
	private Rinformation rinfo;
	public Rinformation getRinfo() {
		return rinfo;
	}
	public void setRinfo(Rinformation rinfo) {
		this.rinfo = rinfo;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal() {
		float i=0;
		for(Orders o:order) {
			i+=o.getPrice();
		}
		total=i;
	}
	public List<Orders> getOrder() {
		return order;
	}
	public void setOrder(List<Orders> order) {
		this.order = order;
	}
	public BigOrder getBigorder() {
		return bigorder;
	}
	public void setBigorder(BigOrder bigorder) {
		this.bigorder = bigorder;
	}
	
	
}
