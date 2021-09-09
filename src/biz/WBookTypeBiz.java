package biz;

import java.util.List;

import dao.WBookTypeDao;
import entity.BookType;

public class WBookTypeBiz {

	public List<BookType> getBookType(){
		return new WBookTypeDao().getBookType();
	}
	
	public int deleteBookType(String id) {
		return new WBookTypeDao().delete(id);
	}
	
	public int addBookType(String id,String name,String des) {
		List<BookType> list=new WBookTypeDao().getBookType();
		
		if((id.length()==0)||(name.length()==0)||(des.length()==0)) {
			return -2;
		}
		if((id.matches("[A-Z]+1"))) {
			
		}
		for(BookType bt:list) {//判断是否重复加入
			if(id.equals(bt.getTypeid())||name.equals(bt.getName())) {
				return -1;
			}
		}
		return new WBookTypeDao().add(id, name, des);
	}
}
