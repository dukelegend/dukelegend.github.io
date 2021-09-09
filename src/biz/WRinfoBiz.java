package biz;

import java.util.List;

import dao.WRinfoDao;
import entity.Rinformation;

public class WRinfoBiz {

	public List<Rinformation> getRinfo(){
		return new WRinfoDao().getRinfo();
	}
}
