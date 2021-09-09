package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xpath.internal.operations.Or;

import entity.Orders1;
import jdk.nashorn.internal.ir.Flags;

/**
 * Servlet implementation class SaleStatisticsServlet
 */
@WebServlet("/SaleStatisticsServlet")
public class SaleStatisticsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaleStatisticsServlet() {
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
		

		List<Orders1> list = GetListForStatistics.getListForOrders();
		float totalForPrice=0;
		int totalForNum=0;
		for (Orders1 od : list) {
			totalForPrice = totalForPrice +od.getPrice();
			totalForNum = totalForNum + od.getNum();
		}
		HttpSession session = request.getSession();
		session.setAttribute("totalForPrice", totalForPrice);
		session.setAttribute("totalForNum", totalForNum);
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
