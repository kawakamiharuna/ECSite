package jp.co.aforce.master;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.Item;
import jp.co.aforce.dao.ItemDAO;
import jp.co.aforce.tool.Page;

/**
 * Servlet implementation class ItemDelete
 */
@WebServlet(urlPatterns={"/itemdeletesearch/itemdeletesearch"})
public class ItemDeleteSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDeleteSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("../views/master/itemdelete.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		
		HttpSession session = request.getSession();

		try {
			
		String keyword = request.getParameter("ITEM_NAME");
		
			ItemDAO dao = new ItemDAO();
			List<Item> list = dao.search(keyword);

			session.setAttribute("list", list);

			response.sendRedirect("../views/master/itemdelete-in.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}
		
		//String keyword = request.getParameter("ITEM_NAME");
		
//		try {
//			//検索した製品の情報を取得
//			ItemDAO dao = new ItemDAO();
//			List<Item> result = dao.deletesearch(keyword);
//			
//			//検索結果の保存
//			HttpSession session = request.getSession();
//			session.setAttribute("result", result);
//			
//			if(result != null && !result.isEmpty()) {
//				response.sendRedirect("../views/master/itemdelete-in.jsp");
//			} else {
//				session.setAttribute("noitem", "該当する製品はありません");
//				response.sendRedirect("../views/master/itemdelete.jsp");
//				}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//
//}
