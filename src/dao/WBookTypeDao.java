package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConnect.BaseDao;
import entity.BookType;

public class WBookTypeDao extends BaseDao{

	public List<BookType> getBookType(){
		String sql="select * from booktype";
		ResultSet rs=exceuteQuery(sql);
		
		List<BookType> list=new ArrayList<>();
		try {
			while(rs.next()) {
				BookType bo=new BookType();
				
				bo.setTypeid(rs.getString("typeid"));
				bo.setDescription(rs.getString("description"));
				bo.setName(rs.getString("name"));
				
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
	
	public int add(String id,String name,String des) {
		String sql="insert into booktype(typeid,name,description) value(?,?,?)";
		int i= exceuteUpdate(sql,id,name,des);
		closeAll();
		return i;
	}
	
	public int delete(String id) {
		String sql="delete from booktype where typeid ='"+id+"'";
		int i=exceuteUpdate(sql);
		closeAll();
		return i;
	}
}
