package chapter2;

import java.util.Scanner;

public class Practice09 {
	public static void main(String[] args) {
		/*
		 * (10, 10) (200, 300)의 두 점으로 이루어진 사각형이 있을 때 x, y값을 받고 이 사각형 안에 있는지, 사각형 선 상에
		 * 있는지, 사각형 외부에 있는지 판별
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("점 (x, y)의 좌표 입력>>");
		int x = sc.nextInt();
		int y = sc.nextInt();

		// 사각형 선상에 있는 경우 :
		if ((x == 10 && y >= 10 && y <= 300) || (x == 200 && y >= 10 && y <= 300)) {
		    System.out.println("(" + x + "," + y + ")는 사각형 선 상에 있습니다.");
		} else if ((y == 10 && x >= 10 && x <= 200) || (y == 300 && x >= 10 && x <= 200)) {
		    System.out.println("(" + x + "," + y + ")는 사각형 선 상에 있습니다.");
		} else if (x > 10 && x < 200 && y > 10 && y < 300) {
		    System.out.println("(" + x + "," + y + ")는 사각형 안에 있습니다.");
		} else {
		    System.out.println("(" + x + "," + y + ")는 사각형 밖에 있습니다.");
		}

		sc.close();
	}
}
