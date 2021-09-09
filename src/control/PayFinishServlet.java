package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.NBigOrderBiz;
import biz.NBigOrderBizImpl;
import biz.NCustomerBiz;
import biz.NCustomerBizImpl;
import biz.NHuancunBiz;
import biz.NHuancunBizImpl;
import biz.NOrdersBiz;
import biz.NOrdersBizImpl;
import entity.Customer;
import new_entity.NHuancun;

/**
 * Servlet implementation class PayFinishServlet
 */
@WebServlet("/PayFinishServlet")
public class PayFinishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayFinishServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NBigOrderBiz nBigOrderBiz = new NBigOrderBizImpl();
		NOrdersBiz nOrdersBiz = new NOrdersBizImpl();
		NHuancunBiz nHuancunBiz = new NHuancunBizImpl();
		List<NHuancun> allNHuancun = nHuancunBiz.getHuancun();
		int length=allNHuancun.size()-1;
		String BOID =allNHuancun.get(length).getBOID();
		String CID=allNHuancun.get(length).getCID();
		NCustomerBiz customerBiz = new NCustomerBizImpl();
		List<Customer> customers = customerBiz.getUsers();
		String sql = "update bigorder set state ='待发货' where BOID = '"+BOID+"';";	
		nBigOrderBiz.exceuteUpdate(sql);
		String sql2 = "update orders set state ='待发货' where BOID = '"+BOID+"';";	
		nOrdersBiz.exceuteUpdate(sql2);
		Customer customer = null;
		for(int i=0;i<customers.size();i++) {
			if(CID.equals(customers.get(i).getId())) {	
				customer = customers.get(i);
			}
		}
		HttpSession session=request.getSession();
		session.setAttribute("loginUser",customer);
		response.sendRedirect("Npay_success.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
