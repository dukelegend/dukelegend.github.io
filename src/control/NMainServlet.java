package control;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.NBookBiz;
import biz.NBookBizImpl;
import biz.NBooktypeBiz;
import biz.NBooktypeBizImpl;
import biz.NSalesBookBiz;
import biz.NSalesBookBizImpl;
import entity.Book;
import entity.BookType;
import entity.SalesBook;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/NMainServlet")
public class NMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		NBookBiz nBookBiz=new NBookBizImpl();
		NSalesBookBiz nSalesBookBiz = new NSalesBookBizImpl();
		int count=nSalesBookBiz.getCount_con(1);
		int pageSize=4;
		int total=count%pageSize==0?count/pageSize:count/pageSize+1;
		int pageNum=1;
		if(request.getParameter("num")!=null){
			pageNum=Integer.parseInt(request.getParameter("num"));
		}
		if(pageNum<=0){
			pageNum=1;
		}else if(pageNum>total){
			pageNum=total;
		}		
		List<SalesBook> allSalesBook = nSalesBookBiz.getSalesBook();
		List<SalesBook> lstSalesBooks=nSalesBookBiz.getNewsByPage_con(pageNum, pageSize, 1);
		List<Book> allBook = nBookBiz.getBook();
		NBooktypeBiz nBooktypeBiz = new NBooktypeBizImpl();
		List<BookType> allBookTypes = nBooktypeBiz.getBookTypes();
		Properties prop = new Properties();
		try {
			//加载配置文件
			prop.load(new InputStreamReader(NMainServlet.class.getResourceAsStream("Storeinformation.properties"), "UTF-8"));         
		} catch (IOException e) {
			System.out.println("读取配置文件approver.properties失败！");
			throw new RuntimeException(e);
		}
		
		//从配置文件中获取信息
		String ZXDT = prop.getProperty("ZXDT");
		String XG = prop.getProperty("XG");
		String ZJGG = prop.getProperty("ZJGG");
		String CXTS = prop.getProperty("CXTS");
		String ZXDTs[] = ZXDT.split("\\r?\\n");
		String ZJGGs[] = ZJGG.split("\\r?\\n");
		String CXTSs[] = CXTS.split("\\r?\\n");
		HttpSession session=request.getSession();
		session.setAttribute("allSalesBook",allSalesBook);
		session.setAttribute("allSalesBookSize",allSalesBook.size());
		session.setAttribute("lstSalesBooks", lstSalesBooks);
		session.setAttribute("pageNum", pageNum);
		session.setAttribute("pageSize", pageSize);
		session.setAttribute("total", total);
		session.setAttribute("ZXDT",ZXDTs);
		session.setAttribute("ZJGG",ZJGGs);
		session.setAttribute("CXTS",CXTSs);
		session.setAttribute("XG",XG);
		session.setAttribute("allBook",allBook);
		session.setAttribute("booktypes",allBookTypes);
		response.sendRedirect("Nindex.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
