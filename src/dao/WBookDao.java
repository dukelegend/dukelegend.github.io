package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import dbConnect.BaseDao;
import entity.Book;

public class WBookDao extends BaseDao{

	public List<Book> getBook(){
		String sql="select * from book";
		ResultSet rs=exceuteQuery(sql);
		
		List<Book> list=new ArrayList<>();
		try {
			while(rs.next()) {
				Book bo=new Book();
				
				bo.setISBN(rs.getString("ISBN"));
				bo.setName(rs.getString("name"));
				bo.setAuthor(rs.getString("author"));
				bo.setPress(rs.getString("press"));
				bo.setPrice(rs.getFloat("price"));
				bo.setImage(rs.getString("image"));
				bo.setBookSize(rs.getString("booksize"));
				bo.setPublishTime(rs.getDate("PUBLISHTIME").toString());
				bo.setIssale(rs.getBoolean("issale"));
				
				list.add(bo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return list;
	}
	
	public List<Book> queryId(String id){
		String sql="select * from book where ISBN = '"+id+"'";
		ResultSet rs=exceuteQuery(sql);
		
		List<Book> list=new ArrayList<>();
		try {
			while(rs.next()) {
				Book bo=new Book();
				
				bo.setISBN(rs.getString("ISBN"));
				bo.setName(rs.getString("name"));
				bo.setAuthor(rs.getString("author"));
				bo.setPress(rs.getString("press"));
				bo.setPrice(rs.getFloat("price"));
				bo.setImage(rs.getString("image"));
				bo.setBookSize(rs.getString("booksize"));
				bo.setPublishTime(rs.getDate("PUBLISHTIME").toString());
				bo.setIssale(rs.getBoolean("issale"));
				list.add(bo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return list;
		
	}
	
	public List<Book> queryName(String name){
		String sql="select * from book where name LIKE '%"+name+"%'";
		ResultSet rs=exceuteQuery(sql);
		
		List<Book> list=new ArrayList<>();
		try {
			while(rs.next()) {
				Book bo=new Book();
				
				bo.setISBN(rs.getString("ISBN"));
				bo.setName(rs.getString("name"));
				bo.setAuthor(rs.getString("author"));
				bo.setPress(rs.getString("press"));
				bo.setPrice(rs.getFloat("price"));
				bo.setImage(rs.getString("image"));
				bo.setBookSize(rs.getString("booksize"));
				bo.setPublishTime(rs.getDate("PUBLISHTIME").toString());
				bo.setIssale(rs.getBoolean("issale"));
				list.add(bo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return list;
	}
	
	public int add(String isbn,String name,String author,String press,float price,String image,String booksize,String publishtime,boolean issale) {
		String sql="insert into book(ISBN,name,author,press,price,image,booksize,publishtime,issale) value(?,?,?,?,?,?,?,?,?)";
		int i;
		i= exceuteUpdate(sql,isbn,name,author,press,price,image,booksize,publishtime,issale);
		
		closeAll();
		return i;
	}
	
	public int delete(String id) {
		String sql="delete from book where ISBN ='"+id+"'";
		int i=exceuteUpdate(sql);
		closeAll();
		return i;
	}
	
	public int upBook(String id,boolean bo) {
		String sql="update book set issale= "+bo+" where ISBN ='"+id+"'";
		int i=exceuteUpdate(sql);
		closeAll();
		return i;
	}
}
