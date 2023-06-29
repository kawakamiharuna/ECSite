package jp.co.aforce.kidney;

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
 * Servlet implementation class HeartItem
 */
@WebServlet(urlPatterns={"/kidneyitem/kidneyitem"})
public class KidneyItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		Page.header(out);
		
		HttpSession session = request.getSession();
		
		try {
			ItemDAO dao = new ItemDAO();
			List<Item> list = dao.searchKidney("");
			
			session.setAttribute("list", list);
			
			response.sendRedirect("../views/kidney/kidneyitem.jsp");
			
		} catch (Exception e) {
			e.printStackTrace(out);
			out.println("de-tanasi");
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
