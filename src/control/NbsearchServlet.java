package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.NSalesBookBiz;
import biz.NSalesBookBizImpl;
import entity.BookType;
import entity.SalesBook;

/**
 * Servlet implementation class NbsearchServlet
 */
@WebServlet("/NbsearchServlet")
public class NbsearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NbsearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(request.getParameter("cateId")!=null){
			session.setAttribute("cateId", request.getParameter("cateId"));
		}
		NSalesBookBiz nSalesBookBiz = new NSalesBookBizImpl();
		int pageSize=4;
		int total;
		List<SalesBook> lstSalesBooks = null;
		int pageNum=1;
		String cateId = (String) session.getAttribute("cateId");
		if(cateId.equals("QBTS")) {
			int count=nSalesBookBiz.getCount();
			total=count%pageSize==0?count/pageSize:count/pageSize+1;
			if(request.getParameter("num")!=null){
				pageNum=Integer.parseInt(request.getParameter("num"));
			}
			if(pageNum<=0){
				pageNum=1;
			}else if(pageNum>total){
				pageNum=total;
			}
			session.setAttribute("bookTypeName", "È«²¿Í¼Êé");
			lstSalesBooks=nSalesBookBiz.getNewsByPage(pageNum, pageSize);
		}else {
			int count=nSalesBookBiz.getCount_type(cateId);
			total=count%pageSize==0?count/pageSize:count/pageSize+1;
			if(request.getParameter("num")!=null){
				pageNum=Integer.parseInt(request.getParameter("num"));
			}
			if(pageNum<=0){
				pageNum=1;
			}else if(pageNum>total){
				pageNum=total;
			}
			@SuppressWarnings("unchecked")
			List<BookType> bookTypes = (List<BookType>) session.getAttribute("booktypes");
			for(int i=0;i<bookTypes.size();i++) {
				if(bookTypes.get(i).getTypeid().equals(cateId)) {
					session.setAttribute("bookTypeName", bookTypes.get(i).getName());
				}
			}
			lstSalesBooks=nSalesBookBiz.getNewsByPage_type(pageNum, pageSize, cateId);
		}
		session.setAttribute("searchmethod", "type");
		session.setAttribute("bookNum",total*pageSize);
		session.setAttribute("SalesBooksByType", lstSalesBooks);
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
