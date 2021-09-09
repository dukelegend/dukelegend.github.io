package control;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.bcel.internal.generic.NEW;

import biz.HOrderBiz;
import entity.Orders1;

/**
 * Servlet implementation class SaleQueryServlet
 */
@WebServlet("/SaleQueryServlet")
public class SaleQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public List<Orders1> list2 = new ArrayList<>();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaleQueryServlet() {
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
		
		String isbn = request.getParameter("isbn");
		String begintime = request.getParameter("begintime");
		String endtime = request.getParameter("endtime");
		String odtime;//订单创建时间
		String[] spilttime; //分割订单创建时间
		
		HttpSession session = request.getSession();
		session.setAttribute("isbn", isbn);
		session.setAttribute("begintime", begintime);
		session.setAttribute("endtime", endtime);
		
		HOrderBiz odBiz = new HOrderBiz();
		List<Orders1> list = odBiz.getOrders();
		
		List<Orders1> listForSearch = new ArrayList<>();
		boolean judge = false;
		for (Orders1 od : list) {
			spilttime=od.getCreateTime().split(" ");
			odtime=spilttime[0];//只取年月日
			if ((odtime.compareTo(begintime)>0 && odtime.compareTo(endtime)<0)||od.getISBN().equals(isbn)) {
				judge = true;
				listForSearch.add(od);
			}
		}
		if (judge) {
			session.setAttribute("salelist", listForSearch);
			GetListForStatistics.setListForOrders(listForSearch);
		}
		else {
			session.setAttribute("salelist", new ArrayList<>());
		}
		
		
		response.sendRedirect("SaleQueryStatistics.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
