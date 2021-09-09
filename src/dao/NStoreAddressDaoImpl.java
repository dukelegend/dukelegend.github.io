package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConnect.BaseDao;
import entity.StoreAddress;

public class NStoreAddressDaoImpl extends BaseDao implements NStoreAddressDao {

	@Override
	public List<StoreAddress> getStoreAddress() {
		String sql = "select * from storeaddress";
		ResultSet rs=exceuteQuery(sql);
		List<StoreAddress> lstStoreAddress=new ArrayList<StoreAddress>();
		try {
			while(rs.next()){
				StoreAddress storeAddress = new StoreAddress();
				storeAddress.setTid(rs.getString("TID"));
				storeAddress.setName(rs.getString("NAME"));
				storeAddress.setPhonenum(rs.getString("PHONENUM"));
				storeAddress.setAddress(rs.getString("ADDRESS"));
				lstStoreAddress.add(storeAddress);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		
		return lstStoreAddress;
	}

}
