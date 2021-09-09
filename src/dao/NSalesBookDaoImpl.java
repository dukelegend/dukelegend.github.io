package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConnect.BaseDao;
import entity.SalesBook;

public class NSalesBookDaoImpl extends BaseDao implements NSalesBookDao {

	@Override
	public List<SalesBook> getSalesBook() {
		String sql = "select * from salesbook";
		ResultSet rs=exceuteQuery(sql);
		List<SalesBook> lstSalesBook=new ArrayList<SalesBook>();
		try {
			while(rs.next()){
				SalesBook salesBook = new SalesBook();
				salesBook.setISBN(rs.getString("ISBN"));;
				salesBook.setPrice(rs.getFloat("SPRICE"));
				salesBook.setRnum(rs.getInt("RNUM"));
				salesBook.setSnum(rs.getInt("SNUM"));
				salesBook.setIsDBooks(rs.getInt("ISDBOOKS"));
				salesBook.setDescription(rs.getString("DESCRIPTION"));
				salesBook.setTypeid(rs.getString("TYPEID"));
				lstSalesBook.add(salesBook);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		
		return lstSalesBook;
	}
	@Override
	public int getCount() {
		int count=0;
		String sql="select count(*) from salesbook";
			
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
	public List<SalesBook> getNewsByPage(int pageNum, int pageSize) {
		int count=0;
		String sql1="select count(*) from salesbook";
		
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
       
		List<SalesBook> lstSalesbook=new ArrayList<SalesBook>();
       if(count!=0) {
    	 String sql="select  * from salesbook LIMIT ?,?";
   		int beginIndex=(pageNum-1)*pageSize;
   		
   		Object params[]={beginIndex,pageSize};
   		
   		ResultSet rs=exceuteQuery(sql, params);
   		
   		try {
   			while(rs.next()){
				SalesBook salesBook = new SalesBook();
				salesBook.setISBN(rs.getString("ISBN"));;
				salesBook.setPrice(rs.getFloat("SPRICE"));
				salesBook.setRnum(rs.getInt("RNUM"));
				salesBook.setSnum(rs.getInt("SNUM"));
				salesBook.setIsDBooks(rs.getInt("ISDBOOKS"));
				salesBook.setDescription(rs.getString("DESCRIPTION"));
				salesBook.setTypeid(rs.getString("TYPEID"));
				lstSalesbook.add(salesBook);
			}
   		} catch (SQLException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}finally{
   			closeAll();
   		}
       }
		return lstSalesbook;
	}
	
	@Override
	public int getCount_con(int condition) {
		
		int count=0;
		String sql="select count(*) from salesbook where ISDBOOKS="+condition+";";
		
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
	public List<SalesBook> getNewsByPage_con(int pageNum, int pageSize, int condition) {
		int count=0;
		String sql1="select count(*) from salesbook where ISDBOOKS="+condition+";";	
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
		
		List<SalesBook> lstSalesBooks=new ArrayList<SalesBook>();
		if(count!=0) {
			String sql="select  * from salesbook where ISDBOOKS="+condition+" LIMIT ?,?";
			int beginIndex=(pageNum-1)*pageSize;
			Object params[]={beginIndex,pageSize};
			ResultSet rs=exceuteQuery(sql, params);
			try {
				while(rs.next()){
					SalesBook salesBook = new SalesBook();
					salesBook.setISBN(rs.getString("ISBN"));;
					salesBook.setPrice(rs.getFloat("SPRICE"));
					salesBook.setRnum(rs.getInt("RNUM"));
					salesBook.setSnum(rs.getInt("SNUM"));
					salesBook.setIsDBooks(rs.getInt("ISDBOOKS"));
					salesBook.setDescription(rs.getString("DESCRIPTION"));
					salesBook.setTypeid(rs.getString("TYPEID"));
					lstSalesBooks.add(salesBook);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				closeAll();
			}
		}
		return lstSalesBooks;
	}
	@Override
	public int getCount_type(String condition) {
		
		int count=0;
		String sql="select count(*) from salesbook where TYPEID='"+condition+"';";
		
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
	public List<SalesBook> getNewsByPage_type(int pageNum, int pageSize, String condition) {
		int count=0;
		String sql1="select count(*) from salesbook where TYPEID='"+condition+"';";	
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
		
		List<SalesBook> lstSalesBooks=new ArrayList<SalesBook>();
		if(count!=0) {
			String sql="select  * from salesbook where TYPEID='"+condition+"' LIMIT ?,?";
			int beginIndex=(pageNum-1)*pageSize;
			Object params[]={beginIndex,pageSize};
			ResultSet rs=exceuteQuery(sql, params);
			try {
				while(rs.next()){
					SalesBook salesBook = new SalesBook();
					salesBook.setISBN(rs.getString("ISBN"));;
					salesBook.setPrice(rs.getFloat("SPRICE"));
					salesBook.setRnum(rs.getInt("RNUM"));
					salesBook.setSnum(rs.getInt("SNUM"));
					salesBook.setIsDBooks(rs.getInt("ISDBOOKS"));
					salesBook.setDescription(rs.getString("DESCRIPTION"));
					salesBook.setTypeid(rs.getString("TYPEID"));
					lstSalesBooks.add(salesBook);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				closeAll();
			}
		}
		return lstSalesBooks;
	}

}
