package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Translation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> array = new ArrayList<String>();

		while (true) {
			System.out.print("문자열들을 입력하세요>>");
			String inputLine = sc.nextLine();

			if (inputLine.trim().equalsIgnoreCase("그만")) {
				return;
			}
			String[] parts = inputLine.split("\\s+");

			// parts로 분리한 모든 원소를 ArrayList에 넣기
			for (int i = 0; i < parts.length; i++) {
				array.add(parts[i]);
			}

			ArrayList<String> result = new ArrayList<String>();
			for (int i = 0; i < array.size(); i++) {
				String currentWord = array.get(i);

				if (i == 0 || !currentWord.equals(array.get(i - 1))) {
					result.add(currentWord);
				}
			}
			
			for (String a : result) {
				System.out.println(a + " ");
			}
		}
	}
}
