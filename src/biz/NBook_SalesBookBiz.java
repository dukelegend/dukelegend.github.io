package biz;

import java.util.List;

import new_entity.NBook_SalesBook;

public interface NBook_SalesBookBiz {
	 List<NBook_SalesBook> getAll();
	 
	   int getCount_type(String condition) ;
		
	    List<NBook_SalesBook> getNewsByPage_type(int pageNum, int pageSize,String condition);
}
