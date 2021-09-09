package dao;

import java.util.List;

import entity.Orders;

public interface NOrders {
	int getCount_type(String keyword) ;
	
	 List<Orders> getNewsByPage_type(int pageNum, int pageSize,String condition);
	 
	 List<Orders> getall(String condition);
	 
}
