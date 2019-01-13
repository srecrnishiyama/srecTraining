package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Const.Common;
import beans.Const.Path;
import beans.SessionKanriBean;
import control.CheckLogin;

/**
 * Servlet implementation class IndexAction
 */
@WebServlet("/IndexAction")
public class IndexAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexAction() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String id;
		String password;

		id = request.getParameter("id");
		password = request.getParameter("password");

		// IDが入力されていない場合、エラー画面に遷移
		if (id == null || "".equals(id)) {
			// エラー画面に遷移
			RequestDispatcher dispatcher = request
					.getRequestDispatcher(Path.SYSTEM_ERROR_GAMEN);
			dispatcher.forward(request, response);
			return;
		}

		// パスワードが入力されていない場合、エラー画面に遷移
		if (password == null || "".equals(password)) {
			// エラー画面に遷移
			RequestDispatcher dispatcher = request
					.getRequestDispatcher(Path.SYSTEM_ERROR_GAMEN);
			dispatcher.forward(request, response);
			return;
		}

		boolean errorFlg; // ログインIDパスワード存在チェック用 true = 存在 false = 存在しない

		CheckLogin checkLogin = new CheckLogin();

		errorFlg = checkLogin.checkLoginId(id);

		// ログインIDが存在しない場合はエラー画面に遷移
		if (errorFlg == false) {
			// エラー画面に遷移
			RequestDispatcher dispatcher = request
					.getRequestDispatcher(Path.SYSTEM_ERROR_GAMEN);
			dispatcher.forward(request, response);
		}

		errorFlg = checkLogin.checkLoginIdAndPassword(id, password);

		// ログインIDとパスワードが一致しない場合はエラー画面に遷移
		if (errorFlg == false) {
			// エラー画面に遷移
			RequestDispatcher dispatcher = request
					.getRequestDispatcher(Path.SYSTEM_ERROR_GAMEN);
			dispatcher.forward(request, response);
		} else {
			// セッション情報を格納
			SessionKanriBean sessionKanriBean = new SessionKanriBean(id, password);
			
			// セッション情報の文字化け対策
			request.setCharacterEncoding(Common.ENCODE_UTF8);
			// セッション情報の取得
			HttpSession httpSession = request.getSession();
			// セッションスコープにログイン情報を保存
			httpSession.setAttribute(Path.SESSION_SCOPE_NAME, sessionKanriBean);

			// メイン画面に遷移
			RequestDispatcher dispatcher = request
					.getRequestDispatcher(Path.MAIN_GAMEN);
			dispatcher.forward(request, response);
		}
	}

}
