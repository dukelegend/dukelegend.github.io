package biz;

import java.util.List;

import dao.HCustomerDao;
import entity.Customer;
import entity.Cvip;

/**
 * 
 * 
 * @author HuMin
 *
 */
public class HCustomerBiz {

	public List<Customer> getCustomer(){
		return new HCustomerDao().getCustomers();
	}
	
	public List<Cvip> getCvips(){
		return new HCustomerDao().getCvips();
	}
}
