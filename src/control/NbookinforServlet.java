package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.NBook_SalesBookBiz;
import biz.NBook_SalesBookBizImpl;
import biz.NBooktypeBiz;
import biz.NBooktypeBizImpl;
import biz.NEvaluatesBiz;
import biz.NEvaluatesBizImpl;
import entity.BookType;
import entity.Evaluates;
import new_entity.NBook_SalesBook;

/**
 * Servlet implementation class NbookinforServlet
 */
@WebServlet("/NbookinforServlet")
public class NbookinforServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NbookinforServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(request.getParameter("BISBN")!=null){
			session.setAttribute("BISBN", request.getParameter("BISBN"));
		}
		String BISBN = (String) session.getAttribute("BISBN");
		NBook_SalesBookBiz nBookBiz=new NBook_SalesBookBizImpl();
		List<NBook_SalesBook> allBookByMHsearch = nBookBiz.getAll();
		List<NBook_SalesBook> recommendBookList = new ArrayList<NBook_SalesBook>();
		NBook_SalesBook nBook_SalesBook = null;
		NBooktypeBiz nBooktypeBiz = new NBooktypeBizImpl();
		List<BookType> allBookTypes = nBooktypeBiz.getBookTypes();
		String booktype = "";
		for(int i=0;i<allBookByMHsearch.size();i++) {
			if(allBookByMHsearch.get(i).getISBN().equals(BISBN)) {
				nBook_SalesBook = allBookByMHsearch.get(i);
				for(int j=0;j<allBookTypes.size();j++) {
					if(allBookTypes.get(j).getTypeid().equals(nBook_SalesBook.getTypeid())) {
						booktype = allBookTypes.get(j).getName();
					}
				}
			}
			if(i<3) {
				recommendBookList.add(allBookByMHsearch.get(i));
			}
		}
		NEvaluatesBiz nEvaluatesBiz = new NEvaluatesBizImpl();
		List<Evaluates> evaluates = nEvaluatesBiz.getall(nBook_SalesBook.getISBN());
		session.setAttribute("evaluates", evaluates);
		session.setAttribute("booktype", booktype);
		session.setAttribute("nBook_SalesBook", nBook_SalesBook);
		session.setAttribute("recommendBookList", recommendBookList);
		response.sendRedirect("Nbook_info.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
