package chapter7;

import java.util.Scanner;
import java.util.Vector;

class Word {
	String eng;
	String kor;

	public Word(String eng, String kor) {
		this.eng = eng;
		this.kor = kor;
	}

	@Override
	public String toString() {
		return this.eng;
	}
}

public class WordQuiz {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Vector<Word> v = new Vector<Word>(17);
		// 문제(17개)
		v.add(new Word("love", "사랑"));
		v.add(new Word("peace", "평화"));
		v.add(new Word("friendship", "우정"));
		v.add(new Word("freedom", "자유"));
		v.add(new Word("wisdom", "지혜"));
		v.add(new Word("courage", "용기"));
		v.add(new Word("happy", "행복한"));
		v.add(new Word("dream", "꿈"));
		v.add(new Word("journey", "여행"));
		v.add(new Word("nature", "자연"));
		v.add(new Word("music", "음악"));
		v.add(new Word("star", "별"));
		v.add(new Word("memory", "기억"));
		v.add(new Word("family", "가족"));
		v.add(new Word("hope", "희망"));
		v.add(new Word("future", "미래"));
		v.add(new Word("success", "성공"));

		System.out.println("\"명품영어\"의 단어 테스트를 시작합니다. -1을 입력하면 종료합니다.");
		System.out.println("현재 " + v.size() + "개의 단어가 들어 있습니다.");

		while (true) {
			// 문제 선별
			int answerIndex = (int) (Math.random() * v.size());
			Word answerWord = v.get(answerIndex);
			String answerKor = answerWord.kor;

			System.out.println(answerWord + "?");

			// 보기 배열 및 정답 위치 설정
			String[] example = new String[4];
			int correctAnswerPos = (int) (Math.random() * 4); // 정답 인덱스
			example[correctAnswerPos] = answerKor;

			// 오답 인덱스 중복 방지용 Vector (정답 인덱스는 삽입한 상태)
			Vector<Integer> chosenIndices = new Vector<>();
			chosenIndices.add(answerIndex);

			// 오답 3개 생성 및 삽입(정답 인덱스 건너뛰기)
			for (int i = 0; i < 4; i++) {
				if (i == correctAnswerPos)
					continue;

				int worngIndex;
				do {
					worngIndex = (int) (Math.random() * v.size());
				} while (chosenIndices.contains(worngIndex));

				// 찾은 인덱스를 기록하고 보기 배열에 오답 한국어 삽입
				chosenIndices.add(worngIndex);
				example[i] = v.get(worngIndex).kor;
			}
			// 보기 출력
			for (int i = 0; i < 4; i++) {
				System.out.print("(" + (i + 1) + ")" + example[i] + " ");
			}

			System.out.println(": >");

			int answer = sc.nextInt();

			if (answer == -1) {
				System.out.print("\"명품영어\"를 종료합니다...");
				break;
			} else if ((answer - 1) == correctAnswerPos)
				System.out.println("Excellnet !!");
			else
				System.out.println("No. !!");
		}

	}
}
