package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.NStoreAddressBiz;
import biz.NStoreAddressBizImpl;
import biz.NreturnapplicationBiz;
import biz.NreturnapplicationBizImpl;
import entity.ReturnApplication;
import entity.StoreAddress;

/**
 * Servlet implementation class NdealreturnInforServlet
 */
@WebServlet("/NdealreturnInforServlet")
public class NdealreturnInforServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NdealreturnInforServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String BOID=request.getParameter("Qid");
		NStoreAddressBiz nStoreAddressBiz = new NStoreAddressBizImpl();
		List<StoreAddress> lstStoreAddress = nStoreAddressBiz.getStoreAddress();
		NreturnapplicationBiz nreturnapplicationBiz = new NreturnapplicationBizImpl();
		ReturnApplication returnApplication = nreturnapplicationBiz.get(BOID);
		StoreAddress storeAddress = null;
		for(int i=0;i<lstStoreAddress.size();i++) {
			if(lstStoreAddress.get(i).getTid().equals(returnApplication.getTid())) {
				storeAddress=lstStoreAddress.get(i);
			}
		}
		if(returnApplication.getSstate().equals("pending")) {
			returnApplication.setSstate("待处理");
		}else if (returnApplication.getSstate().equals("agree")) {
			returnApplication.setSstate("已同意");
		}else {
			returnApplication.setSstate("已拒绝");
		}
		if(returnApplication.getFstate().equals("pending")) {
			returnApplication.setFstate("待处理");
		}else if (returnApplication.getFstate().equals("agree")) {
			returnApplication.setFstate("已同意");
		}else {
			returnApplication.setFstate("已拒绝");
		}
		session.setAttribute("returnApplication", returnApplication);
		session.setAttribute("storeAddress", storeAddress);
	    response.sendRedirect("NWriteRInf.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
