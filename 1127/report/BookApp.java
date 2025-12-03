package chapter16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Scanner;

public class BookApp {
	public static void main(String[] args) {
		Connection conn;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb", "root", "wjdalsdl!590");
			System.out.println("DB 연결 완료");

			while (true) {
				startMenu();
				int menuSel = sc.nextInt();

				switch (menuSel) {
				case 1:
					try {
						// id, 책제목, 출판사, 저자 정보를 입력받아 데이터베이스 레코드에 추가
						System.out.print("id >> ");
						int bookId = sc.nextInt();

						System.out.print("책 제목 >> ");
						String bookTitle = sc.next();

						System.out.print("출판사 >> ");
						String publisher = sc.next();

						System.out.print("저자 >> ");
						String author = sc.next();

						pstmt = conn.prepareStatement(Sql.insert);

						pstmt.setInt(1, bookId);
						pstmt.setString(2, bookTitle);
						pstmt.setString(3, publisher);
						pstmt.setString(4, author);
						pstmt.executeUpdate();
					} catch (SQLIntegrityConstraintViolationException e) {
						System.out.println("이미 존재하는 pk입니다. id 명을 다르게 입력하세요.");
					}

					break;
				case 2:
					// id 값을 입력받아 레코드 삭제
					try {
						System.out.print("삭제 할 id >> ");
						int bookId = sc.nextInt();

						pstmt = conn.prepareStatement(Sql.delete);

						pstmt.setInt(1, bookId);
						int result = pstmt.executeUpdate();

						if (result > 0) {
							System.out.println("삭제 완료 되었습니다.");
						} else {
							System.out.println("해당 id의 데이터가 존재하지 않습니다.");
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

					break;
				case 3:
					// 수정할 속성의 이름을 입력받고, 속성의 현재 값과 새로운 값을 입력받아 레코드를 수정
					// id값을 받으면 조건에 id를 넣고 수정할 값에 컬럼1 = 값1
					// 조건이랑 현재 id의 값이 같음
					System.out.print("수정할 속성 값을 입력하세요. (id, title, publisher, author) >> ");
					String column = sc.next();
					
					if (!column.equals("id") && !column.equals("title") &&
						!column.equals("publisher") && !column.equals("author")) {
						System.out.println("없는 속성입니다. 다시 입력해주세요.");
						break;
					}
					
					System.out.print("현재 값 >> ");
					sc.nextLine();
					String currVal = sc.nextLine();
					
					System.out.print("수정할 값 >> ");
					String modiVal = sc.nextLine();
					
					// 동적으로 SQL 만들기
					String sql = "UPDATE book SET " + column + " = ? WHERE " + column + " = ?";
					pstmt = conn.prepareStatement(sql);
					
					if (column.equals("id")) {
						pstmt.setInt(1, Integer.parseInt(modiVal));
						pstmt.setInt(2, Integer.parseInt(currVal));
					} else {
						pstmt.setString(1, modiVal);
						pstmt.setString(2, currVal);
					}
					
					int result = pstmt.executeUpdate();
					if (result > 0) {
						System.out.println("수정 완료!");
					} else {
						System.out.println("해당 데이터가 존재하지 않습니다.");
					}

					break;
				case 4:
					// 전체 조회
					stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(Sql.searchAll);
					printData(rs, "id", "title", "publisher", "author");
					break;
				case 5:
					// 끝내기
					return;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void startMenu() {
		System.out.println("=================================");
		System.out.print("1.추가 ");
		System.out.print("2.삭제 ");
		System.out.print("3.수정 ");
		System.out.print("4.조회 ");
		System.out.print("5.끝내기 >> ");
	}

	private static void printData(ResultSet rs, String col1, String col2, String col3, String col4)
			throws SQLException {
		System.out.println();
		System.out.println("===============================================================");
		while (rs.next()) {
			System.out.print(rs.getString(col1) + "\t");
			System.out.print(rs.getString(col2) + "\t");
			System.out.print(rs.getString(col3) + "\t");
			System.out.print(rs.getString(col4) + "\t");
			System.out.println();
		}
		System.out.println("===============================================================");
	}

}

class Sql {
	static String searchAll = "SELECT * FROM book";
	static String insert = "INSERT INTO book(id, title, publisher, author)" + "VALUES (?, ?, ?, ?);";
	static String delete = "DELETE FROM book WHERE id = ?;";
}
