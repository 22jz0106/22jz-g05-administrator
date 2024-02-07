package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class Itemadmin
 */
@WebServlet("/Orderadmin")
public class Orderadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // フォワード先のJSPのパスを指定
	    String forward = "/WEB-INF/jsp/order-admin.jsp"; 

	    OrderDAO dao = new OrderDAO();
	    UserDAO udao = new UserDAO();
	    List<model.Orderadmin> list = dao.getAllOrders();
	    List<User> user = null;
	    System.out.println(list);
	    for(model.Orderadmin li : list) {
	    	int id = li.getUser_id();
	    	System.out.println(id);
	    	System.out.println(li.getPayment_date());
	    	if(user == null) {
	    		user = udao.find(id);
	    	}
	    	user.addAll(udao.find(id));
	    }
	    for(User us : user) {
	    	System.out.println(us.getEmail());
	    }
	    request.setAttribute("user", user);
	    request.setAttribute("order", list);
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
