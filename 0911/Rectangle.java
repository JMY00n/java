package s0911;

import java.util.Scanner;

public class Rectangle {
	public static void main(String[] args) {
		/*
		 * 사각형의 height와 width를 입력받아 면적을 출력하는 프로그램 작성
		 */
		Scanner sc = new Scanner(System.in);

		System.out.println("height를 입력하세요.");
		double height = sc.nextInt();
		System.out.println("width를 입력하세요.");
		double width = sc.nextInt();
		double rectangle = height * width;

		System.out.println("입력하신 사각형의 넓이는 " + rectangle + "입니다.");

		sc.close();
	}
}
