package beans;

import java.io.Serializable;


public class SessionKanriBean implements Serializable{
	
	private String loginId;			//ログインID
	private String loginPassword; 	//ログインパスワード
	private boolean kanriFlg;   	//管理フラグ(true=管理者権限あり　false=管理者権限なし)
	
	//コンストラクタ
	public SessionKanriBean(){
		
	}
	
	//コンストラクタ（id）
	public SessionKanriBean(String id){
		this.loginId = id;
	} 
	
	//コンストラクタ（id,password）
	public SessionKanriBean(String id,String password){
		this.loginId = id;
		this.loginPassword = password;
	}
	
	//アクセサメソッド
	public String getLoginId(){
		return loginId;
	}
	
	public void setLoginId(String id){
		this.loginId = id;
	}
	
	public String getLoginPassword(){
		return loginPassword;
	}
	
	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}

	public boolean isKanriFlg() {
	    return kanriFlg;
	}

	public void setKanriFlg(boolean kanriFlg) {
	    this.kanriFlg = kanriFlg;
	}

}
