package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConnect.BaseDao;
import entity.Evaluates;

public class NEvaluatesDaoImpl extends BaseDao implements NEvaluatesDao {

	@Override
	public int getCount_type(String keyword) {
		int count=0;
		String sql="select count(*) from evaluates where ISBN ='"+keyword+"';";
			
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
	public List<Evaluates> getNewsByPage_type(int pageNum, int pageSize, String condition) {
		int count=0;
		String sql1="select count(*) from evaluates where ISBN='"+condition+"';";	
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
		
		List<Evaluates> lstEvaluates=new ArrayList<Evaluates>();
		if(count!=0) {
			String sql="select  * from evaluates where ISBN='"+condition+"' LIMIT ?,?";
			int beginIndex=(pageNum-1)*pageSize;
			Object params[]={beginIndex,pageSize};
			ResultSet rs=exceuteQuery(sql, params);
			try {
				while(rs.next()){
					Evaluates evaluates = new Evaluates();
					evaluates.setId(rs.getInt("ID"));
					evaluates.setCid(rs.getString("cid"));
					evaluates.setISBN(rs.getString("ISBN"));
					evaluates.setContext(rs.getString("CONTEXT"));
					evaluates.setLevel(rs.getInt("LEVEL"));
					evaluates.setTime(rs.getString("TIME"));
					lstEvaluates.add(evaluates);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				closeAll();
			}
		}
		return lstEvaluates;
	}

	@Override
	public List<Evaluates> getall(String condition) {
		String sql="select  * from evaluates where ISBN='"+condition+"';";
		ResultSet rs=exceuteQuery(sql);
		List<Evaluates> lstEvaluates=new ArrayList<Evaluates>();
		try {
			while(rs.next()){
				Evaluates evaluates = new Evaluates();
				evaluates.setId(rs.getInt("ID"));
				evaluates.setCid(rs.getString("cid"));
				evaluates.setISBN(rs.getString("ISBN"));
				evaluates.setContext(rs.getString("CONTEXT"));
				evaluates.setLevel(rs.getInt("LEVEL"));
				evaluates.setTime(rs.getString("TIME"));
				lstEvaluates.add(evaluates);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return lstEvaluates;
	}

}
