package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConnect.BaseDao;

import entity.SalesBook;

public class WSalesBookDao extends BaseDao{

	public List<SalesBook> getSaleBook(){
		String sql="select * from salesbook";
		ResultSet rs=exceuteQuery(sql);
		
		List<SalesBook> list=new ArrayList<>();
		try {
			while(rs.next()) {
				SalesBook bo=new SalesBook();
				
				bo.setTypeid(rs.getString("typeid"));
				bo.setDescription(rs.getString("description"));
				bo.setISBN(rs.getString("isbn"));
				bo.setSjdate(rs.getString("sjdate"));
				bo.setSnum(rs.getInt("snum"));
				bo.setRnum(rs.getInt("rnum"));
				bo.setPrice(rs.getFloat("sprice"));
				bo.setIsDBooks(rs.getInt("isdbooks"));
				
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
	
	public int add(String isbn,float sprice,int rnum,int snum,boolean isdbooks,String description,String sjdate,String typeid) {
		String sql="insert into salesbook(ISBN,sprice,rnum,snum,isdbooks,description,sjdate,typeid) value(?,?,?,?,?,?,?,?)";
		int i;
		i= exceuteUpdate(sql,isbn,sprice,rnum,snum,isdbooks,description,sjdate,typeid);
		
		closeAll();
		return i;
	}
	
	public int delete(String id) {
		String sql="delete from salesbook where ISBN ='"+id+"'";
		int i=exceuteUpdate(sql);
		closeAll();
		return i;
	}
	
	public int update(String id,float price,int num) {
		String sql1="update salesbook set rnum= "+num+" where ISBN ='"+id+"'";
		int i=exceuteUpdate(sql1);
		String sql="update salesbook set sprice= "+price+" where ISBN ='"+id+"'";
		exceuteUpdate(sql);
		
		closeAll();
		return i;
	}
	
	public int jian(String id,int num) {
		String sql1="update salesbook set rnum= rnum - "+num+" where ISBN ='"+id+"'";
		int i=exceuteUpdate(sql1);
		
		closeAll();
		return i;
	}
}
