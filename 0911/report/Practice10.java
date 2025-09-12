package chapter2;

import java.util.Scanner;

public class Practice10 {
	public static void main(String[] args) {
		/*
		 * 사각형을 구성하는 두점을 입력받고 이 사각형이 (10,10)과 (200,300)의 사각형에 완전히 포함되면 "포함된다." 아니면
		 * "포함되지 않는다."를 출력
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("(x1, y1), (x2, y2)의 좌표 입력>>");
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();

		// x1, x2 가 10 <= x <= 200 && y1, y2 가 10 <= y <= 300 이면 사각형에 완전히 포함
		if (x1 >= 10 && x1 <= 200 && x2 >= 10 && x2 <= 200) {
			if (y1 >= 10 && y1 <= 300 && y2 >= 10 && y2 <= 300) {
				System.out.println(
						"(" + x1 + "," + y1 + ")" + "(" + x2 + "," + y2 + ")" + "사각형은 (10,10) (200,300) 사각형에 포함된다.");
			}
		} else {
			System.out.println(
					"(" + x1 + "," + y1 + ")" + "(" + x2 + "," + y2 + ")" + "사각형은 (10,10) (200,300) 사각형에 포함되지 않는다.");
		}
	}
}
