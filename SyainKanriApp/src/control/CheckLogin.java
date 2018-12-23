package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckLogin extends DBConnection {

	public boolean checkLoginId(Connection conn,String pLoginId) {

		super.loadJDBCDriver();

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT loginid");
		sql.append(" FROM login");
		sql.append(" WHERE loginid = ?;");

		try {
			PreparedStatement pStmt = conn.prepareStatement(sql.toString());

			pStmt.setString(1, pLoginId);
			
			ResultSet rs = pStmt.executeQuery();
			
			String id = null;
			
			while(rs.next()){
				
				id = rs.getString("loginid");
				
			}
			
			if(id != "" && !(id.equals(null))){
				return true;
			}else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean checkPassword(String pLoginId, String pLoginPassword) {

		String loginId;
		String loginPassword;

		return true;

	}

}
