package dao;

import java.util.List;

import entity.SalesBook;

public interface NSalesBookDao {
	List<SalesBook> getSalesBook();
	
	int getCount();
	
	int getCount_con(int condition) ;
	
	int getCount_type(String condition) ;
	
	List<SalesBook> getNewsByPage(int pageNum,int pageSize);
	
	List<SalesBook> getNewsByPage_con(int pageNum, int pageSize,int condition);
	
	List<SalesBook> getNewsByPage_type(int pageNum, int pageSize,String condition);
}
