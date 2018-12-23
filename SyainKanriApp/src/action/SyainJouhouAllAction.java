package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Const.Path;
import beans.SyainJouhouAllEntity;
import control.SyainJouhouAllDAO;

@WebServlet("/SyainJouhouAllAction")
public class SyainJouhouAllAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// リクエストスコープにインスタンスを保存
		SyainJouhouAllDAO syainJouhouAllDAO = new SyainJouhouAllDAO();
		List<SyainJouhouAllEntity> syainJouhouAllEntityList = syainJouhouAllDAO
				.findAll(syainJouhouAllDAO);
		request.setAttribute(Path.SYAIN_JOUHOU_ALL_SCOPE,
				syainJouhouAllEntityList);

		// 結果出力画面(Result.jsp)にフォワード
		RequestDispatcher dispatcher = request
				.getRequestDispatcher(Path.SYAIN_JOUHOU_ALL_PATH);
		dispatcher.forward(request, response);

	}
}