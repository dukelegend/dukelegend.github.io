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
 * Servlet implementation class EditShopOwnerServlet
 */
@WebServlet("/EditShopOwnerServlet")
public class EditShopOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditShopOwnerServlet() {
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
		
		WSalesManBiz saBiz = new WSalesManBiz();
		List<SalesMan> list = saBiz.getSalesMan();
		SalesMan sam = new SalesMan();
		
		for (SalesMan sa : list) {
			if (id.equals(sa.getId())) {
				sam=sa;
				break;
			}
		}
		HttpSession session = request.getSession();
		session.setAttribute("id", sam.getId());
		session.setAttribute("name",sam.getName());
		session.setAttribute("nickname",sam.getNickname());
		session.setAttribute("sex", sam.getSex());
		session.setAttribute("phonenum", sam.getPhonenum());
		session.setAttribute("email", sam.getEmail());
		session.setAttribute("address", sam.getAddress());
		session.setAttribute("type", sam.getType());
		session.setAttribute("password", sam.getPassword());
		
		
		response.sendRedirect("ShopOwnerCenter.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
