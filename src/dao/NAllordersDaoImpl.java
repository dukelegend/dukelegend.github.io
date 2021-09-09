package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import biz.NOrdersBiz;
import biz.NOrdersBizImpl;
import biz.NRinformationBiz;
import biz.NRinformationBizImpl;
import dbConnect.BaseDao;
import entity.Orders;
import entity.Rinformation;
import new_entity.NAllorders;

public class NAllordersDaoImpl extends BaseDao implements NAllordersDao {

	@Override
	public int getCount_type(String keyword) {
		int count=0;
		String sql="select count(*) from bigorder where CID ='"+keyword+"' and state != '已取消';";
			
		ResultSet rs=exceuteQuery(sql);
		
		try {
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		
		return count;
	}

	@Override
	public List<NAllorders> getNewsByPage_type(int pageNum, int pageSize, String condition) {
		int count=0;
		String sql1="select count(*) from bigorder where CID='"+condition+"' and state != '已取消' ORDER BY (CASE WHEN STATE='未付款' THEN 1 WHEN STATE='待发货' THEN 2 "
				+ "WHEN STATE='待收货' THEN 3 WHEN STATE='申请退货中' THEN 4 WHEN STATE='退货中' THEN 5  WHEN STATE='已收货' THEN 6 "
				+ "WHEN STATE='已完成' THEN 7 WHEN STATE='已退货' THEN 8 WHEN STATE='部分退货完成' THEN 9 END);";	
		ResultSet rs1=exceuteQuery(sql1);
		try {
			if(rs1.next()){
				count=rs1.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		
		List<NAllorders> lstBigOrder=new ArrayList<NAllorders>();
		if(count!=0) {
			String sql="select * from bigorder where CID='"+condition+"' and state != '已取消' ORDER BY (CASE WHEN STATE='未付款' THEN 1 WHEN STATE='待发货' THEN 2 "
					+ "WHEN STATE='待收货' THEN 3 WHEN STATE='申请退货中' THEN 4 WHEN STATE='退货中' THEN 5  WHEN STATE='已收货' THEN 6 "
					+ "WHEN STATE='已完成' THEN 7 WHEN STATE='已退货' THEN 8 WHEN STATE='部分退货完成' THEN 9 END) LIMIT ?,?";
			int beginIndex=(pageNum-1)*pageSize;
			Object params[]={beginIndex,pageSize};
			ResultSet rs=exceuteQuery(sql, params);
			try {
				while(rs.next()){
					NAllorders bigOrder = new NAllorders();
					bigOrder.setBOid(rs.getString("BOID"));
					bigOrder.setCid(rs.getString("CID"));
					bigOrder.setRid(rs.getString("RID"));
					bigOrder.setState(rs.getString("STATE"));
					bigOrder.setExpressid(rs.getString("EXPRESSID"));
					bigOrder.setDelayTime(rs.getString("DELAYTIME"));
					lstBigOrder.add(bigOrder);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				closeAll();
			}
		}
		float totolprice =0;
		NOrdersBiz nOrdersBiz = new NOrdersBizImpl();
		NRinformationBiz nRinformationBiz = new NRinformationBizImpl();
		List<Rinformation> rinformation = nRinformationBiz.getRinformation(condition);
		List<Orders> lstOrders=null;
		String address = "";
		for(int i=0;i<lstBigOrder.size();i++) {
			    lstOrders = nOrdersBiz.getall(lstBigOrder.get(i).getBOid());
			    for(int j=0;j<lstOrders.size();j++) {
				totolprice+=lstOrders.get(j).getPrice();
			   }
			lstBigOrder.get(i).setOrders(lstOrders);
			lstBigOrder.get(i).setTotolprice(totolprice);
			totolprice = 0;
			lstOrders=null;
			for(int j=0;j<rinformation.size();j++) {
				if(lstBigOrder.get(i).getRid().equals(""+rinformation.get(j).getId())) {
					address =  rinformation.get(j).getName()+","+rinformation.get(j).getPhoneNum()+","+rinformation.get(j).getAddress();
				}
			}
			lstBigOrder.get(i).setAddress(address);
		}
		return lstBigOrder;
	}

}
