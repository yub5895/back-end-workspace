package config;

public interface ServerInfo {
	// 인터페이스에선 public 생략해도 상수처럼 사용됨
	static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver"; 
	static final String URL = "jdbc:mysql://localhost:3306/kh";
	static final String USER = "root";
	static final String PASSWORD = "qwer1234";
}
