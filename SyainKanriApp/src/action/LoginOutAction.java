package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Const.Path;

/**
 * Servlet implementation class LoginOutAction
 */
@WebServlet("/LoginOutAction")
public class LoginOutAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginOutAction() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//セッションを破棄
		HttpSession session = request.getSession();
		session.removeAttribute(Path.SESSION_SCOPE_NAME);
		session.invalidate();

		//ログイン画面に遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher(Path.LOGIN_GAMEN);
		dispatcher.forward(request, response);

	}

}
