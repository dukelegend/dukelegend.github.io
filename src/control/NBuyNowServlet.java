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

import biz.NBook_SalesBookBiz;
import biz.NBook_SalesBookBizImpl;
import entity.Customer;
import new_entity.NBook_SalesBook;
import new_entity.NShoppingCart_Book;

/**
 * Servlet implementation class NBuyNowServlet
 */
@WebServlet("/NBuyNowServlet")
public class NBuyNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NBuyNowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Customer customer = (Customer) session.getAttribute("loginUser");
		int buynum = Integer.parseInt(request.getParameter("buyNum"));
		float price =0;
		String ISBN = request.getParameter("bookId");
		if(!(customer==null)) {
			NShoppingCart_Book nShoppingCart_Book =new NShoppingCart_Book();
			nShoppingCart_Book.setCid(customer.getId());
			nShoppingCart_Book.setNum(buynum);
			NBook_SalesBookBiz nBook_SalesBookBiz = new NBook_SalesBookBizImpl();
			List<NBook_SalesBook> nBook_SalesBookBizs = nBook_SalesBookBiz.getAll();
			for(int i=0;i<nBook_SalesBookBizs.size();i++) {
				if(ISBN.equals(nBook_SalesBookBizs.get(i).getISBN())) {
					nShoppingCart_Book.setnBook_SalesBook(nBook_SalesBookBizs.get(i));
					price = buynum*nBook_SalesBookBizs.get(i).getNowprice();
					nShoppingCart_Book.setTotolprice(price);
				}
			}
			List<NShoppingCart_Book> shoppingCarts = new ArrayList<NShoppingCart_Book>();
			shoppingCarts.add(nShoppingCart_Book);
			session.setAttribute("shoppingCarts", shoppingCarts);
			session.setAttribute("allshoppingCarts", shoppingCarts);
			session.setAttribute("allprice", shoppingCarts.get(0).getTotolprice());
			response.sendRedirect("order_info.jsp");
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
