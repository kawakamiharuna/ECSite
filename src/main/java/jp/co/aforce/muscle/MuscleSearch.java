package jp.co.aforce.muscle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
 * Servlet implementation class HeartSearch
 */
@WebServlet(urlPatterns = { "/musclesearch/musclesearch" })
public class MuscleSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MuscleSearch() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
		List<Item> list = new ArrayList<>();
		
		try {
			String keyword = request.getParameter("keywordMuscle");
			
			ItemDAO dao = new ItemDAO();
			list = dao.searchMuscle(keyword);
			
			session .setAttribute("list", list);
			
				response.sendRedirect("../views/muscle/muscle-in.jsp");
	
		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}

}