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
import beans.SyainSeibetsuEntity;
import control.SyainSeibetsuDAO;

@WebServlet("/SyainJouhouSeibetsuAction")
public class SyainJouhouSeibetsuAction extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//メイン画面に遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher(Path.MAIN_GAMEN);
		dispatcher.forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストスコープにインスタンスを保存
		SyainSeibetsuDAO syainSeibetsuDAO = new SyainSeibetsuDAO();
		List<SyainSeibetsuEntity> syainSeibetsuEntityList = syainSeibetsuDAO.findAll(syainSeibetsuDAO);
		request.setAttribute(Path.SEIBETSU_SCOPE, syainSeibetsuEntityList);
		
		//結果出力画面(Result.jsp)にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(Path.SEIBETSU_PATH);
		dispatcher.forward(request, response);

	}

}
