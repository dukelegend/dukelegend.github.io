package control;

import java.awt.Component;
import java.awt.Frame;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import biz.NCustomerBiz;
import biz.NCustomerBizImpl;
import entity.Customer;

/**
 * Servlet implementation class UpdateCinforServlet
 */
@WebServlet("/UpdateCinforServlet")
public class UpdateCinforServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCinforServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickname=request.getParameter("nickname1");
		String name=request.getParameter("name1");
		String phone=request.getParameter("phone1");
		String email=request.getParameter("email1");
		String password=request.getParameter("password1");
		String sex=request.getParameter("sex1");
		HttpSession s = request.getSession(); 
		String mail=(String) s.getAttribute("str");
		String m=request.getParameter("nums");
		NCustomerBiz customerBiz = new NCustomerBizImpl();
		String account=request.getParameter("account");
		if(m.equals(mail)) {
			String sql ="update customer set PASSWORD = '"+password+"',NAME = '"+name+"',NICKNAME = '"+nickname+"',SEX = '"+sex+"',PHONENUM = '"+phone+"',EMAIL = '"+email+"' where ID = '"+account+"';";	
			 customerBiz.exceuteUpdate(sql);
			 Frame frame=new Frame();
			 frame.setAlwaysOnTop(true);//������������ǰ��
			 JOptionPane.showMessageDialog((Component)frame, "�޸ĳɹ��������˺�Ϊ"+account+",���μǣ�","ע����", 2);
	        //JOptionPane.showMessageDialog(null, "ע��ɹ��������˺�Ϊ"+valString+",���μǣ�");
	        //out.print("<script>alert('ע��ɹ��������˺�Ϊ''"+valString+"',���μǣ�');window.location.href='NMainServlet'</script>");
		}
		
		else {
			//response.getWriter().write("<script language=javascript>alert('" +"ע��ʧ�ܣ�������֤�벻��ȷ��������ѱ�ע�ᣡ"+ "')</script>");
			// out.print("<script>alert('ע��ʧ�ܣ�������֤�벻��ȷ��������ѱ�ע�ᣡ')</script>");
			 Frame frame=new Frame();
			 frame.setAlwaysOnTop(true);//������������ǰ��
			 JOptionPane.showMessageDialog((Component)frame, "�޸�ʧ�ܣ�������֤�벻��ȷ��","ע����", 2);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
