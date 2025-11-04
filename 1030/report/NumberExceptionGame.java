package practice;

import java.util.Scanner;

class Player {
	String name;
	int answer;
	int correctAnswer;

	public Player() {
	}

	public Player(String name) {
		this.name = name;
		correctAnswer = 0;
	}
}

public class NumberExceptionGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("게임에 참여할 선수들 이름 >> ");
		String[] players = sc.nextLine().split(" ");
		Player[] player = new Player[players.length];

		// 각 플레이어 이름들로 객체 초기화
		for (int i = 0; i < players.length; i++) {
			player[i] = new Player(players[i]);
		}

		// 각자 플레이어 마다 정수 선택 후 answer 필드 초기화
		for (Player val : player) {
			System.out.print("[" + val.name + "] 정수 선택(1~10) >> ");
			val.answer = Integer.parseInt(sc.nextLine());
		}
		
		System.out.print("Enter키 입력 >> ");
		sc.nextLine(); // 이 엔터 입력 후 15개의 랜덤한 정수 생성 후 출력

		// 15개의 난수 생성
		int[] random = new int[15];
		for (int i = 0; i < 15; i++) {
			random[i] = (int) ((Math.random() * 15) + 1); // 1~15 사이의 랜덤한 정수 값 삽입
		}
		// 이후 난수 15개 출력
		for (int val : random)
			System.out.print(val + " ");
		
		// 맞춘 개수 계산
		for (int i = 0; i < player.length; i++) {
			for (int j = 0; j < 15; j++) {
				if (player[i].answer == random[j]) {
					player[i].correctAnswer++;
				}
			}
		}
		
		System.out.println();
		// 맞춘 개수 출력
		for (Player val : player) {
			System.out.println("[" + val.name + "] 맞춘 개수 : " + val.correctAnswer);
		}

	}
}
