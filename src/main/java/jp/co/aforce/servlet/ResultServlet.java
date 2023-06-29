package jp.co.aforce.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.ShoppingDao;

/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/servlet/ResultServlet")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultServlet() {
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
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String product_id = request.getParameter("product_id");
		int purchased_num = Integer.parseInt(request.getParameter("quantity"));
		
		ShoppingDao dao = null;
		try {
			dao = new ShoppingDao();
			dao.updateItem(product_id, purchased_num);
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}finally {
			if(dao != null) {
				dao.close();
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("../views/result.jsp");
		rd.forward(request, response);
	}

}
