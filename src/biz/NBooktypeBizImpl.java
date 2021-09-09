package biz;

import java.util.List;

import dao.NBooktypeDaoImpl;
import entity.BookType;

public class NBooktypeBizImpl implements NBooktypeBiz {

	@Override
	public List<BookType> getBookTypes() {
		return new NBooktypeDaoImpl().getBooktTypes();
	}

}
