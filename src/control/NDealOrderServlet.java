package control;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.NBigOrderBiz;
import biz.NBigOrderBizImpl;
import biz.NHuancunBiz;
import biz.NHuancunBizImpl;
import biz.NOrdersBiz;
import biz.NOrdersBizImpl;
import biz.NRinformationBiz;
import biz.NRinformationBizImpl;
import biz.NShoppingCartBiz;
import biz.NShoppingCartBizImpl;
import entity.Customer;
import new_entity.NShoppingCart_Book;

/**
 * Servlet implementation class NDealOrderServlet
 */
@WebServlet("/NDealOrderServlet")
public class NDealOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NDealOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Customer customer = (Customer) session.getAttribute("loginUser");
		if(customer != null) {
			String keywords = customer.getId();
			String name=request.getParameter("username");
			String phone=request.getParameter("phone");
			String address=request.getParameter("detailAddress");
			String remarks=request.getParameter("remarks");
			String sql = "insert into rinformation(CID,NAME,PHONENUM,ADDRESS,STATE) values('"+keywords+"','"+name+"','"+phone+"','"+address+"',1);";	
			NRinformationBiz nRinformationBiz = new NRinformationBizImpl();
			NBigOrderBiz nBigOrderBiz = new NBigOrderBizImpl();
			NOrdersBiz nOrdersBiz = new NOrdersBizImpl();
			int rid = nRinformationBiz.exceuteUpdate(sql);
			@SuppressWarnings("unchecked")
			List<NShoppingCart_Book> shoppingCart = (List<NShoppingCart_Book>) session.getAttribute("allshoppingCarts");
			TimeNumberUtils timeNumberUtils = new TimeNumberUtils();
			String BOID = timeNumberUtils.BOID(keywords);
			String sql2 = "insert into bigorder(BOID,RID,CID,STATE) values('"+BOID+"',"+rid+",'"+keywords+"','待付款');";	
			nBigOrderBiz.exceuteUpdate(sql2);
			SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
			sdf.applyPattern("yyyy-MM-dd HH:MM:ss");// a为am/pm的标记
			Calendar calendar = Calendar.getInstance();
			String sql3 = "";
			String oid = "";
			String creattime ="";
			String zdtime ="";
			float totolprice=0;
			 String sql4;
			  NShoppingCartBiz nShoppingCartBiz = new NShoppingCartBizImpl();
			  NHuancunBiz nHuancunBiz = new NHuancunBizImpl();
			for(int i=0;i<shoppingCart.size();i++) {
				oid = timeNumberUtils.OID(keywords)+i;
				Date date = new Date();// 获取当前时间
				creattime = sdf.format(date);
				calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + 7);
			    Date today = calendar.getTime();
			    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
			    zdtime = format.format(today);
			    sql3 = "insert into orders(OID,BOID,ISBN,PRICE,CREATTIME,ZDTIME,REMARKS,STATE,NUM) values('"+oid+"','"+BOID+"','"+shoppingCart.get(i).getnBook_SalesBook().getISBN()+"',"+shoppingCart.get(i).getTotolprice()+",'"+creattime+"','"+zdtime+"','"+remarks+"','待付款',"+shoppingCart.get(i).getNum()+");";
			    nOrdersBiz.exceuteUpdate(sql3);
			    totolprice+=shoppingCart.get(i).getTotolprice();
			    sql4 = "delete from shoppingcart where ID="+shoppingCart.get(i).getId()+";";
				nShoppingCartBiz.exceuteUpdate(sql4);
			}
			DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
			String totolString = decimalFormat.format(totolprice);//format 返回的是字符串
			String sql5 = "insert into huancun(BOID,CID) values('"+BOID+"','"+keywords+"');";
			//System.out.println(sql5);
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
