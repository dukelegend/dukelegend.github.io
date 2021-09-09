package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConnect.BaseDao;
import entity.BigOrder;

public class NBigOrderImpl extends BaseDao implements NBigOrder {

	@Override
	public int getCount_type(String keyword) {
		int count=0;
		String sql="select count(*) from bigorder where CID ='"+keyword+"';";
			
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
	public List<BigOrder> getNewsByPage_type(int pageNum, int pageSize, String condition) {
		int count=0;
		String sql1="select count(*) from bigorder where CID='"+condition+"';";	
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
		
		List<BigOrder> lstBigOrder=new ArrayList<BigOrder>();
		if(count!=0) {
			String sql="select  * from bigorder where CID='"+condition+"' LIMIT ?,?";
			int beginIndex=(pageNum-1)*pageSize;
			Object params[]={beginIndex,pageSize};
			ResultSet rs=exceuteQuery(sql, params);
			try {
				while(rs.next()){
					BigOrder bigOrder = new BigOrder();
					bigOrder.setBOid(rs.getString("BOID"));
					bigOrder.setCid(rs.getString("CID"));
					bigOrder.setRid(rs.getString("RID"));
					bigOrder.setState(rs.getString("STATE"));
					bigOrder.setExpressid(rs.getString("EXPRESSID"));
					bigOrder.setDelayTime(rs.getString("DELAYTIME"));
					lstBigOrder.add(bigOrder);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				closeAll();
			}
		}
		return lstBigOrder;
	}

	@Override
	public List<BigOrder> getall(String condition) {
		String sql="select  * from bigorder where CID='"+condition+"';";
		ResultSet rs=exceuteQuery(sql);
		List<BigOrder> lstBigOrder=new ArrayList<BigOrder>();
		try {
			while(rs.next()){
				BigOrder bigOrder = new BigOrder();
				bigOrder.setBOid(rs.getString("BOID"));
				bigOrder.setCid(rs.getString("CID"));
				bigOrder.setRid(rs.getString("RID"));
				bigOrder.setState(rs.getString("STATE"));
				bigOrder.setExpressid(rs.getString("EXPRESSID"));
				bigOrder.setDelayTime(rs.getString("DELAYTIME"));
				lstBigOrder.add(bigOrder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return lstBigOrder;
	}

	@Override
	public BigOrder get(String condition) {
		String sql="select  * from bigorder where BOID='"+condition+"';";
		ResultSet rs=exceuteQuery(sql);
		BigOrder bigOrder = new BigOrder();
		try {
			while(rs.next()){
				bigOrder.setBOid(rs.getString("BOID"));
				bigOrder.setCid(rs.getString("CID"));
				bigOrder.setRid(rs.getString("RID"));
				bigOrder.setState(rs.getString("STATE"));
				bigOrder.setExpressid(rs.getString("EXPRESSID"));
				bigOrder.setDelayTime(rs.getString("DELAYTIME"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return bigOrder;
	}

}
