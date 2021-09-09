package biz;

import java.util.List;

import dao.NCustomerDaoImpl;
import entity.Customer;

public class NCustomerBizImpl implements NCustomerBiz {

	@Override
	public List<Customer> getUsers() {
		// TODO Auto-generated method stub
		return new NCustomerDaoImpl().getUsers();
	}

	@Override
	public void exceuteUpdate(String sql) {
		// TODO Auto-generated method stub
		new NCustomerDaoImpl().exceuteUpdate(sql);
	}

}
