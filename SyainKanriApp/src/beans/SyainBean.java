package beans;

import java.io.Serializable;

public class SyainBean implements Serializable {
	
	private int id;				//社員ID
	private String name;		//社員名
	private String yomigana;	//読み仮名（ローマ字）
	private String seibetsu;	//性別
	private String syussinn;	//出身地
	private String juusyo;		//現住所
	private int teate;			//住宅手当有無(0=なし 1=あり)
	private String job;			//職位
	private int salary;			//年収
	private int nyuusya;		//入社年月
	private int kinzoku;		//勤続年数
	
	//コンストラクタ
	public SyainBean(){
		
	}
	
	//コンストラクタ（社員ID、名前、性別）
	public SyainBean(int id,String name,String seibetsu){
		this.id = id;
		this.name = name;
		this.seibetsu = seibetsu;
	}
	
	//アクセサメソッド
	/**
	 * idを取得します。
	 * @return id
	 */
	public int getId() {
	    return id;
	}

	/**
	 * idを設定します。
	 * @param id id
	 */
	public void setId(int id) {
	    this.id = id;
	}

	/**
	 * nameを取得します。
	 * @return name
	 */
	public String getName() {
	    return name;
	}

	/**
	 * nameを設定します。
	 * @param name name
	 */
	public void setName(String name) {
	    this.name = name;
	}

	/**
	 * yomiganaを取得します。
	 * @return yomigana
	 */
	public String getYomigana() {
	    return yomigana;
	}

	/**
	 * yomiganaを設定します。
	 * @param yomigana yomigana
	 */
	public void setYomigana(String yomigana) {
	    this.yomigana = yomigana;
	}

	/**
	 * seibetsuを取得します。
	 * @return seibetsu
	 */
	public String getSeibetsu() {
	    return seibetsu;
	}

	/**
	 * seibetsuを設定します。
	 * @param seibetsu seibetsu
	 */
	public void setSeibetsu(String seibetsu) {
	    this.seibetsu = seibetsu;
	}

	/**
	 * syussinnを取得します。
	 * @return syussinn
	 */
	public String getSyussinn() {
	    return syussinn;
	}

	/**
	 * syussinnを設定します。
	 * @param syussinn syussinn
	 */
	public void setSyussinn(String syussinn) {
	    this.syussinn = syussinn;
	}

	/**
	 * juusyoを取得します。
	 * @return juusyo
	 */
	public String getJuusyo() {
	    return juusyo;
	}

	/**
	 * juusyoを設定します。
	 * @param juusyo juusyo
	 */
	public void setJuusyo(String juusyo) {
	    this.juusyo = juusyo;
	}

	/**
	 * teateを取得します。
	 * @return teate
	 */
	public int getTeate() {
	    return teate;
	}

	/**
	 * teateを設定します。
	 * @param teate teate
	 */
	public void setTeate(int teate) {
	    this.teate = teate;
	}

	/**
	 * jobを取得します。
	 * @return job
	 */
	public String getJob() {
	    return job;
	}

	/**
	 * jobを設定します。
	 * @param job job
	 */
	public void setJob(String job) {
	    this.job = job;
	}

	/**
	 * salaryを取得します。
	 * @return salary
	 */
	public int getSalary() {
	    return salary;
	}

	/**
	 * salaryを設定します。
	 * @param salary salary
	 */
	public void setSalary(int salary) {
	    this.salary = salary;
	}

	/**
	 * nyuusyaを取得します。
	 * @return nyuusya
	 */
	public int getNyuusya() {
	    return nyuusya;
	}

	/**
	 * nyuusyaを設定します。
	 * @param nyuusya nyuusya
	 */
	public void setNyuusya(int nyuusya) {
	    this.nyuusya = nyuusya;
	}

	/**
	 * kinzokuを取得します。
	 * @return kinzoku
	 */
	public int getKinzoku() {
	    return kinzoku;
	}

	/**
	 * kinzokuを設定します。
	 * @param kinzoku kinzoku
	 */
	public void setKinzoku(int kinzoku) {
	    this.kinzoku = kinzoku;
	}
	
}
