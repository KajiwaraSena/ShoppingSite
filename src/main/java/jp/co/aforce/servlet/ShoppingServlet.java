package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.java.Shopping;

/**
 * Servlet implementation class ShoppingServlet
 */
@WebServlet("/servlet/shoppingservlet")
public class ShoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      	 request.setCharacterEncoding("UTF-8");
      	 HttpSession session = request.getSession();
      	 String login_status = (String)session.getAttribute("login_status");
         
         // 商品一覧を取得
      	 Shopping shopping = new Shopping();
         ArrayList<ItemBean> item_list = shopping.getItem();
         System.out.println("item_list" + item_list);
         
         // 商品一覧をリクエストスコープの属性にセット
         request.setAttribute("itemList", item_list);
         if(login_status == "user") {
         // 商品一覧画面に移動
         RequestDispatcher rd = request.getRequestDispatcher("../views/main.jsp");
         rd.forward(request, response);      	 
         }else {
        	 RequestDispatcher rd = request.getRequestDispatcher("../views/adminmain.jsp");
             rd.forward(request, response); 
         }
         
	}

}
