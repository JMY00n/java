package practice;

import java.util.*;

class Player {
	String name;
	int answer;
	int correctAnswer;

	public Player(String name) {
		this.name = name;
	}
}

public class NumberExceptionGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("게임에 참여할 선수들 이름 >> ");
		String[] players = sc.nextLine().split(" ");
		List<Player> playerList = new ArrayList<>();

		for (String name : players)
			playerList.add(new Player(name));

		// 초기 정답 선택
		for (Player p : playerList) {
			System.out.print("[" + p.name + "] 정수 선택(1~10) >> ");
			p.answer = Integer.parseInt(sc.nextLine());
		}

		// 한 명 남을 때까지 반복
		while (playerList.size() > 1) {
			System.out.print("Enter키 입력 >> ");
			sc.nextLine();

			// 난수 15개 생성
			int[] random = new int[15];
			for (int i = 0; i < 15; i++)
				random[i] = (int) (Math.random() * 15 + 1);

			// 출력
			System.out.print("이번 라운드 난수 : ");
			for (int val : random)
				System.out.print(val + " ");
			System.out.println();

			// 맞춘 개수 계산
			for (Player p : playerList) {
				p.correctAnswer = 0;
				for (int val : random) {
					if (p.answer == val)
						p.correctAnswer++;
				}
			}

			// 최고 점수 계산
			int maxCorrect = playerList.stream().mapToInt(p -> p.correctAnswer).max().orElse(0);

			// 승자 출력
			System.out.print("이번 라운드 승자(제외됨): ");
			for (Player p : playerList) {
				if (p.correctAnswer == maxCorrect) {
					System.out.print("[" + p.name + "] ");
				}
			}
			System.out.println();

			// 승자 제거 (== 최고점자 제거)
			playerList.removeIf(p -> p.correctAnswer == maxCorrect);

			// 남은 사람 출력
			System.out.println("남은 플레이어: ");
			for (Player p : playerList) {
				System.out.print("[" + p.name + "] ");
			}
			System.out.println("\n-----------------------");
		}

		// 마지막 남은 사람 = 패자
		if (playerList.size() == 1) {
			System.out.println("최종 패자 : [" + playerList.get(0).name + "]");
		}
	}
}
