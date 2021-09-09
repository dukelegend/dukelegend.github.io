package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.NAllordersBiz;
import biz.NAllordersBizImpl;
import entity.Customer;
import new_entity.NAllorders;

/**
 * Servlet implementation class SearchOrderServlet
 */
@WebServlet("/SearchOrderServlet")
public class NSearchOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NSearchOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Customer customer = (Customer) session.getAttribute("loginUser");
		if(customer != null) {
			String keywords = customer.getId();
			int pageSize=4;
			int total;
			int pageNum=1;
			NAllordersBiz nAllordersBiz = new NAllordersBizImpl();
			int count=nAllordersBiz.getCount_type(keywords);
			total=count%pageSize==0?count/pageSize:count/pageSize+1;
			if(request.getParameter("num")!=null){
				pageNum=Integer.parseInt(request.getParameter("num"));
			}
			if(pageNum<=0){
				pageNum=1;
			}else if(pageNum>total){
				pageNum=total;
			}	
			List<NAllorders> allorders = nAllordersBiz.getNewsByPage_type(pageNum, pageSize, keywords);
			session.setAttribute("orderCustom", allorders);
			session.setAttribute("pageNum", pageNum);
			session.setAttribute("total", total);
		}
		response.sendRedirect("Norder_list.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
