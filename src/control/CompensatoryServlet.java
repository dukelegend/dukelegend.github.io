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

import biz.HCompensatoryBiz;
import entity.ReturnApplication;

/**
 * Servlet implementation class CompensatoryServlet
 */
@WebServlet("/CompensatoryServlet")
public class CompensatoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompensatoryServlet() {
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
		
		String oid = request.getParameter("oid");
		session.setAttribute("oid", oid);
		HCompensatoryBiz comBiz = new HCompensatoryBiz();
		List<ReturnApplication> list = comBiz.getReturnApplications();
		List<ReturnApplication> listFoReturnApplications = new ArrayList<>();
		List<ReturnApplication> listForPending = new ArrayList<>();
		
		for (ReturnApplication re1 : list) {
			if (re1.getFstate().equals("pending")) {
				listForPending.add(re1);
			}
		}
		
		Boolean judge = false;
		for (ReturnApplication re : list) {
			if (re.getOid().equals(oid)) {
				judge = false;
				listFoReturnApplications.add(re);
				break;
			}
		}
		if (judge) {
			session.setAttribute("compensatorylist", listFoReturnApplications);
			response.sendRedirect("CompensatoryApplication.jsp");
		}
		
		else {
			session.setAttribute("compensatorylist", listForPending);
			response.sendRedirect("CompensatoryApplication.jsp");
		}
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
