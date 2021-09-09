package control;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SendEmail;

/**
 * Servlet implementation class GetMial
 */
@WebServlet("/GetMial")
public class GetMial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetMial() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		if(email==null) {
			email=request.getParameter("email1");
		}
		System.out.println("���յ���������   "+email);
		
		SendEmail sendEmail=new SendEmail();
		//����Ҫ���͵�����
		sendEmail.setReceiveMailAccount(email);
		//����5λ����֤��
		Random random=new Random();
		String str="";
		for(int i=0;i<5;i++) {
			int n=random.nextInt(10);
			str+=n;
		}
		sendEmail.setInfo(str);
		HttpSession s = request.getSession(); 
		s.setAttribute("str", str);
		System.out.println("���͵���֤��Ϊ��"+str);
		try {
			sendEmail.Send();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
