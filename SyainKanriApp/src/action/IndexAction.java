package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Const.Path;
import control.IndexDAO;

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
		
		if(id == null || "".equals(id)){
			// エラー画面に遷移
			RequestDispatcher dispatcher = request
					.getRequestDispatcher(Path.ERROR_GAMEN);
			dispatcher.forward(request, response);
			return;
		}
		
		if(password == null || "".equals(password)){
			// エラー画面に遷移
			RequestDispatcher dispatcher = request
					.getRequestDispatcher(Path.ERROR_GAMEN);
			dispatcher.forward(request, response);
			return;
		}
		
		boolean errorFlg;

		IndexDAO indexDao = new IndexDAO();
		errorFlg = indexDao.checkLoginId(id,password);

		// ログインIDとパスワードがテーブルに存在しない場合はエラー画面に遷移
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
