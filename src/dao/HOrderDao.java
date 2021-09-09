package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author HuMin
 *
 */
import dbConnect.DbConnection;
import entity.Orders1;

public class HOrderDao extends  DbConnection{

	public List<Orders1> getOrders() {
		String sql = "select * from orders";
		ResultSet rs = executeQuery(sql);
		
		List<Orders1> list = new ArrayList<>();
		
		try {
			while(rs.next()) {
				Orders1 od = new Orders1();
				
				od.setOid(rs.getString("oid"));
				od.setBOid(rs.getString("boid"));
				od.setISBN(rs.getString("isbn"));
				od.setPrice(rs.getFloat("price"));
				od.setCreateTime(rs.getString("creattime"));
				od.setState(rs.getString("state"));
				od.setZdTime(rs.getString("zdtime"));
				od.setRemarks(rs.getString("remarks"));
				od.setNum(rs.getInt("num"));
				list.add(od);
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
