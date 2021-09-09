package biz;

import java.util.List;

import dao.NSalesBookDaoImpl;
import entity.SalesBook;

public class NSalesBookBizImpl implements NSalesBookBiz {

	@Override
	public List<SalesBook> getSalesBook() {
		// TODO Auto-generated method stub
		return new NSalesBookDaoImpl().getSalesBook();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return new NSalesBookDaoImpl().getCount();
	}

	@Override
	public List<SalesBook> getNewsByPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return new NSalesBookDaoImpl().getNewsByPage(pageNum, pageSize);
	}

	@Override
	public int getCount_con(int condition) {
		// TODO Auto-generated method stub
		return new NSalesBookDaoImpl().getCount_con(condition);
	}

	@Override
	public List<SalesBook> getNewsByPage_con(int pageNum, int pageSize, int condition) {
		// TODO Auto-generated method stub
		return new NSalesBookDaoImpl().getNewsByPage_con(pageNum, pageSize, condition);
	}

	@Override
	public int getCount_type(String condition) {
		// TODO Auto-generated method stub
		return new NSalesBookDaoImpl().getCount_type(condition);
	}

	@Override
	public List<SalesBook> getNewsByPage_type(int pageNum, int pageSize, String condition) {
		// TODO Auto-generated method stub
		return new NSalesBookDaoImpl().getNewsByPage_type(pageNum, pageSize, condition);
	}

}
