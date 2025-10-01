package intro;

import java.util.Scanner;

class Dictionary {
	static String[] kor = { "사랑", "아기", "돈", "미래", "희망" };
	static String[] eng = { "love", "baby", "money", "future", "hope" };

	static String kor2Eng(String word) {
		/* 검색 코드 작성 */
		for (int i = 0; i < kor.length; i++) {
			if (word.equals(kor[i])) {
				word = eng[i];
				return word;
			}
		}
		return word;
	}
}

public class Practice12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("한영 단어 검색 프로그램입니다.");
	
		while (true) {
			boolean check = false;
			System.out.print("한글 단어?");
			String str1 = sc.next();
			String str = Dictionary.kor2Eng(str1);

			if (str.equals("그만"))
				break;

			for (int i = 0; i < Dictionary.kor.length; i++) {
				if (str1.equals(Dictionary.kor[i])) {
					check = true;
				}
			}

			if (check) {
				System.out.println(str1 + "은 " + str);
			} else {
				System.out.println(str + "은 저의 사전에 없습니다.");
			}
		}
		
	}
}
