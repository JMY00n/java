package chapter3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Practice17 {
	public static void main(String[] args) {
		String coffee[] = { "핫아메리카노", "아이스아메리카노", "카푸치노", "라떼" };
		int price[] = { 3000, 3500, 4000, 5000 };
		Scanner sc = new Scanner(System.in);

		System.out.println("핫아메리카노, 아이스아메리카노, 카푸치노, 라떼 있습니다.");

		while (true) {
			try {
				System.out.print("주문>>");
				String answer = sc.next();
				int order = sc.nextInt();

				boolean found = false;

				for (int i = 0; i < coffee.length; i++) {
					if (answer.equals(coffee[i])) {
						System.out.println("가격은 " + (price[i] * order) + "원입니다.");
						found = true;
						break;
					}
				}

				if (!found) {
					if (!answer.equals("그만")) {
						System.out.println(answer + "는 없는 메뉴입니다.");
					} else {
						sc.close();
						return;
					}
				}

			} catch (InputMismatchException e) {
				System.out.println("잔 수는 양의 정수로 입력해주세요!");
				sc.nextLine();
			} 
		}
	}
}
