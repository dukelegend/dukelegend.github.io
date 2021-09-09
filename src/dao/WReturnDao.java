package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConnect.BaseDao;
import entity.ReturnApplication;

public class WReturnDao extends BaseDao{

	public List<ReturnApplication> getreturn(){
		String sql="select * from returnapplication where sstate = 'pending'";
		ResultSet rs=exceuteQuery(sql);
		
		List<ReturnApplication> list=new ArrayList<>();
		
		try {
			while(rs.next()) {
				ReturnApplication ra=new ReturnApplication();
				
				ra.setId(rs.getString("id"));
				ra.setOid(rs.getString("oid"));
				ra.setSstate(rs.getString("sstate"));
				ra.setReason(rs.getString("reason"));
				ra.setDate(rs.getString("date"));
				ra.setPrice(rs.getFloat("price"));
				ra.setFstate(rs.getString("fstate"));
				ra.setExpressid(rs.getString("expressid"));
				
				list.add(ra);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return list;
	}
	
	public int choice(String id,String sstate) {
		String sql="update returnapplication set sstate= '"+sstate+"'"+" where oid= '"+id+"'";
		int i=exceuteUpdate(sql);
		if(sstate.equals("agree")) {
			String sql1="update returnapplication set fstate= 'pending' where oid= '"+id+"'";

			exceuteUpdate(sql1);
		}
		closeAll();
		return i;
	}
	
	
}
