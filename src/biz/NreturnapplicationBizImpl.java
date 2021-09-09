package biz;

import dao.NreturnapplicationImpl;
import entity.ReturnApplication;

public class NreturnapplicationBizImpl implements NreturnapplicationBiz {

	@Override
	public void exceuteUpdate(String sql) {
		new NreturnapplicationImpl().exceuteUpdate(sql);
		
	}

	@Override
	public ReturnApplication get(String condition) {
		// TODO Auto-generated method stub
		return new NreturnapplicationImpl().get(condition);
	}

}
