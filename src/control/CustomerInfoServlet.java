package control;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.HCustomerBiz;
import entity.Customer;

/**
 * Servlet implementation class CustomerInfoServlet
 */
@WebServlet("/CustomerInfoServlet")
public class CustomerInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerInfoServlet() {
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
		
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		
		HCustomerBiz customerBiz = new HCustomerBiz();
		List<Customer> list = customerBiz.getCustomer();
		
		boolean judge=false;
		List<Customer> listForCustomer = new ArrayList<>();
		for (Customer customer : list) {
			if (customer.getId().equals(id)) {
				judge = true;
				listForCustomer.add(customer);
				break;
			}
		}
		if (judge) {
			session.setAttribute("list", listForCustomer);
		}
		else {
			session.setAttribute("list",list);
		}

		
		response.sendRedirect("CustomerInfo.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
