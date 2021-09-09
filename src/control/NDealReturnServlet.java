package control;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.NBigOrderBiz;
import biz.NBigOrderBizImpl;
import biz.NOrdersBiz;
import biz.NOrdersBizImpl;
import biz.NreturnapplicationBiz;
import biz.NreturnapplicationBizImpl;
import entity.Customer;

/**
 * Servlet implementation class NDealReturnServlet
 */
@WebServlet("/NDealReturnServlet")
public class NDealReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NDealReturnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Customer customer = (Customer) session.getAttribute("loginUser");
		String keywords = customer.getId();
		String BOID=request.getParameter("BOID");
		String money=request.getParameter("money");
		String reason=request.getParameter("reason");
		NBigOrderBiz nBigOrderBiz = new NBigOrderBizImpl();
		NOrdersBiz nOrdersBiz = new NOrdersBizImpl();
		String sql2 = "update orders set STATE = '�����˻���' where BOID ='"+BOID+"';";
		nOrdersBiz.exceuteUpdate(sql2);
		String sql1 = "update bigorder set STATE = '�����˻���' where BOID ='"+BOID+"';";
		nBigOrderBiz.exceuteUpdate(sql1);
		NreturnapplicationBiz nreturnapplicationBiz = new NreturnapplicationBizImpl();
		TimeNumberUtils timeNumberUtils = new TimeNumberUtils();
		String rid = "R"+timeNumberUtils.BOID(keywords);
		SimpleDateFormat sdf = new SimpleDateFormat();// ��ʽ��ʱ��
		sdf.applyPattern("yyyy-MM-dd HH:MM:ss");// aΪam/pm�ı��
		Date date = new Date();// ��ȡ��ǰʱ��
		String creattime = sdf.format(date);
		float price = Float.parseFloat(money);
		DecimalFormat decimalFormat=new DecimalFormat(".00");//���췽�����ַ���ʽ�������С������2λ,����0����.
		String totolString = decimalFormat.format(price);//format ���ص����ַ���
		price = Float.parseFloat(totolString);
		String sql = "insert into returnapplication(ID,OID,REASON,DATE,PRICE,SSTATE,FSTATE,TID) values('"+rid+"','"+BOID+"','"+reason+"','"+creattime+"',"+price+",'pending','pending','101');";	
		nreturnapplicationBiz.exceuteUpdate(sql);
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
