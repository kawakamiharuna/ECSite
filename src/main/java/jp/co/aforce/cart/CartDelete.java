package jp.co.aforce.cart;

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
import jp.co.aforce.tool.Page;

/**
 * Servlet implementation class CartDelete
 */
@WebServlet("/cartDelete/cartDelete")
public class CartDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		
		//削除する商品の識別
		String deleteItemById = request.getParameter("delete");
		
		//商品の削除
		@SuppressWarnings("unchecked")
		List<Item> cart = (List<Item>)session.getAttribute("cart");
		if(cart != null) {
			for(Item cartItem : cart) {
				if(cartItem.getNO() == Integer.parseInt(deleteItemById)) {
					if(cartItem.getQuantity() > 1) {
						cartItem.setQuantity(cartItem.getQuantity() -1);
				}else {
					cart.remove(cartItem);
				}
					break;
				}
			}
		}
		session.removeAttribute(deleteItemById);
		
		//商品の一覧に戻る
		response.sendRedirect("../views/cart.jsp");
		
		
		
		
	}

}
