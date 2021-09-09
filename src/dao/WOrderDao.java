package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConnect.BaseDao;
import entity.Orders;

public class WOrderDao extends BaseDao{

	public List<Orders> getOrder(String bigId){
		String sql="select * from orders where boid='"+bigId+"'";
		ResultSet rs=exceuteQuery(sql);
		
		List<Orders> list=new ArrayList<>();
		
		try {
			while(rs.next()) {
				Orders order=new Orders();
				
				order.setBOid(rs.getString("boid"));
				order.setOid(rs.getString("oid"));
				order.setISBN(rs.getString("isbn"));
				order.setPrice(rs.getFloat("price"));
				order.setCreateTime(rs.getString("creattime"));
				order.setZdTime(rs.getString("zdtime"));
				order.setRemarks(rs.getString("remarks"));
				order.setState(rs.getString("state"));
				order.setNum(rs.getInt("num"));
				
				list.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return list;
	}
	
	public List<Orders> getOrders(){//获取全部小定单
		String sql="select * from orders";
		ResultSet rs=exceuteQuery(sql);
		
		List<Orders> list=new ArrayList<>();
		
		try {
			while(rs.next()) {
				Orders order=new Orders();
				
				order.setBOid(rs.getString("boid"));
				order.setOid(rs.getString("oid"));
				order.setISBN(rs.getString("isbn"));
				order.setPrice(rs.getFloat("price"));
				order.setCreateTime(rs.getString("creattime"));
				order.setZdTime(rs.getString("zdtime"));
				order.setRemarks(rs.getString("remarks"));
				order.setState(rs.getString("state"));
				order.setNum(rs.getInt("num"));
				
				list.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return list;
	}
	
	public int change(String state,String boid) {
		String sql="update orders set state= '"+state+"'"+" where boid= '"+boid+"'";
//				String sql1="update salesbook set rnum= "+num+" where ISBN ='"+id+"'";
		int i=exceuteUpdate(sql);
		closeAll();
		return i;
	}
	
	
}
