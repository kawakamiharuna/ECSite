package jp.co.aforce.master;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class ItemRegister
 */
@WebServlet(urlPatterns = { "/itemRegist/itemReagist" })
public class ItemRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		Page.header(out);

		try {
			
			HttpSession session = request.getSession();

			String ITEM_NAME = request.getParameter("ITEM_NAME");
			String ENGLISH = request.getParameter("ENGLISH");
			String DERIVATION = request.getParameter("DERIVATION");
			int PRICE = Integer.parseInt(request.getParameter("PRICE"));
			String DATASHEET = request.getParameter("DATASHEET");
			String CATEGORY = request.getParameter("CATEGORY");
			String IMG = request.getParameter("IMG");
			
			
			//SQL実行時に使用するためBeanに格納
			Item i = new Item();
			i.setITEM_NAME(ITEM_NAME);
			i.setENGLISH(ENGLISH);
			i.setDERIVATION(DERIVATION);
			i.setPRICE(PRICE);
			i.setDATASHEET(DATASHEET);
			i.setCATEGORY(CATEGORY);
			i.setIMG(IMG);
			i.setQuantity(1);
			

			ItemDAO dao = new ItemDAO();
			int counts = dao.check(ITEM_NAME, ENGLISH, DERIVATION, PRICE, DATASHEET, CATEGORY, IMG);

			if (counts >= 1) {
				session.setAttribute("erroritem1", "この商品は既に追加済みです。");
				response.sendRedirect("../views/master/item-register.jsp");

			} else {

				int count = dao.insert(i);
				request.setAttribute("i", i);
				session.setAttribute("ITEM_NAME", ITEM_NAME);
				session.setAttribute("ENGLISH", ENGLISH);
				session.setAttribute("DERIVATION",DERIVATION);
				session.setAttribute("PRICE", PRICE);
				session.setAttribute("DATASHEET", DATASHEET);
				session.setAttribute("CATEGORY", CATEGORY );
				session.setAttribute("IMG",IMG);
				
				if(count > 0) {
					response.sendRedirect("../views/master/itemregist-in.jsp");
				}else {
					session.setAttribute("erroritem2","商品の追加に失敗しました。");
					response.sendRedirect("../views/master/itemregist.jsp");
				}

				
			}

		} catch (Exception e) {
			out.println("エラー" + e);
			e.printStackTrace();

		}
		Page.footer(out);

	}

}
