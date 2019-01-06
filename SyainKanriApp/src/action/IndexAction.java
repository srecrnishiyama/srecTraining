package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Const.Path;
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
		
		//IDが入力されていない場合、エラー画面に遷移
		if(id == null || "".equals(id)){
			// エラー画面に遷移
			RequestDispatcher dispatcher = request
					.getRequestDispatcher(Path.ERROR_GAMEN);
			dispatcher.forward(request, response);
			return;
		}
		
		//パスワードが入力されていない場合、エラー画面に遷移
		if(password == null || "".equals(password)){
			// エラー画面に遷移
			RequestDispatcher dispatcher = request
					.getRequestDispatcher(Path.ERROR_GAMEN);
			dispatcher.forward(request, response);
			return;
		}
		
		boolean errorFlg; //ログインIDパスワード存在チェック用 true = 存在 false = 存在しない
		
		CheckLogin checkLogin = new CheckLogin();
		
		errorFlg = checkLogin.checkLoginId(id);
		
		// ログインIDが存在しない場合はエラー画面に遷移
		if (errorFlg == false){
			// エラー画面に遷移
			RequestDispatcher dispatcher = request
					.getRequestDispatcher(Path.ERROR_GAMEN);
			dispatcher.forward(request, response);
		}
		
		errorFlg = checkLogin.checkLoginIdAndPassword(id, password);

		// ログインIDとパスワードが一致しない場合はエラー画面に遷移
		if (errorFlg == false) {
			// エラー画面に遷移
			RequestDispatcher dispatcher = request
					.getRequestDispatcher(Path.ERROR_GAMEN);
			dispatcher.forward(request, response);
		} else {
			// メイン画面に遷移
			RequestDispatcher dispatcher = request
					.getRequestDispatcher(Path.MAIN_GAMEN);
			dispatcher.forward(request, response);
		}
	}

}
