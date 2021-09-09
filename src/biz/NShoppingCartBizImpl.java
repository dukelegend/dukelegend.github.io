package biz;

import java.util.List;

import dao.NShoppingCartDaoImpl;
import entity.ShoppingCart;
import new_entity.NShoppingCart_Book;

public class NShoppingCartBizImpl implements NShoppingCartBiz {

	@Override
	public int getCount_type(String condition) {
		// TODO Auto-generated method stub
		return new NShoppingCartDaoImpl().getCount_type(condition);
	}

	@Override
	public List<NShoppingCart_Book> getNewsByPage_type(int pageNum, int pageSize, String condition) {
		// TODO Auto-generated method stub
		return new NShoppingCartDaoImpl().getNewsByPage_type(pageNum, pageSize, condition);
	}

	@Override
	public void exceuteUpdate(String sql) {
		// TODO Auto-generated method stub
		 new NShoppingCartDaoImpl().exceuteUpdate(sql);
	}

	@Override
	public List<ShoppingCart> getShoppingCart() {
		// TODO Auto-generated method stub
		return new NShoppingCartDaoImpl().getShoppingCart();
	}

	@Override
	public List<NShoppingCart_Book> getall(String condition) {
		// TODO Auto-generated method stub
		return new NShoppingCartDaoImpl().getall(condition);
	}

}
