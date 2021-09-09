package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.WBookBiz;
import biz.WBookTypeBiz;
import entity.Book;
import entity.BookType;

/**
 * Servlet implementation class WBookServlet
 */
@WebServlet("/WBookServlet")
public class WBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WBookServlet() {
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
		
		List<Book> list = null,booklist = null;
		int page=1,pagesize=5,totalpage,size=1;
		
		List<BookType> booktype=new WBookTypeBiz().getBookType();
		WBookBiz bookbiz=new WBookBiz();
		
		String query=request.getParameter("querys");
		
		
		if(query!=null) {
			if(query.length()!=0) {
				
				list=bookbiz.query(query);
				size=list.size()==0?1:list.size();//
			}else {
				list=bookbiz.getBook();
				size=list.size();
			}
			
			
		}else {
			list=bookbiz.getBook();
			size=list.size();
			
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
		
		
		
		
		HttpSession s=request.getSession();
		
		s.setAttribute("total",totalpage);
		s.setAttribute("page",page);
		s.setAttribute("book",booklist);
		s.setAttribute("type",booktype);
		response.sendRedirect("wBookShow.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
