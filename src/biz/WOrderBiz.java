package biz;

import java.util.ArrayList;
import java.util.List;

import dao.WBigOrderDao;
import dao.WOrderDao;
import entity.BigOrder;
import entity.Orders;
import new_entity.WOrder;

public class WOrderBiz {

	public List<WOrder> getOrder(String state){
		List<WOrder> list = new ArrayList<>();
		List<BigOrder> bolist=new WBigOrderDao().getBigOrder();
		for(BigOrder bo:bolist) {
			if(bo.getState().equals(state)) {
				WOrder wo=new WOrder();
				
				wo.setBigorder(bo);
				wo.setOrder(new WOrderDao().getOrder(bo.getBOid()));
				wo.setTotal();
				list.add(wo);
			}
		}
		return list;
	}
	
	public int send(String boid,String expressid,String delaytime,String name) {
		return new WBigOrderDao().send(boid, expressid, delaytime,name);
	}
	
	public int change(String state,String boid) {
		new WBigOrderDao().change(state, boid);
		return new WOrderDao().change(state, boid);
	}
	
	public List<Orders> getorders(){
		return new WOrderDao().getOrders();
	}
	
	public List<WOrder> getRorder(List<Orders> orlist){//获取退货的大订单、小定单
		Orders o=new Orders();
		o.setBOid("0");
		
		List<WOrder> list = new ArrayList<>();
		
		List<BigOrder> blist=new ArrayList<>();
		List<BigOrder> bolist=new WBigOrderDao().getBigOrder();
		
		for(Orders or:orlist) {
			for(BigOrder bo:bolist) {
				if(bo.getBOid().equals(or.getBOid())&&(!or.getBOid().equals(o.getBOid()))) {
					blist.add(bo);
					o.setBOid(or.getBOid());
				}	
			}
			
		}
		
		for(BigOrder bo:blist) {
			WOrder wo=new WOrder();
			List<Orders> olist = new ArrayList<>();
			for(Orders or:orlist) {
				if(bo.getBOid().equals(or.getBOid())) {
					
					olist.add(or);
				}	
			}
			wo.setBigorder(bo);
			wo.setOrder(olist);
			wo.setTotal();
			list.add(wo);
			
		}
		
		
		return list;
		
	}
	
}
