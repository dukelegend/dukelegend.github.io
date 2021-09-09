package dao;

import java.util.List;

import entity.ShoppingCart;
import new_entity.NShoppingCart_Book;

public interface NShoppingCartDao {
	List<ShoppingCart> getShoppingCart();
	
	int getCount_type(String condition) ;
	
	List<NShoppingCart_Book> getNewsByPage_type(int pageNum, int pageSize,String condition);
	
	List<NShoppingCart_Book> getall(String condition);
}
