package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.NOrdersBiz;
import biz.NOrdersBizImpl;
import entity.Orders;

/**
 * Servlet implementation class NEvaluateOrderServlet
 */
@WebServlet("/NEvaluateOrderServlet")
public class NEvaluateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NEvaluateOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String evaBigOrders=request.getParameter("Qid");
		NOrdersBiz nOrdersBiz = new NOrdersBizImpl();
		List<Orders> evaOrders = nOrdersBiz.getall(evaBigOrders);
		session.setAttribute("evaOrders", evaOrders);
		session.setAttribute("evaBigOrders", evaBigOrders);
		response.sendRedirect("NEvaluate.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
