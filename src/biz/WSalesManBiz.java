package biz;

import java.util.List;

import dao.WSalesManDao;
import entity.SalesMan;

public class WSalesManBiz {

	public List<SalesMan> getSalesMan(){
		return new WSalesManDao().getSalesMan();
	}
}
