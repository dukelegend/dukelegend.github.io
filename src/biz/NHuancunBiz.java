package biz;

import java.util.List;

import new_entity.NHuancun;

public interface NHuancunBiz {
	 List<NHuancun> getHuancun();
	 
	 void exceuteUpdate(String sql);

}
