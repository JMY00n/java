package chapter2;

import java.util.Scanner;

public class Practice06 {
	public static void main(String[] args) {
		/* 생일 케이크 초 개수 계산 프로그램. 빨간 초는 10살, 파란 초는 5살, 노란 초는 1살 */
		Scanner sc = new Scanner(System.in);
		int red = 10;
		int blue = 5;
//		int yellow = 1;
		
		System.out.print("나이를 입력하세요>>");
		int age = sc.nextInt();
		if (age < 0) {
			System.out.println("나이는 양수로만 입력하세요.");
			System.exit(0);
		}
		int inputRed = 0;
		int inputBlue = 0;
		int inputYellow = 0;
		int total = 0;
		
		inputRed = age / red;
		inputBlue = (age % 10) / blue;
		inputYellow = age % 10 % blue;
		total = inputRed + inputBlue + inputYellow;
		
		System.out.println("빨간 초 "+ inputRed + "개, 파란 초 " + inputBlue + "개, 노란 초 " + inputYellow+"개. 총 " + total +"개가 필요합니다.");
		
		sc.close();
	}
}
