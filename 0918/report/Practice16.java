package chapter3;

import java.util.ArrayList;
import java.util.Scanner;

public class Practice16 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수를 입력하세요. -1은 입력 끝>>");
		ArrayList<Integer> arr = new ArrayList<>();
		double sum = 0;

		while (true) {
			String input = sc.next();
			try {
				int num = Integer.parseInt(input);
				if (num == -1)
					break;
				if (num < 0) {
					System.out.println(input + " 제외");
					continue;
				}

				arr.add(num);
				sum += num;
			} catch (NumberFormatException e) {
				System.out.println(input + " 제외");
			}
		}

		if (arr.size() == 0) {
			System.out.println("입력된 숫자가 없습니다.");
		} else {
			double avg = sum / arr.size();
			System.out.println("평균은 " + sum / arr.size());
		}
		
		sc.close();
	}
}
