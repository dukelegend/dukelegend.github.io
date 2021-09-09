package control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import biz.HCompensatoryBiz;
import biz.NBigOrderBiz;
import biz.NBigOrderBizImpl;
import biz.NOrdersBiz;
import biz.NOrdersBizImpl;
import dao.HBillRecordsDao;
import dao.HCompensatoryDao;
import entity.ReturnApplication;

/**
 * Servlet implementation class UpdateCompensatoryServlet
 */
@WebServlet("/UpdateCompensatoryServlet")
public class UpdateCompensatoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCompensatoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		session.removeAttribute("compensatorylist");

		HCompensatoryBiz comBiz = new HCompensatoryBiz();
		List<ReturnApplication> list = comBiz.getReturnApplications();
		HBillRecordsDao billDao = new HBillRecordsDao();
		
		
		/*鐢熸垚鍑鸿处璁板綍缂栧彿 */
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowdate = sdf.format(date);
		String[] datesp = nowdate.split(" ");
		String[] ymdsp = datesp[0].split("-");
		String[] sfmsp = datesp[1].split(":");
		String billid = ymdsp[0]+ymdsp[1]+ymdsp[2]+sfmsp[0]+sfmsp[1]+sfmsp[2];
		
		Float price = null;//鍑鸿处璁板綍閲戦
		String oid = null;//鍑鸿处璁板綍璁㈠崟缂栧彿
		String billname = "退款";
		
		String id = request.getParameter("id");
		String state = request.getParameter("state");
		
		if (state.equals("agree")) {//鐢熸垚鍑鸿处璁板綍
			for (ReturnApplication returnApplication : list) {
				if (returnApplication.getId().equals(id)) {
					price = returnApplication.getPrice();
					oid = returnApplication.getOid();
					break;
				}
			}
			billDao.updateBillRecord(billid, billname, price, oid, nowdate);
//改
			String BOid=oid;
			NBigOrderBiz nBigOrderBiz = new NBigOrderBizImpl();
			NOrdersBiz nOrdersBiz = new NOrdersBizImpl();
			String sql2 = "update orders set STATE = '已退货' where BOID ='"+BOid+"';";
			nOrdersBiz.exceuteUpdate(sql2);
			String sql1 = "update bigorder set STATE = '已退货' where BOID ='"+BOid+"';";
			nBigOrderBiz.exceuteUpdate(sql1);
		}
		HCompensatoryDao comDao =new HCompensatoryDao();
		comDao.updateReturnApplication(id, state);
		
		response.sendRedirect("${pageContext.request.contextPath}/CompensatoryServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
