package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConnect.BaseDao;
import entity.Customer;

public class NCustomerDaoImpl extends BaseDao implements NCustomerDao {

	@Override
	public List<Customer> getUsers() {
		String sql = "select * from customer";
		ResultSet rs=exceuteQuery(sql);
		List<Customer> lstCustomer=new ArrayList<Customer>();
		try {
			while(rs.next()){
				Customer customer = new Customer();
				customer.setId(rs.getString("ID"));
				customer.setPassword(rs.getString("PASSWORD"));
				customer.setNickname(rs.getString("NICKNAME"));
				customer.setName(rs.getString("NAME"));
				customer.setPhonenum(rs.getString("PHONENUM"));
				customer.setSex(rs.getString("SEX"));
				customer.setEmail(rs.getString("EMAIL"));
				lstCustomer.add(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		
		return lstCustomer;
	}

}
