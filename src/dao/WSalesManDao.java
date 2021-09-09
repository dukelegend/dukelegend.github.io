package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConnect.BaseDao;
import entity.SalesMan;

public class WSalesManDao extends BaseDao{

	public List<SalesMan> getSalesMan(){
		String sql="select * from salesman";
		ResultSet rs=exceuteQuery(sql);
		
		List<SalesMan> list=new ArrayList<>();
		
		try {
			while(rs.next()) {
				SalesMan sa=new SalesMan();
				
				sa.setId(rs.getString("id"));
				sa.setPassword(rs.getString("password"));
				sa.setName(rs.getString("name"));
				sa.setNickname(rs.getString("NICKNAME"));
				sa.setType(rs.getString("type"));
				sa.setPhonenum(rs.getString("PHONENUM"));
				sa.setAddress(rs.getString("ADDRESS"));
				sa.setSex(rs.getString("sex"));
				sa.setEmail(rs.getString("email"));
				
				list.add(sa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return list;
	}
	public void addSalesMan(String id,String name,String sex,String phonenum,String email,String address,String type,String password){
		String sql = "insert into salesman (id,password,name,sex,nickname,phonenum,email,address,type) values('"+id+"','"+password+"','"+name+"','"+sex+"','00','"+phonenum+"','"+email+"','"+address+"','"+type+"')";
		exceuteUpdate(sql);
	}
	
	public int deleteSalesMan(String id) {
		String sql = "delete from salesman where id=?";
		Object[] params= {id};
		int row = exceuteUpdate(sql,params);
		return row;
	}
	
	public int upDateSalesman(String id,String password,String name,String sex,String phonenum,String email,String address,String type) {
		String sql = "update salesman set password=?,name=?,sex=?,phonenum=?,email=?,address=?,type=? where id=?";
		Object[] params= {password,name,sex,phonenum,email,address,type,id};
		int row = exceuteUpdate(sql, params);
		return row;
	}
	public int upDateShopOwner(String id,String password,String name,String nickname,String sex,String phonenum,String email,String address,String type) {
		String sql = "update salesman set password=?,name=?,nickname=?,sex=?,phonenum=?,email=?,address=?,type=? where id=?";
		Object[] params= {password,name,nickname,sex,phonenum,email,address,type,id};
		int row = exceuteUpdate(sql, params);
		return row;
	}
}
