package beans;

public class IndexEntity {
	
	private String loginId;
	private String loginPassword;
	private boolean kanriFlg;
	
	//コンストラクタ
	public IndexEntity(){
		
	}
	
	public IndexEntity(String id){
		this.loginId = id;
	} 
	
	public IndexEntity(String id,String password){
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
