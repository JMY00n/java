package intro;

import java.util.Scanner;

class Player {
	String name;

	String getWordFromUser(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.print(name + ">>");
		
		return sc.next();
	}

	Player(String name) {
		this.name = name;
	}
}

public class WordGameApp {
	public static void main(String[] args) {
		WordGameApp app = new WordGameApp();
		app.run();

	}

	void run() {
		Scanner sc = new Scanner(System.in);

		System.out.println("끝말잇기 게임을 시작합니다...");
		System.out.print("게임에 참가하는 인원은 몇명입니까?>>");
		int number = sc.nextInt();

		Player[] players = new Player[number];

		for (int i = 0; i < number; i++) {
			System.out.print("참가자의 이름을 입력하세요>>");
			players[i] = new Player(sc.next());
		}
		
		String word = "아버지";
		System.out.println("시작하는 단어는 " + word + "입니다.");
		
		int turn = 0;
		while (true) {
			Player current = players[turn % number];
			String newWord = current.getWordFromUser(word);
			
			if (!checkSuccess(word, newWord)) {
				System.out.println(current.name + "이(가) 졌습니다!!");
				break;
			}
			
			word = newWord;
			turn++;
		}
		sc.close();

	}

	boolean checkSuccess(String prev, String next) {
		int lastChar = prev.charAt(prev.length() - 1);
		char firstChar = next.charAt(0);
		
		return lastChar == firstChar;
	}
}
