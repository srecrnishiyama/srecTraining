package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Const.ERRORMSG;
import beans.Const.Path;
import beans.SessionKanriBean;
import beans.SyainJouhouAllEntity;
import control.IndexDAO;
import control.SyainJouhouAllDAO;

@WebServlet("/SyainJouhouAllAction")
public class SyainJouhouAllAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 直接アクセスがあった場合、ログイン画面に遷移させる
		RequestDispatcher dispatcher = request.getRequestDispatcher(request
				.getContextPath() + Path.LOGIN_GAMEN);
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

		    //該当IDの管理者フラグを呼び出す
		    List<String> resultList = new ArrayList<String>();
		    String kanriFlg = null;

		    IndexDAO indexDAO = new IndexDAO();

		    resultList = indexDAO.getSessionInfo(sessionKanriBean.getLoginId(), sessionKanriBean.getLoginPassword());

		    kanriFlg = resultList.get(2);

		    //管理フラグがFALSEの場合、管理者権限ではないためシステムエラー画面に遷移させる
		    if(!kanriFlg.equals("1")) {
	            //エラーメッセージを格納
	            request.setAttribute("ERRMSG", ERRORMSG.ERR_5);
	            // エラー画面に遷移
	            RequestDispatcher dispatcher = request
	                    .getRequestDispatcher(Path.SYSTEM_ERROR_GAMEN);
	            dispatcher.forward(request, response);
		    }

			// セッションスコープにインスタンスを保存
			SyainJouhouAllDAO syainJouhouAllDAO = new SyainJouhouAllDAO();
			List<SyainJouhouAllEntity> syainJouhouAllEntityList = syainJouhouAllDAO
					.findAll(syainJouhouAllDAO);
			request.setAttribute(Path.SESSION_SCOPE_NAME,
					syainJouhouAllEntityList);
			// 結果出力画面(ResultSyainJouhouAll.jsp)にフォワード
			RequestDispatcher dispatcher = request
					.getRequestDispatcher(Path.SYAIN_JOUHOU_ALL_PATH);
			dispatcher.forward(request, response);
		}
	}
}