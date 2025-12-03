package chapter16;

import java.sql.*;

public class JDBC_Ex1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			Connection conn = DriverManager.getConnection(
				    "jdbc:mysql://localhost:3306/sampledb?serverTimezone=UTC",
				    "root",
				    "wjdalsdl!590"
				);
// JDBC 연결, password는 root 계정 패스워드 입력
			System.out.println("DB 연결 완료");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결 에러");
		}
	}
}
