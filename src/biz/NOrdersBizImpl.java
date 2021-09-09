package biz;

import java.util.List;

import dao.NOrdersImpl;
import entity.Orders;

public class NOrdersBizImpl implements NOrdersBiz {

	@Override
	public int getCount_type(String keyword) {
		// TODO Auto-generated method stub
		return new NOrdersImpl().getCount_type(keyword);
	}

	@Override
	public List<Orders> getNewsByPage_type(int pageNum, int pageSize, String condition) {
		// TODO Auto-generated method stub
		return new NOrdersImpl().getNewsByPage_type(pageNum, pageSize, condition);
	}

	@Override
	public List<Orders> getall(String condition) {
		// TODO Auto-generated method stub
		return new NOrdersImpl().getall(condition);
	}

	@Override
	public void exceuteUpdate(String sql) {
		// TODO Auto-generated method stub
		new NOrdersImpl().exceuteUpdate(sql);
	}

}
