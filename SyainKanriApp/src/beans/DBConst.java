package beans;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBConst {

	//コンストラクタ
	public DBConst() {

	}
	//プロパティファイルを読み込む
	Properties properties = new Properties();

	try {
	InputStream inStream = new FileInputStream("/DBAccess.properties");
	properties.load(inStream);

	}catch(IOException e) {
		e.printStackTrace();
	}

	private final String DRIVER_NAME = properties.getProperty("drivername");
	private final String JDBC_URL = properties.getProperty("jdbcurl");
	private final String DB_USER = properties.getProperty("username");
	private final String DB_PASS = properties.getProperty("userpassword");

	public String getDriverName() {

		return DRIVER_NAME;
	}

	public String getJdbcurl() {

		return JDBC_URL;
	}

	public String getUsername() {

		return DB_USER;
	}

	public String getUserpassword() {

		return DB_PASS;
	}

}
