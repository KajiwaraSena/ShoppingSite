package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.ItemBean;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/servlet/insertservlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		
		try {
			request.setCharacterEncoding(("UTF-8"));
			ItemBean itembean = new ItemBean();
			
			itembean.setProduct_Id(request.getParameter("product_id"));
			itembean.setName(request.getParameter("name"));
			itembean.setPrice(Integer.parseInt(request.getParameter("price")));
			itembean.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			
			ProductDao objDao4 = new ProductDao();
			
			int count = objDao4.insert(itembean);
			
			request.setAttribute("count", count);
			
		}catch (IllegalStateException e) {
			error ="DB接続エラーのため、登録できませんでした";
			e.printStackTrace();
			
		}catch (Exception e) {
			error = "予期せぬエラーが発生しました。<br>"+e;
		}finally {
			request.setAttribute("error", error);
			request.getRequestDispatcher("../views/insertReceipt.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
