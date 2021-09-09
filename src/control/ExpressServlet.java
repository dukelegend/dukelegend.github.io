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
import entity.Express;
import entity.ReturnApplication;

/**
 * Servlet implementation class ExpressServlet
 */
@WebServlet("/ExpressServlet")
public class ExpressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpressServlet() {
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
		
		String expname = request.getParameter("expname");
		session.setAttribute("expname", expname);
		HCompensatoryBiz comBiz = new HCompensatoryBiz();
		List<Express> list = comBiz.getExpresses();
		List<Express> listForExpresses = new ArrayList<>();
		List<Express> listForFalse = new ArrayList<>();
		
		for (Express exp1 : list) {
			if (!exp1.isType()) {
				listForFalse.add(exp1);
			}
		}
		
		Boolean judge = false;
		for (Express exp : list) {
			if (exp.getName().equals(expname)) {
				judge = false;
				listForExpresses.add(exp);
				break;
			}
		}
		if (judge) {
			session.setAttribute("expresslist", listForExpresses);
			response.sendRedirect("ExpressApplicaton.jsp");
		}
		
		else {
			session.setAttribute("expresslist", listForFalse);
			response.sendRedirect("ExpressApplicaton.jsp");
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
