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
@WebServlet(urlPatterns={"/itemdel/itemdel"})
public class ItemDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
			//製品の識別
			String itemIndex = request.getParameter("deleteitem");
			@SuppressWarnings("unchecked")
			List<Item> itemList = (List<Item>)session.getAttribute("result");
			Item selected = itemList.get(Integer.parseInt(itemIndex));
			
			//String ITEM_NAME = (String) session.getAttribute("result");
			
			//製品の削除
			ItemDAO dao = new ItemDAO();
			int result = dao.delete(selected.getITEM_NAME());
			
			if(result > 0) {
				session.setAttribute("finish","製品の情報を削除しました");
				response.sendRedirect(response.encodeRedirectURL("../views/master/itemdelfin.jsp"));

			}else {
				session.removeAttribute("result");
				session.setAttribute("fail","製品の情報の削除に失敗しました");
				response.sendRedirect(response.encodeRedirectURL("../views/master/itemdelete.jsp"));			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("エラーでーす♡");
		}
		Page.footer(out);
		out.close();

		
	}

}
