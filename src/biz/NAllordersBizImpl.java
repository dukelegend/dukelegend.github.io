package biz;

import java.util.List;

import dao.NAllordersDaoImpl;
import new_entity.NAllorders;

public class NAllordersBizImpl implements NAllordersBiz {

	@Override
	public int getCount_type(String keyword) {
		// TODO Auto-generated method stub
		return new NAllordersDaoImpl().getCount_type(keyword);
	}

	@Override
	public List<NAllorders> getNewsByPage_type(int pageNum, int pageSize, String condition) {
		// TODO Auto-generated method stub
		return new NAllordersDaoImpl().getNewsByPage_type(pageNum, pageSize, condition);
	}

	@Override
	public void exceuteUpdate(String sql) {
		// TODO Auto-generated method stub
		new NAllordersDaoImpl().exceuteUpdate(sql);
	}

}
