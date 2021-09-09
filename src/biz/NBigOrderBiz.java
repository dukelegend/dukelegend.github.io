package biz;

import java.util.List;

import entity.BigOrder;

public interface NBigOrderBiz {
	int getCount_type(String keyword) ;
	
	 List<BigOrder> getNewsByPage_type(int pageNum, int pageSize,String condition);
	 
	 List<BigOrder> getall(String condition);
	 
	 void exceuteUpdate(String sql);
	 
	 BigOrder get(String condition);
}
