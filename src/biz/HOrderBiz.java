package biz;

import java.util.List;

import dao.HOrderDao;
import entity.Orders1;

/**
 * 
 * 
 * @author HuMin
 *
 */
public class HOrderBiz {

	public List<Orders1> getOrders() {
		return new HOrderDao().getOrders();
	}
}
