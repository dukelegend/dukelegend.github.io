package biz;

import java.util.List;

import dao.WReturnDao;
import entity.ReturnApplication;

public class WReturnBiz {

	public List<ReturnApplication> getreturn(){
		return new WReturnDao().getreturn();
	}
	
	public int choice(String id,String sstate) {
		return new WReturnDao().choice(id, sstate);
	}
}
