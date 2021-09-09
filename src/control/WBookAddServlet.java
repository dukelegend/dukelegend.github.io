package control;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import biz.WBookBiz;

/**
 * Servlet implementation class WBookAddServlet
 */
@WebServlet("/WBookAddServlet")
public class WBookAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WBookAddServlet() {
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
		
		String isbn = null,name = null,author = null,press = null,image = null,booksize = null,publishtime = null;
		float price = 0;
		int addjudge=0;
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			
			DiskFileItemFactory factory = new DiskFileItemFactory();
			
			ServletFileUpload sfu = new ServletFileUpload(factory);
			sfu.setHeaderEncoding("utf-8");
	 
			
			List<FileItem> fileItemList = null;
			
				try {
					fileItemList = sfu.parseRequest(new ServletRequestContext(request));
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			Iterator<FileItem> fileItems = fileItemList.iterator();
			
			while (fileItems.hasNext()) {
				FileItem fileItem = fileItems.next();

				if (fileItem.isFormField()) {
					String filename = fileItem.getFieldName();// name属性值
					String value = fileItem.getString("utf-8");// name对应的value值
					if("isbn".equals(filename)) {
						isbn=value;
						
					}else if("name".equals(filename)) {
						name=value;
						
					}else if("price".equals(filename)) {
						price=Float.parseFloat(value);;
						
					}else if("size".equals(filename)) {
						booksize=value;
						
					}else if("publishDate".equals(filename)) {
						publishtime=value;
						
					}else if("press".equals(filename)) {
						press=value;
						
					}else if("author".equals(filename)) {
						author=value;
						
					}
					
				   } else {
						String fileName = fileItem.getName();// 文件名称
						String suffix = fileName.substring(fileName.lastIndexOf('.'));
						String newFileName = new Date().getTime() + suffix;
						String realpath=request.getServletContext().getRealPath("/upload/");
						
						image="upload/"+newFileName;
						
						addjudge=new WBookBiz().add(isbn, name, author, press,price , image, booksize, publishtime);
						if(addjudge>0) {
							File file = new File(realpath+newFileName);
							System.out.println(file.getAbsolutePath());
							try {
								fileItem.write(file);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				 
							fileItem.delete();
						}
					
				    }
		
			}

		}
		
		HttpSession s=request.getSession();
		s.setAttribute("judge",addjudge);
		response.sendRedirect("wBookAdd.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
