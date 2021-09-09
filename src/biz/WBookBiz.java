package biz;


import java.util.List;

import dao.WBookDao;
import entity.Book;

public class WBookBiz {

	public List<Book> getBook(){
		return new WBookDao().getBook();
	}
	
	public List<Book> query(String name){
		List<Book> list=null;
		if(name.matches("[0-9]+")) {
			list=new WBookDao().queryId(name);
		}else{
			list=new WBookDao().queryName(name);
		}
		return list;
	}
	
	public int add(String isbn,String name,String author,String press,float price,String image,String booksize,String publishtime) {
		int i=new WBookDao().add(isbn, name, author, press, price, image, booksize, publishtime, false);
		return i;
	}
	
	public int upBook(String id,boolean bo) {
		return new WBookDao().upBook(id, bo);
	}
}
