package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.NBigOrderBiz;
import biz.NBigOrderBizImpl;
import biz.NOrdersBiz;
import biz.NOrdersBizImpl;

/**
 * Servlet implementation class NQorderServlet
 */
@WebServlet("/NQorderServlet")
public class NQorderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NQorderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("Qid");
		NBigOrderBiz nBigOrderBiz = new NBigOrderBizImpl();
		NOrdersBiz nOrdersBiz = new NOrdersBizImpl();
		String sql2 = "update orders set STATE = '已取消' where BOID ='"+id+"';";
		nOrdersBiz.exceuteUpdate(sql2);
		String sql1 = "update bigorder set STATE = '已取消' where BOID ='"+id+"';";
		nBigOrderBiz.exceuteUpdate(sql1);
		response.sendRedirect("SearchOrderServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
