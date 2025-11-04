package practice;

import java.util.Random;
import java.util.Scanner;

public class WordGame {
	public static void main(String[] args) {
		String[] words = { "happy", "morning", "package", "together", "computer", "holiday" };

		while (true) {
			Scanner sc = new Scanner(System.in);
			Random random = new Random();

			// 랜덤 단어 선택
			String answer = words[random.nextInt(words.length)];
			// random.nextInt()를 하면 랜덤한 정수가 하나 만들어 지는거야? 안에 속성은 words의 길이만큼만 뽑아야 하니까 안에 값
						// 준거고?
			// 글자 섞기 (문자 배열로 변환 후 셔플)
			char[] chars = answer.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				int r = random.nextInt(chars.length);
				char temp = chars[i];
				chars[i] = chars[r];
				chars[r] = temp;
			}
			System.out.println("다음 단어를 10초 안에 맞춰보세요.");
			System.out.println(chars); // 여기는 왜 chars를 보여주는 거지? chars는 그냥 char하나 인 거 아니야? for문으로 전체 다 출력하던가 해야 하지 않나?

			// 시간 측정 시작
			long start = System.currentTimeMillis();

			System.out.print("정답 입력 >> ");
			String input = sc.nextLine();
			if (input.equals("그만"))
				break;

			long end = System.currentTimeMillis();
			double elapsed = (end - start) / 1000.0;

			if (elapsed > 10) {
				System.out.println("시간 초과 (" + elapsed + "초)");
			} else if (input.equals(answer)) {
				System.out.println("정답입니다. " + elapsed + "초 경과");
			} else {
				System.out.println("오답입니다. 정답은 " + answer);
			}
		}
	}
}
