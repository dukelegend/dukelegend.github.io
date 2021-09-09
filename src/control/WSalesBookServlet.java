package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.WSalesBookBiz;
import new_entity.WSalesBook;

/**
 * Servlet implementation class WSalesBookServlet
 */
@WebServlet("/WSalesBookServlet")
public class WSalesBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WSalesBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		int page=1,pagesize=6,totalpage,size=1;
		List<WSalesBook> booklist = null,list=null;
		if(request.getParameter("query")==null) {
			
			list=new WSalesBookBiz().getSalesBook();
			size=list.size();
		}else {
			list=new WSalesBookBiz().query(request.getParameter("query"));
			size=list.size()==0?1:list.size();
		}
		totalpage=size%pagesize==0?size/pagesize:size/pagesize+1;
		
		if(request.getParameter("num")!=null) {
			page=Integer.parseInt(request.getParameter("num"));
			if(page<=0) {
				page=1;
			}else if(page>=totalpage) {
				page=totalpage;
			}
		}
		
		if(page<totalpage) {
			booklist=list.subList((page-1)*pagesize,page*pagesize);
		}else {
			if(list.size()!=0) {
				int index=(size-(page-1)*pagesize)%(pagesize+1);
				booklist=list.subList((page-1)*pagesize,(page-1)*pagesize+index);
			}
				
		}
		
		HttpSession session=request.getSession();
		session.setAttribute("total",totalpage);
		session.setAttribute("page",page);
		session.setAttribute("book",booklist);
		response.sendRedirect("wSalesBook.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
