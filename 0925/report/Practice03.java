package intro;

import java.util.Scanner;

class Grade {
	String name;
	int java;
	int web;
	int os;
	int avg;

	Grade(String name, int java, int web, int os) {
		this.name = name;
		this.java = java;
		this.web = web;
		this.os = os;
	}

	String getName() {
		return name;
	}

	int getAverage() {
		avg = (java + web + os) / 3;

		return avg;
	}
}

public class Practice03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름, 자바, 웹프로그래밍, 운영체제 순으로 점수 입력>>");
		String name = sc.next();
		int java = sc.nextInt();
		int web = sc.nextInt();
		int os = sc.nextInt();
		Grade st = new Grade(name, java, web, os);
		System.out.println(st.getName() + "의 평균은 " + st.getAverage());
		sc.close();
	}
}
