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
import biz.NOrdersBiz;
import biz.NOrdersBizImpl;
import entity.Orders;

/**
 * Servlet implementation class NApplyReturnServlet
 */
@WebServlet("/NApplyReturnServlet")
public class NApplyReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NApplyReturnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String id=request.getParameter("Qid");
		NOrdersBiz nOrdersBiz = new NOrdersBizImpl();
		List<Orders> orders = nOrdersBiz.getall(id);
		float price =0;
		for(int i=0;i<orders.size();i++) {
			price+=orders.get(i).getPrice();
		}
		DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
		String totolString = decimalFormat.format(price);//format 返回的是字符串
		session.setAttribute("Ttotolprice", totolString);
		session.setAttribute("TBOID", id);
		response.sendRedirect("NWriteApp.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
