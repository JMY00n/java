package chapter3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Practice18 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] student = new int[10];
		int[] score = new int[10];
		ArrayList<Integer> correct = new ArrayList<>();

		System.out.println("10명의 학생의 학번과 점수 입력");
		for (int i = 0; i < student.length; i++) {
			System.out.print(i + 1 + ">>");
			student[i] = sc.nextInt();
			score[i] = sc.nextInt();
		}

		while (true) {
			boolean found = false;
			System.out.print("학번으로 검색 : 1, 점수로 검색 : 2, 끝내려면 3>>");
			int answer = sc.nextInt();
			if (answer == 3) {
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				return;
			} else if (answer == 2) {
				/* 점수로 검색 */
				while (true) {
					try {
						System.out.print("점수>>");
						answer = sc.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("경고!! 정수를 입력하세요.");
						sc.nextLine();
						continue;
					}
					for (int i = 0; i < score.length; i++) {
						if (answer == score[i]) {
							correct.add(student[i]);
							found = true;
						}
					}
					if (found) {
						System.out.println("점수가 " + answer + "인 학생은 " + correct + "입니다.");
						break;
					} else {
						System.out.println("점수가 " + answer +"인 학생은 없습니다.");
						break;
					}

				}

			} else if (answer == 1) {
				/* 학번으로 검색 */

				while (true) {
					try {
						System.out.print("학번>>");
						answer = sc.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("경고!! 정수를 입력하세요.");
						sc.nextLine();
						continue;
					}
					for (int i = 0; i < student.length; i++) {
						if (answer == student[i]) {
							System.out.println(score[i] + "점");
							found = true;
							break;
						}
					}

					if (found) {
						break;
					} else {
						System.out.println(answer + "의 학생은 없습니다.");
					}
				}

			}
		}
	}
}
