package chapter2;

import java.util.Scanner;

public class Practice11 {
	public static void main(String[] args) {
		/* 냉장고의 상태를 나타내기 위해 8비트 정수 중 하위 4비트가 다음과 같이 사용
		 * 비트 0 : 값이 0이면 전원이 꺼져 있고, 1이면 켜져 있음
		 * 비트 1 : 값이 0이면 문이 열려 있고, 1이면 닫혀 있음
		 * 비트 2 : 값이 0이면 냉장고 전구가 손상된 상태이고, 1이면 정상작동
		 * 비트 3 : 값이 0이면 냉장고 온도가 3도 이상이고, 1이면 3도 미만
		 * 비트 4이상 : 아무 의미 없음 */
		Scanner sc = new Scanner(System.in);
		System.out.print("냉장고 상태 입력>>");
		String str = sc.next();
		byte status = Byte.parseByte(str, 2);
		
		// 전원
		if ((status & 0b00000001) != 0) System.out.print("전원 켜져 있음. ");
		else System.out.print("전원 꺼져 있음. ");
		
		// 문
		if ((status & 0b00000010) != 0) System.out.print("문 닫혀 있음. ");
		else System.out.print("문 열려 있음. ");
		
		// 전구
		if ((status & 0b00000100) != 0)	System.out.print("전구 정상 작동. ");
		else System.out.print("전구 손상됨. ");
				
		// 온도
		if ((status & 0b00001000) != 0) System.out.print("냉장고 온도 3도 미만. ");
		else System.out.print("냉장고 온도 3도 이상. ");
		
		sc.close();
	}
}
