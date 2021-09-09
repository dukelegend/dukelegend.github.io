package control;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.NHuancunBiz;
import biz.NHuancunBizImpl;
import biz.NOrdersBiz;
import biz.NOrdersBizImpl;
import entity.Customer;
import entity.Orders;

/**
 * Servlet implementation class NOrderPayServlet
 */
@WebServlet("/NOrderPayServlet")
public class NOrderPayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NOrderPayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Customer customer = (Customer) session.getAttribute("loginUser");
		float price =0;
		String BOID = request.getParameter("ZBOID");
		if(!(customer==null)) {
			String keywords = customer.getId();
			NOrdersBiz nOrdersBiz = new NOrdersBizImpl();
			NHuancunBiz nHuancunBiz = new NHuancunBizImpl();
			List<Orders> orders = nOrdersBiz.getall(BOID);
			for(int i=0;i<orders.size();i++) {
				price+=orders.get(i).getPrice();
			}
			DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
			String totolString = decimalFormat.format(price);//format 返回的是字符串
			String sql5 = "insert into huancun(BOID,CID) values('"+BOID+"','"+keywords+"');";
			nHuancunBiz.exceuteUpdate(sql5);
			session.setAttribute("totolprice", totolString);
			session.setAttribute("BOID", BOID);
		}
		response.sendRedirect("Npayment.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
