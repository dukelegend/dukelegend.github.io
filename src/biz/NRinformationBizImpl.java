package biz;

import java.util.List;

import dao.NRinformationDAOImpl;
import entity.Rinformation;

public class NRinformationBizImpl implements NRinformationBiz {

	@Override
	public List<Rinformation> getRinformation(String cid) {
		// TODO Auto-generated method stub
		return new NRinformationDAOImpl().getRinformation(cid);
	}

	@Override
	public int exceuteUpdate(String sql) {
		// TODO Auto-generated method stub
		return new NRinformationDAOImpl().exceuteUpdate1(sql);

	}

}
