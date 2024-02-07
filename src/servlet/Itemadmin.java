package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDAO;
import model.Item;

/**
 * Servlet implementation class Itemadmin
 */
@WebServlet("/Itemadmin")
public class Itemadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // フォワード先のJSPのパスを指定
	    String forward = "/WEB-INF/jsp/item-admin.jsp"; 
	    
	    ItemDAO dao = new ItemDAO();
	    List<Item> list = dao.get();
	    System.out.println(list);
	    request.setAttribute("item_list", list);
	    for(Item item : list) {
	    	System.out.println(item.getItemName());
	    }
	   
	    
//	    System.out.println(((item) list).getItemID());
//	    for(item it : list) {
//	    	int name = it.getItemID();3
//	    	System.out.println("id:" + name);
//	    	request.setAttribute("name", name);
//	    	
//	    }
	    // フォワードを行う
	    RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
	    dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text.html; charset=UTF-8");
		String action = request.getParameter("action");
		if("add".equals(action)) {
		
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
		System.out.println(price);
		
		ItemDAO item = new ItemDAO();
		item.set(productName,productCode,price,stock,FEATURED_PRODUCTS,description,size,color,image_url, PRODUCT_TYPE, new_item);
		} else if ("delete".equals(action)) {
		    int itemId = Integer.parseInt(request.getParameter("itemId"));

		    ItemDAO dao = new ItemDAO();
		    dao.deleteItem(itemId);
		}

		response.sendRedirect("Itemadmin");
		doGet(request, response);
	}
}
