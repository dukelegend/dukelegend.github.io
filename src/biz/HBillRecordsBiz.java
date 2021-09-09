package biz;
/**
 * 
 * @author HuMin
 *
 */

import java.util.List;

import dao.HBillRecordsDao;
import entity.BillRecords;

public class HBillRecordsBiz {

	public List<BillRecords> getBillRecords(){
		return new HBillRecordsDao().getBillRecords();
	}
}
