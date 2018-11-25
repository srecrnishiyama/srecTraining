package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static beans.Const.DBConst;

public class DBConnection {
	
	public static void loadJDBCDriver(){
		//JDBCドライバを読み込み
		try {
			Class.forName(DBConst.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection connectionDB(Connection conn){
		//データベースへ接続
		try {
			conn = DriverManager.getConnection(DBConst.JDBC_URL,DBConst.DB_USER,DBConst.DB_PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}
