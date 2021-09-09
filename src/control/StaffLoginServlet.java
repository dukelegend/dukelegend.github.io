package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.WSalesManBiz;
import entity.SalesMan;

/**
 * Servlet implementation class StaffLoginServlet
 */
@WebServlet("/StaffLoginServlet")
public class StaffLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffLoginServlet() {
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
		
		String count=request.getParameter("count");
		String pasw=request.getParameter("pasw");

		WSalesManBiz sabiz=new WSalesManBiz();
		List<SalesMan> list=sabiz.getSalesMan();
		
		boolean judge=false;
		SalesMan sam=null;
		
		for(SalesMan sa:list) {
			if(sa.getId().equals(count)&&sa.getPassword().equals(pasw)) {
				judge=true;
				sam=sa;
				break;
			}
		}
		
		if(judge) {
			HttpSession s = request.getSession(); 
			s.removeAttribute("sa");
			
			if(sam.getType().equals("店长")) {//dianzhang
				s.setAttribute("sa", sam);
				response.sendRedirect("ShopOwnerIndex.jsp");
				
			}else if(sam.getType().equals("管理员")) {//guanliyuan
				s.setAttribute("sa", sam);
				response.sendRedirect("bookManerge.jsp");
				
			}else if(sam.getType().equals("客服")) {//kefu
				s.setAttribute("sa", sam);
				response.sendRedirect("orderManerge.jsp");
				
			}else if(sam.getType().equals("财务")) {//caiwu
				s.setAttribute("sa", sam);
				response.sendRedirect("FinanceIndex.jsp");
			}
			
		}else {
			int num=1;
			request.setAttribute("num", num);
			request.getRequestDispatcher("staffLogin.jsp").forward(request, response);

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
