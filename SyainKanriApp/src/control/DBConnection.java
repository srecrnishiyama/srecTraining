package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import beans.Const.DBConst;

public class DBConnection {
	
	//DB読み込み用メソッド
	public static void loadJDBCDriver(){
		//JDBCドライバを読み込み
		try {
			Class.forName(DBConst.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//DB接続用メソッド
	public static Connection connectionDB(Connection conn){
		//データベースへ接続
		try {
			conn = DriverManager.getConnection(DBConst.JDBC_URL,DBConst.DB_USER,DBConst.DB_PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	//DB切断用メソッド
	public static void closeDB(Connection conn){
		//データベース切断
		if(conn != null){
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();

			}
		}
	}

}
