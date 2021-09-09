package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import biz.NBook_SalesBookBiz;
import biz.NBook_SalesBookBizImpl;
import dbConnect.BaseDao;
import entity.ShoppingCart;
import new_entity.NBook_SalesBook;
import new_entity.NShoppingCart_Book;

public class NShoppingCartDaoImpl extends BaseDao implements NShoppingCartDao {

	@Override
	public int getCount_type(String condition) {
		
		int count=0;
		String sql="select count(*) from shoppingcart where CID='"+condition+"';";
		
		ResultSet rs=exceuteQuery(sql);
		
		try {
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		
		return count;
	}

	@Override
	public List<NShoppingCart_Book> getNewsByPage_type(int pageNum, int pageSize, String condition) {
		int count=0;
		String sql1="select count(*) from shoppingcart where CID='"+condition+"';";	
		ResultSet rs1=exceuteQuery(sql1);
		try {
			if(rs1.next()){
				count=rs1.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		
		List<NShoppingCart_Book> lstShoppingCart=new ArrayList<NShoppingCart_Book>();
		if(count!=0) {
			String sql="select  * from shoppingcart where CID='"+condition+"' LIMIT ?,?";
			int beginIndex=(pageNum-1)*pageSize;
			Object params[]={beginIndex,pageSize};
			ResultSet rs=exceuteQuery(sql, params);
			NBook_SalesBookBiz nBookBiz=new NBook_SalesBookBizImpl();
			List<NBook_SalesBook> allBookByMHsearch = nBookBiz.getAll();
			try {
				while(rs.next()){
					NShoppingCart_Book nShoppingCart_Book = new NShoppingCart_Book();
					String ISBN=rs.getString("ISBN");
					for(int i=0;i<allBookByMHsearch.size();i++) {
						if(ISBN.equals(allBookByMHsearch.get(i).getISBN())) {
							nShoppingCart_Book.setId(rs.getString("ID"));
							nShoppingCart_Book.setCid(rs.getString("CID"));
							nShoppingCart_Book.setnBook_SalesBook(allBookByMHsearch.get(i));
							nShoppingCart_Book.setNum(rs.getInt("NUM"));
							nShoppingCart_Book.setTotolprice(rs.getInt("NUM")*allBookByMHsearch.get(i).getNowprice());
						}
					}
					lstShoppingCart.add(nShoppingCart_Book);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				closeAll();
			}
		}
		return lstShoppingCart;
	}

	@Override
	public List<ShoppingCart> getShoppingCart() {
		String sql = "select * from shoppingcart";
		ResultSet rs=exceuteQuery(sql);
		List<ShoppingCart> lstShoppingCart=new ArrayList<ShoppingCart>();
		try {
			while(rs.next()){
				ShoppingCart shoppingCart = new ShoppingCart();
				shoppingCart.setId(rs.getString("ID"));
				shoppingCart.setCid(rs.getString("CID"));
				shoppingCart.setISBN(rs.getString("ISBN"));
				shoppingCart.setNum(rs.getInt("NUM"));
				lstShoppingCart.add(shoppingCart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		
		return lstShoppingCart;
	}

	@Override
	public List<NShoppingCart_Book> getall(String condition) {
		
		List<NShoppingCart_Book> lstShoppingCart=new ArrayList<NShoppingCart_Book>();
		String sql="select  * from shoppingcart where CID='"+condition+"';";
		ResultSet rs=exceuteQuery(sql);
		NBook_SalesBookBiz nBookBiz=new NBook_SalesBookBizImpl();
		List<NBook_SalesBook> allBookByMHsearch = nBookBiz.getAll();
			try {
				while(rs.next()){
					NShoppingCart_Book nShoppingCart_Book = new NShoppingCart_Book();
					String ISBN=rs.getString("ISBN");
					for(int i=0;i<allBookByMHsearch.size();i++) {
						if(ISBN.equals(allBookByMHsearch.get(i).getISBN())) {
							nShoppingCart_Book.setId(rs.getString("ID"));
							nShoppingCart_Book.setCid(rs.getString("CID"));
							nShoppingCart_Book.setnBook_SalesBook(allBookByMHsearch.get(i));
							nShoppingCart_Book.setNum(rs.getInt("NUM"));
							nShoppingCart_Book.setTotolprice(rs.getInt("NUM")*allBookByMHsearch.get(i).getNowprice());
						}
					}
					lstShoppingCart.add(nShoppingCart_Book);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				closeAll();
			}
		return lstShoppingCart;
	}

}
