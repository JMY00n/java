package chapter3;

import java.util.Random;
import java.util.Scanner;

public class Practice14 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		int[] correct = new int[3];
		int[] answer = new int[3];

		System.out.println("***** 겜블링 게임을 시작합니다. *****");
//		System.out.println("엔터키 입력>>");

		while (true) {
			// 0~2 난 수 생성
			for (int i = 0; i < 3; i++) {
				correct[i] = r.nextInt(3);
			}

			System.out.println("엔터키 입력>>");
			while (true) {

				// 사용자 입력
				for (int i = 0; i < 3; i++)
					answer[i] = sc.nextInt();

				// 체크
				boolean success = true;
				for (int j = 0; j < 3; j++) {
					if (correct[j] != answer[j]) {
						success = false;
						break;
					}
				}

				// 위의 for문을 지나치면 정답
				if (success) {
					System.out.println("성공! 대박났어요!");
					System.out.println("계속하시겠습니까?(yes/no)>>");
					String isGo = sc.next();
					if (!isGo.equals("yes")) {
						sc.close();
						return;
					} else {
						break;
					}
				} else {
					System.out.println("엔터키 입력>>");
				}
			}

		}

	}
}
