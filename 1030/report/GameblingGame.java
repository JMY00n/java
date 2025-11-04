package practice;

import java.util.Scanner;

class Player {
	String name;

	public Player(String name) {
		this.name = name;
	}
}

public class GameblingGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] correct = new int[3];
		boolean isGO = true;
		boolean isCorrect = true;

		System.out.print("겜블링 게임에 참여할 선수 숫자 >> ");
		int number = sc.nextInt();
		Player[] players = new Player[number];

		for (int i = 0; i < number; i++) {
			System.out.print((i + 1) + "번째 선수 이름 >> ");
			players[i] = new Player(sc.next());
		}

		// 랜덤 난수 생성
		for (int i = 0; i < 3; i++) {
			correct[i] = (int) ((Math.random() * 3) + 1);
		}

//		테스트용 정답 확인 코드
//		for (int val : correct) {
//			System.out.print(val + " ");
//		} 

		// 각 플레이어들의 정답 입력
		while (isGO) {

			for (int i = 0; i < number; i++) {
				int[] playerCor = new int[3];
				System.out.println("[" + players[i].name + "]:<Enter>");
				playerCor[i] = sc.nextInt();
				playerCor[i + 1] = sc.nextInt();
				playerCor[i + 2] = sc.nextInt();

				if (playerCor[i] != correct[i]) {
					System.out.println("아쉽군요!");
					break;
				}
				if (playerCor[i + 1] != correct[i + 1]) {
					System.out.println("아쉽군요!");
					break;
				}
				if (playerCor[i + 2] != correct[i + 2]) {
					System.out.println("아쉽군요!");
					break;
				}

				System.out.println(players[i].name + "님이 이겼습니다!");
				return;

			}
		}
	}
}
