package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PurchaseHistoryDAO;
import model.Ph;
import model.User;

/**
 * Servlet implementation class PurchaseHistoryDAO
 */
@WebServlet("/PurchaseHistory")
public class PurchaseHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PurchaseHistoryDAO dao = new PurchaseHistoryDAO();
		int user_id = ((User) request.getSession().getAttribute("loginUser")).getId();
		List<Ph> list = dao.findByPh(user_id);
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/buy_log.jsp");
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
