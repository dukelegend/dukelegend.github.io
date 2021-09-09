package biz;

import java.util.List;

import dao.NBookDAOImpl;
import entity.Book;

public class NBookBizImpl implements NBookBiz {
	@Override
	public List<Book> getBook() {
		// TODO Auto-generated method stub
		return new NBookDAOImpl().getBook();
	}


	
}
