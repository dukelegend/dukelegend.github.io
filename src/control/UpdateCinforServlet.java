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
			 frame.setAlwaysOnTop(true);//将弹窗放在最前面
			 JOptionPane.showMessageDialog((Component)frame, "修改成功！您的账号为"+account+",请牢记！","注册结果", 2);
	        //JOptionPane.showMessageDialog(null, "注册成功！您的账号为"+valString+",请牢记！");
	        //out.print("<script>alert('注册成功！您的账号为''"+valString+"',请牢记！');window.location.href='NMainServlet'</script>");
		}
		
		else {
			//response.getWriter().write("<script language=javascript>alert('" +"注册失败，邮箱验证码不正确或该邮箱已被注册！"+ "')</script>");
			// out.print("<script>alert('注册失败，邮箱验证码不正确或该邮箱已被注册！')</script>");
			 Frame frame=new Frame();
			 frame.setAlwaysOnTop(true);//将弹窗放在最前面
			 JOptionPane.showMessageDialog((Component)frame, "修改失败，邮箱验证码不正确！","注册结果", 2);
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
