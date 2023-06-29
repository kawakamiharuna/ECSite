package jp.co.aforce.cart;

import java.io.IOException;
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

@WebServlet(urlPatterns = { "/cartAdd/cartAdd" })

public class CartAdd extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int NO = Integer.parseInt(request.getParameter("NO"));

		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		//新しいカートの作成
		if (cart == null) {
			cart = new ArrayList<>();
			session.setAttribute("cart", cart);
		}
		//カートの重複確認
		boolean count = false;
		for (Item cartItem : cart) {
			if (cartItem.getNO() == NO) {
				//カート内に存在する場合個数を増やす
				cartItem.setQuantity(cartItem.getQuantity() + 1);
				count = true;
				break;
			}
		}

		//重複がないとき
		if (!count) {
		   try { // カートに新しく商品を追加
			ItemDAO dao = new ItemDAO();
		   List<Item> list = dao.getItemById(NO);
		   if(!list.isEmpty()) {
			   Item newItem = list.get(0);
		    newItem.setQuantity(1);
		    cart.add(newItem);
		}
		   } catch(Exception e) {
			   e.printStackTrace();
		   }
		   }

		// カートにアイテムを追加した後カート一覧に飛ぶ
		response.sendRedirect("../views/cart.jsp");

	}
}