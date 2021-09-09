package biz;

import java.util.List;

import entity.Rinformation;

public interface NRinformationBiz {
	List<Rinformation> getRinformation(String cid);
	
	int exceuteUpdate(String sql);
}
