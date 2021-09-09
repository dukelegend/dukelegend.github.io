package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConnect.BaseDao;
import new_entity.NBook_SalesBook;

public class NBook_SalesBookImpl extends BaseDao implements NBook_SalesBookDao {
/*	@Override
	public List<NBook_SalesBook> getBookbyMHsearch(String keyword) {

		String sql = "SELECT * FROM book,salesbook WHERE book.ISBN = salesbook.ISBN and name LIKE '%"+keyword+"%' ORDER BY (CASE WHEN name='"+keyword+"' THEN 1 " + 
				"WHEN name like '"+keyword+"%' THEN 2 " + 
				"WHEN name like '%"+keyword+"%' THEN 3 " + 
				"WHEN name like '%"+keyword+"' THEN 4 " + 
				"ELSE 5 " + 
				"END)";
		System.out.println(sql);
		ResultSet rs=exceuteQuery(sql);
		List<NBook_SalesBook> lstBooks=new ArrayList<NBook_SalesBook>();
		try {
			while(rs.next()){
				NBook_SalesBook book=new NBook_SalesBook();
				book.setISBN(rs.getString(1));
				book.setName(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPress(rs.getString(4));
				book.setPrice(rs.getFloat(5));
				book.setImage(rs.getString(6));
				book.setBookSize(rs.getString(7));
				book.setPublishTime(rs.getString(8));
				book.setPrice(rs.getFloat(9));
				book.setRnum(rs.getInt(10));
				book.setSnum(rs.getInt(11));
				book.setIsDBooks(rs.getInt(12));
				book.setDescription(rs.getString(13));
				lstBooks.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		
		return lstBooks;
	
	}*/

	@Override
	public int getCount_type(String keyword) {
		
		int count=0;
		String sql = "SELECT count(*) FROM book,salesbook WHERE book.ISBN = salesbook.ISBN and name LIKE '%"+keyword+"%' ORDER BY (CASE WHEN name='"+keyword+"' THEN 1 " + 
				"WHEN name like '"+keyword+"%' THEN 2 " + 
				"WHEN name like '%"+keyword+"%' THEN 3 " + 
				"WHEN name like '%"+keyword+"' THEN 4 " + 
				"ELSE 5 " + 
				"END)";
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
	public List<NBook_SalesBook> getNewsByPage_type(int pageNum, int pageSize, String keyword) {
		int count=0;
		String sql1 = "SELECT count(*) FROM book,salesbook WHERE book.ISBN = salesbook.ISBN and name LIKE '%"+keyword+"%' ORDER BY (CASE WHEN name='"+keyword+"' THEN 1 " + 
				"WHEN name like '"+keyword+"%' THEN 2 " + 
				"WHEN name like '%"+keyword+"%' THEN 3 " + 
				"WHEN name like '%"+keyword+"' THEN 4 " + 
				"ELSE 5 " + 
				"END)";
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
		List<NBook_SalesBook> lstBooks=new ArrayList<NBook_SalesBook>();
		if(count!=0) {
			String sql="SELECT * FROM book,salesbook WHERE book.ISBN = salesbook.ISBN and name LIKE '%"+keyword+"%' ORDER BY (CASE WHEN name='"+keyword+"' THEN 1 " + 
					"WHEN name like '"+keyword+"%' THEN 2 " + 
					"WHEN name like '%"+keyword+"%' THEN 3 " + 
					"WHEN name like '%"+keyword+"' THEN 4 " + 
					"ELSE 5 " + 
					"END)"+" LIMIT ?,?";
			int beginIndex=(pageNum-1)*pageSize;
			Object params[]={beginIndex,pageSize};
			ResultSet rs=exceuteQuery(sql, params);
			try {
				while(rs.next()){
					NBook_SalesBook book=new NBook_SalesBook();
					book.setISBN(rs.getString("ISBN"));
					book.setName(rs.getString("NAME"));
					book.setAuthor(rs.getString("AUTHOR"));
					book.setPress(rs.getString("PRESS"));
					book.setPrice(rs.getFloat("PRICE"));
					book.setImage(rs.getString("IMAGE"));
					book.setBookSize(rs.getString("BOOKSIZE"));
					book.setPublishTime(rs.getString("PUBLISHTIME"));
					book.setNowprice(rs.getFloat("SPRICE"));
					book.setRnum(rs.getInt("RNUM"));
					book.setSnum(rs.getInt("SNUM"));
					book.setIsDBooks(rs.getInt("ISDBOOKS"));
					book.setDescription(rs.getString("DESCRIPTION"));
					book.setTypeid(rs.getString("TYPEID"));
					lstBooks.add(book);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				closeAll();
			}
		}
		return lstBooks;
	}

	@Override
	public List<NBook_SalesBook> getAll() {
		String sql = "SELECT * FROM book,salesbook WHERE book.ISBN = salesbook.ISBN ";
		ResultSet rs=exceuteQuery(sql);
		List<NBook_SalesBook> lstBooks=new ArrayList<NBook_SalesBook>();
		try {
			while(rs.next()){
				NBook_SalesBook book=new NBook_SalesBook();
				book.setISBN(rs.getString("ISBN"));
				book.setName(rs.getString("NAME"));
				book.setAuthor(rs.getString("AUTHOR"));
				book.setPress(rs.getString("PRESS"));
				book.setPrice(rs.getFloat("PRICE"));
				book.setImage(rs.getString("IMAGE"));
				book.setBookSize(rs.getString("BOOKSIZE"));
				book.setPublishTime(rs.getString("PUBLISHTIME"));
				book.setNowprice(rs.getFloat("SPRICE"));
				book.setRnum(rs.getInt("RNUM"));
				book.setSnum(rs.getInt("SNUM"));
				book.setIsDBooks(rs.getInt("ISDBOOKS"));
				book.setDescription(rs.getString("DESCRIPTION"));
				book.setTypeid(rs.getString("TYPEID"));
				lstBooks.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		
		return lstBooks;}
}
