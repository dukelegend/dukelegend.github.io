package dao;

import java.util.List;

import new_entity.NBook_SalesBook;

public interface NBook_SalesBookDao {
	   List<NBook_SalesBook> getAll();
	   
	   int getCount_type(String keyword) ;
		
	   List<NBook_SalesBook> getNewsByPage_type(int pageNum, int pageSize,String condition);
}
