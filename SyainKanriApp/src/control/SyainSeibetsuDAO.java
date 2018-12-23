package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.SyainSeibetsuEntity;

public class SyainSeibetsuDAO extends DBConnection{
	
	public List<SyainSeibetsuEntity> findAll(SyainSeibetsuDAO syainKanriDAO){
	
	List<SyainSeibetsuEntity> syainSeibetsuEntityList = new ArrayList<SyainSeibetsuEntity>();
	
	Connection conn = null;
	
	try{
		//JDBCドライバを読み込み
		super.loadJDBCDriver();
		
		//DBへ接続
		conn = super.connectionDB(conn);
		
		//SELECT文を準備
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id,name,seibetsu");
		sql.append(" FROM meibo;");
		
		PreparedStatement pStmt = conn.prepareStatement(sql.toString());
		
		//SELECTを実行し、結果表を取得
		ResultSet rs = pStmt.executeQuery();
		
		//結果表に格納されたレコードの内容をSyainBeanインスタンスに設定し、ArrayListインスタンスに追加
		while(rs.next()){
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String seibetsu = rs.getString("seibetsu");
			
			SyainSeibetsuEntity syainSeibetsuEntityAdd = new SyainSeibetsuEntity(id,name,seibetsu);
			syainSeibetsuEntityList.add(syainSeibetsuEntityAdd);
		}
		
	}catch(SQLException e){
		e.printStackTrace();
		return null;
	}finally{
		//データベース切断
		if(conn != null){
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
				return null;
			}
		}
	}
	return syainSeibetsuEntityList;
	
	}

}