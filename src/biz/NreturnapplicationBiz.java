package biz;

import entity.ReturnApplication;

public interface NreturnapplicationBiz {
	void exceuteUpdate(String sql);
	ReturnApplication get(String condition);
}
