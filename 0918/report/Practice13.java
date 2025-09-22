package chapter3;

import java.util.Scanner;

public class Practice13 {
	// 09/19 없는 과목입니다. 추가해야줘야 함
	public static void main(String[] args) {
		String course[] = { "C", "C++", "Python", "Java", "HTML5" };
		String grade[] = { "A", "B+", "B", "A+", "D" };

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("과목>>");
			String subject = sc.next();
			boolean found = false;

			if (subject.equals("그만")) {
				return;
			}

			for (int i = 0; i < course.length; i++) {
				if (subject.equals(course[i])) {
					System.out.println(subject + "학점은 " + grade[i]);
					found = true;
					break;
				}
			}
			if (!found) {
				System.out.println("없는 과목입니다. 다시 시도해주세요.");
				continue;
			}

		}

	}
}
