package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDAO;
import model.Item;

/**
 * Servlet implementation class ItemInfo
 */
@WebServlet("/Itemupdate")
public class Itemupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ItemDAO itemDAO = new ItemDAO();
		System.out.println(itemDAO);
		int num = Integer.parseInt(request.getParameter("id"));
		System.out.println(num);
		Item itemfind = itemDAO.find(num);
		request.setAttribute("item", itemfind);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text.html; charset=UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/update.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text.html; charset=UTF-8");
		
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
		
		System.out.println("stock : " + stock);
		System.out.println("color : " + color);
		
		ItemDAO item = new ItemDAO();
		item.update(productName,productCode,price,stock,FEATURED_PRODUCTS,description,size,color,image_url, PRODUCT_TYPE, new_item);
		
		doGet(request, response);
	}

}
