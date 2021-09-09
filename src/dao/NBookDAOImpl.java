package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConnect.BaseDao;
import entity.Book;

public class NBookDAOImpl extends BaseDao implements NBookDAO {

	@Override
	public List<Book> getBook() {
		String sql = "select * from book";
		ResultSet rs=exceuteQuery(sql);
		List<Book> lstBooks=new ArrayList<Book>();
		try {
			while(rs.next()){
				Book book=new Book();
				book.setISBN(rs.getString("ISBN"));
				book.setName(rs.getString("NAME"));
				book.setAuthor(rs.getString("AUTHOR"));
				book.setPress(rs.getString("PRESS"));
				book.setPrice(rs.getFloat("PRICE"));
				book.setImage(rs.getString("IMAGE"));
				book.setBookSize(rs.getString("BOOKSIZE"));
				book.setPublishTime(rs.getString("PUBLISHTIME"));
				lstBooks.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		
		return lstBooks;
	}
	
}
