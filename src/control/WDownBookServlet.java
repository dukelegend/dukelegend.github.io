package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.WBookBiz;
import biz.WSalesBookBiz;

/**
 * Servlet implementation class WDownBookServlet
 */
@WebServlet("/WDownBookServlet")
public class WDownBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WDownBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		if(request.getParameter("down")!=null) {
			new WBookBiz().upBook(request.getParameter("down"), false);
			new WSalesBookBiz().delete(request.getParameter("down"));
		}
		if(request.getParameter("isbn")!=null) {
			float price=Float.parseFloat(request.getParameter("price"));
			int num=Integer.parseInt(request.getParameter("num"));
			new WSalesBookBiz().update(request.getParameter("isbn"),price ,num);
		}
		
		
		response.sendRedirect("WSalesBookServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
