package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.AuthLogic;
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// すでにログイン済みならビデオ一覧へリダイレクト
		User loginUser = (User)request.getSession().getAttribute("loginUser");
		if (loginUser != null) {//loginユーザがnullではないならすでにログイン済み
			response.sendRedirect("VideoList");
		}
		
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログイン
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		AuthLogic logic = new AuthLogic();
		User user = logic.login(email, password);
		
		if (user != null) {
			// ログインしてトップページ（今回はVoD一覧）へリダイレクト
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
			response.sendRedirect("/user-admin.jsp");
		} else {
			// エラー時はエラーメッセージを追加し自分へ戻る
			request.setAttribute("msg", "ログインに失敗しました");
			doGet(request, response);
		}
	}

}
