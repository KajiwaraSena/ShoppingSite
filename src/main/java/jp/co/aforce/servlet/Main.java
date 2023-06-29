package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.cart.Cart;
import jp.co.aforce.cart.CartItem;
import jp.co.aforce.cart.CartLogic;

/**
 * Servlet implementation class Main
 */
@WebServlet("/servlet/main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("../views/cart.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String product_id=request.getParameter("product_id");
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		String quantity=request.getParameter("quantity");
		System.out.println(name);
		
		if(name.isEmpty() || price.isEmpty()) {
			request.setAttribute("err", "未記入の項目があります");
		}else {
			HttpSession session=request.getSession();
			Cart cart=(Cart)session.getAttribute("cart");
			if(cart==null) {
				cart=new Cart();
			}
			String test_id ="";
			int test_quantity =0;
			CartItem vege=new CartItem(test_id,name,Integer.parseInt(price),test_quantity);
			CartLogic logic=new CartLogic();
			logic.execute(cart, vege);
			session.setAttribute("cart",cart);
			request.setAttribute("msg", vege.getName()+"をカートに追加しました");
			
		
		}
		doGet(request, response);
	}

}
