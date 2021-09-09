package biz;

import java.util.List;

import entity.SalesBook;

public interface NSalesBookBiz {
	List<SalesBook> getSalesBook();
	
	int getCount();

	List<SalesBook> getNewsByPage(int pageNum,int pageSize);
	
	int getCount_con(int condition) ;
	
	List<SalesBook> getNewsByPage_con(int pageNum, int pageSize,int condition);
	
	int getCount_type(String condition) ;
	
	List<SalesBook> getNewsByPage_type(int pageNum, int pageSize,String condition);
}
