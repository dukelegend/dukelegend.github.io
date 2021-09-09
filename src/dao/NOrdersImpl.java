package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConnect.BaseDao;
import entity.Orders;

public class NOrdersImpl extends BaseDao implements NOrders {

	@Override
	public int getCount_type(String keyword) {
		int count=0;
		String sql="select count(*) from orders where BOID ='"+keyword+"';";
			
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
	public List<Orders> getNewsByPage_type(int pageNum, int pageSize, String condition) {
		int count=0;
		String sql1="select count(*) from orders where BOID='"+condition+"';";	
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
		
		List<Orders> lstOrder=new ArrayList<Orders>();
		if(count!=0) {
			String sql="select  * from orders where BOID='"+condition+"' LIMIT ?,?";
			int beginIndex=(pageNum-1)*pageSize;
			Object params[]={beginIndex,pageSize};
			ResultSet rs=exceuteQuery(sql, params);
			try {
				while(rs.next()){
					Orders order = new Orders();
					order.setBOid(rs.getString("BOID"));
					order.setOid(rs.getString("OID"));
					order.setISBN(rs.getString("ISBN"));
					order.setState(rs.getString("STATE"));
					order.setPrice(rs.getFloat("PRICE"));
					order.setNum(rs.getInt("NUM"));
					order.setCreateTime(rs.getString("CREATTIME"));
					order.setZdTime(rs.getString("ZDTIME"));
					order.setRemarks(rs.getString("REMARKS"));
					lstOrder.add(order);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				closeAll();
			}
		}
		return lstOrder;
	}

	@Override
	public List<Orders> getall(String condition) {
		String sql="select  * from orders where BOID='"+condition+"';";
		ResultSet rs=exceuteQuery(sql);
		List<Orders> lstOrder=new ArrayList<Orders>();
		try {
			while(rs.next()){
				Orders order = new Orders();
				order.setBOid(rs.getString("BOID"));
				order.setOid(rs.getString("OID"));
				order.setISBN(rs.getString("ISBN"));
				order.setState(rs.getString("STATE"));
				order.setPrice(rs.getFloat("PRICE"));
				order.setNum(rs.getInt("NUM"));
				order.setCreateTime(rs.getString("CREATTIME"));
				order.setZdTime(rs.getString("ZDTIME"));
				order.setRemarks(rs.getString("REMARKS"));
				lstOrder.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return lstOrder;
	}

}
