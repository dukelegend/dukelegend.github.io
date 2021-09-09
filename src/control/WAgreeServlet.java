package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.WOrderBiz;
import biz.WReturnBiz;

/**
 * Servlet implementation class WAgreeServlet
 */
@WebServlet("/WAgreeServlet")
public class WAgreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WAgreeServlet() {
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
		
		if(request.getParameter("yes")!=null) {
			
			new WOrderBiz().change("退货中", request.getParameter("yes"));//tuihuozhong
			new WReturnBiz().choice(request.getParameter("yes"), "agree");
			
		}
		if(request.getParameter("no")!=null) {
			new WOrderBiz().change("已收货", request.getParameter("no"));//yishouhuo
			new WReturnBiz().choice(request.getParameter("no"), "reject");
		}
//		
		response.sendRedirect("WReturnServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
