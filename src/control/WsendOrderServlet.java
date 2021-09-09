package control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.WOrderBiz;
import biz.WSalesBookBiz;
import entity.Orders;
import new_entity.WOrder;

/**
 * Servlet implementation class WsendOrderServlet
 */
@WebServlet("/WsendOrderServlet")
public class WsendOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WsendOrderServlet() {
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
		WSalesBookBiz wb=new WSalesBookBiz();
		WOrderBiz ob=new WOrderBiz();
		List<WOrder> list=ob.getOrder("待发货");//daifahuo
		for(WOrder wo:list) {
			if(wo.getBigorder().getBOid().equals(request.getParameter("boid"))) {
				for(Orders bo:wo.getOrder()) {
					wb.jian(bo.getISBN(), bo.getNum());
					
				}
			}
			
		}
		
		
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String delaytime = sdf.format(date);
		
		WOrderBiz wo=new WOrderBiz();
		wo.change("待收货", request.getParameter("boid"));
		wo.send(request.getParameter("boid"), request.getParameter("di"), delaytime,request.getParameter("go"));
		response.sendRedirect("WOrderServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
