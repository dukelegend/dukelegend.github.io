package dao;

import java.util.List;

import entity.BigOrder;
public interface NBigOrder {
	int getCount_type(String keyword) ;
	
	 List<BigOrder> getNewsByPage_type(int pageNum, int pageSize,String condition);
	 
	 List<BigOrder> getall(String condition);
	 
	 BigOrder get(String condition);
}
