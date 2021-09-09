package biz;

import java.util.List;

import new_entity.NAllorders;

public interface NAllordersBiz {
	  int getCount_type(String keyword) ;
		
	   List<NAllorders> getNewsByPage_type(int pageNum, int pageSize,String condition);
	   
	   void exceuteUpdate(String sql);
}
