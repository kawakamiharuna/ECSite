package jp.co.aforce.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.Member;
import jp.co.aforce.dao.LoginDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns = { "/login/login"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		HttpSession session=request.getSession();

		String USER_NAME=request.getParameter("USER_NAME");
		String PASSWORD=request.getParameter("PASSWORD");

		LoginDAO dao=new LoginDAO();
		Member i;
		try {
			i = dao.search(USER_NAME, PASSWORD);
			if (i != null) {
				session.setAttribute("i", i);
				request.getRequestDispatcher("../views/final.jsp").forward(request, response);
			}else {
				session.setAttribute("nologin", "ユーザ名もしくはパスワードが違います!");
				response.sendRedirect("../views/preview.jsp");
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		
	}


}
