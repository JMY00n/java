package chapter2;

import java.util.Scanner;

public class Practice07_1 {
	public static void main(String[] args) {
		/*
		 * 3~5 : 따뜻한 봄, 6~8 : 바다가 즐거운 여름, 9~11 : 낙엽이 지는 아름다운 가을, 12,0,1 : 눈 내리는 하얀 겨울 그
		 * 외는 1~12만 입력하세요. 출력
		 */
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();

		if (month >= 12 || month == 0 || month == 1) {
			System.out.println("눈 내리는 하얀 겨울");
		} else if (month >= 9 && month <= 11) {
			System.out.println("낙엽이 지는 아름다운 가을");
		} else if (month >= 6 && month <= 8) {
			System.out.println("바다가 즐거운 여름");
		} else if (month >= 3 && month <= 5) {
			System.out.println("따뜻한 봄");
		} else {
			System.out.println("1~12만 입력하세요.");
		}

		sc.close();
	}
}
