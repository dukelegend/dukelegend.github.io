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
import entity.ShoppingCart;

/**
 * Servlet implementation class NaddcartServlet
 */
@WebServlet("/NaddcartServlet")
public class NaddcartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NaddcartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Customer customer = (Customer) session.getAttribute("loginUser");
		String buynum = request.getParameter("buyNum");
		String ISBN = request.getParameter("bookId");
		NShoppingCartBiz nShoppingCartBiz = new NShoppingCartBizImpl();
		List<ShoppingCart> shoppingCarts = nShoppingCartBiz.getShoppingCart();
		boolean flag = false;
		String sqlString="";
		ShoppingCart shoppingCart = null;
		if(!(customer==null)) {
			for(int i=0;i<shoppingCarts.size();i++) {
				if(shoppingCarts.get(i).getISBN().equals(ISBN)&&shoppingCarts.get(i).getCid().equals(customer.getId())) {
					flag = true;
					shoppingCart = shoppingCarts.get(i);
				}
			}
			if(flag) {
				int num = shoppingCart.getNum()+Integer.parseInt(buynum);
				sqlString = "update shoppingcart set NUM = "+num+" WHERE ID = "+shoppingCart.getId()+";";	
			}else {
				sqlString = "insert into shoppingcart(CID,ISBN,NUM) values('"+customer.getId()+"','"+ISBN+"',"+Integer.parseInt(buynum)+");";	
			}
			nShoppingCartBiz.exceuteUpdate(sqlString);
		}
		session.setAttribute("buynum", buynum);
		response.sendRedirect("Naddcart.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
