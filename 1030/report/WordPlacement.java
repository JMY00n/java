package practice;

import java.util.Scanner;

public class WordPlacement {
	public static void main(String[] args) {
		while (true) {
			Scanner sc = new Scanner(System.in);
			char[][] board = new char[5][5]; // 5x5 배열 판

			System.out.print("단어 입력>>");
			String word = sc.next().toUpperCase();
			if (word.equals("그만"))
				return;

			int[][] direction = { { 0, 1 }, { 1, 0 }, { 1, 1 } };
			int dir = (int) (Math.random() * 3);
			int dx = direction[dir][0];
			int dy = direction[dir][1];

			int startRow = (int) (Math.random() * (5 - dx * word.length()));
			int startCol = (int) (Math.random() * (5 - dy * word.length()));

			// 단어 삽입
			for (int i = 0; i < word.length(); i++) {
				board[startRow + dx * i][startCol + dy * i] = word.charAt(i);
			}

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (board[i][j] == '\u0000') { // board[i][j]에 null이면 아무 랜덤 문자 삽입
						board[i][j] = (char) ('A' + (int) (Math.random() * 26));
					}
				}
			}

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
