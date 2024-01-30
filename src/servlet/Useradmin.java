package servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UseradminDAO;

@WebServlet("/Useradmin")
public class Useradmin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ログインチェックなどを実装する場合、ここで行う

        // ユーザー一覧を取得してJSPに渡す 
        UseradminDAO userDAO = new UseradminDAO();
        List<model.Useradmin> userlist = userDAO.getAllUsers();
        request.setAttribute("user",userlist);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/user-admin.jsp");
        dispatcher.forward(request, response);
    }
}
