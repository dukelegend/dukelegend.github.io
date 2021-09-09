package control;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.WBookBiz;
import biz.WOrderBiz;
import biz.WReturnBiz;
import entity.Book;
import entity.ReturnApplication;
import new_entity.WOrder;

/**
 * Servlet implementation class WReturnServlet
 */
@WebServlet("/WReturnServlet")
public class WReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WReturnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<Book> book=new WBookBiz().getBook();
//		List<Orders> olist=new ArrayList<>();
		List<WOrder> worlist=new WOrderBiz().getOrder("申请退货中");//申请退款中shenqingtuikuanzhong	
		List<ReturnApplication> ralist=new WReturnBiz().getreturn();
//		List<ReturnApplication> rlist=new WReturnBiz().getreturn();
//		
//		for(ReturnApplication ra:rlist) {
//			for(Orders or:orlist) {
//				if(ra.getOid().equals(or.getOid())) {
//					olist.add(or);
//				}
//			}
//		}
		
//		List<WOrder> list=ob.getRorder(olist);
		HttpSession s=request.getSession();
		
		
		s.setAttribute("rorder",worlist);
		s.setAttribute("application",ralist);
		s.setAttribute("book",book);
//		s.setAttribute("rinfo", rlist);
		response.sendRedirect("wReturnOrder.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
