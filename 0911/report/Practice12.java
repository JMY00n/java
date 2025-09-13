package basic;

import java.util.Scanner;

public class Practice12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("자동차 상태 입력>>");
		int status = sc.nextInt();
		
		int cur = status & 0xFF;
		
		if ((cur & 0b01000000) == 0) {
			System.out.print("자동차는 정지 상태이고 ");
		} else {
			System.out.print("자동차는 달리는 상태이고 ");
		}

		if ((cur & 0b00100000) == 0) {
			System.out.print("에어컨이 꺼진 상태이고 ");
		} else {
			System.out.print("에어컨이 켜진 상태이고 ");
		}

		int temp = cur & 0b00011111;

		System.out.print("온도는 " + temp + "도이다.");

		sc.close();

	}
}
