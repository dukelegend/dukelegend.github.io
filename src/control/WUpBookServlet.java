package control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.WBookBiz;
import biz.WSalesBookBiz;

/**
 * Servlet implementation class WUpBookServlet
 */
@WebServlet("/WUpBookServlet")
public class WUpBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WUpBookServlet() {
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
		
		String des,type,isbn;
		float price;
		int num;
		if(request.getParameter("down")==null) {
			des=request.getParameter("des");
			type=request.getParameter("type");
			price=Float.parseFloat(request.getParameter("price"));
			num=Integer.parseInt(request.getParameter("num"));
			isbn=request.getParameter("isbn");
			
			Date date=new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        String sjdate = sdf.format(date);
	        
	        new WSalesBookBiz().add(isbn,price, num, 0, false, des, sjdate, type);
			new WBookBiz().upBook(isbn, true);
		}else {
			new WBookBiz().upBook(request.getParameter("down"), false);
			new WSalesBookBiz().delete(request.getParameter("down"));
		}
		
		response.sendRedirect("WBookServlet");
		
		
       
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
