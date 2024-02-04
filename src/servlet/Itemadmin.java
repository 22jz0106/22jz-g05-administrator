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
	    request.setAttribute("list", list);
	   
	    
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
