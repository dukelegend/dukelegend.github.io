package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConnect.BaseDao;
import entity.Rinformation;

public class WRinfoDao extends BaseDao{

	public List<Rinformation> getRinfo(){
		String sql="select * from rinformation";
		ResultSet rs=exceuteQuery(sql);
		
		List<Rinformation> list=new ArrayList<>();
		try {
			while(rs.next()) {
				Rinformation ri=new Rinformation();
				
				ri.setAddress(rs.getString("address"));
				ri.setCid(rs.getString("cid"));
				ri.setId(rs.getLong("rid"));
				ri.setName(rs.getString("name"));
				ri.setPhoneNum(rs.getString("phonenum"));
				ri.setState(rs.getBoolean("state"));
				
				list.add(ri);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return list;
	}
	
	
}
