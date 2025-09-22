package chapter3;

import java.util.Scanner;

public class Practice11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("***** 구구단을 맞추는 퀴즈 입니다. *****");

		int count = 0;
		while (true) {
			int n = (int) ((Math.random() * 10) + 1);
			int m = (int) ((Math.random() * 10) + 1);

			System.out.print(n + "x" + m + "=");
			int answer = sc.nextInt();

			while (true) {
				if (answer == n * m) {
					System.out.print("정답입니다. 잘했습니다.");
					break;
				} else {
					count++;
					if (count == 3) {
						System.out.print(count + "번 틀렸습니다. 퀴즈 종료합니다.");
						return;
					}

					System.out.println(count + "번 틀렸습니다. 분발하세요.");
					break;
				}
			}
			sc.close();
		}

	}
}
