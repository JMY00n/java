package chapter16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Practice07 {
	public static void main(String[] args) {
		Connection conn;
		String sql = "DELETE FROM book WHERE title = ?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb", "root", "wjdalsdl!590");
			System.out.println("DB 연결됨");
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "제인 오스틴");
			int rows = pstmt.executeUpdate();
			
			System.out.println(rows + "행이 삭제되었습니다.");
			
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
