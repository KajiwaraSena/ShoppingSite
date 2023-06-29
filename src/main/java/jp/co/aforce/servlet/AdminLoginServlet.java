package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.AdminLogin;
import jp.co.aforce.dao.AdminLoginDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/servlet/adminloginservlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("../views/adminlogin.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();

		String admin_id=request.getParameter("admin_id");
		String password=request.getParameter("password");

		AdminLoginDAO dao=new AdminLoginDAO();
		AdminLogin Adminlogin;
		try {
			Adminlogin = dao.search(admin_id, password);
			if (Adminlogin != null) {
				session.setAttribute("Adminlogin", Adminlogin);
				session.setAttribute("login_status", "admin");
				request.getRequestDispatcher("/servlet/shoppingservlet2").forward(request, response);
			}else {
				session.setAttribute("errormsg", "ユーザIDもしくはパスワードが違います。");
				response.sendRedirect("../views/adminlogin.jsp");
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		
	}

}