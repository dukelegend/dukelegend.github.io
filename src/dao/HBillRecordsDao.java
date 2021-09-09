package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.regexp.internal.recompile;

import dbConnect.DbConnection;
import entity.BillRecords;

public class HBillRecordsDao extends  DbConnection {

	public List<BillRecords> getBillRecords() {
		String sql = "select * from billrecords";
		ResultSet rs = executeQuery(sql);
		
		List<BillRecords> list = new ArrayList<>();
		try {
			while(rs.next()) {
				BillRecords billRecords = new BillRecords();
				billRecords.setId(rs.getString("id"));
				billRecords.setDate(rs.getString("date"));
				billRecords.setName(rs.getString("name"));
				billRecords.setPrice(rs.getFloat("price"));
				billRecords.setOid(rs.getString("oid"));
				
				list.add(billRecords);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		return list;
	}
	public int updateBillRecord(String id,String name,Float price,String oid,String date) {
		String sql = "insert into billrecords values(?,?,?,?,?)";
		Object[] prams = {id,name,price,oid,date};
		int row = executeUpdate(sql, prams);
		return row;
	}
}
