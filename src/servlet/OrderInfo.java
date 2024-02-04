package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDAO;
import dao.OrderDAO;
import dao.UseradminDAO;

/**
 * Servlet implementation class OrderItem
 */
@WebServlet("/OrderItem")
public class OrderInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/order-info-admin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text.html; charset=UTF-8");
		
		OrderDAO order = new OrderDAO();
		ItemDAO item = new ItemDAO();
		UseradminDAO useradmin = new UseradminDAO();
		
		String productName = request.getParameter("productName");
		String productCode = request.getParameter("productCode");
		String price = request.getParameter("price");
		String stock = request.getParameter("stockQuantity");
		String FEATURED_PRODUCTS = request.getParameter("FEATURED_PRODUCTS");
		String description = request.getParameter("description");
		String size = request.getParameter("size");
		String color = request.getParameter("color");
		String image_url = request.getParameter("image_url");
		String PRODUCT_TYPE = request.getParameter("PRODUCT_TYPE");
		String new_item = request.getParameter("new_item");
		
		Object UserName = request.getParameter("UserName");
		Object PriceSUM = request.getParameter("PriceSUM");
		Object ItemSUM = request.getParameter("ItemSUM");
		Object PaymentStatus = request.getParameter("PaymentStatus");
		item.set(productName,productCode,price,stock,FEATURED_PRODUCTS,description,size,color,image_url, PRODUCT_TYPE, new_item);
		
		
	}

}
