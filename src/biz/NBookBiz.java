package biz;

import java.util.List;

import entity.Book;

public interface NBookBiz {
	/**
	 * 获取所有书籍信息
	 * @return
	 */
	 List<Book> getBook();
	
}
