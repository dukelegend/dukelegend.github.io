package biz;

import java.util.List;

import dao.NEvaluatesDaoImpl;
import entity.Evaluates;

public class NEvaluatesBizImpl implements NEvaluatesBiz {

	@Override
	public int getCount_type(String keyword) {
		// TODO Auto-generated method stub
		return new NEvaluatesDaoImpl().getCount_type(keyword);
	}

	@Override
	public List<Evaluates> getNewsByPage_type(int pageNum, int pageSize, String condition) {
		// TODO Auto-generated method stub
		return new NEvaluatesDaoImpl().getNewsByPage_type(pageNum, pageSize, condition);
	}

	@Override
	public List<Evaluates> getall(String condition) {
		// TODO Auto-generated method stub
		return new NEvaluatesDaoImpl().getall(condition);
	}

	@Override
	public void exceuteUpdate(String sql) {
		// TODO Auto-generated method stub
		
		new NEvaluatesDaoImpl().exceuteUpdate1(sql);
	}

}
