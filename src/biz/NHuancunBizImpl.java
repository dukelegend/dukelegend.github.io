package biz;

import java.util.List;

import dao.NHuancunDaoImpl;
import new_entity.NHuancun;

public class NHuancunBizImpl implements NHuancunBiz {

	@Override
	public List<NHuancun> getHuancun() {
		// TODO Auto-generated method stub
		return new NHuancunDaoImpl().getBook();
	}

	@Override
	public void exceuteUpdate(String sql) {
		// TODO Auto-generated method stub
		 new NHuancunDaoImpl().exceuteUpdate(sql);
	}

}
