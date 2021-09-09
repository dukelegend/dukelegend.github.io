package biz;
/**
 * 
 * 
 */
import java.util.List;

import dao.HCompensatoryDao;
import entity.Express;
import entity.ReturnApplication;

public class HCompensatoryBiz {
	public List<ReturnApplication> getReturnApplications(){
		return new HCompensatoryDao().getReturnApplications();
	}

	public List<Express> getExpresses(){
		return new HCompensatoryDao().getExpresses();
	}
}
