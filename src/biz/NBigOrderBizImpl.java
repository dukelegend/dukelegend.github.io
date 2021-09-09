package biz;

import java.util.List;

import dao.NBigOrderImpl;
import entity.BigOrder;

public class NBigOrderBizImpl implements NBigOrderBiz {

	@Override
	public int getCount_type(String keyword) {
		// TODO Auto-generated method stub
		return new NBigOrderImpl().getCount_type(keyword);
	}

	@Override
	public List<BigOrder> getNewsByPage_type(int pageNum, int pageSize, String condition) {
		// TODO Auto-generated method stub
		return new NBigOrderImpl().getNewsByPage_type(pageNum, pageSize, condition);
	}

	@Override
	public void exceuteUpdate(String sql) {
		// TODO Auto-generated method stub
		 new NBigOrderImpl().exceuteUpdate(sql);
	}

	@Override
	public List<BigOrder> getall(String condition) {
		// TODO Auto-generated method stub
		return new NBigOrderImpl().getall(condition);
	}

	@Override
	public BigOrder get(String condition) {
		// TODO Auto-generated method stub
		return new NBigOrderImpl().get(condition);
	}

}
