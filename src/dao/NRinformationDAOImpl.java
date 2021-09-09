package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConnect.BaseDao;
import entity.Rinformation;

public class NRinformationDAOImpl extends BaseDao implements NRinformationDAO {

	@Override
	public List<Rinformation> getRinformation(String cid) {
		String sql = "select * from rinformation where CID = '"+cid+"';";
		ResultSet rs=exceuteQuery(sql);
		 List<Rinformation> lstRinformation=new ArrayList<Rinformation>();
		try {
			while(rs.next()){
				Rinformation rinformation = new Rinformation();
				rinformation.setId(rs.getInt("RID"));
				rinformation.setCid(rs.getString("CID"));
				rinformation.setName(rs.getString("NAME"));
				rinformation.setPhoneNum(rs.getString("PHONENUM"));
				rinformation.setAddress(rs.getString("ADDRESS"));
				rinformation.setState(rs.getBoolean("STATE"));
				lstRinformation.add(rinformation);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		
		return lstRinformation;
	}

}
