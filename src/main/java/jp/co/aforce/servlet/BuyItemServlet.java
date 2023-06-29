package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.java.Shopping;

/**
 * Servlet implementation class BuyItemServlet
 */
@WebServlet("/servlet/buyitemservlet")
public class BuyItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> names = request.getParameterNames();
		
		String name;
		String product_id = "";
		String purchased_num;
		
		while(names.hasMoreElements()) {
			name = names.nextElement();
			
			if("購入".equals(request.getParameter(name))) {
				product_id = name;
			}
		}
		
		purchased_num = request.getParameter(product_id + "list");
		
		Shopping shopping = new Shopping();
		System.out.println("product_id:" + product_id);
		ItemBean item_bean = shopping.getItem(product_id);
		System.out.println("item_bean:" + item_bean);
		
		request.setAttribute("item_bean", item_bean);
		request.setAttribute("purchased_num", purchased_num);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("../views/purchase_confirm.jsp");
		rd.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
