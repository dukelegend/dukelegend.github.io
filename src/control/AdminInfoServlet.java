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

import com.mysql.cj.Session;

import biz.WSalesManBiz;
import entity.SalesMan;

/**
 * Servlet implementation class AdminInfoServlet
 */
@WebServlet("/AdminInfoServlet")
public class AdminInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInfoServlet() {
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
		
		String name=request.getParameter("name");
		String type=request.getParameter("type");
		HttpSession session=request.getSession();
		session.setAttribute("name", name);
		session.setAttribute("type", type);
		
		WSalesManBiz sabiz=new WSalesManBiz();
		List<SalesMan> list=sabiz.getSalesMan();
		boolean judge=false;
		List<SalesMan> listForSearch= new ArrayList<>();
		for(SalesMan sam:list) {
			if (sam.getName().equals(name)||sam.getType().equals(type)){
				judge = true;
				listForSearch.add(sam);
				break;
			}
		}
		if (judge) {
			session.setAttribute("list", listForSearch);
		}
		else {
			session.setAttribute("list", list);
		}		
		response.sendRedirect("AdminInfo.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
