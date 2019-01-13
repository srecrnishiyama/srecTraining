package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Const.Path;
import beans.SessionKanriBean;
import beans.SyainSeibetsuEntity;
import control.SyainSeibetsuDAO;

@WebServlet("/SyainJouhouSeibetsuAction")
public class SyainJouhouSeibetsuAction extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 直接アクセスがあった場合、ログイン画面に遷移させる
		RequestDispatcher dispatcher = request
				.getRequestDispatcher(Path.LOGIN_GAMEN);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// ログインしているのか確認するため、セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		SessionKanriBean sessionKanriBean = (SessionKanriBean) session
				.getAttribute(Path.SESSION_SCOPE_NAME);

		if (sessionKanriBean == null) {
			// ログインしていない場合リダイレクト
			response.sendRedirect(request.getContextPath() + Path.LOGIN_GAMEN);
		} else {
			// セッションスコープにインスタンスを保存
			SyainSeibetsuDAO syainSeibetsuDAO = new SyainSeibetsuDAO();
			List<SyainSeibetsuEntity> syainSeibetsuEntityList = syainSeibetsuDAO
					.findSeibetsu(syainSeibetsuDAO);
			request.setAttribute(Path.SESSION_SCOPE_NAME,
					syainSeibetsuEntityList);
			// 結果出力画面(ResultSyainJouhouAll.jsp)にフォワード
			RequestDispatcher dispatcher = request
					.getRequestDispatcher(Path.SEIBETSU_PATH);
			dispatcher.forward(request, response);
		}

	}

}
