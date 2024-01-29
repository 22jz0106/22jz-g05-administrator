package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class CreateUser
 */
@WebServlet("/CreateUser")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/createUser.jsp");
		dispatcher.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ユーザを新規登録
		UserDAO dao = new UserDAO();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = dao.create(email, password);
		if (user != null) {
			// ログインしてトップページ（今回はVoD一覧）へリダイレクト
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
			response.sendRedirect("/VoDSystem_ex0801/VideoList");
		} else {
			// エラー時はエラーメッセージを追加し自分へ戻る
			request.setAttribute("msg", "ユーザの追加に失敗しました");
			doGet(request, response);
		}
	}

}
