package control;

import java.io.IOException;
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
 * Servlet implementation class EditCustomerServlet
 */
@WebServlet("/EditCustomerServlet")
public class EditCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCustomerServlet() {
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
		
		HCustomerBiz cusBiz = new HCustomerBiz();
		List<Customer> list = cusBiz.getCustomer();
		Customer cus = new Customer();
		
		for (Customer cu : list) {
			if (id.equals(cu.getId())) {
				cus=cu;
				break;
			}
		}
		HttpSession session = request.getSession();
		session.setAttribute("Cid", cus.getId());
		session.setAttribute("name",cus.getName());
		session.setAttribute("sex",cus.getSex());
		session.setAttribute("phonenum",cus.getPhonenum());
		session.setAttribute("email", cus.getEmail());
		session.setAttribute("password",cus.getPassword());
		
		
		response.sendRedirect("EditCustomer.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
