package biz;

import java.util.List;

import entity.Evaluates;

public interface NEvaluatesBiz {
	int getCount_type(String keyword) ;
	
	 List<Evaluates> getNewsByPage_type(int pageNum, int pageSize,String condition);
	 
	 List<Evaluates> getall(String condition);
	 
	 void  exceuteUpdate(String sql);
}
