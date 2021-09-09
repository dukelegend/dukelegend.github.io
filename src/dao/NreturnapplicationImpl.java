package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import dbConnect.BaseDao;
import entity.ReturnApplication;

public class NreturnapplicationImpl extends BaseDao implements Nreturnapplication {

	@Override
	public ReturnApplication get(String condition) {
		String sql="select  * from returnapplication where OID='"+condition+"';";
		ResultSet rs=exceuteQuery(sql);
		ReturnApplication returnApplication = new ReturnApplication();
		try {
			while(rs.next()){
				returnApplication.setId(rs.getString("ID"));
				returnApplication.setOid(rs.getString("OID"));
				returnApplication.setPrice(rs.getFloat("PRICE"));
				returnApplication.setExpressid(rs.getString("EXPRESSID"));
				returnApplication.setSstate(rs.getString("SSTATE"));
				returnApplication.setFstate(rs.getString("FSTATE"));
				returnApplication.setDate(rs.getString("DATE"));
				returnApplication.setTid(rs.getString("TID"));
				returnApplication.setReason(rs.getString("REASON"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return returnApplication;
	}

}
