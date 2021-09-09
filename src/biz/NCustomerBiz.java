package biz;

import java.util.List;

import entity.Customer;

public interface NCustomerBiz {
	List<Customer> getUsers();
	
	void exceuteUpdate(String sql);
}
