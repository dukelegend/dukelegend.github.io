package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.NBook_SalesBookBiz;
import biz.NBook_SalesBookBizImpl;
import new_entity.NBook_SalesBook;

/**
 * Servlet implementation class NMHSearchServlet
 */
@WebServlet("/NMHSearchServlet")
public class NMHSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NMHSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(request.getParameter("keywords")!=null){
			session.setAttribute("keywords", request.getParameter("keywords"));
		}
		String keywords = (String) session.getAttribute("keywords");
		int pageSize=4;
		int total;
		int pageNum=1;
		NBook_SalesBookBiz nBookBiz=new NBook_SalesBookBizImpl();
		List<NBook_SalesBook> allBookByMHsearch = null;
		int count=nBookBiz.getCount_type(keywords);
		total=count%pageSize==0?count/pageSize:count/pageSize+1;
		if(request.getParameter("num")!=null){
			pageNum=Integer.parseInt(request.getParameter("num"));
		}
		if(pageNum<=0){
			pageNum=1;
		}else if(pageNum>total){
			pageNum=total;
		}
		session.setAttribute("bookTypeName", keywords);
		System.out.println(""+pageNum+","+pageSize);
		allBookByMHsearch=nBookBiz.getNewsByPage_type(pageNum, pageSize, keywords);
		session.setAttribute("searchmethod", "keyword");
		session.setAttribute("bookNum", allBookByMHsearch.size());
		session.setAttribute("allBookByMHsearch", allBookByMHsearch);
		session.setAttribute("pageNum", pageNum);
		session.setAttribute("total", total);
		response.sendRedirect("Nbooksearch.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
