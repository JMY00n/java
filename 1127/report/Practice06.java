package chapter16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
// import java.sql.ResultSet; // UPDATE문에서는 ResultSet이 필요 없어서 주석 처리

public class Practice06 {
	public static void main(String[] args) {
		Connection conn = null;
		// Statement stmt = null; // PreparedStatement를 쓸 거면 이건 필요 없습니다.

		// ? (물음표)를 사용한 SQL 템플릿
		String sql = "UPDATE book SET title = ? WHERE title = 'Pride and Prejudice'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb", "root", "wjdalsdl!590");
			System.out.println("DB 연결 완료");

			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "제인 오스틴");
			
			int rows = pstmt.executeUpdate(); 
			
			System.out.println(rows + "행이 수정되었습니다.");

			pstmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}