package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConnect.BaseDao;
import new_entity.NHuancun;

public class NHuancunDaoImpl extends BaseDao implements NHuancunDao {

	@Override
	public List<NHuancun> getBook() {
		String sql = "select * from huancun";
		ResultSet rs=exceuteQuery(sql);
		List<NHuancun> lsts=new ArrayList<NHuancun>();
		try {
			while(rs.next()){
				NHuancun huancun=new NHuancun();
				huancun.setBOID(rs.getString("BOID"));
				huancun.setCID(rs.getString("CID"));
				lsts.add(huancun);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		
		return lsts;
	}

}
