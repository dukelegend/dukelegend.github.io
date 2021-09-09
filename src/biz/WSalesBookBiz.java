package biz;

import java.util.ArrayList;
import java.util.List;

import dao.WBookDao;
import dao.WBookTypeDao;
import dao.WSalesBookDao;
import entity.Book;
import entity.BookType;
import entity.SalesBook;
import new_entity.WSalesBook;

public class WSalesBookBiz {

	public List<WSalesBook> getSalesBook(){
		List<WSalesBook> list=new ArrayList<>();
		List<SalesBook> slist= new WSalesBookDao().getSaleBook();
		List<Book> blist=new WBookDao().getBook();
		List<BookType> tylist=new WBookTypeDao().getBookType();
		for(SalesBook s:slist) {
			for(Book bo:blist) {
				if(s.getISBN().equals(bo.getISBN())) {
					WSalesBook book=new WSalesBook();
					
					book.setBook(bo);
					book.setSbook(s);
					
					list.add(book);
				}
			}
		}
		
		for(WSalesBook s:list) {
			for(BookType type:tylist) {
				if(s.getSbook().getTypeid().equals(type.getTypeid())) {
					s.setType(type);
				}
			}
		}
		
		
		
		return sole(list);
		
	}
	
	public int add(String isbn,float sprice,int rnum,int snum,boolean isdbooks,String description,String sjdate,String typeid) {
		return new WSalesBookDao().add(isbn, sprice, rnum, snum, isdbooks, description, sjdate, typeid);
	}
	
	public int delete(String id) {
		return new WSalesBookDao().delete(id);
		
	}
	
	public List<WSalesBook> query(String name){
		List<WSalesBook> list=getSalesBook();
		List<WSalesBook> rlist=new ArrayList<>();
		if(name.matches("[0-9]{13}")) {
			for(WSalesBook s:list) {
				if(name.equals(s.getBook().getISBN())) {
					rlist.add(s);
				}
			}
			
		}else {
			for(WSalesBook s:list) {
				if(name.equals(s.getBook().getName())) {
					rlist.add(s);
				}
			}
		} 
			
		return rlist;
		
	}
	
	public int update(String isbn,float price,int num) {
		return new WSalesBookDao().update(isbn, price, num);
	}
	
	public int jian(String id,int num) {
		return new WSalesBookDao().jian(id, num);
		
	}
	
	private List<WSalesBook> sole(List<WSalesBook> list) {
		List<WSalesBook> list1=new ArrayList<>();
		List<WSalesBook> list2=new ArrayList<>();
		for(WSalesBook s:list) {
			if(s.getSbook().getRnum()<=40) {
				list1.add(s);
			}else {
				list2.add(s);
			}
		}
		list1.addAll(list2);
		return list1;
	}
}
