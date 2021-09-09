package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.NShoppingCartBiz;
import biz.NShoppingCartBizImpl;
import entity.Customer;
import new_entity.NShoppingCart_Book;

/**
 * Servlet implementation class NCartItemsServlet
 */
@WebServlet("/NCartItemsServlet")
public class NCartItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NCartItemsServlet() {
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
			float allprice=0;
			NShoppingCartBiz nShoppingCartBiz=new NShoppingCartBizImpl();
			List<NShoppingCart_Book> shoppingCarts = null;
			List<NShoppingCart_Book> shoppingCart = nShoppingCartBiz.getall(keywords);
			for(int i=0;i<shoppingCart.size();i++) {
				allprice+=shoppingCart.get(i).getTotolprice();
			}
			int count=nShoppingCartBiz.getCount_type(keywords);
			total=count%pageSize==0?count/pageSize:count/pageSize+1;
			if(request.getParameter("num")!=null){
				pageNum=Integer.parseInt(request.getParameter("num"));
			}
			if(pageNum<=0){
				pageNum=1;
			}else if(pageNum>total){
				pageNum=total;
			}	
			shoppingCarts=nShoppingCartBiz.getNewsByPage_type(pageNum, pageSize, keywords);
			session.setAttribute("shoppingCarts", shoppingCarts);
			session.setAttribute("allshoppingCarts", shoppingCart);
			session.setAttribute("allprice", allprice);
			session.setAttribute("pageNum", pageNum);
			session.setAttribute("total", total);
		}
		response.sendRedirect("Ncart.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
