package chapter16;

import java.sql.*;
import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		Scanner sc = new Scanner(System.in);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 최신 드라이버
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root", "wjdalsdl!590");
			System.out.println("DB 연결 완료");

			stmt = conn.createStatement();

			while (true) {
				printStart();
				int answer = sc.nextInt();
				sc.nextLine(); // 버퍼 정리

				switch (answer) {
				case 1:
					// SELECT
					ResultSet rs = stmt.executeQuery("SELECT * FROM student");
					printData(rs);
					break;

				case 2:
					// UPDATE
					stmt.executeUpdate("UPDATE student SET dept='Computer'");
					System.out.println("UPDATE 완료");
					break;

				case 3:
					// INSERT
					stmt.executeUpdate("INSERT INTO student VALUES ('윤정민', '컴퓨터소프트웨어과', '2025305')");
					System.out.println("INSERT 완료");
					break;

				case 4:
					// DELETE
					stmt.executeUpdate("DELETE FROM student WHERE name='윤정민'");
					System.out.println("DELETE 완료");
					break;

				case 0:
					System.out.println("프로그램 종료");
					return;

				default:
					System.out.println("잘못된 입력입니다.");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void printData(ResultSet rs) throws SQLException {
		while (rs.next()) {
			System.out.println(rs.getString("name") + ", " + rs.getString("dept") + ", " + rs.getString("id"));
		}
	}

	public static void printStart() {
		System.out.println("=====================");
		System.out.println("1. SELECT");
		System.out.println("2. UPDATE");
		System.out.println("3. INSERT");
		System.out.println("4. DELETE");
		System.out.println("0. EXIT");
		System.out.println("=====================");
		System.out.print("번호 선택 : ");
	}
}