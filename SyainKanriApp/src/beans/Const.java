package beans;

public class Const {
	
	//DB接続関連
	public static final class DBConst{
		
		public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
		public static final String JDBC_URL = "jdbc:mysql://localhost:3306/softrecsyainkanri?useSSL=false";//MySQLの設定の関係上SSL使用をFALSEに設定
		public static final String DB_USER = "nishiyama";
		public static final String DB_PASS = "password";
		
	}
	
	//遷移関連
	public static final class Path{
		
		public static final String MAIN_GAMEN = "/index.jsp";
		public static final String MAIN_GAMEN_PATH = "/SyainKanriApp/index.jsp";
		public static final String SYAIN_JOUHOU_ALL_PATH = "/WEB-INF/ResultSyainJouhouAll.jsp";
		public static final String SYAIN_JOUHOU_ALL_SCOPE = "syainJouhouAllEntityList";
		public static final String SEIBETSU_PATH = "/WEB-INF/ResultSyainJouhouSeibetsu.jsp";
		public static final String SEIBETSU_SCOPE = "syainSeibetsuEntityList";
		
	}

}
