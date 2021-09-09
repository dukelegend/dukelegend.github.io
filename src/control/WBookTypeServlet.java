package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.WBookTypeBiz;
import entity.BookType;

/**
 * Servlet implementation class WBookTypeServlet
 */
@WebServlet("/WBookTypeServlet")
public class WBookTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WBookTypeServlet() {
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
		
		WBookTypeBiz booktype=new WBookTypeBiz();
		List<BookType> list,typeList;
		int pageNum=1,pagesize=4;//add添加的判断
		String meg=null;
		
		typeList=booktype.getBookType();
		int totalpage=typeList.size()%pagesize==0?typeList.size()/pagesize:typeList.size()/pagesize+1;
		
		String tid=request.getParameter("id");
		String type=request.getParameter("type");
		String outline=request.getParameter("outline");
		
		if((tid!=null)&&(type!=null)&&(outline!=null)) {//添加判断
			int add=booktype.addBookType(tid, type,outline );
			if(add==-1) {
				meg="添加失败！";//tianjiachenggong
			}else if(add>0) {
				meg="添加成功！";//tianjiashibai
			}
			
		}
		
		if(request.getParameter("num")!=null){//页数
			pageNum=Integer.parseInt(request.getParameter("num"));
			if(pageNum<=0){
				pageNum=1;
			}else if(pageNum>totalpage){
				pageNum=totalpage;
			}
		}
		
		
		if(pageNum<totalpage) {
			list=typeList.subList((pageNum-1)*pagesize, pageNum*pagesize);
		}else {
			int index=typeList.size()%pagesize==0?pagesize:typeList.size()%pagesize;
			list=typeList.subList((pageNum-1)*pagesize,(pageNum-1)*pagesize+index);
		}
		
		HttpSession s = request.getSession();
		
		s.setAttribute("type",list);
		s.setAttribute("total",totalpage);
		s.setAttribute("page", pageNum);
		s.setAttribute("meg",meg);
		response.sendRedirect("wBookType.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
