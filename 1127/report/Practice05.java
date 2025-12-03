package chapter16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Practice05 {
	public static void main(String[] args) {
		Connection conn;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb", "root", "wjdalsdl!590");
			System.out.println("DB 연결 완료");
			
			stmt = conn.createStatement();
			
//			stmt.execute("INSERT INTO book(id, title, publisher, author)\n"
//					+ "VALUES (0, 'Harry Potter', 'Bloomsbury', 'J.K Rowling');");
			
//			stmt.execute("INSERT INTO book(id, title, publisher, author)\n"
//					+ "VALUES (1, 'The Lord of the Rings', 'Allen & Unwin', 'J. R. R Tolkein');");
			
//			stmt.execute("INSERT INTO book(id, title, publisher, author)\n"
//					+ "VALUES (2, 'Pride and Prejudice', 'T. Egerton Kingdom', 'Jane Austen');");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
