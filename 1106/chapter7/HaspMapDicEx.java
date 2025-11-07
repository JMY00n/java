package main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HaspMapDicEx {
	public static void main(String[] args) {
		HashMap<String, String> dic = new HashMap<String, String>();

		dic.put("baby", "아기");
		dic.put("love", "사랑");
		dic.put("apple", "사과");

		Set<String> keys = dic.keySet();
		Iterator<String> it = keys.iterator();

		while (it.hasNext()) {
			String key = it.next();
			String value = dic.get(key);
			System.out.println("(" + key + ", " + value + ")");
		}
		System.out.println();

		it = keys.iterator();
		// 영단어 입력을 받고 한글 단어 검색
		Scanner sc = new Scanner(System.in);
		System.out.print("영어 단어를 입력해주세요 >> ");
		String str = sc.next();
		for (int i = 0; i < dic.size(); i++) {
			String key = it.next();
			if (str.equals(key)) {
				System.out.println(str + "은(는) " + key + "입니다.");
				break;
			} else {
				System.out.println("[" + str + "]" + "해당 단어는 없는 단어입니다.");
				break;
			}

		}
		sc.close();
	}
}
