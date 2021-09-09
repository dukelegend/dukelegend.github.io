package biz;

import java.util.List;

import dao.NBook_SalesBookImpl;
import new_entity.NBook_SalesBook;

public class NBook_SalesBookBizImpl implements NBook_SalesBookBiz {

	@Override
	public int getCount_type(String condition) {
		// TODO Auto-generated method stub
		return new NBook_SalesBookImpl().getCount_type(condition);
	}

	@Override
	public List<NBook_SalesBook> getNewsByPage_type(int pageNum, int pageSize, String condition) {
		// TODO Auto-generated method stub
		return new NBook_SalesBookImpl().getNewsByPage_type(pageNum, pageSize, condition);
	}

	@Override
	public List<NBook_SalesBook> getAll() {
		// TODO Auto-generated method stub
		return new NBook_SalesBookImpl().getAll();
	}
	


}
