package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.HBillRecordsBiz;
import entity.BillRecords;

/**
 * Servlet implementation class OutQueryServlet
 */
@WebServlet("/OutQueryServlet")
public class OutQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutQueryServlet() {
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
		
		String billname = request.getParameter("billname");
		String billbegintime = request.getParameter("billbegintime");
		String billendtime = request.getParameter("billendtime");
		String billtime;//订单创建时间
		String[] spilttime; //分割订单创建时间
		
		HttpSession session = request.getSession();
		session.setAttribute("billname", billname);
		session.setAttribute("billbegintime", billbegintime);
		session.setAttribute("billendtime", billendtime);
		
		HBillRecordsBiz billBiz = new HBillRecordsBiz();
		List<BillRecords> list = billBiz.getBillRecords();
		
		List<BillRecords> listForSearch = new ArrayList<>();
		boolean judge = false;
		for (BillRecords bill : list) {
			spilttime=bill.getDate().split(" ");
			billtime=spilttime[0];//只取年月日
			if ((billtime.compareTo(billbegintime)>0 && billtime.compareTo(billendtime)<0)||bill.getName().equals(billname)) {
				judge = true;
				listForSearch.add(bill);
			}
		}
		if (judge) {
			session.setAttribute("outlist", listForSearch);
			GetListForStatistics.setListFoRecords(listForSearch);
		}
		else {
			session.setAttribute("outlist", new ArrayList<>());
		}
		
		
		response.sendRedirect("OutQueryStatistics.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
