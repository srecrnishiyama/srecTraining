package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.IndexEntity;

public class IndexDAO extends DBConnection {

	public boolean checkLoginId(String pLoginId,String pLoginPassword) {

		Connection conn = null;
		
		String id = null;
		String password = null;
		
		boolean result = false; 

		try {
			// JDBCドライバを読み込み
			super.loadJDBCDriver();

			// DBへ接続
			conn = super.connectionDB(conn);

			// SELECT文を準備
			StringBuilder sql1 = new StringBuilder();

			sql1.append("SELECT loginid,loginpass");
			sql1.append(" FROM login");
			sql1.append(" WHERE loginid = ?;");

			PreparedStatement pStmt1 = conn.prepareStatement(sql1.toString());
			pStmt1.setString(1,pLoginId);

			// SELECTを実行し、結果表を取得
			ResultSet rs1 = pStmt1.executeQuery();
			
			while(rs1.next()){
				id = rs1.getString("loginid");
			}
			
			IndexEntity indexEntity = new IndexEntity(id,password);
			
			indexEntity.setLoginId(id);
			
			// IDがDB内に存在しなかった場合エラー画面に遷移
			if(indexEntity.getLoginId() == null){
				result =  false;
			}
			
			// SELECT文を準備
			StringBuilder sql2 = new StringBuilder();

			sql2.append("SELECT loginid,loginpass");
			sql2.append(" FROM login");
			sql2.append(" WHERE loginid = ? AND loginpass = ?;");

			PreparedStatement pStmt2 = conn.prepareStatement(sql2.toString());
			pStmt2.setString(1,pLoginId);
			pStmt2.setString(2,pLoginPassword);

			// SELECTを実行し、結果表を取得
			ResultSet rs2 = pStmt2.executeQuery();
			
			while(rs2.next()){
				id = rs2.getString("loginid");
				password = rs2.getString("loginpass");
			}
			
			indexEntity.setLoginPassword(password);
			
			// DB内のパスワードがDB内のパスワードと異なる場合エラー画面に遷移
			if(indexEntity.getLoginPassword() == null){
				result =   false;
			}else{
				result =  true;
			}

		} catch (SQLException e) {
			System.out.println("stop");
			e.printStackTrace();
			result =  false;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
		
	}

}
