package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.IndexEntity;

public class IndexDAO extends DBConnection {

	public String findLoginId(String pLoginId) {

		Connection conn = null;
		String loginId = null;

		try {

			// JDBCドライバを読み込み
			super.loadJDBCDriver();

			// DBへ接続
			conn = super.connectionDB(conn);

			// SELECT文を準備
			StringBuilder sql = new StringBuilder();

			sql.append("SELECT loginid,loginpass");
			sql.append(" FROM login");
			sql.append(" WHERE loginid = ?;");

			PreparedStatement pStmt = conn.prepareStatement(sql.toString());
			pStmt.setString(1, pLoginId);

			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				loginId = rs.getString("loginid");
			}

			IndexEntity indexEntity = new IndexEntity(loginId);

			indexEntity.setLoginId(loginId);

			loginId = indexEntity.getLoginId();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// データベース切断
			super.closeDB(conn);
		}

		return loginId;
	}

	public List<String> findLoginIdAndPassword(String pLoginId,
			String pLoginPassword) {

		Connection conn = null;
		List<String> indexEntityList = new ArrayList<String>();

		try {
			// JDBCドライバ読み込み
			super.loadJDBCDriver();

			// DBへ接続
			conn = super.connectionDB(conn);

			// SELECT文を準備
			StringBuilder sql = new StringBuilder();

			sql.append("SELECT loginid,loginpass");
			sql.append(" FROM login");
			sql.append(" WHERE loginid = ? AND loginpass = ?;");

			PreparedStatement pStmt = conn.prepareStatement(sql.toString());
			pStmt.setString(1, pLoginId);
			pStmt.setString(2, pLoginPassword);

			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			String loginId = null;
			String loginPassword = null;

			while (rs.next()) {
				loginId = rs.getString("loginid");
				loginPassword = rs.getString("loginpass");
			}

			IndexEntity indexEntity = new IndexEntity(loginId, loginPassword);

			indexEntity.setLoginId(loginId);
			indexEntity.setLoginPassword(loginPassword);

			indexEntityList.add(indexEntity.getLoginId());
			indexEntityList.add(indexEntity.getLoginPassword());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.closeDB(conn);
		}

		return indexEntityList;
	}
}
