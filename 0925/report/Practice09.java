package intro;

import java.util.Scanner;

class Player {
	String name;
	int score;
	int guessNumber;

	Player(String name) {
		this.name = name;
	}
}
// GuessGame
public class Practice09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int winnerScore = 1;
		System.out.println("*** 예측 게임을 시작합니다. ***");
		System.out.print("게임에 참여할 선수 수>>");
		Player[] players = new Player[sc.nextInt()];

		// 플레이어 객체 생성
		for (int i = 0; i < players.length; i++) {
			System.out.print("선수 이름>>");
			players[i] = new Player(sc.next());
			players[i].score = 0; // 선수 생성하고 스코어도 0으로 초기화
		}

		while (true) {
			// 난수 생성
			int hiddenAnswer = (int) (Math.random() * 100 + 1); // 1~100 범위의 랜덤 정수
			System.out.println("1~100 사이의 숫자가 결정되었습니다. 선수들은 맞추어 보세요.");

			while (true) {
				// 각 플레이어들로부터 answer 받기
				for (int i = 0; i < players.length; i++) {
					System.out.print(players[i].name + ">>");
					players[i].guessNumber = sc.nextInt();
				}
				int minDiff = Integer.MAX_VALUE;
				Player winner = null;
				// 정답 체크
				for (int i = 0; i < players.length; i++) {
					int diff = Math.abs(players[i].guessNumber - hiddenAnswer);
					if (diff < minDiff) {
						minDiff = diff;
						winner = players[i];
					}
				}

				System.out.println("정답은 " + hiddenAnswer + ", " + winner.name + "이(가) 이겼습니다.");
				System.out.println("승점" + winnerScore + "점 확보!");
				winner.score += winnerScore;

				System.out.println("계속 하시려면 yes 입력>>");
				String answer = sc.next();
				int max = 0;
				Player finalWinner = null;
				if (answer.equals("yes")) {
					break;
				} else if (answer.equals("no")) {
					for (int i = 0; i < players.length; i++) {
						System.out.print(players[i].name + ":" + players[i].score + " ");
						if (players[i].score > max) {
							max = players[i].score;
							finalWinner = players[i];
						}
					}
					System.out.println();
					System.out.println(finalWinner.name + "이(가) 최종 승리하였습니다.");

					return;
				}
			}
		}

	}
}
