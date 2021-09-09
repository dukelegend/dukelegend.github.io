package control;

import java.awt.Component;
import java.awt.Frame;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import biz.NBigOrderBiz;
import biz.NBigOrderBizImpl;
import biz.NEvaluatesBiz;
import biz.NEvaluatesBizImpl;
import biz.NOrdersBiz;
import biz.NOrdersBizImpl;
import entity.Customer;
import entity.Orders;

/**
 * Servlet implementation class NDealEvaServlet
 */
@WebServlet("/NDealEvaServlet")
public class NDealEvaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NDealEvaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		@SuppressWarnings("unchecked")
		List<Orders> evaOrders = (List<Orders>) session.getAttribute("evaOrders");
		String BOID = (String) session.getAttribute("evaBigOrders");
		String context;
		String time;
		String level;
		int l=0;
		NBigOrderBiz nBigOrderBiz = new NBigOrderBizImpl();
		NOrdersBiz nOrdersBiz = new NOrdersBizImpl();
		String sql2 = "update bigorder set STATE = '已完成' where BOID ='"+BOID+"';";
		String sql1 = "";
		nBigOrderBiz.exceuteUpdate(sql2);
		Customer customer = (Customer) session.getAttribute("loginUser");
		String cid = customer.getId();
		String sql="";SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
		sdf.applyPattern("yyyy-MM-dd HH:MM:ss");// a为am/pm的标记
		Date date = new Date();// 获取当前时间
		NEvaluatesBiz nEvaluatesBiz = new NEvaluatesBizImpl();
		for(int i=0;i<evaOrders.size();i++) {
			context = request.getParameter("context"+evaOrders.get(i).getOid());
			level = request.getParameter("level"+evaOrders.get(i).getOid());
			l=Integer.parseInt(level);
			time = sdf.format(date);
			sql = "insert into evaluates(ISBN,CID,TIME,CONTEXT,LEVEL) values('"+evaOrders.get(i).getISBN()+"','"+cid+"','"+time+"','"+context+"',"+l+");";
		    nEvaluatesBiz.exceuteUpdate(sql);
			sql1 = "update orders set STATE = '已完成' where OID ='"+evaOrders.get(i).getOid()+"';";
			nOrdersBiz.exceuteUpdate(sql1);
		}
		 Frame frame=new Frame();
		 frame.setAlwaysOnTop(true);//将弹窗放在最前面
		 JOptionPane.showMessageDialog((Component)frame, "评价成功！","注册结果", 2);
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
