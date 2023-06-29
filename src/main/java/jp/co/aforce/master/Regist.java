package jp.co.aforce.master;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.Member;
import jp.co.aforce.dao.MemberDAO;
import jp.co.aforce.tool.Page;

/**
 * Servlet implementation class Regist
 */
@WebServlet(urlPatterns = { "/regist/regist" })
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Regist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("../views/registration.jsp").forward(request, response);}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		Page.header(out);

		//HttpSession session = request.getSession();

		try {
			MemberDAO dao = new MemberDAO();
			Member mi = new Member();
			HttpSession session = request.getSession();
			
			String USER_NAME= request.getParameter("USER_NAME");
			String PASSWORD = request.getParameter("PASSWORD");
			String NAME= request.getParameter("NAME");
			String BIRTHDAY = request.getParameter("BIRTHDAY");

			String MAIL= request.getParameter("MAIL");
			String TEL = request.getParameter("TEL");
			String POSTAL_CODE = request.getParameter("POSTAL_CODE");
			String ADDRESS1 = request.getParameter("ADDRESS1");
			String ADDRESS2 = request.getParameter("ADDRESS2");
			String ADDRESS3 = request.getParameter("ADDRESS3");
			
			mi.setUSER_NAME(USER_NAME);
			mi.setPASSWORD(PASSWORD);
			mi.setNAME(NAME);
			mi.setBIRTHDAY(BIRTHDAY);
			mi.setMAIL(MAIL);
			mi.setTEL(TEL);
			mi.setPOSTAL_CODE(POSTAL_CODE);
			mi.setADDRESS1(ADDRESS1);
			mi.setADDRESS2(ADDRESS2);
			mi.setADDRESS3(ADDRESS3);
			
			
			
			if(TEL.length() > 11) {
				session.setAttribute("error1", "電話番号が間違っています！");
				response.sendRedirect("../views/registration.jsp");
			}
			
			if(POSTAL_CODE.length() != 7) {
				session.setAttribute("error2", "郵便番号が間違っています！");
				response.sendRedirect("../views/registration.jsp");
			}

			int counts = dao.check(USER_NAME, PASSWORD, NAME, BIRTHDAY, MAIL, TEL, POSTAL_CODE,  ADDRESS1, ADDRESS2, ADDRESS3);
			int countPass = dao.checkpass(PASSWORD);
		

			if (counts >= 1) {
				session.setAttribute("error3", "この会員情報はすでに存在します!");
				response.sendRedirect("../views/registration.jsp");
			}else if(countPass >= 1) {
				session.setAttribute("errorpass"," このパスワードは無効です");
				response.sendRedirect("../views/registration.jsp");

			} else {

				dao.insert(mi);
				request.setAttribute("mi", mi);
				session.setAttribute("USER_NAME", USER_NAME);
				session.setAttribute("PASSWORD", PASSWORD);
				session.setAttribute("NAME",NAME);
				session.setAttribute("BIRTHDAY", BIRTHDAY);
				session.setAttribute("MAIL", MAIL);
				session.setAttribute("TEL",TEL);
				session.setAttribute("POSTAL_CODE", POSTAL_CODE);
				session.setAttribute("ADDRESS1", ADDRESS1);
				session.setAttribute("ADDRESS2", ADDRESS2);
				session.setAttribute("ADDRESS3", ADDRESS3);
				

				response.sendRedirect("../views/registration-in.jsp");
			}

		} catch (Exception e) {
			out.println("エラー" + e);
			e.printStackTrace();

		}
		Page.footer(out);

	}

}
