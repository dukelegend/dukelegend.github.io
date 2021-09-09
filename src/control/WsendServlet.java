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
import biz.WOrderBiz;
import biz.WRinfoBiz;
import entity.Book;
import entity.Rinformation;
import new_entity.WOrder;

/**
 * Servlet implementation class WsendServlet
 */
@WebServlet("/WsendServlet")
public class WsendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WsendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<WOrder> list = null,orderlist = null;
		int page=1,pagesize=3,totalpage,size;
		
		List<Book> book=new WBookBiz().getBook();
		
		WOrderBiz ob=new WOrderBiz();
		
		List<Rinformation> wrlist=new WRinfoBiz().getRinfo();
		
//		String query=request.getParameter("querys");
		
		list=ob.getOrder("待收货");//daishouhuo
		size=list.size()==0?1:list.size();
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
			orderlist=list.subList((page-1)*pagesize,page*pagesize);
		}else {
			if(list.size()!=0) {
				int index=(size-(page-1)*pagesize)%(pagesize+1);
				orderlist=list.subList((page-1)*pagesize,(page-1)*pagesize+index);
			}
			
					
		}
		if(orderlist!=null) {
			for(WOrder wo:orderlist) {
				for(Rinformation ri:wrlist) {
					if(wo.getBigorder().getCid().equals(ri.getCid())&&(wo.getBigorder().getRid().equals(""+ri.getId()))){//改动
						wo.setRinfo(ri);
					}
				}
			}
		}
		
		
		
		
		HttpSession s=request.getSession();
		
		s.setAttribute("total",totalpage);
		s.setAttribute("page",page);
		s.setAttribute("order",orderlist);
		s.setAttribute("book",book);
//		s.setAttribute("rinfo", rlist);
		response.sendRedirect("wWait.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
