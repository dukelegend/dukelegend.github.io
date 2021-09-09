package control;

import java.awt.Component;
import java.awt.Frame;
import java.io.IOException;
import java.util.List;
import java.util.Random;

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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unlikely-arg-type")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickname=request.getParameter("nickname");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String sex=request.getParameter("sex");
		HttpSession s = request.getSession(); 
		String mail=(String) s.getAttribute("str");
		String m=request.getParameter("nums");
		NCustomerBiz customerBiz = new NCustomerBizImpl();
		List<Customer> customers = customerBiz.getUsers();
		String valString=getRandomNickname(10);
		boolean flag = false;
		boolean emailflag = true;
		for (int i = 0; i < customers.size(); i++) {
			if(customers.get(i).equals(valString)) {
				flag = true;
			}
			if(customers.get(i).getEmail().equals(email)){
				emailflag = false;
			}
		}
		while(flag) {
			flag=false;
			valString=getRandomNickname(10);
			for (int i = 0; i < customers.size(); i++) {
				if(customers.get(i).equals(valString)) {
					flag = true;
				}
			}
		}
		if(m.equals(mail)&&emailflag) {
			String sql ="insert into customer values("+valString+",'"+password+"','"+name+"','"+nickname+"','"+sex+"','"+phone+"','"+email+"');";	
			 customerBiz.exceuteUpdate(sql);
			 Frame frame=new Frame();
			 frame.setAlwaysOnTop(true);//将弹窗放在最前面
			 JOptionPane.showMessageDialog((Component)frame, "注册成功！您的账号为"+valString+",请牢记！","注册结果", 2);
	        //JOptionPane.showMessageDialog(null, "注册成功！您的账号为"+valString+",请牢记！");
	        //out.print("<script>alert('注册成功！您的账号为''"+valString+"',请牢记！');window.location.href='NMainServlet'</script>");
		}
		
		else {

			//response.getWriter().write("<script language=javascript>alert('" +"注册失败，邮箱验证码不正确或该邮箱已被注册！"+ "')</script>");
			// out.print("<script>alert('注册失败，邮箱验证码不正确或该邮箱已被注册！')</script>");
			 Frame frame=new Frame();
			 frame.setAlwaysOnTop(true);//将弹窗放在最前面
			 JOptionPane.showMessageDialog((Component)frame, "注册失败，邮箱验证码不正确或该邮箱已被注册！","注册结果", 2);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	 public static String getRandomNickname(int length) {
		 String val = "";
		 Random random = new Random();
		 for (int i = 0; i < length; i++) {
		 val += String.valueOf(random.nextInt(10));
		 }
		 	return val;
	}


}
