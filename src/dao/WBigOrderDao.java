package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConnect.BaseDao;
import entity.BigOrder;

public class WBigOrderDao extends BaseDao{

	public List<BigOrder> getBigOrder(){
		String sql="select * from bigorder";
		ResultSet rs=exceuteQuery(sql);
		List<BigOrder> list=new ArrayList<>();
		
		try {
			while(rs.next()) {
				BigOrder bo=new BigOrder();
				
				bo.setBOid(rs.getString("boid"));
				bo.setRid(rs.getString("rid"));
				bo.setState(rs.getString("state"));
				bo.setExpressid(rs.getString("expressid"));
				bo.setDelayTime(rs.getString("delaytime"));
				bo.setCid(rs.getString("cid"));
				
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
	
	public int change(String state,String boid) {
		String sql="update bigorder set state= '"+state+"'"+" where boid= '"+boid+"'";

		int i=exceuteUpdate(sql);
		closeAll();
		return i;
	}
	
	public int send(String boid,String expressid,String delaytime,String name) {
		String sql="update bigorder set expressid= '"+expressid+"'"+" where boid= '"+boid+"'";
		
		String sql1="update bigorder set delaytime= '"+delaytime+"'"+" where boid= '"+boid+"'";

		String sql2="insert into express(id,name,price,type) value(?,?,?,?)";
		
		exceuteUpdate(sql2,expressid,name,10,false);
		
		exceuteUpdate(sql);
		
		int i=exceuteUpdate(sql1);
		closeAll();
		return i;
		
	}
}
