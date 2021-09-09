package dao;
/**
 * 
 * 
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.sun.crypto.provider.RSACipher;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import dbConnect.DbConnection;
import entity.Customer;
import entity.Cvip;
import jdk.nashorn.internal.ir.WhileNode;

public class HCustomerDao extends DbConnection{


	public List<Customer> getCustomers(){
		String sql="select * from customer";
		ResultSet rs=executeQuery(sql);
		
		List<Customer> list=new ArrayList<>();
		
		try {
			while (rs.next()) {
				Customer customer = new Customer();
				
				customer.setId(rs.getString("id"));
				customer.setPassword(rs.getString("password"));
				customer.setName(rs.getString("name"));
				customer.setSex(rs.getString("sex"));
				customer.setNickname(rs.getString("nickname"));
				customer.setPhonenum(rs.getString("phonenum"));
				customer.setEmail(rs.getString("email"));
				
				list.add(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return list;
	}
	
	public List<Cvip> getCvips(){
		String sql = "select * from cvip";
		ResultSet rs = executeQuery(sql);
		
		List<Cvip> list = new ArrayList<>();
		try {
			while(rs.next()) {
				Cvip cvip = new Cvip();
				cvip.setCid(rs.getString("id"));
				cvip.setDate(rs.getString("date"));
				cvip.setDiscount(rs.getFloat("discount"));
				list.add(cvip);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		
		
		}
		return list;
	}

	public int addCustomer(String id,String name,String sex,String phonenum,String email,String password){
		String sql = "insert into customer (id,password,name,sex,phonenum,email) values(?,?,?,?,?,?)";
		Object[] params= {id,password,name,sex,phonenum,email,};
		int row = executeUpdate(sql,params);
		return row;
	}
	
	public int deleteCustomer(String id) {
		String sql = "delete from customer where id=?";
		Object[] params= {id};
		int row = executeUpdate(sql,params);
		return row;
	}
	public int upDateCustomer(String id,String password,String name,String sex,String phonenum,String email) {
		String sql = "update customer set password=?,name=?,sex=?,phonenum=?,email=? where id=?";
		Object[] params= {password,name,sex,phonenum,email,id};
		int row = executeUpdate(sql, params);
		return row;
	}
}
