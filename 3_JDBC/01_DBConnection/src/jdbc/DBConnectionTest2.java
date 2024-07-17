package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnectionTest2 {

	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver"; // 상수로 다른곳에서 변경 못하게 막아놓는 기능
	public static final String URL = "jdbc:mysql://localhost:3306/kh";
	public static final String USER = "root";
	public static final String PASSWORD = "qwer1234";
	
	public static void main(String[] args) {
		
		try {
			// 1. 드라이버 로딩
			Class.forName(DRIVER_NAME);
			
			// 2. 데이터베이스 연결
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// 3. PreparedStatement - INSERT
			String query = "INSERT INTO employee(emp_id, emp_name, emp_no) VALUES (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, 900); // 1번째 물음표(emp_id)에 900을 넣겠다
			ps.setString(2, "김미경"); // 2번째 물음표(emp_name)에 "김미경"을 넣겠다
			ps.setString(3, "111111-1111111");
			
			// 4. 쿼리문 실행
			System.out.println(ps.executeUpdate() + "명 추가!"); // 자바, mySQL에 모두 추가가 되는 점 확인가능
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
	
	}

}
