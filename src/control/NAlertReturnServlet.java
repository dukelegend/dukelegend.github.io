package control;

import java.awt.Component;
import java.awt.Frame;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import biz.NreturnapplicationBiz;
import biz.NreturnapplicationBizImpl;
import entity.ReturnApplication;

/**
 * Servlet implementation class NAlertReturnServlet
 */
@WebServlet("/NAlertReturnServlet")
public class NAlertReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NAlertReturnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String expressid=request.getParameter("expressid");
		ReturnApplication returnApplication = (ReturnApplication) session.getAttribute("returnApplication");
		NreturnapplicationBiz nreturnapplicationBiz = new NreturnapplicationBizImpl();
		String sql = "update returnapplication set EXPRESSID = '"+expressid+"' where ID = '"+returnApplication.getId()+"';";
		nreturnapplicationBiz.exceuteUpdate(sql);
		 Frame frame=new Frame();
		 frame.setAlwaysOnTop(true);//将弹窗放在最前面
		 JOptionPane.showMessageDialog((Component)frame, "修改成功！","注册结果", 2);
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
