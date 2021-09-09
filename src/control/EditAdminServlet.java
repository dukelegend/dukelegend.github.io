package control;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.sun.swing.internal.plaf.metal.resources.metal;

import biz.WSalesManBiz;
import entity.SalesMan;

/**
 * Servlet implementation class EditAdminServlet
 */
@WebServlet("/EditAdminServlet")
public class EditAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAdminServlet() {
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
		session.setAttribute("Aname",sam.getName());
		session.setAttribute("sex", sam.getSex());
		session.setAttribute("phonenum", sam.getPhonenum());
		session.setAttribute("email", sam.getEmail());
		session.setAttribute("address", sam.getAddress());
		session.setAttribute("type", sam.getType());
		session.setAttribute("password", sam.getPassword());
		
		
		response.sendRedirect("EditAdmin.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
