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
import dao.HCustomerDao;
import entity.Cvip;

/**
 * Servlet implementation class CvipInfoServlet
 */
@WebServlet("/CvipInfoServlet")
public class CvipInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CvipInfoServlet() {
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
		
		HCustomerBiz cvipBiz = new HCustomerBiz();
		List<Cvip> list = cvipBiz.getCvips();
		HttpSession session = request.getSession();
		session.setAttribute("cid", id);
		
		List<Cvip> listForRearch = new ArrayList<>();
		boolean judge = false;
		for(Cvip cvip : list) {
			if (cvip.getCid().equals(id)) {
				judge = true;
				listForRearch.add(cvip);
				break;
				
			}
		}
		if (judge) {
			session.setAttribute("list", listForRearch);
		}
		else {
			session.setAttribute("list", list);
		}
		
		
		response.sendRedirect("CvipInfo.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
