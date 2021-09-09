package control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.HCompensatoryBiz;
import dao.HBillRecordsDao;
import dao.HCompensatoryDao;
import entity.Express;
import entity.ReturnApplication;

/**
 * Servlet implementation class UpdateExpressServlet
 */
@WebServlet("/UpdateExpressServlet")
public class UpdateExpressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateExpressServlet() {
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
		HttpSession session = request.getSession();
		session.removeAttribute("expresslist");

		HCompensatoryBiz comBiz = new HCompensatoryBiz();
		List<Express> list = comBiz.getExpresses();
		HBillRecordsDao billDao = new HBillRecordsDao();
		
		
		/*生成出账记录编号 */
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowdate = sdf.format(date);
		String[] datesp = nowdate.split(" ");
		String[] ymdsp = datesp[0].split("-");
		String[] sfmsp = datesp[1].split(":");
		String billid = ymdsp[0]+ymdsp[1]+ymdsp[2]+sfmsp[0]+sfmsp[1]+sfmsp[2];
		
		Float price = null;//出账记录金额
		String oid = null;//出账记录订单编号
		String billname = "����";
		boolean type =false;
		
		String id = request.getParameter("id");
		String state = request.getParameter("state");
		
		if (state.equals("true")) {//生成出账记录
			type = true;
			for (Express express : list) {
				if (express.getId().equals(id)) {
					price = express.getPrice();
					break;
				}
			}
			billDao.updateBillRecord(billid, billname, price, oid, nowdate);
		}
		HCompensatoryDao comDao =new HCompensatoryDao();
		comDao.updateExpress(id, type);
		
		
		response.sendRedirect("${pageContext.request.contextPath}/ExpressServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
