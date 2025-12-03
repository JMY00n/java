package chapter16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Ex2 {
	public static void main(String[] args) {
		Connection conn;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/sampledb", "root","wjdalsdl!590");
					// JDBC 연결, password는 root 계정 패스워드 입력
					System.out.println("DB 연결 완료");
					stmt = conn.createStatement(); // SQL문 처리용 Statement 객체 생성
					ResultSet srs = stmt.executeQuery("select * from student");
					// 테이블의 모든 데이터 검색
					printData(srs, "name", "id", "dept");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("SQL 실행 에러");
		}
	}
	
	private static void printData(ResultSet srs, String col1, String col2, String col3) throws SQLException {
		while (srs.next()) {
			if (col1 != "") {
				System.out.print(new String(srs.getString("name")));
				System.out.print(", ");
			}
			if (col2 != "") {
				System.out.print(new String(srs.getString("id")));
				System.out.print(", ");
			}
			if (col3 != "") {
				System.out.print(new String(srs.getString("dept")));
				System.out.println();
			} else
				System.out.println();
		}
	}
}
