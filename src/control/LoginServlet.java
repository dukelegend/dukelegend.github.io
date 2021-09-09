package control;

import java.awt.Component;
import java.awt.Frame;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import biz.NCustomerBiz;
import biz.NCustomerBizImpl;
import entity.Customer;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account=request.getParameter("account");
		String password=request.getParameter("passw");
		NCustomerBiz customerBiz = new NCustomerBizImpl();
		List<Customer> customers = customerBiz.getUsers();
		Customer customer = null;
		for(int i=0;i<customers.size();i++) {
			if(account.equals(customers.get(i).getId())||account.equals(customers.get(i).getEmail())) {
				if(password.equals(customers.get(i).getPassword())) {
					customer = customers.get(i);
				}
			}
		}
		if(customer==null) {
			 Frame frame=new Frame();
			 frame.setAlwaysOnTop(true);//将弹窗放在最前面
			 JOptionPane.showMessageDialog((Component)frame, "密码错误！或您还未注册","登录结果", 2);
			 response.sendRedirect("NMainServlet");
		}else {
			HttpSession session=request.getSession();
			session.setAttribute("loginUser",customer);
			response.sendRedirect("NMainServlet");
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
