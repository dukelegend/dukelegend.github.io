package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConnect.DbConnection;
import entity.Express;
import entity.ReturnApplication;

public class HCompensatoryDao extends  DbConnection{

	public List<ReturnApplication> getReturnApplications(){
		String sql = "select * from returnapplication";
		ResultSet rs = executeQuery(sql);
		List<ReturnApplication> list = new ArrayList<>();
		
		try {
			while(rs.next()) {
				ReturnApplication rA = new ReturnApplication();
				rA.setId(rs.getString("id"));
				rA.setOid(rs.getString("oid"));
				rA.setExpressid(rs.getString("expressid"));
				rA.setTid(rs.getString("tid"));
				rA.setPrice(rs.getFloat("price"));
				rA.setReason(rs.getString("reason"));
				rA.setSstate(rs.getString("sstate"));
				rA.setFstate(rs.getString("fstate"));
				rA.setDate(rs.getString("date"));
				
				list.add(rA);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return list;
	}
	
	public List<Express> getExpresses(){
		String sql = "select * from express";
		ResultSet rs = executeQuery(sql);
		List<Express> list = new ArrayList<>();
		
		try {
			while (rs.next()) {
				Express express =new Express();
				express.setId(rs.getString("id"));
				express.setName(rs.getString("name"));
				express.setPrice(rs.getFloat("price"));
				express.setType(rs.getBoolean("type"));
				list.add(express);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return list;
	}
	
	public int updateReturnApplication(String id,String state) {
		String sql = "update returnapplication set fstate=? where id=?";
		Object[] params= {state,id};
		int row = executeUpdate(sql, params);
		return row;
	}
	public int updateExpress(String id,Boolean type) {
		String sql = "update express set type=? where id=?";
		Object[] params= {type,id};
		int row = executeUpdate(sql, params);
		return row;
	}
}
